package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.utils.ContactUtils;

class ChatSettingActivity$22
  extends ProfileCardObserver
{
  ChatSettingActivity$22(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {
      paramObject = (Card)paramObject;
    } else {
      paramObject = null;
    }
    if ((paramBoolean) && (paramObject != null))
    {
      if ((ChatSettingActivity.n(this.a) == 0) && (ChatSettingActivity.a(this.a).equals(paramObject.uin)))
      {
        String str = ContactUtils.a(this.a.app, ChatSettingActivity.a(this.a));
        if ((!TextUtils.isEmpty(str)) && (!str.equals(ChatSettingActivity.c(this.a)))) {
          ChatSettingActivity.a(this.a, str);
        }
      }
      if ((this.a.E != null) && (!TextUtils.isEmpty(ChatSettingActivity.a(this.a))) && (ChatSettingActivity.a(this.a).equals(paramObject.uin)))
      {
        paramObject = this.a;
        ChatSettingActivity.a(paramObject, ChatSettingActivity.g(paramObject, ChatSettingActivity.a(paramObject)), this.a.E);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.22
 * JD-Core Version:    0.7.0.1
 */