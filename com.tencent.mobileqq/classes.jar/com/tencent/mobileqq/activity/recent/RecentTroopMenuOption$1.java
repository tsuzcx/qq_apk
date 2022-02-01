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
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(RecentTroopMenuOption.a(paramView));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131694424, 1500);
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
      if ((paramInt != this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setTroopMsgFilterToServer(this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "data_page", "Clk_setmsg", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(paramInt - 1), "", "");
      }
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentTroopMenuOption.1
 * JD-Core Version:    0.7.0.1
 */