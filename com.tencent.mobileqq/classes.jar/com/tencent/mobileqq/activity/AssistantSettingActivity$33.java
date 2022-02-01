package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$33
  implements View.OnClickListener
{
  AssistantSettingActivity$33(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    PublicFragmentActivity.Launcher.a(paramView.getContext(), localIntent, PublicFragmentActivity.class, BottomTabSettingFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.33
 * JD-Core Version:    0.7.0.1
 */