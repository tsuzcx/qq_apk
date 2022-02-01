package com.tencent.mobileqq.activity.contact.phonecontact;

import axfs;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneContactManagerImp$12
  implements Runnable
{
  PhoneContactManagerImp$12(PhoneContactManagerImp paramPhoneContactManagerImp, long paramLong) {}
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.this$0))
    {
      Iterator localIterator = PhoneContactManagerImp.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((axfs)localIterator.next()).a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.12
 * JD-Core Version:    0.7.0.1
 */