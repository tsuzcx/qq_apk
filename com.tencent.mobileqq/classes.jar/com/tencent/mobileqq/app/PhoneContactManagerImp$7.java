package com.tencent.mobileqq.app;

import aroi;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneContactManagerImp$7
  implements Runnable
{
  PhoneContactManagerImp$7(PhoneContactManagerImp paramPhoneContactManagerImp, int paramInt) {}
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.this$0))
    {
      Iterator localIterator = PhoneContactManagerImp.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((aroi)localIterator.next()).c(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp.7
 * JD-Core Version:    0.7.0.1
 */