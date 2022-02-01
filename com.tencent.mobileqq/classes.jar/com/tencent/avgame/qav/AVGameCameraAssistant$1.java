package com.tencent.avgame.qav;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class AVGameCameraAssistant$1
  implements Runnable
{
  AVGameCameraAssistant$1(AVGameCameraAssistant paramAVGameCameraAssistant, long paramLong) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = AVGameCameraAssistant.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        AVGameCameraAssistant.CameraEventListener localCameraEventListener = (AVGameCameraAssistant.CameraEventListener)localIterator.next();
        if (localCameraEventListener != null) {
          localCameraEventListener.b(this.a);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("AVGameCameraAssistant", 1, "notifyDevicePermission", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameCameraAssistant.1
 * JD-Core Version:    0.7.0.1
 */