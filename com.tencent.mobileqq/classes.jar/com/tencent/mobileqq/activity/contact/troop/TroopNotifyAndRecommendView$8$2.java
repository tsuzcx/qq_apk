package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopNotifyAndRecommendView$8$2
  implements Runnable
{
  TroopNotifyAndRecommendView$8$2(TroopNotifyAndRecommendView.8 param8, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    TroopNotifyAndRecommendView.i(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a);
    if (((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_AndroidContentContext).isFinishing()) {}
    TroopNotificationManager localTroopNotificationManager;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter == null) || (!this.jdField_a_of_type_Boolean));
        if (QLog.isColorLevel()) {
          QLog.i("TroopNotifyAndRecommendView", 2, "onGetSystemMsgFin.success");
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      localTroopNotificationManager = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    } while (localTroopNotificationManager == null);
    List localList1 = localTroopNotificationManager.a(2);
    List localList2 = localTroopNotificationManager.a(1);
    List localList3 = localTroopNotificationManager.a(0);
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "dataListWithOutExit Size =", Integer.valueOf(localList3.size()), "exitDataList Size =", Integer.valueOf(localList1.size()), "undealDataList Size=", Integer.valueOf(localList2.size()) });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.c == 1) && (localList2 != null) && (localList2.size() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(localList2);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.c == 0) {
        break label518;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a = 0;
      label264:
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp.c = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.b) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.b(localList2);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.c(localList1);
      if (!localTroopNotificationManager.a()) {
        break label550;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.a(true, 1);
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.h(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.c == 2) && (localList1 != null) && (localList1.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(localList1);
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.c != 0) || (localList3 == null) || (localList3.size() <= 0)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a(localList3);
      break;
      label518:
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.a = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break label264;
      label550:
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.a(false, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.8.2
 * JD-Core Version:    0.7.0.1
 */