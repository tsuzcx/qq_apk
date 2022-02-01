package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.support.v7.widget.RecyclerView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class AEVideoStoryDashboardPart$2
  implements CompoundButton.OnCheckedChangeListener
{
  AEVideoStoryDashboardPart$2(AEVideoStoryDashboardPart paramAEVideoStoryDashboardPart) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = AEVideoStoryDashboardPart.a(this.a);
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    paramCompoundButton.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.2
 * JD-Core Version:    0.7.0.1
 */