package com.tencent.mobileqq.activity.contact.troop;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;

class TroopNotifyAndRecommendView$15
  implements DialogInterface.OnClickListener
{
  TroopNotifyAndRecommendView$15(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.k();
    this.a.q();
    if (TroopNotifyAndRecommendView.b(this.a) != null) {
      TroopNotifyAndRecommendView.b(this.a).setVisibility(8);
    }
    ReportController.b(this.a.a, "dc00899", "Grp_contacts_news", "", "notice", "clear_clk", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.15
 * JD-Core Version:    0.7.0.1
 */