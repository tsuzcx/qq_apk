package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class AEVideoStoryDashboardPart$4
  implements View.OnClickListener
{
  AEVideoStoryDashboardPart$4(AEVideoStoryDashboardPart paramAEVideoStoryDashboardPart) {}
  
  public void onClick(View paramView)
  {
    paramView = AEVideoStoryDashboardPart.c(this.a).getText();
    if (TextUtils.isEmpty(paramView)) {
      return;
    }
    AEVideoStoryDashboardPart.a(this.a, paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.4
 * JD-Core Version:    0.7.0.1
 */