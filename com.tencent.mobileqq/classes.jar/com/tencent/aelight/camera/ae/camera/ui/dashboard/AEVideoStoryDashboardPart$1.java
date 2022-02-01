package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.ScrollView;

class AEVideoStoryDashboardPart$1
  implements View.OnClickListener
{
  AEVideoStoryDashboardPart$1(AEVideoStoryDashboardPart paramAEVideoStoryDashboardPart) {}
  
  public void onClick(View paramView)
  {
    paramView = AEVideoStoryDashboardPart.a(this.a);
    int i;
    if (AEVideoStoryDashboardPart.a(this.a).getVisibility() == 0) {
      i = 8;
    } else {
      i = 0;
    }
    paramView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.1
 * JD-Core Version:    0.7.0.1
 */