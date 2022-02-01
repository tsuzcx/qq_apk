package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.biz.videostory.animator.AnimationListener.Stop;
import com.tencent.mobileqq.utils.ViewUtils;

class DYAEProviderContainerView$16
  implements AnimationListener.Stop
{
  DYAEProviderContainerView$16(DYAEProviderContainerView paramDYAEProviderContainerView, Runnable paramRunnable) {}
  
  public void a()
  {
    ViewUtils.setVisible(DYAEProviderContainerView.k(this.b), 4);
    Runnable localRunnable = this.a;
    if (localRunnable != null) {
      this.b.post(localRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEProviderContainerView.16
 * JD-Core Version:    0.7.0.1
 */