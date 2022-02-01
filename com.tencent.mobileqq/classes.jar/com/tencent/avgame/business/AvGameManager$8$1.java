package com.tencent.avgame.business;

import android.app.Activity;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class AvGameManager$8$1
  extends ConfigObserver
{
  AvGameManager$8$1(AvGameManager.8 param8) {}
  
  public void a(boolean paramBoolean)
  {
    Activity localActivity;
    if (paramBoolean)
    {
      localActivity = (Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localActivity != null) && (!localActivity.isFinishing()))
      {
        ReportController.b(null, "dc00898", "", "", "0X800B079", "0X800B079", this.a.jdField_a_of_type_Int, 0, "", "", "", "");
        if (!this.a.jdField_a_of_type_JavaLangString.isEmpty()) {
          break label288;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AvGameManager", 2, "onGetRealNameStatusForAV createAvGameRoom");
        }
        if (this.a.jdField_b_of_type_Int != 9) {
          break label175;
        }
        this.a.jdField_a_of_type_ComTencentAvgameBusinessAvGameManager.a(localActivity, 9);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RealName", 2, "onGetRealNameStatusForAV authed: " + paramBoolean + ". Remove observer.");
      }
      AvGameManager.a(this.a.jdField_a_of_type_ComTencentAvgameBusinessAvGameManager).removeObserver(AvGameManager.a(this.a.jdField_a_of_type_ComTencentAvgameBusinessAvGameManager));
      return;
      label175:
      if ((this.a.jdField_b_of_type_Int == 11) || (this.a.jdField_b_of_type_Int == 13))
      {
        AvGameManager localAvGameManager = this.a.jdField_a_of_type_ComTencentAvgameBusinessAvGameManager;
        int j = this.a.c;
        if (this.a.c > 0) {}
        for (int i = 1;; i = 0)
        {
          localAvGameManager.a(localActivity, j, i, this.a.jdField_b_of_type_Int);
          break;
        }
      }
      this.a.jdField_a_of_type_ComTencentAvgameBusinessAvGameManager.a(localActivity, this.a.jdField_b_of_type_Int, this.a.jdField_b_of_type_JavaLangString, this.a.c);
      continue;
      label288:
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManager", 2, "onGetRealNameStatusForAV joinAvGameRoom. roomId: " + this.a.jdField_a_of_type_JavaLangString);
      }
      this.a.jdField_a_of_type_ComTencentAvgameBusinessAvGameManager.a(localActivity, this.a.jdField_b_of_type_Int, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.business.AvGameManager.8.1
 * JD-Core Version:    0.7.0.1
 */