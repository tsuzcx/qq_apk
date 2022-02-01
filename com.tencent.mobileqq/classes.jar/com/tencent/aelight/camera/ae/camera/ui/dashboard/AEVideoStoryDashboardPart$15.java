package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEVideoStoryDashboardPart$15
  implements Observer<Float>
{
  AEVideoStoryDashboardPart$15(AEVideoStoryDashboardPart paramAEVideoStoryDashboardPart) {}
  
  public void a(Float paramFloat)
  {
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.15.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.15
 * JD-Core Version:    0.7.0.1
 */