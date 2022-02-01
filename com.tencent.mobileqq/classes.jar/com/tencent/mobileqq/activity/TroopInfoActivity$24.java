package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.Handler;
import bhap;
import bhaq;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$24
  implements Runnable
{
  TroopInfoActivity$24(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject = BaseApplication.getContext();
      String str = Long.toString(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
      bhap localbhap = bhaq.a((Context)localObject).a();
      if ((localbhap != null) && (localbhap.b.equals(str)))
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass = localbhap.a();
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText = localbhap.a;
      }
      for (;;)
      {
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        return;
        localObject = bhaq.a((Context)localObject).a((Context)localObject, str);
        if (localObject != null)
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass = ((bhap)localObject).a();
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText = ((bhap)localObject).a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.24
 * JD-Core Version:    0.7.0.1
 */