package com.tencent.gdtad.aditem;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.statistics.AdRelationTargetMatch;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.views.canvas.AdCanvasJsonManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class GdtPreLoader
{
  private static volatile GdtPreLoader a;
  
  public static GdtPreLoader a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new GdtPreLoader();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void b(GdtAd paramGdtAd)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if ((localBaseApplication != null) && (paramGdtAd != null) && (paramGdtAd.isValid()))
    {
      AdRelationTargetMatch.handle(new WeakReference(localBaseApplication), paramGdtAd);
      return;
    }
    GdtLog.d("GdtPreLoader", "dealAdReltargetMatch error params error");
  }
  
  private void c(GdtAd paramGdtAd)
  {
    AdCanvasJsonManager.getInstance().init(BaseApplicationImpl.getContext());
    if ((paramGdtAd != null) && (paramGdtAd.isValid()))
    {
      if (TextUtils.isEmpty(paramGdtAd.getCanvas())) {
        return;
      }
      int i;
      if ((!paramGdtAd.isWebXiJing()) && (!paramGdtAd.isAppXiJing()) && (!paramGdtAd.isAppXiJingDefault())) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        return;
      }
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
        GdtLog.d("GdtPreLoader", "preloadCanvasJsonAfterAdLoaded error");
        return;
      }
      catch (JSONException paramGdtAd)
      {
        GdtLog.d("GdtPreLoader", "preloadCanvasJsonAfterAdLoaded error", paramGdtAd);
      }
    }
  }
  
  private void d(GdtAd paramGdtAd)
  {
    if (paramGdtAd != null)
    {
      if (!paramGdtAd.isValid()) {
        return;
      }
      if ((!paramGdtAd.isAppXiJingOffline()) && (!paramGdtAd.isWebXiJingOffline())) {
        return;
      }
      AdThreadManager.INSTANCE.post(new GdtPreLoader.2(this, paramGdtAd), 5);
      AdCanvasJsonManager.getInstance().init(BaseApplicationImpl.getContext());
      if (!TextUtils.isEmpty(AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramGdtAd, paramGdtAd.getJSONKeyForXiJingOffline(), false))) {
        return;
      }
      AdCanvasJsonManager.getInstance().preloadCanvasJson(paramGdtAd, paramGdtAd.getJSONKeyForXiJingOffline(), paramGdtAd.getJSONUrlForXiJingOffline());
    }
  }
  
  private void e(GdtAd paramGdtAd)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadVideoAfterAdLoaded() called with: ad = [");
    localStringBuilder.append(paramGdtAd);
    localStringBuilder.append("]");
    GdtLog.a("GdtPreLoader", localStringBuilder.toString());
    if (paramGdtAd != null)
    {
      if (!paramGdtAd.isVideoSplice()) {
        return;
      }
      new Handler(Looper.getMainLooper()).post(new GdtPreLoader.3(this, paramGdtAd));
    }
  }
  
  private void f(GdtAd paramGdtAd)
  {
    GdtManager.a().a(BaseApplicationImpl.getContext(), null);
    boolean bool;
    if ((paramGdtAd != null) && (paramGdtAd.isInterstitial())) {
      bool = true;
    } else {
      bool = false;
    }
    GdtLog.b("GdtPreLoader", String.format("preDownloadInterstitialAfterAdLoaded isInterstitial:%b", new Object[] { Boolean.valueOf(bool) }));
    if (bool) {
      ((IGdtInterstitialAPI)QRoute.api(IGdtInterstitialAPI.class)).preDownload(BaseApplicationImpl.getContext());
    }
  }
  
  @Deprecated
  public void a(GdtAd paramGdtAd)
  {
    GdtLog.b("GdtPreLoader", "preLoadAfterAdLoaded");
    new Handler(Looper.getMainLooper()).post(new GdtPreLoader.1(this, paramGdtAd));
    e(paramGdtAd);
    c(paramGdtAd);
    d(paramGdtAd);
    f(paramGdtAd);
    b(paramGdtAd);
    AdAnalysisHelperForUtil.reportForPreload(BaseApplicationImpl.getContext(), paramGdtAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader
 * JD-Core Version:    0.7.0.1
 */