package com.tencent.mobileqq.activity.contacts.alphabet;

import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;

class AlphabetFriendAdapter$4
  implements Runnable
{
  AlphabetFriendAdapter$4(AlphabetFriendAdapter paramAlphabetFriendAdapter, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlphabetFriendAdapter", 2, "notifyDataSetChanged out ThreadManager");
    }
    AlphabetFriendAdapter localAlphabetFriendAdapter = this.this$0;
    Object[] arrayOfObject = this.a;
    localAlphabetFriendAdapter.a = ((LinkedHashMap)arrayOfObject[0]);
    localAlphabetFriendAdapter.b = ((int[])arrayOfObject[1]);
    localAlphabetFriendAdapter.c = ((String[])arrayOfObject[2]);
    AlphabetFriendAdapter.b(localAlphabetFriendAdapter);
    this.this$0.e();
    AlphabetFriendAdapter.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter.4
 * JD-Core Version:    0.7.0.1
 */