package com.tencent.mobileqq.app.qim;

import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QIMNewFriend
{
  private static DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new QIMNewFriend.1();
  private static QIMUndecideNotifyDialog jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog;
  
  public static void a()
  {
    QIMUndecideNotifyDialog localQIMUndecideNotifyDialog = jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog;
    if ((localQIMUndecideNotifyDialog != null) && (localQIMUndecideNotifyDialog.isShowing())) {
      jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog.dismiss();
    }
  }
  
  public static boolean a(QBaseActivity paramQBaseActivity, ArrayList<QIMNotifyAddFriend> paramArrayList)
  {
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog != null) && (jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog.isShowing()))
      {
        bool1 = jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog.a(paramArrayList);
        return bool1;
      }
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramArrayList != null)
      {
        bool1 = bool2;
        if (paramArrayList.size() > 0)
        {
          jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog = new QIMUndecideNotifyDialog(paramQBaseActivity, paramArrayList);
          jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog.setOnDismissListener(jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
          jdField_a_of_type_ComTencentMobileqqAppQimQIMUndecideNotifyDialog.show();
          bool1 = true;
        }
      }
      if (QLog.isColorLevel())
      {
        paramQBaseActivity = new StringBuilder();
        paramQBaseActivity.append("showDialogIfNeed");
        paramQBaseActivity.append(bool1);
        QLog.i("UndecidedListDialogUtil", 2, paramQBaseActivity.toString());
      }
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.qim.QIMNewFriend
 * JD-Core Version:    0.7.0.1
 */