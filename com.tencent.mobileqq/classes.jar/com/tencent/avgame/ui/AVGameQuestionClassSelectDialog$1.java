package com.tencent.avgame.ui;

import android.os.Handler.Callback;
import android.os.Message;

class AVGameQuestionClassSelectDialog$1
  implements Handler.Callback
{
  AVGameQuestionClassSelectDialog$1(AVGameQuestionClassSelectDialog paramAVGameQuestionClassSelectDialog) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    paramMessage = this.a;
    int i;
    if (AVGameQuestionClassSelectDialog.a(paramMessage) > 0) {
      i = AVGameQuestionClassSelectDialog.a(this.a) - 1;
    } else {
      i = 0;
    }
    AVGameQuestionClassSelectDialog.a(paramMessage, i);
    AVGameQuestionClassSelectDialog.b(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameQuestionClassSelectDialog.1
 * JD-Core Version:    0.7.0.1
 */