package com.tencent.mobileqq.activity.phone;

import agku;
import com.tencent.mobileqq.app.QQAppInterface;

public class SettingActivity2$3
  implements Runnable
{
  SettingActivity2$3(SettingActivity2 paramSettingActivity2) {}
  
  public void run()
  {
    if (this.this$0.c == null)
    {
      this.this$0.c = new agku(this);
      this.this$0.app.registObserver(this.this$0.c);
    }
    this.this$0.app.a(new SettingActivity2.3.2(this));
    this.this$0.a(2131719292, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.3
 * JD-Core Version:    0.7.0.1
 */