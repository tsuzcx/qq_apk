package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.app.QQAppInterface;

class SettingActivity2$3
  implements Runnable
{
  SettingActivity2$3(SettingActivity2 paramSettingActivity2) {}
  
  public void run()
  {
    if (this.this$0.c == null)
    {
      this.this$0.c = new SettingActivity2.3.1(this);
      this.this$0.app.registObserver(this.this$0.c);
    }
    this.this$0.app.execute(new SettingActivity2.3.2(this));
    this.this$0.a(2131719050, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.3
 * JD-Core Version:    0.7.0.1
 */