package com.tencent.mobileqq.activity;

import android.os.Build.VERSION;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.setting.AssistantSwitchImpl;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.mobileqq.qassistant.wake.WakeServiceCallBack;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$4
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$4(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject;
    if (!NetworkUtil.d(this.a))
    {
      AssistantSettingActivity.a(this.a, 2131694510, 1);
      localObject = this.a;
      if (!paramBoolean) {}
      for (;;)
      {
        AssistantSettingActivity.b((AssistantSettingActivity)localObject, bool, this);
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        bool = false;
      }
    }
    int i;
    if (paramBoolean)
    {
      AssistantSwitchImpl.a(this.a.app, true);
      WakeManager.a().a(true);
      ReportController.b(null, "dc00898", "", "", "0X800B44F", "0X800B44F", 1, 0, "", "", "", "");
      AssistantUtils.a("HelloQQWake", "qVoiceAssistantCkb change isChecked:" + paramBoolean);
      if ((Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0))
      {
        i = 1;
        label147:
        bool = FloatingScreenPermission.checkPermission(BaseApplicationImpl.getContext());
        localObject = new AssistantSettingActivity.4.1(this);
        if ((i == 0) || (!bool)) {
          break label203;
        }
        WakeManager.a().a(this.a, "AssistantSettingActivity", (WakeServiceCallBack)localObject);
      }
    }
    for (;;)
    {
      AssistantSettingActivity.a(this.a);
      break;
      i = 0;
      break label147;
      label203:
      if (i == 0) {
        this.a.requestPermissions(new AssistantSettingActivity.4.2(this, (WakeServiceCallBack)localObject), 1, new String[] { "android.permission.RECORD_AUDIO" });
      }
      if (!bool)
      {
        FloatingScreenPermission.requestPermission(this.a);
        continue;
        AssistantSwitchImpl.a(this.a.app, false);
        WakeManager.a().a(false);
        WakeManager.a().b("AssistantSettingActivity");
        ReportController.b(null, "dc00898", "", "", "0X800B44F", "0X800B44F", 2, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.4
 * JD-Core Version:    0.7.0.1
 */