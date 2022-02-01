package com.tencent.aelight.camera.ae.camera.ui.bottom;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import mqq.os.MqqHandler;

class AEBottomListAdapter$1
  implements INetEventHandler
{
  AEBottomListAdapter$1(AEBottomListAdapter paramAEBottomListAdapter) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.1
 * JD-Core Version:    0.7.0.1
 */