package com.tencent.mobileqq.activity.contact.phonecontact;

import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class PhoneContactManagerImp$LoadContactFriendListTask$1
  implements Comparator<PhoneContact>
{
  PhoneContactManagerImp$LoadContactFriendListTask$1(PhoneContactManagerImp.LoadContactFriendListTask paramLoadContactFriendListTask) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    return paramPhoneContact1.contactID - paramPhoneContact2.contactID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.LoadContactFriendListTask.1
 * JD-Core Version:    0.7.0.1
 */