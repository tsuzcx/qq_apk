package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LbsBaseActivity$6
  implements View.OnClickListener
{
  LbsBaseActivity$6(LbsBaseActivity paramLbsBaseActivity) {}
  
  public void onClick(View paramView)
  {
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setObtainLocAllowed(this.a.getAppInterface().getAccount(), true);
    if ((LbsBaseActivity.access$300(this.a) != null) && (LbsBaseActivity.access$300(this.a).isShowing()))
    {
      LbsBaseActivity localLbsBaseActivity = this.a;
      localLbsBaseActivity.dialogDismiss(LbsBaseActivity.access$300(localLbsBaseActivity));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LbsBaseActivity.6
 * JD-Core Version:    0.7.0.1
 */