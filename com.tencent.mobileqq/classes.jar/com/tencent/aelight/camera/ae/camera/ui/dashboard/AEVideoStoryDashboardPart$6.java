package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.support.v7.widget.RecyclerView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class AEVideoStoryDashboardPart$6
  implements CompoundButton.OnCheckedChangeListener
{
  AEVideoStoryDashboardPart$6(AEVideoStoryDashboardPart paramAEVideoStoryDashboardPart) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = AEVideoStoryDashboardPart.e(this.a);
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    paramCompoundButton.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.6
 * JD-Core Version:    0.7.0.1
 */