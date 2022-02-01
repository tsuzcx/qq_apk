package com.tencent.mobileqq.activity.contacts.alphabet;

import com.tencent.qphone.base.util.QLog;

class AlphabetFriendAdapter$3
  implements Runnable
{
  AlphabetFriendAdapter$3(AlphabetFriendAdapter paramAlphabetFriendAdapter) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlphabetFriendAdapter", 2, "notifyDataSetChanged out ThreadManager");
    }
    this.this$0.c();
    this.this$0.d();
    AlphabetFriendAdapter.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter.3
 * JD-Core Version:    0.7.0.1
 */