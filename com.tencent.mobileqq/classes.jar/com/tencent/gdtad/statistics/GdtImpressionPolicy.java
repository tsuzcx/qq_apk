package com.tencent.gdtad.statistics;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class GdtImpressionPolicy
  implements Handler.Callback
{
  private static GdtImpressionPolicy c = new GdtImpressionPolicy();
  private ConcurrentHashMap<String, WeakReference<View>> a = new ConcurrentHashMap();
  private Handler b = null;
  
  private GdtImpressionPolicy()
  {
    HandlerThread localHandlerThread = new HandlerThread("GdtImpressionPolicy");
    localHandlerThread.start();
    this.b = new Handler(localHandlerThread.getLooper(), this);
  }
  
  public static GdtImpressionPolicy a()
  {
    try
    {
      GdtImpressionPolicy localGdtImpressionPolicy = c;
      return localGdtImpressionPolicy;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor, int paramInt)
  {
    paramSharedPreferences = paramSharedPreferences.getAll();
    if (paramSharedPreferences != null)
    {
      Object localObject = paramSharedPreferences.keySet();
      if (((Set)localObject).size() - paramInt > 0)
      {
        int k = Math.abs((int)(((Set)localObject).size() - paramInt * 0.5F));
        paramSharedPreferences = new String[k];
        localObject = ((Set)localObject).iterator();
        int i = 0;
        for (paramInt = 0; ((Iterator)localObject).hasNext(); paramInt = j)
        {
          String str = (String)((Iterator)localObject).next();
          j = paramInt + 1;
          paramSharedPreferences[paramInt] = str;
          if (j >= k) {
            break;
          }
        }
        int j = paramSharedPreferences.length;
        paramInt = i;
        while (paramInt < j)
        {
          paramEditor.remove(paramSharedPreferences[paramInt]);
          paramInt += 1;
        }
      }
    }
  }
  
  private void a(View paramView, GdtAd paramGdtAd)
  {
    Object localObject = this.a.keySet();
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        WeakReference localWeakReference = (WeakReference)this.a.get(str);
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (paramView == localWeakReference.get())) {
          if ((paramGdtAd.getTraceId() != null) && (!paramGdtAd.getTraceId().equals(str))) {
            b(str);
          }
        }
      }
    }
  }
  
  private void a(String paramString, WeakReference<View> paramWeakReference)
  {
    this.a.put(paramString, paramWeakReference);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("GdtImpressionPolicyReported", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    a(localSharedPreferences, localEditor, 8192);
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.apply();
  }
  
  private boolean a(String paramString)
  {
    return MobileQQ.sMobileQQ.getSharedPreferences("GdtImpressionPolicyReported", 0).getBoolean(paramString, false);
  }
  
  private void b(String paramString)
  {
    this.a.remove(paramString);
  }
  
  public static boolean b(View paramView)
  {
    return GdtUIUtils.a(paramView) > 0.5D;
  }
  
  private GdtAd c(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    paramView = paramView.getTag(2131449865);
    if (paramView == null) {
      return null;
    }
    if (!(paramView instanceof GdtAd)) {
      return null;
    }
    paramView = (GdtAd)paramView;
    if (TextUtils.isEmpty(paramView.getTraceId())) {
      return null;
    }
    if (TextUtils.isEmpty(paramView.getUrlForImpression())) {
      return null;
    }
    return paramView;
  }
  
  private boolean d(View paramView)
  {
    Object localObject = this.a.values();
    if (localObject != null)
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((paramView != null) && (localWeakReference != null) && (localWeakReference.get() != null) && (paramView == localWeakReference.get())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void a(View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("report view: ");
    ((StringBuilder)localObject).append(paramView.hashCode());
    GdtLog.a("GdtImpressionPolicy", ((StringBuilder)localObject).toString());
    localObject = c(paramView);
    if (localObject == null)
    {
      GdtLog.a("GdtImpressionPolicy", "break: statistics == null");
      return;
    }
    if (((GdtAd)localObject).reportState == 2)
    {
      paramView = new StringBuilder();
      paramView.append("break: already report ");
      paramView.append(((GdtAd)localObject).getTraceId());
      GdtLog.a("GdtImpressionPolicy", paramView.toString());
      return;
    }
    if (!b(paramView))
    {
      GdtLog.a("GdtImpressionPolicy", "break: isVisibleAreaSatisfied not");
      return;
    }
    a(paramView, (GdtAd)localObject);
    Message localMessage = this.b.obtainMessage();
    WeakReference localWeakReference = new WeakReference(paramView);
    localMessage.obj = localWeakReference;
    if (!d(paramView))
    {
      paramView = new StringBuilder();
      paramView.append("inCountingMap not ");
      paramView.append(((GdtAd)localObject).getTraceId());
      GdtLog.a("GdtImpressionPolicy", paramView.toString());
      a(((GdtAd)localObject).getTraceId(), localWeakReference);
    }
    ((GdtAd)localObject).reportState = 1;
    this.b.sendMessageDelayed(localMessage, 1000L);
  }
  
  public void b()
  {
    this.a.clear();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    GdtLog.a("GdtImpressionPolicy", "handleMessage : ");
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      paramMessage = (WeakReference)paramMessage.obj;
      if (paramMessage.get() != null)
      {
        Object localObject1 = (View)paramMessage.get();
        paramMessage = c((View)localObject1);
        if (paramMessage == null)
        {
          GdtLog.a("GdtImpressionPolicy", "break: statistics == null");
        }
        else if (paramMessage.reportState != 1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("break: statistics.reportState != 1 ");
          ((StringBuilder)localObject1).append(paramMessage.getTraceId());
          GdtLog.a("GdtImpressionPolicy", ((StringBuilder)localObject1).toString());
        }
        else if (!b((View)localObject1))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("break: isVisibleAreaSatisfied not ");
          ((StringBuilder)localObject1).append(paramMessage.getTraceId());
          GdtLog.a("GdtImpressionPolicy", ((StringBuilder)localObject1).toString());
          paramMessage.reportState = -1;
        }
        else if (!d((View)localObject1))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("break: inCountingMap not ");
          ((StringBuilder)localObject1).append(paramMessage.getTraceId());
          GdtLog.a("GdtImpressionPolicy", ((StringBuilder)localObject1).toString());
        }
        else
        {
          Object localObject2 = ((View)localObject1).getTag(2131449864);
          if (localObject2 == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("break: o2 == null ");
            ((StringBuilder)localObject1).append(paramMessage.getTraceId());
            GdtLog.a("GdtImpressionPolicy", ((StringBuilder)localObject1).toString());
          }
          else if (!(localObject2 instanceof GdtImpressionPolicy.ReportListener))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("break: o2 instanceof ReportListener not ");
            ((StringBuilder)localObject1).append(paramMessage.getTraceId());
            GdtLog.a("GdtImpressionPolicy", ((StringBuilder)localObject1).toString());
          }
          else if (a(paramMessage.getTraceId()))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("break: already reported ");
            ((StringBuilder)localObject1).append(paramMessage.getTraceId());
            GdtLog.a("GdtImpressionPolicy", ((StringBuilder)localObject1).toString());
          }
          else
          {
            ((GdtImpressionPolicy.ReportListener)localObject2).a((View)localObject1);
            paramMessage.reportState = 2;
            a(paramMessage.getTraceId(), true);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("report ");
            ((StringBuilder)localObject1).append(paramMessage.getTraceId());
            GdtLog.a("GdtImpressionPolicy", ((StringBuilder)localObject1).toString());
            b(paramMessage.getTraceId());
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtImpressionPolicy
 * JD-Core Version:    0.7.0.1
 */