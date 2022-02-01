package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.log.AEQLog;

class DYAEProviderContainerView$13
  implements Observer<Boolean>
{
  DYAEProviderContainerView$13(DYAEProviderContainerView paramDYAEProviderContainerView) {}
  
  public void a(Boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AiBeautyToggle---onChanged: ");
    localStringBuilder.append(paramBoolean);
    AEQLog.b("AEProviderContainerView", localStringBuilder.toString());
    if (paramBoolean == null) {
      return;
    }
    if (paramBoolean.booleanValue()) {
      paramBoolean = ResourcesCompat.getDrawable(this.a.getResources(), 2063925252, null);
    } else {
      paramBoolean = ResourcesCompat.getDrawable(this.a.getResources(), 2063925251, null);
    }
    paramBoolean.setBounds(0, 0, DYAEProviderContainerView.c(this.a, 16), DYAEProviderContainerView.c(this.a, 16));
    DYAEProviderContainerView.q(this.a).setCompoundDrawables(paramBoolean, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEProviderContainerView.13
 * JD-Core Version:    0.7.0.1
 */