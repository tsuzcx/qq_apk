package com.tencent.mobileqq.apollo.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

class HotChatCenterFragment$1
  extends FriendListObserver
{
  HotChatCenterFragment$1(HotChatCenterFragment paramHotChatCenterFragment) {}
  
  void a(String paramString)
  {
    if (!paramString.equals(HotChatCenterFragment.a(this.a).getAccount())) {}
  }
  
  public void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    while ((HotChatCenterFragment.a(this.a).getCurrentAccountUin() == null) || (!HotChatCenterFragment.a(this.a).getCurrentAccountUin().equals(paramString))) {
      return;
    }
    ThreadManager.post(new HotChatCenterFragment.1.1(this, paramString), 8, null, true);
  }
  
  public void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString) {}
  
  public void onUpdateRecentList()
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.activity.HotChatCenterFragment.1
 * JD-Core Version:    0.7.0.1
 */