package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.utils.ContactUtils;

class ChatSettingActivity$21
  extends ProfileCardObserver
{
  ChatSettingActivity$21(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null))
      {
        if ((ChatSettingActivity.a(this.a) == 0) && (ChatSettingActivity.a(this.a).equals(paramObject.uin)))
        {
          String str = ContactUtils.a(this.a.app, ChatSettingActivity.a(this.a));
          if ((!TextUtils.isEmpty(str)) && (!str.equals(ChatSettingActivity.b(this.a)))) {
            ChatSettingActivity.a(this.a, str);
          }
        }
        if ((this.a.h != null) && (!TextUtils.isEmpty(ChatSettingActivity.a(this.a))) && (ChatSettingActivity.a(this.a).equals(paramObject.uin))) {
          ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a)), this.a.h);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.21
 * JD-Core Version:    0.7.0.1
 */