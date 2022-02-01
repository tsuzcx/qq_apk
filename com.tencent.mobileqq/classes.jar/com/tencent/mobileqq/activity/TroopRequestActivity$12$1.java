package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.qphone.base.util.BaseApplication;

class TroopRequestActivity$12$1
  implements Runnable
{
  TroopRequestActivity$12$1(TroopRequestActivity.12 param12, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$12.a, Long.toString(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt));
    if (localGroupCatalogBean != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = localGroupCatalogBean.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity$12.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.12.1
 * JD-Core Version:    0.7.0.1
 */