package com.tencent.gdtad.aditem;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;

public class GdtAdLoader
{
  private GdtAdLoader.Session a;
  private WeakReference<GdtAdLoader.Listener> b;
  
  public GdtAdLoader(GdtAdLoader.Session paramSession, WeakReference<GdtAdLoader.Listener> paramWeakReference)
  {
    this.a = paramSession;
    this.b = paramWeakReference;
  }
  
  private void b()
  {
    new Handler(Looper.getMainLooper()).post(new GdtAdLoader.2(this));
  }
  
  private void b(WeakReference<Context> paramWeakReference)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((GdtAdLoader.Session)localObject).a != null))
    {
      int i = 0;
      while (i < this.a.a.position_info.size())
      {
        if (paramWeakReference != null) {
          localObject = (Context)paramWeakReference.get();
        } else {
          localObject = null;
        }
        AdAnalysisHelperForUtil.reportForLoadAd((Context)localObject, ((qq_ad_get.QQAdGet.PositionInfo)this.a.a.position_info.get(i)).pos_id.get());
        i += 1;
      }
      return;
    }
    GdtLog.d("GdtAdLoader", "reportForAnalysis error");
  }
  
  public GdtAdLoader.Session a()
  {
    return this.a;
  }
  
  @Deprecated
  public void a(WeakReference<Context> paramWeakReference)
  {
    ThreadManager.post(new GdtAdLoader.1(this, paramWeakReference), 5, null, true);
    b(paramWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader
 * JD-Core Version:    0.7.0.1
 */