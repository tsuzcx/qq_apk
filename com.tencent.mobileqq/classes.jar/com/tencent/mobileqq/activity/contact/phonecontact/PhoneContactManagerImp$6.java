package com.tencent.mobileqq.activity.contact.phonecontact;

import avsz;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneContactManagerImp$6
  implements Runnable
{
  PhoneContactManagerImp$6(PhoneContactManagerImp paramPhoneContactManagerImp, int paramInt) {}
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.this$0))
    {
      Iterator localIterator = PhoneContactManagerImp.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((avsz)localIterator.next()).c(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.6
 * JD-Core Version:    0.7.0.1
 */