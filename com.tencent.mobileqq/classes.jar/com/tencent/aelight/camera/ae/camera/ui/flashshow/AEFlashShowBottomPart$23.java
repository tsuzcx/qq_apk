package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.view.CountDownView.OnCountDownListener;

class AEFlashShowBottomPart$23
  implements CountDownView.OnCountDownListener
{
  AEFlashShowBottomPart$23(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void a()
  {
    AEFlashShowBottomPart.n(this.a).setTouchEnable(true);
  }
  
  public void b()
  {
    AEFlashShowBottomPart.n(this.a).k();
    AEFlashShowBottomPart.n(this.a).setTouchEnable(true);
    if (AEFlashShowBottomPart.q(this.a) != null) {
      AEFlashShowBottomPart.q(this.a).e().postValue(Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.23
 * JD-Core Version:    0.7.0.1
 */