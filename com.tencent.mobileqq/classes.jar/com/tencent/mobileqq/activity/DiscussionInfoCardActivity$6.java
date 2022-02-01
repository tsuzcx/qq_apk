package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DiscussionInfoCardActivity$6
  implements ActionSheet.OnButtonClickListener
{
  DiscussionInfoCardActivity$6(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          DiscussionInfoCardActivity.h(this.b);
        }
      }
      else
      {
        paramView = this.b.h.uin;
        Bundle localBundle = NewReportPlugin.a(DiscussionInfoCardActivity.c(this.b), 3000);
        DiscussionInfoCardActivity localDiscussionInfoCardActivity = this.b;
        NewReportPlugin.a(localDiscussionInfoCardActivity, DiscussionInfoCardActivity.c(localDiscussionInfoCardActivity), "", "", paramView, this.b.app.getCurrentAccountUin(), 22001, null, localBundle);
        TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_report", 0, 0, new String[] { DiscussionInfoCardActivity.c(this.b), DiscussionInfoCardActivity.a(this.b.app, this.b.h) });
      }
    }
    else {
      this.b.b();
    }
    paramView = this.a;
    if ((paramView != null) && (paramView.isShowing()) && (!this.b.isFinishing()))
    {
      this.a.dismiss();
      this.a.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.6
 * JD-Core Version:    0.7.0.1
 */