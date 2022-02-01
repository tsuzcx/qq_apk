package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.RequestPublicAccountObserver;

class ChatSettingForTroop$36
  extends TroopBindPubAccountProtocol.RequestPublicAccountObserver
{
  ChatSettingForTroop$36(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(boolean paramBoolean, long paramLong, AccountDetail paramAccountDetail)
  {
    if (paramBoolean)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 16;
      Bundle localBundle = new Bundle();
      localBundle.putString("uinname", paramAccountDetail.name);
      localBundle.putString("extra_type", paramAccountDetail.summary);
      localBundle.putLong("uin", paramLong);
      localMessage.setData(localBundle);
      this.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.36
 * JD-Core Version:    0.7.0.1
 */