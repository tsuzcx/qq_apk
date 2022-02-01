package com.tencent.mobileqq.activity.contacts.phone;

import com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

class PhoneContactFragment$2
  implements Runnable
{
  PhoneContactFragment$2(PhoneContactFragment paramPhoneContactFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "reset data for ui");
    }
    if (this.this$0.f != null) {
      this.this$0.f.b(PhoneContactFragment.c(this.this$0));
    }
    if (this.this$0.b != null)
    {
      if (this.this$0.c == null)
      {
        PhoneContactFragment localPhoneContactFragment = this.this$0;
        localPhoneContactFragment.c = new PhoneContactAdapter(PhoneContactFragment.d(localPhoneContactFragment), PhoneContactFragment.e(this.this$0), this.this$0.b, 1, true, this.this$0);
        this.this$0.b.setAdapter(this.this$0.c);
      }
      this.this$0.c.a(PhoneContactFragment.f(this.this$0));
      this.this$0.c.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment.2
 * JD-Core Version:    0.7.0.1
 */