package com.tencent.gdtad.aditem;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.AdCanvasJsonManager;
import com.tencent.ad.tangram.statistics.AdRelationTargetMatch;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class GdtPreLoader
{
  private static volatile GdtPreLoader a;
  
  public static GdtPreLoader a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new GdtPreLoader();
      }
      return a;
    }
    finally {}
  }
  
  private void b(GdtAd paramGdtAd)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if ((localBaseApplication == null) || (paramGdtAd == null) || (!paramGdtAd.isValid()))
    {
      GdtLog.d("GdtPreLoader", "dealAdReltargetMatch error params error");
      return;
    }
    AdRelationTargetMatch.handle(new WeakReference(localBaseApplication), paramGdtAd);
  }
  
  private void c(GdtAd paramGdtAd)
  {
    int i = 0;
    AdCanvasJsonManager.getInstance().init(BaseApplicationImpl.getContext());
    if ((paramGdtAd == null) || (!paramGdtAd.isValid()) || (TextUtils.isEmpty(paramGdtAd.getCanvas()))) {}
    do
    {
      return;
      if ((paramGdtAd.isWebXiJing()) || (paramGdtAd.isAppXiJing()) || (paramGdtAd.isAppXiJingDefault())) {
        i = 1;
      }
    } while (i == 0);
    try
    {
      Object localObject = new JSONObject(paramGdtAd.getCanvas());
      String str = ((JSONObject)localObject).optString("canvas_json_key");
      localObject = ((JSONObject)localObject).optString("canvas_json_url");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramGdtAd, str, false))))
      {
        AdCanvasJsonManager.getInstance().preloadCanvasJson(paramGdtAd, str, (String)localObject);
        return;
      }
    }
    catch (JSONException paramGdtAd)
    {
      GdtLog.d("GdtPreLoader", "preloadCanvasJsonAfterAdLoaded error", paramGdtAd);
      return;
    }
    GdtLog.d("GdtPreLoader", "preloadCanvasJsonAfterAdLoaded error");
  }
  
  private void d(GdtAd paramGdtAd)
  {
    if ((paramGdtAd == null) || (!paramGdtAd.isValid())) {}
    do
    {
      do
      {
        return;
      } while ((!paramGdtAd.isAppXiJingOffline()) && (!paramGdtAd.isWebXiJingOffline()));
      AdThreadManager.INSTANCE.post(new GdtPreLoader.2(this, paramGdtAd), 5);
      AdCanvasJsonManager.getInstance().init(BaseApplicationImpl.getContext());
    } while (!TextUtils.isEmpty(AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramGdtAd, paramGdtAd.getJSONKeyForXiJingOffline(), false)));
    AdCanvasJsonManager.getInstance().preloadCanvasJson(paramGdtAd, paramGdtAd.getJSONKeyForXiJingOffline(), paramGdtAd.getJSONUrlForXiJingOffline());
  }
  
  private void e(GdtAd paramGdtAd)
  {
    GdtLog.a("GdtPreLoader", "preloadVideoAfterAdLoaded() called with: ad = [" + paramGdtAd + "]");
    if ((paramGdtAd == null) || (!paramGdtAd.isVideoSplice())) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new GdtPreLoader.3(this, paramGdtAd));
  }
  
  private void f(GdtAd paramGdtAd)
  {
    GdtManager.a().a(BaseApplicationImpl.getContext(), null);
    if ((paramGdtAd != null) && (paramGdtAd.isInterstitial())) {}
    for (boolean bool = true;; bool = false)
    {
      GdtLog.b("GdtPreLoader", String.format("preDownloadInterstitialAfterAdLoaded isInterstitial:%b", new Object[] { Boolean.valueOf(bool) }));
      if (bool) {
        GdtInterstitialPreDownloader.a().b(BaseApplicationImpl.getContext());
      }
      return;
    }
  }
  
  public void a(GdtAd paramGdtAd)
  {
    GdtLog.b("GdtPreLoader", "preLoadAfterAdLoaded");
    new Handler(Looper.getMainLooper()).post(new GdtPreLoader.1(this, paramGdtAd));
    e(paramGdtAd);
    c(paramGdtAd);
    d(paramGdtAd);
    f(paramGdtAd);
    b(paramGdtAd);
    AdReporterForAnalysis.reportForPreload(BaseApplicationImpl.getContext(), paramGdtAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader
 * JD-Core Version:    0.7.0.1
 */