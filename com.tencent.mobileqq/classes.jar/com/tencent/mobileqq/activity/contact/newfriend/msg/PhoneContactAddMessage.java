package com.tencent.mobileqq.activity.contact.newfriend.msg;

import com.tencent.mobileqq.data.PhoneContactAdd;

public class PhoneContactAddMessage
  extends NewFriendMessage
{
  public PhoneContactAdd a;
  
  public PhoneContactAddMessage(PhoneContactAdd paramPhoneContactAdd)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd = paramPhoneContactAdd;
    this.jdField_a_of_type_Long = paramPhoneContactAdd.timestamp;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.msg.PhoneContactAddMessage
 * JD-Core Version:    0.7.0.1
 */