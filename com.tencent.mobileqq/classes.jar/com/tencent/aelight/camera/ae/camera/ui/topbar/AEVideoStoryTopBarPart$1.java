package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.view.AECompoundButton;

class AEVideoStoryTopBarPart$1
  implements Observer<AEVideoStoryTopBarViewModel.CountDownSetting>
{
  AEVideoStoryTopBarPart$1(AEVideoStoryTopBarPart paramAEVideoStoryTopBarPart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.CountDownSetting paramCountDownSetting)
  {
    if (paramCountDownSetting == null) {
      return;
    }
    AEVideoStoryTopBarPart.a(this.a).setSelected(paramCountDownSetting.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart.1
 * JD-Core Version:    0.7.0.1
 */