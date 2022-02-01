package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.chat.IAioColdPalaceHelper;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qroute.QRoute;

class ChatSettingActivity$2
  extends ExpandObserver
{
  ChatSettingActivity$2(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if (TextUtils.equals(paramString, ChatSettingActivity.a(this.a)))
    {
      IAioColdPalaceHelper localIAioColdPalaceHelper = (IAioColdPalaceHelper)QRoute.api(IAioColdPalaceHelper.class);
      QQAppInterface localQQAppInterface = this.a.app;
      ChatSettingActivity localChatSettingActivity = this.a;
      localIAioColdPalaceHelper.doOnReqThrowToColdPalace(localQQAppInterface, localChatSettingActivity, paramBoolean1, paramInt, paramString, paramBoolean2, localChatSettingActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */