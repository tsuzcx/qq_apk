package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LbsBaseActivity$6
  implements View.OnClickListener
{
  LbsBaseActivity$6(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    NearbySPUtil.a(this.a.getAppInterface().getAccount(), true);
    if ((LbsBaseActivity.b(this.a) != null) && (LbsBaseActivity.b(this.a).isShowing())) {
      this.a.a(LbsBaseActivity.b(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LbsBaseActivity.6
 * JD-Core Version:    0.7.0.1
 */