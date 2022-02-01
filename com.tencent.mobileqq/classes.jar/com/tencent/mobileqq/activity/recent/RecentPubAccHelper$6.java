package com.tencent.mobileqq.activity.recent;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class RecentPubAccHelper$6
  implements ActionSheet.OnButtonClickListener
{
  RecentPubAccHelper$6(RecentPubAccHelper paramRecentPubAccHelper, QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (RecentPubAccHelper.b(this.d)) {
      return;
    }
    RecentPubAccHelper.a(this.d, true);
    if (paramInt == 0)
    {
      if (RecentPubAccHelper.a()) {
        paramView = "0X800BDD8";
      } else {
        paramView = "0X800991E";
      }
      ReportController.b(this.a, "dc00898", "", this.b.getRecentUserUin(), paramView, paramView, 0, 0, "", "", "", "");
      RecentPubAccHelper.c(this.d, this.b, this.a);
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper.6
 * JD-Core Version:    0.7.0.1
 */