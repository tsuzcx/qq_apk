package com.tencent.mobileqq.adapter;

import akkd;
import avun;
import avuw;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

public class NewFriendMoreSysMsgAdapter$9
  implements Runnable
{
  public NewFriendMoreSysMsgAdapter$9(akkd paramakkd, avun paramavun) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.this$0.a.getManager(11)).a(((avuw)this.a).a);
    this.this$0.a.runOnUiThread(new NewFriendMoreSysMsgAdapter.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.9
 * JD-Core Version:    0.7.0.1
 */