package com.tencent.aelight.camera.ae.camera.ui.topbar;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEAIONewTopBarPart$2
  implements Observer<Boolean>
{
  AEAIONewTopBarPart$2(AEAIONewTopBarPart paramAEAIONewTopBarPart) {}
  
  public void a(Boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new AEAIONewTopBarPart.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEAIONewTopBarPart.2
 * JD-Core Version:    0.7.0.1
 */