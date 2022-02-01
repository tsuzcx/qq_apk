package com.tencent.mobileqq.adapter;

import aigo;
import aigx;
import alkj;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

public class NewFriendMoreSysMsgAdapter$9
  implements Runnable
{
  public NewFriendMoreSysMsgAdapter$9(alkj paramalkj, aigo paramaigo) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.this$0.a.getManager(11)).a(((aigx)this.a).a);
    this.this$0.a.runOnUiThread(new NewFriendMoreSysMsgAdapter.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.9
 * JD-Core Version:    0.7.0.1
 */