package com.tencent.mobileqq.activity.contact.newfriend;

import ajjl;
import ajlz;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ContactMatchBuilder$1
  implements Runnable
{
  public ContactMatchBuilder$1(ajjl paramajjl) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(((ajlz)this.this$0.jdField_a_of_type_Ajmf).a);
    ThreadManager.getUIHandler().post(new ContactMatchBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.ContactMatchBuilder.1
 * JD-Core Version:    0.7.0.1
 */