package com.tencent.biz.troop.feeds;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotifyAd;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopNewGuidePopWindow$8
  implements View.OnClickListener
{
  TroopNewGuidePopWindow$8(TroopNewGuidePopWindow paramTroopNewGuidePopWindow, TroopFeedsDataManager.TroopNotifyAd paramTroopNotifyAd) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopTipsPopWindow", 2, "mTroopNotifyAdImage onClick--------");
    }
    Intent localIntent = new Intent(this.b.a, QQBrowserActivity.class);
    localIntent.putExtra("url", this.a.b);
    this.b.a.startActivity(localIntent);
    ReportController.b(this.b.w, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", "clk_ad", 0, 0, this.b.z, String.valueOf(this.b.B.a), "8020205751015455", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.8
 * JD-Core Version:    0.7.0.1
 */