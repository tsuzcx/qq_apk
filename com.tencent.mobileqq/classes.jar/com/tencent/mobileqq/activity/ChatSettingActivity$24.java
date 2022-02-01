package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;

class ChatSettingActivity$24
  extends MessageObserver
{
  ChatSettingActivity$24(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void onInsertIntoBlackList(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.w(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.v(this.a);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInsertIntoBlackList, isSuccess=");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.p(this.a)))) {
        ChatSettingActivity.a(this.a, true);
      }
      if (QLog.isColorLevel())
      {
        paramString = this.a.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onInsertIntoBlackList, mIsShield=");
        ((StringBuilder)localObject).append(ChatSettingActivity.h(this.a));
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
      }
      ChatSettingActivity.i(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131916584, 1);
  }
  
  protected void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.w(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRemoveFromBlackList, isSuccess=");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    ChatSettingActivity.v(this.a);
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.p(this.a)))) {
        ChatSettingActivity.a(this.a, false);
      }
      if (QLog.isColorLevel())
      {
        paramString = this.a.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRemoveFromBlackList, mIsShield=");
        ((StringBuilder)localObject).append(ChatSettingActivity.h(this.a));
        QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
      }
      ChatSettingActivity.i(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131916584, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.24
 * JD-Core Version:    0.7.0.1
 */