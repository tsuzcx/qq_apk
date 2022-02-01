package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class GroupIconHelper$1
  implements Runnable
{
  GroupIconHelper$1(GroupIconHelper paramGroupIconHelper, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.a.addObserver(this.this$0);
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (localPhoneContactManagerImp != null) {
      localPhoneContactManagerImp.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper.1
 * JD-Core Version:    0.7.0.1
 */