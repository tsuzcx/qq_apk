package com.tencent.mobileqq.app;

import aubn;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneContactManagerImp$12
  implements Runnable
{
  PhoneContactManagerImp$12(PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.this$0))
    {
      Iterator localIterator = PhoneContactManagerImp.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((aubn)localIterator.next()).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp.12
 * JD-Core Version:    0.7.0.1
 */