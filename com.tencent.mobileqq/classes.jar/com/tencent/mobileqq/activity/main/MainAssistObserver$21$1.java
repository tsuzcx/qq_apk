package com.tencent.mobileqq.activity.main;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class MainAssistObserver$21$1
  implements Runnable
{
  MainAssistObserver$21$1(MainAssistObserver.21 param21, int paramInt) {}
  
  public void run()
  {
    this.b.this$0.a(32, 16, Integer.valueOf(this.a));
    Intent localIntent = new Intent("com.tencent.qq.syncQQMessage");
    this.b.a.getApp().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.21.1
 * JD-Core Version:    0.7.0.1
 */