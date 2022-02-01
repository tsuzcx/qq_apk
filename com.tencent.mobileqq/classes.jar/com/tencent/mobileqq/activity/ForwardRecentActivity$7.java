package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardRecentActivity$7
  implements View.OnClickListener
{
  ForwardRecentActivity$7(ForwardRecentActivity paramForwardRecentActivity, DeviceInfo paramDeviceInfo, ForwardRecentItemView paramForwardRecentItemView, ResultRecord paramResultRecord, Resources paramResources, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.access$400(this.f))
    {
      if (ForwardRecentActivity.access$700(this.f, String.valueOf(this.a.din), 9501))
      {
        this.b.a(false);
        ForwardRecentActivity.access$800(this.f, String.valueOf(this.a.din), 9501);
      }
      else if (ForwardRecentActivity.access$900(this.f, this.c))
      {
        this.b.a(true);
      }
    }
    else if (!NetworkUtil.isNetworkAvailable(this.f))
    {
      QQToast.makeText(this.f, HardCodeUtil.a(2131902773), 1000).show(this.d.getDimensionPixelSize(2131299920));
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", String.valueOf(this.a.din));
      localBundle.putInt("uintype", 9501);
      localBundle.putString("uinname", this.e);
      this.f.mForwardOption.a(ForwardAbility.ForwardAbilityType.k.intValue(), localBundle);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.7
 * JD-Core Version:    0.7.0.1
 */