package com.tencent.mobileqq.app;

import aufw;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneContactManagerImp$13
  implements Runnable
{
  PhoneContactManagerImp$13(PhoneContactManagerImp paramPhoneContactManagerImp, long paramLong) {}
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.this$0))
    {
      Iterator localIterator = PhoneContactManagerImp.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((aufw)localIterator.next()).a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp.13
 * JD-Core Version:    0.7.0.1
 */