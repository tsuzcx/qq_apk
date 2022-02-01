package com.tencent.gdtad.impl;

import android.content.Context;
import android.os.Handler;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.aditem.GdtWxHandler;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.GdtManager.Params;
import java.lang.ref.WeakReference;

public class GdtAdAPIImpl
  implements IGdtAdAPI
{
  public static final String TAG = "GdtAdAPIImpl";
  
  public void doCgiReport(String paramString)
  {
    GdtReporter.doCgiReport(paramString);
  }
  
  public void handleGdtAdClick(GdtHandler.Params paramParams)
  {
    GdtHandler.a(paramParams);
  }
  
  public void initGdtContext(Context paramContext, InitGdtContextParams paramInitGdtContextParams)
  {
    if (paramInitGdtContextParams != null) {
      paramInitGdtContextParams = new GdtManager.Params();
    } else {
      paramInitGdtContextParams = null;
    }
    GdtManager.a().a(paramContext, paramInitGdtContextParams);
  }
  
  public AdClickUtil.Result jumpToWechatMiniApp(Handler paramHandler, GdtAd paramGdtAd)
  {
    return GdtWxHandler.a(paramHandler, paramGdtAd);
  }
  
  public GdtAdLoader loadAd(GdtAdLoader.Session paramSession, WeakReference<GdtAdLoader.Listener> paramWeakReference, WeakReference<Context> paramWeakReference1)
  {
    paramSession = new GdtAdLoader(paramSession, paramWeakReference);
    paramSession.a(paramWeakReference1);
    return paramSession;
  }
  
  public void preLoadAfterAdLoaded(Context paramContext, GdtAd paramGdtAd)
  {
    GdtPreLoader.a().a(paramGdtAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.impl.GdtAdAPIImpl
 * JD-Core Version:    0.7.0.1
 */