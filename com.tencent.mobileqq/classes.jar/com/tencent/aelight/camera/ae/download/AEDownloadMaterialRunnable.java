package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.ae.config.CameraDataServiceHandler;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;

public class AEDownloadMaterialRunnable
  implements Runnable
{
  private static final String a = "AEDownloadMaterialRunnable";
  
  public void run()
  {
    AEQLog.a(a, "download material");
    CameraDataServiceHandler localCameraDataServiceHandler = (CameraDataServiceHandler)QQStoryContext.k().getBusinessHandler(PeakAppInterface.e);
    localCameraDataServiceHandler.a("MqStoryCamera");
    localCameraDataServiceHandler.a("MqEmoCamera");
    localCameraDataServiceHandler.a("MqKuaishanCamera");
    localCameraDataServiceHandler.a("MqCircleWatermark");
    localCameraDataServiceHandler.d();
    localCameraDataServiceHandler.c();
    localCameraDataServiceHandler.b();
    VSConfigManager.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEDownloadMaterialRunnable
 * JD-Core Version:    0.7.0.1
 */