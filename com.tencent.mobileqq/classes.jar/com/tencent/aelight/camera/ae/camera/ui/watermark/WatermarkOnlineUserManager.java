package com.tencent.aelight.camera.ae.camera.ui.watermark;

import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import java.util.Random;

public class WatermarkOnlineUserManager
{
  private static volatile WatermarkOnlineUserManager a;
  private final int b = 2000;
  private final int c = 60000;
  private final int d = 1000;
  private long e = 0L;
  private long f = 0L;
  private int g = 0;
  private final Object h = new Object();
  
  public static WatermarkOnlineUserManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WatermarkOnlineUserManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(long paramLong)
  {
    long l = this.e;
    if (paramLong - l > 1000L)
    {
      this.e = paramLong;
      synchronized (this.h)
      {
        if (this.g != 0) {
          this.g = (this.g - 1000 + new Random().nextInt(2000));
        }
        return;
      }
    }
    if (paramLong - l < 0L) {
      this.e = paramLong;
    }
  }
  
  private void b(long paramLong)
  {
    long l = this.f;
    if (paramLong - l > 60000L)
    {
      this.f = paramLong;
      new Thread(new WatermarkOnlineUserManager.1(this)).start();
      return;
    }
    if (paramLong - l < 0L) {
      this.f = paramLong;
    }
  }
  
  private void c()
  {
    AppInterface localAppInterface = QQStoryContext.k();
    if (localAppInterface != null)
    {
      CameraPeakServiceHandler localCameraPeakServiceHandler = (CameraPeakServiceHandler)localAppInterface.getBusinessHandler(PeakAppInterface.e);
      localAppInterface.addObserver(new WatermarkOnlineUserManager.3(this, localAppInterface));
      localCameraPeakServiceHandler.g();
    }
  }
  
  public int b()
  {
    long l = System.currentTimeMillis();
    b(l);
    a(l);
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkOnlineUserManager
 * JD-Core Version:    0.7.0.1
 */