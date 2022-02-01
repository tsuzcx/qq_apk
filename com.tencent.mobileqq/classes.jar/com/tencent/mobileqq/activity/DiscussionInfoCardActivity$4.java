package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DiscussionInfoCardActivity$4
  implements CompoundButton.OnCheckedChangeListener
{
  DiscussionInfoCardActivity$4(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.d)
    {
      localObject1 = this.a.getString(2131693109);
      DiscussionInfoCardActivity.b(this.a).setContentDescription((CharSequence)localObject1);
    }
    boolean bool2 = DiscussionInfoCardActivity.a(this.a).a(this.a.a);
    Object localObject1 = DiscussionInfoCardActivity.a(this.a);
    Object localObject2 = this.a.a;
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      ((DiscussionHandler)localObject1).a((DiscussionInfo)localObject2, bool1);
      localObject2 = new ReportTask(this.a.app).a("dc00899").b("Grp_Dis_set").c("Dis_info");
      if (!bool2) {
        break label145;
      }
    }
    label145:
    for (localObject1 = "Clk_unstick";; localObject1 = "Clk_stick")
    {
      ((ReportTask)localObject2).d((String)localObject1).a();
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.4
 * JD-Core Version:    0.7.0.1
 */