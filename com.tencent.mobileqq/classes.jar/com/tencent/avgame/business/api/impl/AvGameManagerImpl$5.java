package com.tencent.avgame.business.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.avgame.ui.AvGameLoadingActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AvGameManagerImpl$5
  implements DialogInterface.OnClickListener
{
  AvGameManagerImpl$5(AvGameManagerImpl paramAvGameManagerImpl, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface.cancel();
      if (this.jdField_a_of_type_AndroidAppActivity != null)
      {
        paramDialogInterface = this.jdField_a_of_type_ComTencentAvgameBusinessApiImplAvGameManagerImpl.getAvGameRoomId();
        if (this.jdField_a_of_type_ComTencentAvgameBusinessApiImplAvGameManagerImpl.isCurrentPkSurvivalEmptyRoom())
        {
          AvGameManagerImpl.access$100(this.jdField_a_of_type_ComTencentAvgameBusinessApiImplAvGameManagerImpl);
          AvGameLoadingActivity.a(false, this.jdField_a_of_type_AndroidAppActivity, null, paramDialogInterface, null, "", false, true, null);
        }
        else if (TextUtils.isEmpty(paramDialogInterface))
        {
          QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying roomPlayingId empty");
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131690457, 0).a();
        }
        else
        {
          AvGameManagerImpl.access$100(this.jdField_a_of_type_ComTencentAvgameBusinessApiImplAvGameManagerImpl);
          AvGameLoadingActivity.a(false, this.jdField_a_of_type_AndroidAppActivity, null, paramDialogInterface, null, "", false, false, null);
        }
      }
      else
      {
        QLog.e("AvGameManager", 1, "alertDialogWithRetCode createAvGameRoom context  null ");
      }
      ReportController.b(AvGameManagerImpl.access$200(this.jdField_a_of_type_ComTencentAvgameBusinessApiImplAvGameManagerImpl), "dc00898", "", "", "0X800B016", "0X800B016", 0, 0, "", "", "", "");
      return;
    }
    paramDialogInterface.cancel();
    QLog.d("AvGameManager", 2, "showInPlayDialog dialog cancel");
    ReportController.b(AvGameManagerImpl.access$200(this.jdField_a_of_type_ComTencentAvgameBusinessApiImplAvGameManagerImpl), "dc00898", "", "", "0X800B017", "0X800B017", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.api.impl.AvGameManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */