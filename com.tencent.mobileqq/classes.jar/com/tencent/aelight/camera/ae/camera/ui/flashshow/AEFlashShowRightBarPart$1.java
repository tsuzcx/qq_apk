package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.CountDownSetting;
import com.tencent.aelight.camera.ae.view.AECompoundButton;

class AEFlashShowRightBarPart$1
  implements Observer<AEVideoStoryTopBarViewModel.CountDownSetting>
{
  AEFlashShowRightBarPart$1(AEFlashShowRightBarPart paramAEFlashShowRightBarPart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.CountDownSetting paramCountDownSetting)
  {
    if (paramCountDownSetting == null) {
      return;
    }
    if ((!paramCountDownSetting.a()) && (AEFlashShowRightBarPart.a(this.a) != null)) {
      AEFlashShowRightBarPart.a(this.a).getForegroundView().setImageResource(2063925321);
    }
    int i = paramCountDownSetting.b();
    if (i != 0)
    {
      if (i != 3)
      {
        if (i != 10) {
          return;
        }
        AEFlashShowRightBarPart.a(this.a, 0);
        AEFlashShowRightBarPart.a(this.a, false);
        return;
      }
      AEFlashShowRightBarPart.a(this.a, 10);
      AEFlashShowRightBarPart.a(this.a, true);
      return;
    }
    AEFlashShowRightBarPart.a(this.a, 3);
    AEFlashShowRightBarPart.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowRightBarPart.1
 * JD-Core Version:    0.7.0.1
 */