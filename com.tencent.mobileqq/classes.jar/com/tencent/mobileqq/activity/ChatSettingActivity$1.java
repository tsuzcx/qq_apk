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
      if ((this.a.t != null) && (paramBoolean2 != this.a.t.a()))
      {
        this.a.t.setOnCheckedChangeListener(null);
        this.a.t.setChecked(paramBoolean2);
        this.a.t.setOnCheckedChangeListener(this.a);
      }
    }
    else {
      ChatSettingActivity.a(this.a, 2131887632, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */