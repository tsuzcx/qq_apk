package com.tencent.mobileqq.activity.contact.troop;

import acmw;
import ajep;
import ajfn;
import ajgp;
import android.app.Activity;
import bdzy;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopNotifyAndRecommendView$8$2
  implements Runnable
{
  public TroopNotifyAndRecommendView$8$2(ajgp paramajgp, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    TroopNotifyAndRecommendView.i(this.jdField_a_of_type_Ajgp.a);
    if (((Activity)this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_AndroidContentContext).isFinishing()) {}
    ajfn localajfn;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_Ajep == null) || (!this.jdField_a_of_type_Boolean));
        if (QLog.isColorLevel()) {
          QLog.i("TroopNotifyAndRecommendView", 2, "onGetSystemMsgFin.success");
        }
      } while (this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      localajfn = (ajfn)this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    } while (localajfn == null);
    List localList1 = localajfn.a(2);
    List localList2 = localajfn.a(1);
    List localList3 = localajfn.a(0);
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "dataListWithOutExit Size =", Integer.valueOf(localList3.size()), "exitDataList Size =", Integer.valueOf(localList1.size()), "undealDataList Size=", Integer.valueOf(localList2.size()) });
      }
      if ((this.jdField_a_of_type_Ajgp.a.c == 1) && (localList2 != null) && (localList2.size() > 0)) {
        this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_Ajep.a(localList2);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Ajgp.a.c == 0) {
        break label518;
      }
      this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_Ajep.a = 0;
      label264:
      this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_Ajep.notifyDataSetChanged();
      this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_Aoce.c = bdzy.a().a(this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_Ajgp.a.b) {
        this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - bdzy.a().a(this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      bdzy.a().a(this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      this.jdField_a_of_type_Ajgp.a.b(localList2);
      this.jdField_a_of_type_Ajgp.a.c(localList1);
      if (!localajfn.a()) {
        break label550;
      }
      this.jdField_a_of_type_Ajgp.a.a(true, 1);
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.h(this.jdField_a_of_type_Ajgp.a);
      return;
      if ((this.jdField_a_of_type_Ajgp.a.c == 2) && (localList1 != null) && (localList1.size() > 0))
      {
        this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_Ajep.a(localList1);
        break;
      }
      if ((this.jdField_a_of_type_Ajgp.a.c != 0) || (localList3 == null) || (localList3.size() <= 0)) {
        break;
      }
      this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_Ajep.a(localList3);
      break;
      label518:
      this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_Ajep.a = bdzy.a().a(this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break label264;
      label550:
      this.jdField_a_of_type_Ajgp.a.a(false, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.8.2
 * JD-Core Version:    0.7.0.1
 */