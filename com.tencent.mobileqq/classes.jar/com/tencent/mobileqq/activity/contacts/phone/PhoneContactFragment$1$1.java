package com.tencent.mobileqq.activity.contacts.phone;

import com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView;

class PhoneContactFragment$1$1
  implements Runnable
{
  PhoneContactFragment$1$1(PhoneContactFragment.1 param1) {}
  
  public void run()
  {
    this.a.this$0.f.b(PhoneContactFragment.b(this.a.this$0));
    if (this.a.this$0.c != null) {
      this.a.this$0.c.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment.1.1
 * JD-Core Version:    0.7.0.1
 */