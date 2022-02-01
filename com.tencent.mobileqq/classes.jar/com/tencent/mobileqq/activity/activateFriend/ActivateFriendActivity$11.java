package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.reminder.QQNotifyListener;

class ActivateFriendActivity$11
  implements QQNotifyListener
{
  ActivateFriendActivity$11(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public void a(AcsMsg paramAcsMsg)
  {
    Message localMessage = this.a.a.obtainMessage();
    localMessage.what = 3;
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("acsMsg", paramAcsMsg);
    localMessage.obj = localBundle;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity.11
 * JD-Core Version:    0.7.0.1
 */