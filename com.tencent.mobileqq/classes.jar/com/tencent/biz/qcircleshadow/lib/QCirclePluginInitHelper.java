package com.tencent.biz.qcircleshadow.lib;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.biz.qcircleshadow.local.QCircleShadow;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneHelper;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.os.MqqHandler;

public class QCirclePluginInitHelper
{
  private static final String TAG = "QCirclePluginInitHelper";
  private static volatile QCirclePluginInitHelper sInstance;
  
  public static void cancelPeakAlive(@NonNull Context paramContext)
  {
    ((IPeakHelperApi)QRoute.api(IPeakHelperApi.class)).cancelPeakAlive(paramContext);
  }
  
  public static void cancelQzoneAlive()
  {
    ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).cancelQzoneAlive();
  }
  
  public static QCirclePluginInitHelper getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QCirclePluginInitHelper();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static String getPluginQUA()
  {
    return QCircleShadow.a().a();
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
    return ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).isVideoSDKReady();
  }
  
  public static void preloadPeakProcess(@NonNull Context paramContext)
  {
    ((IPeakHelperApi)QRoute.api(IPeakHelperApi.class)).preloadPeakProcess(paramContext);
  }
  
  public static void preloadQZoneProcess()
  {
    ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).preloadQZoneProcess();
  }
  
  public static void preloadToolProgress()
  {
    ThreadManager.getSubThreadHandler().post(new QCirclePluginInitHelper.1());
  }
  
  public static void startFontSoDownload()
  {
    ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).startFontSoDownload();
  }
  
  public void preloadHippy()
  {
    ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).preloadHippy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper
 * JD-Core Version:    0.7.0.1
 */