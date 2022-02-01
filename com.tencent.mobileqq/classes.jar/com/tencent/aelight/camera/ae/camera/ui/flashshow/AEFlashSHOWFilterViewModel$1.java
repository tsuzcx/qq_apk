package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class AEFlashSHOWFilterViewModel$1
  implements Observer
{
  AEFlashSHOWFilterViewModel$1(AEFlashSHOWFilterViewModel paramAEFlashSHOWFilterViewModel) {}
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    ThreadManager.getUIHandler().post(new AEFlashSHOWFilterViewModel.1.1(this));
    QLog.i("AEFlashSHOWFilterViewModel", 4, "RECEIVE DATA.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashSHOWFilterViewModel.1
 * JD-Core Version:    0.7.0.1
 */