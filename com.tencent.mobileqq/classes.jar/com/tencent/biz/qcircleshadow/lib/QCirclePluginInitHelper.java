package com.tencent.biz.qcircleshadow.lib;

import android.content.Context;
import android.support.annotation.NonNull;
import azjl;
import blig;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.font.FontManager;
import mqq.os.MqqHandler;
import vgw;

public class QCirclePluginInitHelper
{
  private static final String TAG = "QCirclePluginInitHelper";
  private static volatile QCirclePluginInitHelper sInstance;
  
  public static void cancelPeakAlive(@NonNull Context paramContext)
  {
    ThreadManager.getSubThreadHandler().post(new QCirclePluginInitHelper.5(paramContext));
  }
  
  public static void cancelQzoneAlive()
  {
    ThreadManager.getSubThreadHandler().post(new QCirclePluginInitHelper.3());
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
    return vgw.a().a();
  }
  
  public static String getReportVersionName()
  {
    return "8.4.8.4810";
  }
  
  public static boolean isPeakAlive(Context paramContext)
  {
    return blig.a(paramContext);
  }
  
  public static boolean isVideoSDKReady()
  {
    return azjl.a();
  }
  
  public static void preloadPeakProcess(@NonNull Context paramContext)
  {
    ThreadManager.getSubThreadHandler().post(new QCirclePluginInitHelper.4(paramContext));
  }
  
  public static void preloadQZoneProcess()
  {
    ThreadManager.getSubThreadHandler().post(new QCirclePluginInitHelper.2());
  }
  
  public static void preloadToolProgress()
  {
    ThreadManager.getSubThreadHandler().post(new QCirclePluginInitHelper.1());
  }
  
  public static void startFontSoDownload()
  {
    FontManager.getInstance().startFontSoDownload(null);
  }
  
  public void preloadHippy()
  {
    HippyQQLibraryManager.getInstance().preDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper
 * JD-Core Version:    0.7.0.1
 */