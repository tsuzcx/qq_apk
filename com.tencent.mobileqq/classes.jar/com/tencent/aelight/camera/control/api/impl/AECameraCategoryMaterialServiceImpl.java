package com.tencent.aelight.camera.control.api.impl;

import android.os.Build.VERSION;
import com.tencent.aelight.camera.ae.config.CameraDataServiceHandler;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.control.api.IAECameraCategoryMaterialService;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

public class AECameraCategoryMaterialServiceImpl
  implements IAECameraCategoryMaterialService
{
  private static final String LAST_ENTRY_TIME = "lasttime";
  private static final String LAST_ENTRY_VERSION = "last_entry_version";
  private static final String TAG = "CameraCategoryMaterialService";
  CameraDataServiceHandler mHandler;
  
  private long getLastEntryTime()
  {
    return AECameraPrefsUtil.a().a("lasttime", 0L, 0);
  }
  
  private String getLastEntryVersion()
  {
    return AECameraPrefsUtil.a().a("last_entry_version", "", 4);
  }
  
  private void setLastEntryTime(long paramLong)
  {
    AECameraPrefsUtil.a().a("lasttime", paramLong, 0);
  }
  
  private void setLastVersion(String paramString)
  {
    AECameraPrefsUtil.a().a("last_entry_version", paramString, 4);
  }
  
  public void doStep()
  {
    if (this.mHandler == null)
    {
      AEQLog.d("CameraCategoryMaterialService", "[CameraCategoryMaterialStep] mHandler is null.");
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (System.currentTimeMillis() - getLastEntryTime() > 86400000L)
      {
        setLastEntryTime(System.currentTimeMillis());
        setLastVersion(AppSetting.a());
        this.mHandler.a("MqStoryCamera");
        this.mHandler.a("MqEmoCamera");
        this.mHandler.a("MqCircleWatermark");
        this.mHandler.c();
        this.mHandler.b();
        ((IAEResDownload)QRoute.api(IAEResDownload.class)).preDownloadAERes();
        return;
      }
      if (!AppSetting.a().equals(getLastEntryVersion()))
      {
        setLastVersion(AppSetting.a());
        this.mHandler.b();
        ((IAEResDownload)QRoute.api(IAEResDownload.class)).preDownloadAERes();
      }
    }
    else
    {
      AEQLog.d("CameraCategoryMaterialService", "[CameraCategoryMaterialStep] Build.VERSION.SDK_INT < 5.0");
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    try
    {
      if ((paramAppRuntime instanceof AppInterface))
      {
        paramAppRuntime = (AppInterface)paramAppRuntime;
        this.mHandler = ((CameraDataServiceHandler)paramAppRuntime.getBusinessHandler("com.tencent.aelight.camera.ae.config.CameraDataServiceHandler"));
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onCreate] init error, not in QQAppInterface! appRuntime = ");
      localStringBuilder.append(paramAppRuntime);
      AEQLog.d("CameraCategoryMaterialService", localStringBuilder.toString());
      return;
    }
    catch (Throwable paramAppRuntime)
    {
      AEQLog.a("CameraCategoryMaterialService", "[onCreate] init error!", paramAppRuntime);
    }
  }
  
  public void onDestroy()
  {
    this.mHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.control.api.impl.AECameraCategoryMaterialServiceImpl
 * JD-Core Version:    0.7.0.1
 */