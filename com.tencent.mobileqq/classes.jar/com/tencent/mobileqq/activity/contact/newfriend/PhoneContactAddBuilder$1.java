package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.activity.contact.newfriend.msg.PhoneContactAddMessage;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class PhoneContactAddBuilder$1
  implements Runnable
{
  PhoneContactAddBuilder$1(PhoneContactAddBuilder paramPhoneContactAddBuilder) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(((PhoneContactAddMessage)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactAddBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.PhoneContactAddBuilder.1
 * JD-Core Version:    0.7.0.1
 */