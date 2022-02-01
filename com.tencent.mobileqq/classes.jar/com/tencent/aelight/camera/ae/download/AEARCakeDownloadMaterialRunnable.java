package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.ae.config.CameraDataServiceHandler;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;

public class AEARCakeDownloadMaterialRunnable
  implements Runnable
{
  private static final String a = "AEARCakeDownloadMaterialRunnable";
  
  public void run()
  {
    AEQLog.a(a, "arcake download material~~~~~~~");
    CameraDataServiceHandler localCameraDataServiceHandler = (CameraDataServiceHandler)QQStoryContext.k().getBusinessHandler(PeakAppInterface.e);
    localCameraDataServiceHandler.b();
    VSConfigManager.a().b();
    localCameraDataServiceHandler.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEARCakeDownloadMaterialRunnable
 * JD-Core Version:    0.7.0.1
 */