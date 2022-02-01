package com.tencent.aelight.camera.ae.camera.ui.topbar;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEVideoStoryTopBarPart$2
  implements Observer<Boolean>
{
  AEVideoStoryTopBarPart$2(AEVideoStoryTopBarPart paramAEVideoStoryTopBarPart) {}
  
  public void a(Boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new AEVideoStoryTopBarPart.2.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart.2
 * JD-Core Version:    0.7.0.1
 */