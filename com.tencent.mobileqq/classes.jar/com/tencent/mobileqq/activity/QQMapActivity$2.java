package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.widgets.QQMapRoutingHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQMapActivity$2
  implements View.OnClickListener
{
  QQMapActivity$2(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this.a)) {
      this.a.showInvalidNetworkAlert();
    } else if (NetworkUtil.isWifiEnabled(this.a)) {
      this.a.jumpToStreetViewMap();
    } else {
      DialogUtil.a(this.a, 230).setTitle(this.a.getString(2131886621)).setMessage(2131892327).setPositiveButton(2131888011, new QQMapActivity.2.2(this)).setNegativeButton(2131887648, new QQMapActivity.2.1(this)).show();
    }
    QQMapRoutingHelper.a("see_streetview");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.2
 * JD-Core Version:    0.7.0.1
 */