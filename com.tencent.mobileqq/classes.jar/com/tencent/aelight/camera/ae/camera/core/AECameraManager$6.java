package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.testpkg.IProxyForTestCap;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.concurrent.atomic.AtomicInteger;

class AECameraManager$6
  implements Runnable
{
  AECameraManager$6(AECameraManager paramAECameraManager) {}
  
  public void run()
  {
    AEQLog.b("AECameraManager", "cameraStopPreview---ENTER");
    if (!AECameraManager.access$500(this.this$0))
    {
      AEQLog.d("AECameraManager", "cameraStopPreview---EXIT, is not previewing");
      return;
    }
    AECameraManager.access$700(this.this$0).a(false);
    AECameraManager.access$800(this.this$0).set(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraManager.6
 * JD-Core Version:    0.7.0.1
 */