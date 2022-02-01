package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LbsBaseActivity$2
  implements View.OnClickListener
{
  LbsBaseActivity$2(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 10);
    this.a.onEnableClick();
    if ((LbsBaseActivity.access$000(this.a) != null) && (LbsBaseActivity.access$000(this.a).isShowing()))
    {
      LbsBaseActivity localLbsBaseActivity = this.a;
      localLbsBaseActivity.dialogDismiss(LbsBaseActivity.access$000(localLbsBaseActivity));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LbsBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */