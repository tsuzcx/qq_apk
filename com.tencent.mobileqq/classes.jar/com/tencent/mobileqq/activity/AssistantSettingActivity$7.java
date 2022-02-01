package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;

class AssistantSettingActivity$7
  extends C2CShortcutBarObserver
{
  AssistantSettingActivity$7(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
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
    AssistantSettingActivity.a(this.a, 2131690784, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.7
 * JD-Core Version:    0.7.0.1
 */