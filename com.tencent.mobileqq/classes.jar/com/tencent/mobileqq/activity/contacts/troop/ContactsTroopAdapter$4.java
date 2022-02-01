package com.tencent.mobileqq.activity.contacts.troop;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;

class ContactsTroopAdapter$4
  implements Runnable
{
  ContactsTroopAdapter$4(ContactsTroopAdapter paramContactsTroopAdapter) {}
  
  public void run()
  {
    ((TroopManager)this.this$0.a.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    this.this$0.a.runOnUiThread(new ContactsTroopAdapter.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter.4
 * JD-Core Version:    0.7.0.1
 */