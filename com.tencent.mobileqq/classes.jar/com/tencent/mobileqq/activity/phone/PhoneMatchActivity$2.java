package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import awqx;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

class PhoneMatchActivity$2
  implements Runnable
{
  PhoneMatchActivity$2(PhoneMatchActivity paramPhoneMatchActivity) {}
  
  public void run()
  {
    ThreadManager.excute(new PhoneMatchActivity.2.1(this), 16, null, false);
    if (this.this$0.getIntent().getBooleanExtra("key_from_Tab", false)) {
      awqx.b(this.this$0.app, "CliOper", "", "", "0X80053DE", "0X80053DE", 0, 0, "", "", "", "");
    }
    if (this.this$0.getIntent().getBooleanExtra("key_from_l_w", false)) {
      awqx.b(this.this$0.app, "dc00898", "", "", "0X800650C", "0X800650C", 2, 0, this.this$0.app.c(), "", "", "");
    }
    awqx.b(this.this$0.app, "dc00898", "", "", "0X800689C", "0X800689C", 0, 0, "", "", "", "");
    int i = this.this$0.getIntent().getIntExtra("kSrouce", 0);
    ContactBindedActivity.a(this.this$0.app, i, 2, null);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchActivity.2
 * JD-Core Version:    0.7.0.1
 */