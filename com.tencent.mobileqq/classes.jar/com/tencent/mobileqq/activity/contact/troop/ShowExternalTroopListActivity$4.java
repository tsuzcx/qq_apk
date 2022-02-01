package com.tencent.mobileqq.activity.contact.troop;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShowExternalTroopListActivity$4
  implements View.OnClickListener
{
  ShowExternalTroopListActivity$4(ShowExternalTroopListActivity paramShowExternalTroopListActivity, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    ProfileCardUtil.a(this.b.k, this.a, this.b.n, 0);
    QQAppInterface localQQAppInterface = this.b.app;
    String str2 = this.b.n;
    String str1;
    if (this.b.l) {
      str1 = "0";
    } else {
      str1 = "1";
    }
    ReportController.b(localQQAppInterface, "P_CliOper", "Grp_join", "", "person_data", "Clk_user", 0, 0, str2, str1, "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.4
 * JD-Core Version:    0.7.0.1
 */