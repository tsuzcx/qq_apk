package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchItem;

class AssistantSettingActivity$29
  implements Runnable
{
  AssistantSettingActivity$29(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void run()
  {
    String str = this.this$0.getIntent().getStringExtra("jumpTo");
    if ("haibao".equals(str)) {
      if ((AssistantSettingActivity.a(this.this$0) != null) && (AssistantSettingActivity.a(this.this$0).getVisibility() == 0)) {
        this.this$0.a.scrollTo(0, AssistantSettingActivity.a(this.this$0).getTop());
      }
    }
    while ((!"color_note_recently_viewed".equals(str)) || (AssistantSettingActivity.a(this.this$0) == null) || (AssistantSettingActivity.a(this.this$0).getVisibility() != 0)) {
      return;
    }
    this.this$0.a.scrollTo(0, AssistantSettingActivity.a(this.this$0).getTop());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.29
 * JD-Core Version:    0.7.0.1
 */