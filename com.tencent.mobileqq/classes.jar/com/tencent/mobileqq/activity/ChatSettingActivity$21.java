package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;

class ChatSettingActivity$21
  extends CardObserver
{
  ChatSettingActivity$21(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.a.r != null) && (paramBoolean2 != this.a.r.a()))
    {
      this.a.r.setOnCheckedChangeListener(null);
      this.a.r.setChecked(paramBoolean2);
      this.a.r.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void onSetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.a.r != null) && (paramBoolean2 != this.a.r.a()))
    {
      this.a.r.setOnCheckedChangeListener(null);
      this.a.r.setChecked(paramBoolean2);
      this.a.r.setOnCheckedChangeListener(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.21
 * JD-Core Version:    0.7.0.1
 */