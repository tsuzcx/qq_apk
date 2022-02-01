package com.tencent.avgame.business.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class AvGameManagerImpl$8
  implements DialogInterface.OnClickListener
{
  AvGameManagerImpl$8(AvGameManagerImpl paramAvGameManagerImpl, WeakReference paramWeakReference, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (AvGameManagerImpl.access$300(this.jdField_a_of_type_ComTencentAvgameBusinessApiImplAvGameManagerImpl) != null) {
        AvGameManagerImpl.access$200(this.jdField_a_of_type_ComTencentAvgameBusinessApiImplAvGameManagerImpl).removeObserver(AvGameManagerImpl.access$300(this.jdField_a_of_type_ComTencentAvgameBusinessApiImplAvGameManagerImpl));
      }
      AvGameManagerImpl.access$302(this.jdField_a_of_type_ComTencentAvgameBusinessApiImplAvGameManagerImpl, new AvGameManagerImpl.8.1(this));
      AvGameManagerImpl.access$200(this.jdField_a_of_type_ComTencentAvgameBusinessApiImplAvGameManagerImpl).addObserver(AvGameManagerImpl.access$300(this.jdField_a_of_type_ComTencentAvgameBusinessApiImplAvGameManagerImpl));
      ReportController.b(null, "dc00898", "", "", "0X800B078", "0X800B078", this.jdField_a_of_type_Int, 0, "", "", "", "");
      paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", "https://ti.qq.com/realname/index.html?source=avgame");
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDialogInterface);
      if (QLog.isColorLevel())
      {
        paramDialogInterface = new StringBuilder();
        paramDialogInterface.append("showRealNameDialog click confirm. roomId: ");
        paramDialogInterface.append(this.jdField_a_of_type_JavaLangString);
        QLog.i("AvGameManager", 2, paramDialogInterface.toString());
      }
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.api.impl.AvGameManagerImpl.8
 * JD-Core Version:    0.7.0.1
 */