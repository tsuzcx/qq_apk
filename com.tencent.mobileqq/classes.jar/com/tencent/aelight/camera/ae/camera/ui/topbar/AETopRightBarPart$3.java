package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.view.AECompoundButton;

class AETopRightBarPart$3
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  AETopRightBarPart$3(AETopRightBarPart paramAETopRightBarPart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == null) {
      return;
    }
    if (AETopRightBarPart.i(this.a) != null)
    {
      if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL)
      {
        AETopRightBarPart.i(this.a).getForegroundView().setImageResource(2063925371);
        return;
      }
      if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_16_9) {
        AETopRightBarPart.i(this.a).getForegroundView().setImageResource(2063925370);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AETopRightBarPart.3
 * JD-Core Version:    0.7.0.1
 */