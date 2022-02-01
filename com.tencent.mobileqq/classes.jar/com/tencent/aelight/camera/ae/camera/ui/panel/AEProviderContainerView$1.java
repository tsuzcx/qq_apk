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
    if (i != 2064121977)
    {
      if (i != 2064122198) {
        return;
      }
      StoryReportor.a("clk_filter", StoryReportor.b(-1), 0, false, new String[0]);
      if (AEProviderContainerView.a(this.a) == 0) {
        return;
      }
      AEProviderContainerView.a(this.a);
      return;
    }
    StoryReportor.a("clk_beauty", StoryReportor.b(-1), 0, false, new String[0]);
    if (AEProviderContainerView.a(this.a) == 1) {
      return;
    }
    AEProviderContainerView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderContainerView.1
 * JD-Core Version:    0.7.0.1
 */