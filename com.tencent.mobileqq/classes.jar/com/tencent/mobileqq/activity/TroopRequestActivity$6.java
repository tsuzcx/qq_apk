package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopRequestActivity$6
  implements View.OnClickListener
{
  TroopRequestActivity$6(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.a, "/pubaccount/detail");
    localActivityURIRequest.extra().putString("uin", this.a.a.req_uin.get() + "");
    localActivityURIRequest.extra().putInt("source", 112);
    QRoute.startUri(localActivityURIRequest, null);
    ReportController.b(this.a.app, "P_CliOper", "Grp_public", "", "oper", "Clk_invite", 0, 0, "", "", "", this.a.a.req_uin.get() + "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.6
 * JD-Core Version:    0.7.0.1
 */