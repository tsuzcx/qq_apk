package com.tencent.mobileqq.activity.contact.troop;

import abwp;
import aijs;
import aikq;
import ails;
import android.app.Activity;
import bcsz;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopNotifyAndRecommendView$9$2
  implements Runnable
{
  public TroopNotifyAndRecommendView$9$2(ails paramails, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    TroopNotifyAndRecommendView.i(this.jdField_a_of_type_Ails.a);
    if (((Activity)this.jdField_a_of_type_Ails.a.jdField_a_of_type_AndroidContentContext).isFinishing()) {}
    aikq localaikq;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_Ails.a.jdField_a_of_type_Aijs == null) || (!this.jdField_a_of_type_Boolean));
        if (QLog.isColorLevel()) {
          QLog.i("TroopNotifyAndRecommendView", 2, "onGetSystemMsgFin.success");
        }
      } while (this.jdField_a_of_type_Ails.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      localaikq = (aikq)this.jdField_a_of_type_Ails.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(383);
    } while (localaikq == null);
    List localList1 = localaikq.a();
    List localList2 = localaikq.b();
    List localList3 = localaikq.c();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "dataListWithOutExit Size =", Integer.valueOf(localList3.size()), "exitDataList Size =", Integer.valueOf(localList1.size()), "undealDataList Size=", Integer.valueOf(localList2.size()) });
      }
      if ((this.jdField_a_of_type_Ails.a.c == 1) && (localList2 != null) && (localList2.size() > 0)) {
        this.jdField_a_of_type_Ails.a.jdField_a_of_type_Aijs.a(localList2);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Ails.a.c == 0) {
        break label534;
      }
      this.jdField_a_of_type_Ails.a.jdField_a_of_type_Aijs.a = 0;
      label261:
      this.jdField_a_of_type_Ails.a.jdField_a_of_type_Aijs.notifyDataSetChanged();
      this.jdField_a_of_type_Ails.a.jdField_a_of_type_Amzp.c = bcsz.a().a(this.jdField_a_of_type_Ails.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_Ails.a.b) {
        this.jdField_a_of_type_Ails.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - bcsz.a().a(this.jdField_a_of_type_Ails.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      bcsz.a().a(this.jdField_a_of_type_Ails.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      this.jdField_a_of_type_Ails.a.b(localList2);
      this.jdField_a_of_type_Ails.a.c(localList1);
      if (!localaikq.b()) {
        this.jdField_a_of_type_Ails.a.a(false, 2);
      }
      if (!localaikq.a()) {
        break label566;
      }
      this.jdField_a_of_type_Ails.a.a(true, 1);
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.h(this.jdField_a_of_type_Ails.a);
      return;
      if ((this.jdField_a_of_type_Ails.a.c == 2) && (localList1 != null) && (localList1.size() > 0))
      {
        this.jdField_a_of_type_Ails.a.jdField_a_of_type_Aijs.a(localList1);
        break;
      }
      if ((this.jdField_a_of_type_Ails.a.c != 0) || (localList3 == null) || (localList3.size() <= 0)) {
        break;
      }
      this.jdField_a_of_type_Ails.a.jdField_a_of_type_Aijs.a(localList3);
      break;
      label534:
      this.jdField_a_of_type_Ails.a.jdField_a_of_type_Aijs.a = bcsz.a().a(this.jdField_a_of_type_Ails.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break label261;
      label566:
      this.jdField_a_of_type_Ails.a.a(false, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.9.2
 * JD-Core Version:    0.7.0.1
 */