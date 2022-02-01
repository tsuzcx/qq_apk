package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.extendfriend.limitchat.AioLimitColdPalaceHelper;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;

class ChatSettingActivity$2
  extends ExtendFriendObserver
{
  ChatSettingActivity$2(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onReqThrowToColdPalace(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if (TextUtils.equals(paramString, ChatSettingActivity.a(this.a))) {
      AioLimitColdPalaceHelper.a(this.a.app, this.a, paramBoolean1, paramInt, paramString, paramBoolean2, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */