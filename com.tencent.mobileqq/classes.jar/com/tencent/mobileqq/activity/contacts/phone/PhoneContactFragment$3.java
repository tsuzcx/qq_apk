package com.tencent.mobileqq.activity.contacts.phone;

import android.os.Handler;
import com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView;
import com.tencent.qphone.base.util.QLog;

class PhoneContactFragment$3
  implements Runnable
{
  PhoneContactFragment$3(PhoneContactFragment paramPhoneContactFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContactFragment", 2, "reset data");
    }
    if (this.this$0.f != null) {
      this.this$0.f.a(PhoneContactFragment.g(this.this$0));
    }
    this.this$0.h.removeCallbacks(PhoneContactFragment.h(this.this$0));
    this.this$0.h.postDelayed(PhoneContactFragment.h(this.this$0), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment.3
 * JD-Core Version:    0.7.0.1
 */