package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class DiscussionInfoCardActivity$3
  implements CompoundButton.OnCheckedChangeListener
{
  DiscussionInfoCardActivity$3(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.e)
    {
      localObject1 = this.a.getString(2131888753);
      DiscussionInfoCardActivity.b(this.a).setContentDescription((CharSequence)localObject1);
    }
    Object localObject1 = DiscussionInfoCardActivity.d(this.a).b(DiscussionInfoCardActivity.c(this.a), this.a.app.getCurrentAccountUin());
    if (localObject1 != null)
    {
      int i = ((DiscussionMemberInfo)localObject1).flag;
      if (paramBoolean) {
        ((DiscussionMemberInfo)localObject1).flag = ((byte)(((DiscussionMemberInfo)localObject1).flag | 0x1));
      } else {
        ((DiscussionMemberInfo)localObject1).flag = ((byte)(((DiscussionMemberInfo)localObject1).flag & 0xFFFFFFFE));
      }
      if (i != ((DiscussionMemberInfo)localObject1).flag)
      {
        byte b = (byte)(((DiscussionMemberInfo)localObject1).flag & 0x1);
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("DiscussionMemberInfo.flag changed save now:");
          ((StringBuilder)localObject2).append(((DiscussionMemberInfo)localObject1).flag);
          ((StringBuilder)localObject2).append(" flag:");
          ((StringBuilder)localObject2).append(b);
          QLog.d("DiscussionInfoCardActivity", 4, ((StringBuilder)localObject2).toString());
        }
        DiscussionInfoCardActivity.e(this.a).a(Long.valueOf(DiscussionInfoCardActivity.c(this.a)).longValue(), b, ((DiscussionMemberInfo)localObject1).flag);
        if (paramBoolean) {
          localObject1 = "msg_open";
        } else {
          localObject1 = "msg_close";
        }
        TroopReportor.a("Grp_Dis_set", "Dis_info", (String)localObject1, 0, 0, new String[] { DiscussionInfoCardActivity.c(this.a), DiscussionInfoCardActivity.a(this.a.app, this.a.h) });
      }
      Object localObject2 = this.a.app;
      if (paramBoolean) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X800629B", "0X800629B", 0, 0, (String)localObject1, "", "", "");
      localObject2 = this.a.app;
      if (paramBoolean) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8006679", "0X8006679", 0, 0, (String)localObject1, "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "0X8006668", "0X8006668", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.3
 * JD-Core Version:    0.7.0.1
 */