package com.tencent.avgame.qav;

import com.tencent.av.camera.CameraObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class AVGameCameraAssistant$4
  extends CameraObserver
{
  AVGameCameraAssistant$4(AVGameCameraAssistant paramAVGameCameraAssistant) {}
  
  protected void a(long paramLong)
  {
    try
    {
      Iterator localIterator = AVGameCameraAssistant.a(this.b).iterator();
      while (localIterator.hasNext())
      {
        AVGameCameraAssistant.CameraEventListener localCameraEventListener = (AVGameCameraAssistant.CameraEventListener)localIterator.next();
        if (localCameraEventListener != null) {
          localCameraEventListener.a(paramLong);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("AVGameCameraAssistant", 1, "onBeforeCloseCamera", localThrowable);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = AVGameCameraAssistant.a(this.b).iterator();
      while (localIterator.hasNext())
      {
        AVGameCameraAssistant.CameraEventListener localCameraEventListener = (AVGameCameraAssistant.CameraEventListener)localIterator.next();
        if (localCameraEventListener != null) {
          localCameraEventListener.a(paramLong, paramBoolean);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("AVGameCameraAssistant", 1, "onBeforeOpenCamera", localThrowable);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    try
    {
      Iterator localIterator = AVGameCameraAssistant.a(this.b).iterator();
      while (localIterator.hasNext())
      {
        AVGameCameraAssistant.CameraEventListener localCameraEventListener = (AVGameCameraAssistant.CameraEventListener)localIterator.next();
        if (localCameraEventListener != null) {
          localCameraEventListener.b(paramLong, paramBoolean);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("AVGameCameraAssistant", 1, "onAfterOpenCamera", localThrowable);
    }
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = AVGameCameraAssistant.a(this.b).iterator();
      while (localIterator.hasNext())
      {
        AVGameCameraAssistant.CameraEventListener localCameraEventListener = (AVGameCameraAssistant.CameraEventListener)localIterator.next();
        if (localCameraEventListener != null) {
          localCameraEventListener.c(paramLong, paramBoolean);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("AVGameCameraAssistant", 1, "onAfterCloseCamera", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameCameraAssistant.4
 * JD-Core Version:    0.7.0.1
 */