package com.tencent.device.msg.activities;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DeviceTipActivity$3
  implements View.OnClickListener
{
  DeviceTipActivity$3(DeviceTipActivity paramDeviceTipActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a)) {
      QQToast.makeText(this.a, HardCodeUtil.a(2131901353), 2000).show();
    }
    DeviceTipActivity.a(this.a, 2);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceTipActivity.3
 * JD-Core Version:    0.7.0.1
 */