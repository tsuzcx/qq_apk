package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.activity.contact.newfriend.msg.ContactMatchMessage;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ContactMatchBuilder$1
  implements Runnable
{
  ContactMatchBuilder$1(ContactMatchBuilder paramContactMatchBuilder) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(((ContactMatchMessage)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a);
    ThreadManager.getUIHandler().post(new ContactMatchBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.ContactMatchBuilder.1
 * JD-Core Version:    0.7.0.1
 */