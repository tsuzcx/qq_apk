package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;

class ChatSettingActivity$1
  extends C2CShortcutBarObserver
{
  ChatSettingActivity$1(ChatSettingActivity paramChatSettingActivity) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.a.f != null) && (paramBoolean2 != this.a.f.a()))
      {
        this.a.f.setOnCheckedChangeListener(null);
        this.a.f.setChecked(paramBoolean2);
        this.a.f.setOnCheckedChangeListener(this.a);
      }
      return;
    }
    ChatSettingActivity.a(this.a, 2131690784, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */