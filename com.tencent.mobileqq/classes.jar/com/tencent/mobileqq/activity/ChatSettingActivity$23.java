package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;

class ChatSettingActivity$23
  extends MessageObserver
{
  ChatSettingActivity$23(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onInsertIntoBlackList(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.d(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.g(this.a);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "onInsertIntoBlackList, isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.e(this.a)))) {
        ChatSettingActivity.a(this.a, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.a, 2, "onInsertIntoBlackList, mIsShield=" + ChatSettingActivity.a(this.a));
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131719330, 1);
  }
  
  public void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.d(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "onRemoveFromBlackList, isSuccess=" + paramBoolean);
    }
    ChatSettingActivity.g(this.a);
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.e(this.a)))) {
        ChatSettingActivity.a(this.a, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.a, 2, "onRemoveFromBlackList, mIsShield=" + ChatSettingActivity.a(this.a));
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131719330, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.23
 * JD-Core Version:    0.7.0.1
 */