package com.tencent.mobileqq.activity.contact.newfriend;

import ajam;
import ajbw;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class PhoneContactAddBuilder$1
  implements Runnable
{
  public PhoneContactAddBuilder$1(ajam paramajam) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(((ajbw)this.this$0.jdField_a_of_type_Ajbn).a);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactAddBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.PhoneContactAddBuilder.1
 * JD-Core Version:    0.7.0.1
 */