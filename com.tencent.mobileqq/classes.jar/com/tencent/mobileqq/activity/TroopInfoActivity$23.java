package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.Handler;
import basm;
import basn;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$23
  implements Runnable
{
  TroopInfoActivity$23(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject = BaseApplication.getContext();
      String str = Long.toString(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
      basm localbasm = basn.a((Context)localObject).a();
      if ((localbasm != null) && (localbasm.b.equals(str)))
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass = localbasm.a();
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText = localbasm.a;
      }
      for (;;)
      {
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        return;
        localObject = basn.a((Context)localObject).a((Context)localObject, str);
        if (localObject != null)
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass = ((basm)localObject).a();
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText = ((basm)localObject).a;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.23
 * JD-Core Version:    0.7.0.1
 */