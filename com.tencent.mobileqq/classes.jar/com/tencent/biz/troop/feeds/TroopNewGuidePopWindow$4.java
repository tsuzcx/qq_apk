package com.tencent.biz.troop.feeds;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class TroopNewGuidePopWindow$4
  implements Runnable
{
  TroopNewGuidePopWindow$4(TroopNewGuidePopWindow paramTroopNewGuidePopWindow, JSONObject paramJSONObject, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    int j = 1;
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify = TroopFeedsDataManager.TroopNotify.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b, this.jdField_a_of_type_OrgJsonJSONObject);
    this.this$0.g = this.jdField_a_of_type_Boolean;
    String str1;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify != null)
    {
      boolean bool = TroopNotificationHelper.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.j);
      TroopNotificationHelper.d(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b);
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "initViewInThread, isRead = " + bool + ", mTroopNotify. mTroopNotify.isShowTipWindow = " + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.b + ", isRemindNotice = " + this.jdField_a_of_type_Boolean);
      }
      if ((!this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.g.equals(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) && (((this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.b) && (!bool) && (!this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.d)) || (this.jdField_a_of_type_Boolean)))
      {
        localObject = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        str1 = "";
        if (localObject == null) {
          break label436;
        }
      }
    }
    label436:
    for (Object localObject = ((TroopManager)localObject).b(this.this$0.b);; localObject = null)
    {
      if (localObject != null) {
        str1 = "" + ((TroopInfo)localObject).dwGroupClassExt;
      }
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str2 = this.this$0.b;
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.c) {}
      for (int i = 2;; i = 1)
      {
        if (this.this$0.g) {
          j = 2;
        }
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800AAC7", "0X800AAC7", 0, 0, str2, str1, String.valueOf(i), String.valueOf(j));
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsPopWindow", 2, "initViewInThread showing popup window for troopNotice");
        }
        this.this$0.jdField_a_of_type_AndroidOsHandler.post(new TroopNewGuidePopWindow.4.1(this));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "initViewInThread, mTroopNotify is null!");
      }
      TroopNotificationHelper.d(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.4
 * JD-Core Version:    0.7.0.1
 */