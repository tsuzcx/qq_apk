package com.tencent.aelight.camera.aioeditor.capture.data;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class CaptureComboManager$1
  implements Handler.Callback
{
  CaptureComboManager$1(CaptureComboManager paramCaptureComboManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    this.a.a.removeMessages(1);
    if (this.a.a()) {
      this.a.a.sendEmptyMessageDelayed(1, 50L);
    }
    if (paramMessage.arg2 == 7)
    {
      int i = paramMessage.arg1;
      paramMessage = (CaptureSet)paramMessage.obj;
      Message.obtain(this.a.c, 7, i, 0, paramMessage).sendToTarget();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.1
 * JD-Core Version:    0.7.0.1
 */