package com.tencent.gdtad.statistics;

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
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GdtImpressionPolicy
  implements Handler.Callback
{
  private static GdtImpressionPolicy jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionPolicy = new GdtImpressionPolicy();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private GdtImpressionPolicy()
  {
    HandlerThread localHandlerThread = new HandlerThread("GdtImpressionPolicy");
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper(), this);
  }
  
  private GdtAd a(View paramView)
  {
    if (paramView == null) {
      paramView = null;
    }
    GdtAd localGdtAd;
    do
    {
      return paramView;
      paramView = paramView.getTag(2131362462);
      if (paramView == null) {
        return null;
      }
      if (!(paramView instanceof GdtAd)) {
        return null;
      }
      localGdtAd = (GdtAd)paramView;
      if (TextUtils.isEmpty(localGdtAd.getTraceId())) {
        return null;
      }
      paramView = localGdtAd;
    } while (!TextUtils.isEmpty(localGdtAd.getUrlForImpression()));
    return null;
  }
  
  public static GdtImpressionPolicy a()
  {
    try
    {
      GdtImpressionPolicy localGdtImpressionPolicy = jdField_a_of_type_ComTencentGdtadStatisticsGdtImpressionPolicy;
      return localGdtImpressionPolicy;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(View paramView, GdtAd paramGdtAd)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet();
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (paramView == localWeakReference.get())) {
          if ((paramGdtAd.getTraceId() != null) && (!paramGdtAd.getTraceId().equals(str))) {
            a(str);
          }
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  private void a(String paramString, WeakReference paramWeakReference)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramWeakReference);
  }
  
  public static boolean a(View paramView)
  {
    return GdtUIUtils.a(paramView) > 0.5D;
  }
  
  private boolean b(View paramView)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values();
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
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(View paramView)
  {
    GdtLog.a("GdtImpressionPolicy", "report view: " + paramView.hashCode());
    GdtAd localGdtAd = a(paramView);
    if (localGdtAd == null)
    {
      GdtLog.a("GdtImpressionPolicy", "break: statistics == null");
      return;
    }
    if (localGdtAd.reportState == 2)
    {
      GdtLog.a("GdtImpressionPolicy", "break: already report " + localGdtAd.getTraceId());
      return;
    }
    if (!a(paramView))
    {
      GdtLog.a("GdtImpressionPolicy", "break: isVisibleAreaSatisfied not");
      return;
    }
    a(paramView, localGdtAd);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    WeakReference localWeakReference = new WeakReference(paramView);
    localMessage.obj = localWeakReference;
    if (!b(paramView))
    {
      GdtLog.a("GdtImpressionPolicy", "inCountingMap not " + localGdtAd.getTraceId());
      a(localGdtAd.getTraceId(), localWeakReference);
    }
    localGdtAd.reportState = 1;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    GdtLog.a("GdtImpressionPolicy", "handleMessage : ");
    if ((paramMessage == null) || (paramMessage.obj == null)) {}
    GdtAd localGdtAd;
    Object localObject;
    for (;;)
    {
      return false;
      paramMessage = (WeakReference)paramMessage.obj;
      if (paramMessage.get() != null)
      {
        paramMessage = (View)paramMessage.get();
        localGdtAd = a(paramMessage);
        if (localGdtAd == null)
        {
          GdtLog.a("GdtImpressionPolicy", "break: statistics == null");
        }
        else if (localGdtAd.reportState != 1)
        {
          GdtLog.a("GdtImpressionPolicy", "break: statistics.reportState != 1 " + localGdtAd.getTraceId());
        }
        else if (!a(paramMessage))
        {
          GdtLog.a("GdtImpressionPolicy", "break: isVisibleAreaSatisfied not " + localGdtAd.getTraceId());
          localGdtAd.reportState = -1;
        }
        else if (!b(paramMessage))
        {
          GdtLog.a("GdtImpressionPolicy", "break: inCountingMap not " + localGdtAd.getTraceId());
        }
        else
        {
          localObject = paramMessage.getTag(2131362463);
          if (localObject == null)
          {
            GdtLog.a("GdtImpressionPolicy", "break: o2 == null " + localGdtAd.getTraceId());
          }
          else
          {
            if ((localObject instanceof GdtImpressionPolicy.ReportListener)) {
              break;
            }
            GdtLog.a("GdtImpressionPolicy", "break: o2 instanceof ReportListener not " + localGdtAd.getTraceId());
          }
        }
      }
    }
    ((GdtImpressionPolicy.ReportListener)localObject).a(paramMessage);
    localGdtAd.reportState = 2;
    GdtLog.a("GdtImpressionPolicy", "report " + localGdtAd.getTraceId());
    a(localGdtAd.getTraceId());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtImpressionPolicy
 * JD-Core Version:    0.7.0.1
 */