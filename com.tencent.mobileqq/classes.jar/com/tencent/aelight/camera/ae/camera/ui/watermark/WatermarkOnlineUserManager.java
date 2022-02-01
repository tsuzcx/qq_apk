package com.tencent.aelight.camera.ae.camera.ui.watermark;

import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import java.util.Random;

public class WatermarkOnlineUserManager
{
  private static volatile WatermarkOnlineUserManager jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkOnlineUserManager;
  private final int jdField_a_of_type_Int = 2000;
  private long jdField_a_of_type_Long = 0L;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final int jdField_b_of_type_Int = 60000;
  private long jdField_b_of_type_Long = 0L;
  private final int c = 1000;
  private int d = 0;
  
  public static WatermarkOnlineUserManager a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkOnlineUserManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkOnlineUserManager == null) {
          jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkOnlineUserManager = new WatermarkOnlineUserManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkOnlineUserManager;
  }
  
  private void a()
  {
    AppInterface localAppInterface = QQStoryContext.a();
    if (localAppInterface != null)
    {
      CameraPeakServiceHandler localCameraPeakServiceHandler = (CameraPeakServiceHandler)localAppInterface.getBusinessHandler(PeakAppInterface.d);
      localAppInterface.addObserver(new WatermarkOnlineUserManager.3(this, localAppInterface));
      localCameraPeakServiceHandler.e();
    }
  }
  
  private void a(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    if (paramLong - l > 1000L)
    {
      this.jdField_a_of_type_Long = paramLong;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.d != 0) {
          this.d = (this.d - 1000 + new Random().nextInt(2000));
        }
        return;
      }
    }
    if (paramLong - l < 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
  }
  
  private void b(long paramLong)
  {
    long l = this.jdField_b_of_type_Long;
    if (paramLong - l > 60000L)
    {
      this.jdField_b_of_type_Long = paramLong;
      new Thread(new WatermarkOnlineUserManager.1(this)).start();
      return;
    }
    if (paramLong - l < 0L) {
      this.jdField_b_of_type_Long = paramLong;
    }
  }
  
  public int a()
  {
    long l = System.currentTimeMillis();
    b(l);
    a(l);
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkOnlineUserManager
 * JD-Core Version:    0.7.0.1
 */