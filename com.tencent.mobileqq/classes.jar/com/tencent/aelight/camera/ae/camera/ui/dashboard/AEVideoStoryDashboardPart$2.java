package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;

class AEVideoStoryDashboardPart$2
  implements View.OnClickListener
{
  AEVideoStoryDashboardPart$2(AEVideoStoryDashboardPart paramAEVideoStoryDashboardPart) {}
  
  public void onClick(View paramView)
  {
    ThreadManager.excute(new AEVideoStoryDashboardPart.2.1(this), 64, null, true);
    AEVideoStoryDashboardPart.b(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.2
 * JD-Core Version:    0.7.0.1
 */