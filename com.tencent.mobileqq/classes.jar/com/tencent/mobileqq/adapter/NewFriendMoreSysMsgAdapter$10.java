package com.tencent.mobileqq.adapter;

import ajbn;
import ajby;
import amik;
import aoay;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class NewFriendMoreSysMsgAdapter$10
  implements Runnable
{
  public NewFriendMoreSysMsgAdapter$10(amik paramamik, ajbn paramajbn) {}
  
  public void run()
  {
    ((aoay)this.this$0.a.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).b(((ajby)this.a).a);
    this.this$0.a.runOnUiThread(new NewFriendMoreSysMsgAdapter.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.10
 * JD-Core Version:    0.7.0.1
 */