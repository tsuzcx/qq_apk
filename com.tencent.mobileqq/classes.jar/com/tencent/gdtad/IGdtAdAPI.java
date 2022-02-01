package com.tencent.gdtad;

import android.content.Context;
import android.os.Handler;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.lang.ref.WeakReference;

@QAPI(process={"all"})
public abstract interface IGdtAdAPI
  extends QRouteApi
{
  @Deprecated
  public abstract void doCgiReport(String paramString);
  
  public abstract void handleGdtAdClick(GdtHandler.Params paramParams);
  
  public abstract void initGdtContext(Context paramContext, InitGdtContextParams paramInitGdtContextParams);
  
  public abstract AdClickUtil.Result jumpToWechatMiniApp(Handler paramHandler, GdtAd paramGdtAd);
  
  public abstract GdtAdLoader loadAd(GdtAdLoader.Session paramSession, WeakReference<GdtAdLoader.Listener> paramWeakReference, WeakReference<Context> paramWeakReference1);
  
  public abstract void preLoadAfterAdLoaded(Context paramContext, GdtAd paramGdtAd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.IGdtAdAPI
 * JD-Core Version:    0.7.0.1
 */