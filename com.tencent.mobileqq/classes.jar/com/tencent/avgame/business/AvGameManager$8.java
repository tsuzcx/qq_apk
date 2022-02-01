package com.tencent.avgame.business;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class AvGameManager$8
  implements DialogInterface.OnClickListener
{
  AvGameManager$8(AvGameManager paramAvGameManager, WeakReference paramWeakReference, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (AvGameManager.a(this.jdField_a_of_type_ComTencentAvgameBusinessAvGameManager) != null) {
        AvGameManager.a(this.jdField_a_of_type_ComTencentAvgameBusinessAvGameManager).removeObserver(AvGameManager.a(this.jdField_a_of_type_ComTencentAvgameBusinessAvGameManager));
      }
      AvGameManager.a(this.jdField_a_of_type_ComTencentAvgameBusinessAvGameManager, new AvGameManager.8.1(this));
      AvGameManager.a(this.jdField_a_of_type_ComTencentAvgameBusinessAvGameManager).addObserver(AvGameManager.a(this.jdField_a_of_type_ComTencentAvgameBusinessAvGameManager));
      ReportController.b(null, "dc00898", "", "", "0X800B078", "0X800B078", this.jdField_a_of_type_Int, 0, "", "", "", "");
      paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", "https://ti.qq.com/realname/index.html?source=avgame");
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDialogInterface);
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManager", 2, "showRealNameDialog click confirm. roomId: " + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.business.AvGameManager.8
 * JD-Core Version:    0.7.0.1
 */