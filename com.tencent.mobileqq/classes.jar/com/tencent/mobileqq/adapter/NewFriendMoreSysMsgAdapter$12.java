package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class NewFriendMoreSysMsgAdapter$12
  implements Runnable
{
  NewFriendMoreSysMsgAdapter$12(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter, NewFriendMessage paramNewFriendMessage) {}
  
  public void run()
  {
    ((QIMNewFriendManager)this.this$0.a.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).b(((QIMNotifyAddFriendMsg)this.a).a);
    this.this$0.a.runOnUiThread(new NewFriendMoreSysMsgAdapter.12.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.12
 * JD-Core Version:    0.7.0.1
 */