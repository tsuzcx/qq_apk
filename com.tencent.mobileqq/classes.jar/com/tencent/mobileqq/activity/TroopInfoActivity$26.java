package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$26
  implements Runnable
{
  TroopInfoActivity$26(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject = BaseApplication.getContext();
      String str = Long.toString(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
      GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a((Context)localObject).a();
      if ((localGroupCatalogBean != null) && (localGroupCatalogBean.b.equals(str)))
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass = localGroupCatalogBean.a();
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText = localGroupCatalogBean.a;
      }
      for (;;)
      {
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        return;
        localObject = GroupCatalogTool.a((Context)localObject).a((Context)localObject, str);
        if (localObject != null)
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass = ((GroupCatalogBean)localObject).a();
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText = ((GroupCatalogBean)localObject).a;
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
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.26
 * JD-Core Version:    0.7.0.1
 */