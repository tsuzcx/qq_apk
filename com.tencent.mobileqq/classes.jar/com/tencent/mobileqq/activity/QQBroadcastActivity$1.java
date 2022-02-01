package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;

class QQBroadcastActivity$1
  extends Handler
{
  QQBroadcastActivity$1(QQBroadcastActivity paramQQBroadcastActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1010) {
      return;
    }
    if (this.a.d != null) {
      this.a.d.changeCursor(this.a.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity.1
 * JD-Core Version:    0.7.0.1
 */