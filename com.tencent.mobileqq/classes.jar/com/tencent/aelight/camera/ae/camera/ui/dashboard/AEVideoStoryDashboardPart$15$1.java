package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.widget.TextView;

class AEVideoStoryDashboardPart$15$1
  implements Runnable
{
  AEVideoStoryDashboardPart$15$1(AEVideoStoryDashboardPart.15 param15, Float paramFloat) {}
  
  public void run()
  {
    TextView localTextView = AEVideoStoryDashboardPart.k(this.b.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("当前帧率:");
    localStringBuilder.append(this.a);
    localTextView.setText(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.15.1
 * JD-Core Version:    0.7.0.1
 */