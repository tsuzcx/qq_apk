package com.tencent.mobileqq.activity;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$6
  implements View.OnClickListener
{
  AssistantSettingActivity$6(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    if ((Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0)) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = FloatingScreenPermission.checkPermission(BaseApplicationImpl.getContext());
      if (i == 0) {
        this.a.requestPermissions(new AssistantSettingActivity.6.1(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
      }
      if (!bool) {
        FloatingScreenPermission.requestPermission(this.a);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.6
 * JD-Core Version:    0.7.0.1
 */