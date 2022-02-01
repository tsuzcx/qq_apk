package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LbsBaseActivity$5
  implements View.OnClickListener
{
  LbsBaseActivity$5(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    if ((LbsBaseActivity.access$300(this.a) != null) && (LbsBaseActivity.access$300(this.a).isShowing()))
    {
      LbsBaseActivity localLbsBaseActivity = this.a;
      localLbsBaseActivity.dialogDismiss(LbsBaseActivity.access$300(localLbsBaseActivity));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LbsBaseActivity.5
 * JD-Core Version:    0.7.0.1
 */