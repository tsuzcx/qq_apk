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
    Object localObject1 = this.this$0;
    ((TroopNewGuidePopWindow)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify = TroopFeedsDataManager.TroopNotify.a(((TroopNewGuidePopWindow)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b, this.jdField_a_of_type_OrgJsonJSONObject);
    localObject1 = this.this$0;
    ((TroopNewGuidePopWindow)localObject1).g = this.jdField_a_of_type_Boolean;
    if (((TroopNewGuidePopWindow)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify != null)
    {
      boolean bool = TroopNotificationHelper.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.j);
      TroopNotificationHelper.d(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initViewInThread, isRead = ");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append(", mTroopNotify. mTroopNotify.isShowTipWindow = ");
        ((StringBuilder)localObject1).append(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.b);
        ((StringBuilder)localObject1).append(", isRemindNotice = ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
        QLog.d("TroopTipsPopWindow", 2, ((StringBuilder)localObject1).toString());
      }
      if ((!this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.g.equals(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) && (((this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.b) && (!bool) && (!this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.d)) || (this.jdField_a_of_type_Boolean)))
      {
        Object localObject3 = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        Object localObject2 = "";
        localObject1 = null;
        if (localObject3 != null) {
          localObject1 = ((TroopManager)localObject3).b(this.this$0.b);
        }
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(((TroopInfo)localObject1).dwGroupClassExt);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject3 = this.this$0.b;
        bool = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.c;
        int j = 1;
        int i;
        if (bool) {
          i = 2;
        } else {
          i = 1;
        }
        if (this.this$0.g) {
          j = 2;
        }
        ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800AAC7", "0X800AAC7", 0, 0, (String)localObject3, (String)localObject2, String.valueOf(i), String.valueOf(j));
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsPopWindow", 2, "initViewInThread showing popup window for troopNotice");
        }
        this.this$0.jdField_a_of_type_AndroidOsHandler.post(new TroopNewGuidePopWindow.4.1(this));
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsPopWindow", 2, "initViewInThread, mTroopNotify is null!");
      }
      TroopNotificationHelper.d(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.4
 * JD-Core Version:    0.7.0.1
 */