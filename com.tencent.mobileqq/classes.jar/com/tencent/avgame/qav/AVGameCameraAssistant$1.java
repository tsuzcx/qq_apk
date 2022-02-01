package com.tencent.avgame.qav;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import nft;

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
        nft localnft = (nft)localIterator.next();
        if (localnft != null) {
          localnft.b(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameCameraAssistant.1
 * JD-Core Version:    0.7.0.1
 */