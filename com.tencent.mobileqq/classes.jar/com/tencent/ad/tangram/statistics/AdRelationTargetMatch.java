package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdAppUtil;
import java.lang.ref.WeakReference;

@Keep
public final class AdRelationTargetMatch
{
  private static final String INSTALL_STATUS_INSTALLED = "1";
  private static final String INSTALL_STATUS_UNINSTALLED = "0";
  private static final int RELATION_TARGET_INSTALLED = 2;
  private static final int RELATION_TARGET_UNINSTALLED = 1;
  private static final int RELATION_TARGET_UNLIMITED = 0;
  private static final String TAG = "AdRelationTargetMatch";
  
  public static void handle(WeakReference<Context> paramWeakReference, Ad paramAd)
  {
    AdLog.i("AdRelationTargetMatch", "handle begin");
    if ((paramAd != null) && (paramAd.isValid()))
    {
      if (paramAd.isAppProductType())
      {
        handleApp(paramWeakReference, paramAd);
        return;
      }
      if (paramAd.isJDProductType()) {
        handleJD(paramWeakReference, paramAd);
      }
      return;
    }
    AdLog.e("AdRelationTargetMatch", "handle error. Ad invalid");
  }
  
  private static void handleApp(WeakReference<Context> paramWeakReference, Ad paramAd)
  {
    AdLog.i("AdRelationTargetMatch", "handleApp begin");
    String str = paramAd.getAppPackageName();
    int i = paramAd.getRelationTarget();
    if ((!TextUtils.isEmpty(str)) && (i > 0))
    {
      boolean bool = AdAppUtil.isInstalled((Context)paramWeakReference.get(), str);
      if ((bool) && (i == 1))
      {
        AdLog.i("AdRelationTargetMatch", "handleApp 已安装 && 定向未安装");
        report(paramWeakReference, paramAd, "1");
        return;
      }
      if ((!bool) && (i == 2))
      {
        AdLog.i("AdRelationTargetMatch", "handleApp 未安装 && 定向已安装");
        report(paramWeakReference, paramAd, "0");
      }
      return;
    }
    AdLog.i("AdRelationTargetMatch", "App packageName empty or relation target unlimited");
  }
  
  private static void handleJD(WeakReference<Context> paramWeakReference, Ad paramAd)
  {
    AdLog.i("AdRelationTargetMatch", "handleJD begin");
    String str = paramAd.getAppPackageName();
    if (TextUtils.isEmpty(str))
    {
      AdLog.i("AdRelationTargetMatch", "JD packageName empty");
      return;
    }
    if (AdAppUtil.isInstalled((Context)paramWeakReference.get(), str)) {
      str = "1";
    } else {
      str = "0";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleJD installStatus: ");
    localStringBuilder.append(str);
    AdLog.i("AdRelationTargetMatch", localStringBuilder.toString());
    report(paramWeakReference, paramAd, str);
  }
  
  private static void report(WeakReference<Context> paramWeakReference, Ad paramAd, String paramString)
  {
    AdThreadManager.INSTANCE.post(new AdRelationTargetMatch.1(paramWeakReference, paramAd, paramString), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdRelationTargetMatch
 * JD-Core Version:    0.7.0.1
 */