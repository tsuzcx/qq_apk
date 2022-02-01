package com.tencent.avgame.qav;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import nnt;

class AVGameCameraAssistant$2
  implements Runnable
{
  AVGameCameraAssistant$2(AVGameCameraAssistant paramAVGameCameraAssistant) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = AVGameCameraAssistant.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        nnt localnnt = (nnt)localIterator.next();
        if (localnnt != null) {
          localnnt.a();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("AVGameCameraAssistant", 1, "notifyCameraNoData", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameCameraAssistant.2
 * JD-Core Version:    0.7.0.1
 */