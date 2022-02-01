package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;

class DYAEProviderContainerView$12
  implements Observer<Integer>
{
  DYAEProviderContainerView$12(DYAEProviderContainerView paramDYAEProviderContainerView) {}
  
  public void a(Integer paramInteger)
  {
    if (paramInteger == null) {
      return;
    }
    int m = paramInteger.intValue();
    int j = 1;
    int k = 0;
    int i = j;
    if (m != 1) {
      if (paramInteger.intValue() == 2) {
        i = j;
      } else {
        i = 0;
      }
    }
    Object localObject = DYAEProviderContainerView.q(this.a);
    if (i != 0) {
      j = 0;
    } else {
      j = 8;
    }
    ((TextView)localObject).setVisibility(j);
    localObject = DYAEProviderContainerView.r(this.a);
    if (i != 0) {
      i = k;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    DYAEProviderContainerView.b(this.a, paramInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEProviderContainerView.12
 * JD-Core Version:    0.7.0.1
 */