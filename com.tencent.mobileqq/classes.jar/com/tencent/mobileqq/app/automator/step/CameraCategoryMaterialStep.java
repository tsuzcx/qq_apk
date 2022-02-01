package com.tencent.mobileqq.app.automator.step;

import android.os.Build.VERSION;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import dov.com.qq.im.ae.config.CameraDataServiceHandler;
import dov.com.qq.im.ae.download.AEResManager;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;

public class CameraCategoryMaterialStep
  extends AsyncStep
{
  private long a()
  {
    return AECameraPrefsUtil.a().a("lasttime", 0L, 0);
  }
  
  private String a()
  {
    return AECameraPrefsUtil.a().a("last_entry_version", "", 4);
  }
  
  private void a(String paramString)
  {
    AECameraPrefsUtil.a().a("last_entry_version", paramString, 4);
  }
  
  private void b(long paramLong)
  {
    AECameraPrefsUtil.a().a("lasttime", paramLong, 0);
  }
  
  public int a()
  {
    CameraDataServiceHandler localCameraDataServiceHandler;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localCameraDataServiceHandler = (CameraDataServiceHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.CAMERA_HANDLER);
      if (System.currentTimeMillis() - a() > 86400000L)
      {
        b(System.currentTimeMillis());
        a(AppSetting.a());
        localCameraDataServiceHandler.a("MqStoryCamera");
        localCameraDataServiceHandler.a("MqEmoCamera");
        localCameraDataServiceHandler.a("MqCircleWatermark");
        localCameraDataServiceHandler.b();
        localCameraDataServiceHandler.a();
        AEResManager.a().a();
      }
    }
    for (;;)
    {
      return super.a();
      if (!AppSetting.a().equals(a()))
      {
        a(AppSetting.a());
        localCameraDataServiceHandler.a();
        AEResManager.a().a();
        continue;
        AEQLog.d("QQInitHandler", "[CameraCategoryMaterialStep] Build.VERSION.SDK_INT < 5.0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CameraCategoryMaterialStep
 * JD-Core Version:    0.7.0.1
 */