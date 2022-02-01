package com.tencent.mobileqq.app;

import android.os.Vibrator;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.onlinestatus.IAccountPanel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

class FrameHelperActivity$10
  implements View.OnLongClickListener
{
  FrameHelperActivity$10(FrameHelperActivity paramFrameHelperActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a() != null)
    {
      if (this.a.a().isFinishing()) {
        return true;
      }
      if (!((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).isHeadIconLongClickFunc((QQAppInterface)this.a.a().getAppRuntime(), false)) {
        return true;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
        return true;
      }
      if ((paramView == this.a.b) && (this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel != null) && (!this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel.isShowing()))
      {
        if ((this.a.a().getAppRuntime() != null) && (this.a.a().getAppRuntime().getApp() != null))
        {
          paramView = (Vibrator)this.a.a().getAppRuntime().getApp().getSystemService("vibrator");
          if (paramView != null) {
            paramView.vibrate(new long[] { 0L, 1L, 20L, 21L }, -1);
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel.show();
        ReportController.b(this.a.a().getAppRuntime(), "dc00898", "", "", "0X800A999", "0X800A999", 1, 0, "", "", "", "");
        ReportController.b(this.a.a().getAppRuntime(), "dc00898", "", "", "0X8009E84", "0X8009E84", 0, 0, "", "", "", "");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$HeadViewLongClick != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$HeadViewLongClick.a();
      }
      this.a.m();
      ReportController.b(this.a.a().getAppRuntime(), "CliOper", "", "", "0X80072D1", "0X80072D1", 0, 0, "", "", "", "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.10
 * JD-Core Version:    0.7.0.1
 */