package com.tencent.mobileqq.activity.contact.phonecontact;

import axfs;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneContactManagerImp$10
  implements Runnable
{
  PhoneContactManagerImp$10(PhoneContactManagerImp paramPhoneContactManagerImp, int paramInt) {}
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.this$0))
    {
      Iterator localIterator = PhoneContactManagerImp.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((axfs)localIterator.next()).b(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.10
 * JD-Core Version:    0.7.0.1
 */