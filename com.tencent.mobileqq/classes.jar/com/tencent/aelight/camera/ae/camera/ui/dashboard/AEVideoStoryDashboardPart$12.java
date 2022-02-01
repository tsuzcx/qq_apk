package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import org.light.utils.LightLogUtil;

class AEVideoStoryDashboardPart$12
  implements CompoundButton.OnCheckedChangeListener
{
  AEVideoStoryDashboardPart$12(AEVideoStoryDashboardPart paramAEVideoStoryDashboardPart) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 7;
    }
    LightLogUtil.setMinPriority(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.12
 * JD-Core Version:    0.7.0.1
 */