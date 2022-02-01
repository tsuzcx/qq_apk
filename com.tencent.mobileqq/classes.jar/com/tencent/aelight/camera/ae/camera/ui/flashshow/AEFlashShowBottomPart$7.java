package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.CountDownSetting;
import com.tencent.aelight.camera.ae.view.CountDownView;

class AEFlashShowBottomPart$7
  implements Observer<AEVideoStoryTopBarViewModel.CountDownSetting>
{
  AEFlashShowBottomPart$7(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.CountDownSetting paramCountDownSetting)
  {
    if (paramCountDownSetting == null) {
      return;
    }
    boolean bool = paramCountDownSetting.a();
    if (bool) {
      AEFlashShowBottomPart.o(this.a);
    } else if (AEFlashShowBottomPart.p(this.a) != null) {
      AEFlashShowBottomPart.p(this.a).a();
    }
    AEFlashShowBottomPart.n(this.a).a(bool, new AEFlashShowBottomPart.7.1(this, paramCountDownSetting));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.7
 * JD-Core Version:    0.7.0.1
 */