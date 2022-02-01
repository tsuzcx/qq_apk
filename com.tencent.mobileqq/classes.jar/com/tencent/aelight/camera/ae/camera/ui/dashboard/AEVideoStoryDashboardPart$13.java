package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import com.tencent.mobileqq.app.ThreadManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.os.MqqHandler;

class AEVideoStoryDashboardPart$13
  implements EIPCResultCallback
{
  AEVideoStoryDashboardPart$13(AEVideoStoryDashboardPart paramAEVideoStoryDashboardPart) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.13.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.13
 * JD-Core Version:    0.7.0.1
 */