package com.tencent.mobileqq.app.hiddenchat;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class HiddenChatFragment$4
  extends FriendListObserver
{
  HiddenChatFragment$4(HiddenChatFragment paramHiddenChatFragment) {}
  
  protected void onSetHiddenChatSwitch(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
    {
      String[] arrayOfString = (String[])paramArrayOfObject[0];
      paramArrayOfObject = (boolean[])paramArrayOfObject[1];
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, new Object[] { "res:", Boolean.valueOf(paramBoolean), " len1:", Integer.valueOf(arrayOfString.length), " len2:", Integer.valueOf(paramArrayOfObject.length) });
      }
      if (paramBoolean)
      {
        this.a.a();
        if (QLog.isColorLevel()) {
          QLog.d("tag_hidden_chat", 2, "onSetHiddenChatSwitch");
        }
      }
      return;
    }
    QLog.e("tag_hidden_chat", 1, "data not right");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment.4
 * JD-Core Version:    0.7.0.1
 */