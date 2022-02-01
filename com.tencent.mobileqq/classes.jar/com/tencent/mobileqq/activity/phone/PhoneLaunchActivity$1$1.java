package com.tencent.mobileqq.activity.phone;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;

class PhoneLaunchActivity$1$1
  extends ContactBindObserver
{
  PhoneLaunchActivity$1$1(PhoneLaunchActivity.1 param1) {}
  
  protected void onUploadContact(boolean paramBoolean, int paramInt)
  {
    PhoneLaunchActivity.a(this.a.this$0).setEnabled(true);
    if (this.a.this$0.a != null)
    {
      this.a.this$0.app.unRegistObserver(this.a.this$0.a);
      this.a.this$0.a = null;
    }
    this.a.this$0.dismissProgressDialog();
    if (paramBoolean)
    {
      Object localObject = this.a.this$0;
      if ((!PhoneLaunchActivity.a(this.a.this$0)) && (!PhoneLaunchActivity.b(this.a.this$0)))
      {
        localObject = new Intent((Context)localObject, SettingActivity2.class);
        if (PhoneLaunchActivity.c(this.a.this$0)) {
          ((Intent)localObject).putExtra("kSrouce", 7);
        }
        this.a.this$0.startActivityForResult((Intent)localObject, 2);
        this.a.this$0.setResult(-1);
        this.a.this$0.finish();
        return;
      }
      this.a.this$0.setResult(-1);
      this.a.this$0.finish();
      return;
    }
    this.a.this$0.showToast(HardCodeUtil.a(2131708015));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchActivity.1.1
 * JD-Core Version:    0.7.0.1
 */