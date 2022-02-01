package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$30
  implements View.OnClickListener
{
  AssistantSettingActivity$30(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("start_from", 2);
    ColorNoteSettingFragment.a(paramView.getContext(), ColorNoteSettingFragment.class, localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.30
 * JD-Core Version:    0.7.0.1
 */