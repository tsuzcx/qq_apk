package com.tencent.mobileqq.activity;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.widget.FormSwitchItem;

class NotifyPushSettingActivity$25
  implements Handler.Callback
{
  NotifyPushSettingActivity$25(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      int i = paramMessage.what;
      boolean bool;
      switch (i)
      {
      default: 
        return false;
      case 10004: 
        NotifyPushSettingActivity.i(this.a).setChecked(((Boolean)paramMessage.obj).booleanValue());
        break;
      case 10003: 
        bool = ((Boolean)paramMessage.obj).booleanValue();
        NotifyPushSettingActivity.h(this.a).setChecked(bool);
        break;
      case 10002: 
        paramMessage = (String)paramMessage.obj;
        NotifyPushSettingActivity.b(this.a, paramMessage);
        break;
      case 10001: 
        paramMessage = (String)paramMessage.obj;
        NotifyPushSettingActivity.a(this.a, paramMessage);
        break;
      case 10000: 
        bool = ((Boolean)paramMessage.obj).booleanValue();
        NotifyPushSettingActivity.g(this.a).setChecked(bool);
      }
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.25
 * JD-Core Version:    0.7.0.1
 */