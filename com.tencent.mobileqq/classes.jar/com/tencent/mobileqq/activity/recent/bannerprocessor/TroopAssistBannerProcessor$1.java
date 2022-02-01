package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class TroopAssistBannerProcessor$1
  implements View.OnClickListener
{
  TroopAssistBannerProcessor$1(TroopAssistBannerProcessor paramTroopAssistBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(TroopAssistBannerProcessor.a(this.a), TroopAssisSettingActivity.class);
    TroopAssistBannerProcessor.b(this.a).startActivityForResult(localIntent, 9001);
    TroopAssistBannerProcessor.c(this.a).sendEmptyMessageDelayed(1000, 1000L);
    ReportController.b(TroopAssistBannerProcessor.d(this.a).getAppRuntime(), "P_CliOper", "Grp_msg", "", "Msglist", "Clk_setmsg", 0, 0, "", "", "", "");
    ReportController.a(TroopAssistBannerProcessor.e(this.a).getAppRuntime(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 17, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.TroopAssistBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */