package com.tencent.aelight.camera.ae;

import android.os.Process;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.concurrent.CountDownLatch;

class AEPituCameraUnit$9
  implements Runnable
{
  AEPituCameraUnit$9(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    try
    {
      AEQLog.b(this.this$0.a, "[AEPituCameraUnit] unit init ENTER");
      Process.setThreadPriority(-2);
    }
    catch (Exception localException)
    {
      String str = this.this$0.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UnitAsyncInit] setThreadPriority exception: ");
      localStringBuilder.append(localException.getMessage());
      AEQLog.d(str, localStringBuilder.toString());
    }
    try
    {
      AEQLog.b(this.this$0.a, "[AEPituCameraUnit] unit init BEGIN");
      AEPituCameraUnit.b(this.this$0);
      AEQLog.b(this.this$0.a, "[AEPituCameraUnit] initAEKitReport-end");
      return;
    }
    finally
    {
      AEPituCameraUnit.a(this.this$0).countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.9
 * JD-Core Version:    0.7.0.1
 */