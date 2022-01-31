package com.tencent.mobileqq.app;

import askm;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneContactManagerImp$10
  implements Runnable
{
  PhoneContactManagerImp$10(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.this$0))
    {
      try
      {
        Iterator localIterator = PhoneContactManagerImp.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((askm)localIterator.next()).a(this.this$0.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp.10
 * JD-Core Version:    0.7.0.1
 */