package com.tencent.mobileqq.app;

import awbw;
import awby;
import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class PhoneContactManagerImp$9
  implements Runnable
{
  PhoneContactManagerImp$9(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    Object localObject1 = PhoneContactManagerImp.a(this.this$0).a();
    ((awby)localObject1).a();
    try
    {
      Iterator localIterator = PhoneContactManagerImp.a(this.this$0).values().iterator();
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        if (localPhoneContact.isNewRecommend)
        {
          localPhoneContact.isNewRecommend = false;
          PhoneContactManagerImp.a(this.this$0).a(localPhoneContact);
        }
      }
    }
    finally
    {
      ((awby)localObject1).b();
    }
    ((awby)localObject1).b();
    localObject1 = PhoneContactManagerImp.a(this.this$0);
    if (localObject1 != null) {
      ((ContactBinded)localObject1).isReaded = true;
    }
    PhoneContactManagerImp.c(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp.9
 * JD-Core Version:    0.7.0.1
 */