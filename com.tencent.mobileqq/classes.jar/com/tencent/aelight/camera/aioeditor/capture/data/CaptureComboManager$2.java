package com.tencent.aelight.camera.aioeditor.capture.data;

import android.os.Handler.Callback;
import android.os.Message;

class CaptureComboManager$2
  implements Handler.Callback
{
  CaptureComboManager$2(CaptureComboManager paramCaptureComboManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 2) && ((paramMessage.obj instanceof CaptureSet))) {
      paramMessage = (CaptureSet)paramMessage.obj;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.2
 * JD-Core Version:    0.7.0.1
 */