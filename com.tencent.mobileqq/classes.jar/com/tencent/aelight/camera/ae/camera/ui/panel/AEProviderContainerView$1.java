package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class AEProviderContainerView$1
  implements View.OnClickListener
{
  AEProviderContainerView$1(AEProviderContainerView paramAEProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2063990905)
    {
      if (i != 2063991079) {
        return;
      }
      StoryReportor.a("clk_filter", StoryReportor.c(-1), 0, false, new String[0]);
      if (AEProviderContainerView.a(this.a) == 0) {
        return;
      }
      AEProviderContainerView.b(this.a);
      return;
    }
    StoryReportor.a("clk_beauty", StoryReportor.c(-1), 0, false, new String[0]);
    if (AEProviderContainerView.a(this.a) == 1) {
      return;
    }
    AEProviderContainerView.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderContainerView.1
 * JD-Core Version:    0.7.0.1
 */