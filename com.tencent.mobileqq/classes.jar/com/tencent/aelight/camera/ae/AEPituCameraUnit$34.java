package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;

class AEPituCameraUnit$34
  implements Runnable
{
  AEPituCameraUnit$34(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    FilterPagerViewStubHolder localFilterPagerViewStubHolder = this.this$0.a;
    boolean bool;
    if (this.this$0.b == AECaptureMode.NORMAL) {
      bool = true;
    } else {
      bool = false;
    }
    localFilterPagerViewStubHolder.d(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.34
 * JD-Core Version:    0.7.0.1
 */