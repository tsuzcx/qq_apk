package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DiscussionInfoCardActivity$14
  implements ActionSheet.OnButtonClickListener
{
  DiscussionInfoCardActivity$14(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (NetworkUtil.isNetSupport(this.b.getActivity()))
      {
        ReportController.b(this.b.app, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, "", "", "", "");
        ReportController.b(this.b.app, "CliOper", "", "", "0X8006669", "0X8006669", 0, 0, "", "", "", "");
        DiscussionInfoCardActivity.e(this.b).c(Long.valueOf(DiscussionInfoCardActivity.c(this.b)).longValue());
        paramView = this.b;
        paramView.b(paramView.getString(2131889064));
        DiscussionInfoCardActivity.i(this.b).show();
      }
      else
      {
        paramView = this.b;
        paramView.a(1, paramView.getString(2131892157));
      }
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.14
 * JD-Core Version:    0.7.0.1
 */