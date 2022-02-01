package com.tencent.mobileqq.activity.contact.newfriend;

import aize;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class NewFriendBindContactGuideBuilderV2$1
  implements Runnable
{
  public NewFriendBindContactGuideBuilderV2$1(aize paramaize) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.this$0.a.getManager(QQManagerFactory.CONTACT_MANAGER);
    localPhoneContactManagerImp.j();
    localPhoneContactManagerImp.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendBindContactGuideBuilderV2.1
 * JD-Core Version:    0.7.0.1
 */