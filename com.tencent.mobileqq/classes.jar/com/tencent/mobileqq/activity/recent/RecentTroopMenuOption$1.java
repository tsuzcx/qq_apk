package com.tencent.mobileqq.activity.recent;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class RecentTroopMenuOption$1
  implements ActionSheet.OnButtonClickListener
{
  public void onClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (this.d.b == null)
      {
        paramView = this.d;
        paramView.b = new QQProgressNotifier(RecentTroopMenuOption.a(paramView));
      }
      this.d.b.b(2, 2131892104, 1500);
    }
    else
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              paramInt = -1;
            } else {
              paramInt = 3;
            }
          }
          else {
            paramInt = 2;
          }
        }
        else {
          paramInt = 4;
        }
      }
      else {
        paramInt = 1;
      }
      if ((paramInt != this.a) && (this.d.a != null))
      {
        this.d.a.setTroopMsgFilterToServer(this.b, Integer.valueOf(paramInt));
        ReportController.b(this.d.a, "P_CliOper", "Grp_msg", "", "data_page", "Clk_setmsg", 0, 0, this.b, String.valueOf(paramInt - 1), "", "");
      }
    }
    try
    {
      if (this.c != null)
      {
        this.c.dismiss();
        return;
      }
    }
    catch (Exception paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RecentTroopMenuOption", 2, paramView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentTroopMenuOption.1
 * JD-Core Version:    0.7.0.1
 */