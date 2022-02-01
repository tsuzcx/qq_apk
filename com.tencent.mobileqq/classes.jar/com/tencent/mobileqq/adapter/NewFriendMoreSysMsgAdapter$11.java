package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.PhoneContactAddMessage;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class NewFriendMoreSysMsgAdapter$11
  implements Runnable
{
  NewFriendMoreSysMsgAdapter$11(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter, NewFriendMessage paramNewFriendMessage) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.this$0.a.getManager(QQManagerFactory.CONTACT_MANAGER)).a(((PhoneContactAddMessage)this.a).a);
    this.this$0.a.runOnUiThread(new NewFriendMoreSysMsgAdapter.11.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.11
 * JD-Core Version:    0.7.0.1
 */