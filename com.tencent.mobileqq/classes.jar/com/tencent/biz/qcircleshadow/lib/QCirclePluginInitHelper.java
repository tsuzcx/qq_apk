package com.tencent.biz.qcircleshadow.lib;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneHelper;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.qzonehub.api.font.IFontManager;
import mqq.os.MqqHandler;

public class QCirclePluginInitHelper
  implements OnLoadListener
{
  public static final String RE_RANK_SO_TAG = "rerank";
  private static final String TAG = "QCirclePluginInitHelper";
  private static volatile QCirclePluginInitHelper sInstance;
  private boolean mRankSoLoaded;
  
  public static void PreloadWink(@NonNull Context paramContext)
  {
    ((IQQWinkLaucher)QRoute.api(IQQWinkLaucher.class)).preloadWink(paramContext);
  }
  
  public static void cancelPeakAlive(@NonNull Context paramContext)
  {
    ((IPeakHelperApi)QRoute.api(IPeakHelperApi.class)).cancelPeakAlive(paramContext);
  }
  
  public static void cancelQzoneAlive()
  {
    ThreadManager.getSubThreadHandler().post(new QCirclePluginInitHelper.3());
  }
  
  public static QCirclePluginInitHelper getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QCirclePluginInitHelper();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public static String getReportVersionName()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getReportVersionName();
  }
  
  public static boolean isPeakAlive(Context paramContext)
  {
    return ((IPeakHelperApi)QRoute.api(IPeakHelperApi.class)).isPeakAlive(paramContext);
  }
  
  public static boolean isVideoSDKReady()
  {
    return QQVideoPlaySDKManager.isSDKReady();
  }
  
  public static void preloadPeakProcess(@NonNull Context paramContext)
  {
    ((IPeakHelperApi)QRoute.api(IPeakHelperApi.class)).preloadPeakProcess(paramContext);
  }
  
  public static void preloadQZoneProcess()
  {
    ThreadManager.getSubThreadHandler().post(new QCirclePluginInitHelper.2());
  }
  
  public static void preloadToolProgress()
  {
    ThreadManager.getSubThreadHandler().post(new QCirclePluginInitHelper.1());
  }
  
  public static void showPermissionSettingDialog2(Activity paramActivity, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(paramActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public static void startFontSoDownload()
  {
    ((IFontManager)QRoute.api(IFontManager.class)).startFontSoDownload(null);
  }
  
  public boolean isRankSoLoaded()
  {
    return this.mRankSoLoaded;
  }
  
  public void loadSoWithSoLoadManager()
  {
    if (!this.mRankSoLoaded) {
      SoLoadManager.getInstance().load("rerank", this);
    }
  }
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if ((paramInt == 0) && (paramLoadExtResult.isSucc())) {
      this.mRankSoLoaded = true;
    }
  }
  
  public void preloadHippy()
  {
    ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).preloadHippy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper
 * JD-Core Version:    0.7.0.1
 */