package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class TroopAssistantActivity$11
  extends FriendListObserver
{
  TroopAssistantActivity$11(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  void a(String paramString)
  {
    if (!paramString.equals(this.a.app.getAccount())) {
      return;
    }
    this.a.I.obtainMessage(1).sendToTarget();
    this.a.runOnUiThread(new TroopAssistantActivity.11.1(this));
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.I.sendEmptyMessage(1);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    if ((this.a.app.getCurrentAccountUin() != null) && (this.a.app.getCurrentAccountUin().equals(paramString)))
    {
      ThreadManager.post(new TroopAssistantActivity.11.2(this, paramString), 8, null, true);
      return;
    }
    this.a.c();
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (paramBoolean) {
      ThreadManager.post(new TroopAssistantActivity.11.3(this), 5, null, true);
    }
  }
  
  protected void onUpdateRecentList()
  {
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.11
 * JD-Core Version:    0.7.0.1
 */