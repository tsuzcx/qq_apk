package com.tencent.mobileqq.app;

import aubn;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneContactManagerImp$11
  implements Runnable
{
  PhoneContactManagerImp$11(PhoneContactManagerImp paramPhoneContactManagerImp, int paramInt) {}
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.this$0))
    {
      Iterator localIterator = PhoneContactManagerImp.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((aubn)localIterator.next()).b(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp.11
 * JD-Core Version:    0.7.0.1
 */