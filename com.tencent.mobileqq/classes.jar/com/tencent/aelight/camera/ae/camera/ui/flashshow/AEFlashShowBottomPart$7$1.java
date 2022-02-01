package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.CountDownSetting;
import com.tencent.aelight.camera.ae.view.CountDownView;
import com.tencent.aelight.camera.aebase.view.IAECaptureButton.CountDownDelegate;

class AEFlashShowBottomPart$7$1
  implements IAECaptureButton.CountDownDelegate
{
  AEFlashShowBottomPart$7$1(AEFlashShowBottomPart.7 param7, AEVideoStoryTopBarViewModel.CountDownSetting paramCountDownSetting) {}
  
  public void a()
  {
    if (AEFlashShowBottomPart.p(this.b.a) != null) {
      AEFlashShowBottomPart.p(this.b.a).a(this.a.b(), false);
    }
    if (AEFlashShowBottomPart.q(this.b.a) != null) {
      AEFlashShowBottomPart.q(this.b.a).e().postValue(Boolean.valueOf(false));
    }
    AEFlashShowBottomPart.n(this.b.a).setTouchEnable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.7.1
 * JD-Core Version:    0.7.0.1
 */