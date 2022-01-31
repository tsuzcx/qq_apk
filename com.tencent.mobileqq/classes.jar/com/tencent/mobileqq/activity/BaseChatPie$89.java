package com.tencent.mobileqq.activity;

import android.provider.Settings.System;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class BaseChatPie$89
  implements Runnable
{
  BaseChatPie$89(BaseChatPie paramBaseChatPie, int paramInt) {}
  
  public void run()
  {
    try
    {
      Settings.System.putInt(this.this$0.a.getApp().getContentResolver(), "listview_oversroll", this.a);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.89
 * JD-Core Version:    0.7.0.1
 */