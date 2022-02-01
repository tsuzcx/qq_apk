package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;

class SettingActivity2$3$1
  extends ContactBindObserver
{
  SettingActivity2$3$1(SettingActivity2.3 param3) {}
  
  protected void onUploadContact(boolean paramBoolean, int paramInt)
  {
    if (this.a.this$0.c != null)
    {
      this.a.this$0.app.unRegistObserver(this.a.this$0.c);
      this.a.this$0.c = null;
    }
    this.a.this$0.dismissProgressDialog();
    if (paramBoolean)
    {
      if (this.a.this$0.c != null)
      {
        this.a.this$0.app.unRegistObserver(this.a.this$0.c);
        this.a.this$0.c = null;
      }
      this.a.this$0.a();
      this.a.this$0.setResult(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.3.1
 * JD-Core Version:    0.7.0.1
 */