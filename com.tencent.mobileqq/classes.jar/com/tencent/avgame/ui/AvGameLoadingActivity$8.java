package com.tencent.avgame.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class AvGameLoadingActivity$8
  implements DialogInterface.OnClickListener
{
  AvGameLoadingActivity$8(AvGameLoadingActivity paramAvGameLoadingActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = -102;
    if (paramInt == 1)
    {
      paramDialogInterface.cancel();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        Object localObject2 = null;
        Object localObject1 = null;
        AvGameLoadingActivity.d(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity, true);
        AvGameLoadingActivity.b(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity, 5);
        paramDialogInterface = localObject2;
        if (!this.jdField_a_of_type_Boolean) {
          if (AvGameLoadingActivity.a(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity) != 3)
          {
            paramDialogInterface = localObject2;
            if (AvGameLoadingActivity.a(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity) != 5) {}
          }
          else
          {
            paramDialogInterface = localObject1;
            if (AvGameLoadingActivity.c(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity) != null)
            {
              AvGameLoadingActivity.b(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity, 6);
              paramDialogInterface = AvGameLoadingActivity.c(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity);
            }
            QLog.e("AvGameManagerAvGameLoadingActivity", 2, "join failed alert DIALOG change to troop  with  troop UIN " + paramDialogInterface);
          }
        }
        AvGameLoadingActivity.a(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity, AvGameLoadingActivity.c(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity), paramDialogInterface);
        return;
      }
      QLog.e("AvGameManagerAvGameLoadingActivity", 2, "alertDialogWithRetCode createAvGameRoom app null ");
      if (this.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        AVGameNodeReportUtil.b(i);
        AvGameLoadingActivity.a(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity, false, this.jdField_a_of_type_Int);
        return;
        i = -103;
      }
    }
    paramDialogInterface.cancel();
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      AVGameNodeReportUtil.b(i);
      AvGameLoadingActivity.a(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity, false, this.jdField_a_of_type_Int);
      return;
      i = -103;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity.8
 * JD-Core Version:    0.7.0.1
 */