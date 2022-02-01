package com.tencent.mobileqq.activity.activateFriend;

import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.report.lp.LpReportInfo_dc00518;

class ActivateFriendActivity$6
  implements ActionSheet.OnButtonClickListener
{
  ActivateFriendActivity$6(ActivateFriendActivity paramActivateFriendActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (ActivateFriendActivity.c(this.b) == null)
      {
        paramView = this.b;
        ActivateFriendActivity.a(paramView, (ActivateFriendsManager)paramView.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
      }
      if (NetworkUtil.isNetSupport(this.b))
      {
        ActivateFriendActivity.c(this.b).a(ActivateFriendActivity.d(this.b) ^ true, true);
        if (ActivateFriendActivity.d(this.b)) {
          paramInt = 2;
        } else {
          paramInt = 1;
        }
        LpReportInfo_dc00518.report(100, paramInt, paramInt);
        if (ActivateFriendActivity.d(this.b)) {
          paramView = "QQnotice.aio.detail.seton";
        } else {
          paramView = "QQnotice.aio.detail.setoff";
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("do report: ");
          localStringBuilder.append(paramView);
          QLog.d("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
        }
        ReportController.b(this.b.app, "P_CliOper", "QQnotice", "", "", paramView, 0, 0, "", "", "", "");
        QQNotifyHelper.a(this.b.app, "remindpage_click", null, null, String.valueOf(1), String.valueOf(paramInt));
      }
      else if (!this.b.isFinishing())
      {
        paramView = this.b;
        if (paramView != null) {
          QQToast.makeText(paramView, 1, paramView.getResources().getString(2131892104), 0).show(this.b.getTitleBarHeight());
        }
      }
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity.6
 * JD-Core Version:    0.7.0.1
 */