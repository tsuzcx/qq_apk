package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;

class AEPituCameraUnit$39
  implements Runnable
{
  AEPituCameraUnit$39(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    if (this.this$0.al != null)
    {
      FilterPagerViewStubHolder localFilterPagerViewStubHolder = this.this$0.al;
      boolean bool;
      if (this.this$0.x == AECaptureMode.NORMAL) {
        bool = true;
      } else {
        bool = false;
      }
      localFilterPagerViewStubHolder.d(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.39
 * JD-Core Version:    0.7.0.1
 */