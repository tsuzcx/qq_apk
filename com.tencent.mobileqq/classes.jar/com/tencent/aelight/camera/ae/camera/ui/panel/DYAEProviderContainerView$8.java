package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import java.util.List;

class DYAEProviderContainerView$8
  implements Observer<AEBeautyConfigModel>
{
  DYAEProviderContainerView$8(DYAEProviderContainerView paramDYAEProviderContainerView) {}
  
  public void a(AEBeautyConfigModel paramAEBeautyConfigModel)
  {
    if (!paramAEBeautyConfigModel.i().isEmpty())
    {
      DYAEProviderContainerView.a(this.a, paramAEBeautyConfigModel);
      if (DYAEProviderContainerView.k(this.a).getVisibility() != 0) {
        DYAEProviderContainerView.l(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEProviderContainerView.8
 * JD-Core Version:    0.7.0.1
 */