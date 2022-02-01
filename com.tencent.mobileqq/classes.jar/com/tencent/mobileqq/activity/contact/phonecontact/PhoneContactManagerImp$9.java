package com.tencent.mobileqq.activity.contact.phonecontact;

import awza;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneContactManagerImp$9
  implements Runnable
{
  PhoneContactManagerImp$9(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.this$0))
    {
      try
      {
        Iterator localIterator = PhoneContactManagerImp.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((awza)localIterator.next()).a(this.this$0.a);
        }
        localObject = finally;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.9
 * JD-Core Version:    0.7.0.1
 */