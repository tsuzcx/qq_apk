package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.SyncLoadTask;
import com.tencent.mobileqq.utils.SyncLoadTask.OnSyncTaskListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class PromotionMgr$1
  implements SyncLoadTask.OnSyncTaskListener
{
  PromotionMgr$1(PromotionMgr paramPromotionMgr, AppInterface paramAppInterface, String paramString, PromotionMgr.GetConfigListen paramGetConfigListen) {}
  
  public void a(boolean paramBoolean, ArrayList<SyncLoadTask> paramArrayList)
  {
    paramArrayList = (ReadConfigTask)paramArrayList.get(0);
    if ((PromotionMgr.a(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionMgr) != null) && (PromotionMgr.a(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionMgr) == paramArrayList) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      QLog.w(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionMgr.jdField_a_of_type_JavaLangString, 1, "异步加载config返回, bsuc[" + paramBoolean + "], TAG[" + paramArrayList.TAG + "], isEnableFromLocal[" + PromotionDevice.c() + "], config[" + paramArrayList.a + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionMgr.a(paramArrayList.a);
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionMgr.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      PromotionMgr.a(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionMgr, null);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionMgr$GetConfigListen != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionMgr$GetConfigListen.a(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionMgr.a());
      }
      return;
      QLog.w(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionMgr.jdField_a_of_type_JavaLangString, 1, "异步加载config返回[" + this.jdField_a_of_type_JavaLangString + "], 但原请求取消了");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionMgr.1
 * JD-Core Version:    0.7.0.1
 */