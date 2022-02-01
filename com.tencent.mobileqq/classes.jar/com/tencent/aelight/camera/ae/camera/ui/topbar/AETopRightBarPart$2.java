package com.tencent.aelight.camera.ae.camera.ui.topbar;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AETopRightBarPart$2
  implements Observer<Boolean>
{
  AETopRightBarPart$2(AETopRightBarPart paramAETopRightBarPart) {}
  
  public void a(Boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new AETopRightBarPart.2.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AETopRightBarPart.2
 * JD-Core Version:    0.7.0.1
 */