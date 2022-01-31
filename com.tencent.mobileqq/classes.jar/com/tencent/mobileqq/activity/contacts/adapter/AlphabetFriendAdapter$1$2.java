package com.tencent.mobileqq.activity.contacts.adapter;

import afpc;
import com.tencent.qphone.base.util.QLog;

class AlphabetFriendAdapter$1$2
  implements Runnable
{
  AlphabetFriendAdapter$1$2(AlphabetFriendAdapter.1 param1) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlphabetFriendAdapter", 2, "notifyDataSetChanged out ThreadManager");
    }
    this.a.this$0.b();
    this.a.this$0.c();
    afpc.a(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.adapter.AlphabetFriendAdapter.1.2
 * JD-Core Version:    0.7.0.1
 */