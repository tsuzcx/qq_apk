package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class MoveToGroupActivity$5
  extends Handler
{
  MoveToGroupActivity$5(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("mWaitingDialogControlHandler operationFinished = ");
      paramMessage.append(MoveToGroupActivity.g(this.a));
      QLog.d("MoveToGroupActivity", 2, paramMessage.toString());
    }
    MoveToGroupActivity.c(this.a, true);
    if (MoveToGroupActivity.g(this.a))
    {
      this.a.a(true);
      return;
    }
    paramMessage = MoveToGroupActivity.h(this.a).obtainMessage(0);
    MoveToGroupActivity.h(this.a).sendMessageDelayed(paramMessage, 60000L);
    MoveToGroupActivity.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity.5
 * JD-Core Version:    0.7.0.1
 */