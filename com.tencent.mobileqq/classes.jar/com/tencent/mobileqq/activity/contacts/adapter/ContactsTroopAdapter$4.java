package com.tencent.mobileqq.activity.contacts.adapter;

import afpm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;

public class ContactsTroopAdapter$4
  implements Runnable
{
  public ContactsTroopAdapter$4(afpm paramafpm) {}
  
  public void run()
  {
    ((TroopManager)this.this$0.a.getManager(52)).a();
    this.this$0.a.runOnUiThread(new ContactsTroopAdapter.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter.4
 * JD-Core Version:    0.7.0.1
 */