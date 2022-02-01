package com.tencent.aelight.camera.aioeditor.capture.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ProviderContainerView$1
  implements View.OnClickListener
{
  ProviderContainerView$1(ProviderContainerView paramProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    int j = ProviderContainerView.a(this.a).c(i);
    if (j == 102) {
      ProviderContainerView.a(this.a).b();
    } else {
      this.a.a(i);
    }
    this.a.b(j);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onclick, index: ");
      paramView.append(i);
      QLog.i("ProviderContainerView", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.ProviderContainerView.1
 * JD-Core Version:    0.7.0.1
 */