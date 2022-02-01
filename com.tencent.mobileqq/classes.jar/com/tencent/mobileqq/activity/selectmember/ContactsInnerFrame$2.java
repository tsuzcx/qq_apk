package com.tencent.mobileqq.activity.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class ContactsInnerFrame$2
  extends ContactBindObserver
{
  ContactsInnerFrame$2(ContactsInnerFrame paramContactsInnerFrame) {}
  
  public void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.a.unRegistObserver(this);
    switch (ContactsInnerFrame.a(this.a).d())
    {
    case 2: 
    case 3: 
    case 4: 
    case 8: 
    default: 
      ContactsInnerFrame.c(this.a);
      return;
    case 0: 
    case 7: 
    case 9: 
      ContactsInnerFrame.a(this.a);
      return;
    case 1: 
    case 5: 
      ContactsInnerFrame.b(this.a);
      return;
    }
    if (ContactsInnerFrame.a(this.a).a().lastUsedFlag == 2L)
    {
      ContactsInnerFrame.a(this.a);
      return;
    }
    ContactsInnerFrame.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame.2
 * JD-Core Version:    0.7.0.1
 */