package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.testpkg.IProxyForTestCap;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.qqcamerakit.capture.CameraProxy.PictureCallback;
import com.tencent.qqcamerakit.capture.CameraSize;
import java.io.File;

class AECameraManager$7
  implements Runnable
{
  AECameraManager$7(AECameraManager paramAECameraManager, Size paramSize, File paramFile, CameraProxy.PictureCallback paramPictureCallback) {}
  
  public void run()
  {
    AECameraManager.access$700(this.this$0).a(new CameraSize(this.val$previewSize.a(), this.val$previewSize.b()), AECameraManager.access$300(this.this$0), this.val$photoFile.getPath(), AECameraManager.access$900(this.this$0), this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraManager.7
 * JD-Core Version:    0.7.0.1
 */