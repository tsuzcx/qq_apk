package com.tencent.mobileqq.activity.contact.newfriend;

import afjp;
import atys;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ContactMatchBuilder$1
  implements Runnable
{
  public ContactMatchBuilder$1(afjp paramafjp) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(((atys)this.this$0.jdField_a_of_type_Atyy).a);
    ThreadManager.getUIHandler().post(new ContactMatchBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.ContactMatchBuilder.1
 * JD-Core Version:    0.7.0.1
 */