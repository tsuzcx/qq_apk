package com.tencent.mobileqq.app;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.settings.message.ReportClickEventHelper;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForegroundNotifyManager$1
  implements CompoundButton.OnCheckedChangeListener
{
  ForegroundNotifyManager$1(ForegroundNotifyManager paramForegroundNotifyManager, BaseActivity paramBaseActivity, FormSwitchItem paramFormSwitchItem) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext());
    Object localObject = NewMsgNotificationManager.a(ForegroundNotifyManager.a(this.c));
    if ((!bool) && (localObject != null))
    {
      ((NewMsgNotificationManager)localObject).a(this.a);
      this.b.setOnCheckedChangeListener(null);
      localObject = this.b;
      ((FormSwitchItem)localObject).setChecked(((FormSwitchItem)localObject).a() ^ true);
      this.b.setOnCheckedChangeListener(ForegroundNotifyManager.b(this.c));
    }
    else
    {
      ReportClickEventHelper.a(ForegroundNotifyManager.a(this.c), "0X800B845", paramBoolean);
      SettingCloneUtil.writeValue(ForegroundNotifyManager.a(this.c).getApp(), ForegroundNotifyManager.a(this.c).getCurrentUin(), null, "top_msg_notification_key", paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ForegroundNotifyManager.1
 * JD-Core Version:    0.7.0.1
 */