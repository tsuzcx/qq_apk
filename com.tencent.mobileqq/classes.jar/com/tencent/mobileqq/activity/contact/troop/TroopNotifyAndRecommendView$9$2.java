package com.tencent.mobileqq.activity.contact.troop;

import acvy;
import ajdv;
import ajfm;
import ajfn;
import android.app.Activity;
import anhk;
import bdgn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopNotifyAndRecommendView$9$2
  implements Runnable
{
  public TroopNotifyAndRecommendView$9$2(ajfm paramajfm, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    TroopNotifyAndRecommendView.d(this.jdField_a_of_type_Ajfm.a);
    if (((Activity)this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_AndroidContentContext).isFinishing()) {}
    while ((this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_Ajdv == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "onGetSystemMsgFin.success");
    }
    List localList1 = ajfn.a();
    List localList2 = ajfn.b();
    List localList3 = ajfn.c();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "dataListWithOutExit Size =", Integer.valueOf(localList3.size()), "exitDataList Size =", Integer.valueOf(localList1.size()), "undealDataList Size=", Integer.valueOf(localList2.size()) });
      }
      if ((this.jdField_a_of_type_Ajfm.a.c == 1) && (localList2 != null) && (localList2.size() > 0)) {
        this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_Ajdv.a(localList2);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Ajfm.a.c == 0) {
        break label470;
      }
      this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_Ajdv.a = 0;
      label219:
      this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_Ajdv.notifyDataSetChanged();
      this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_Antq.c = bdgn.a().a(this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_Ajfm.a.b) {
        this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(anhk.W, 9000, 0 - bdgn.a().a(this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      this.jdField_a_of_type_Ajfm.a.b(localList2);
      this.jdField_a_of_type_Ajfm.a.c(localList1);
      if (!ajfn.b()) {
        this.jdField_a_of_type_Ajfm.a.a(false, 2);
      }
      if (!ajfn.a()) {
        break label502;
      }
      this.jdField_a_of_type_Ajfm.a.a(true, 1);
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajfm.a);
      return;
      if ((this.jdField_a_of_type_Ajfm.a.c == 2) && (localList1 != null) && (localList1.size() > 0))
      {
        this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_Ajdv.a(localList1);
        break;
      }
      if ((this.jdField_a_of_type_Ajfm.a.c != 0) || (localList3 == null) || (localList3.size() <= 0)) {
        break;
      }
      this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_Ajdv.a(localList3);
      break;
      label470:
      this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_Ajdv.a = bdgn.a().a(this.jdField_a_of_type_Ajfm.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break label219;
      label502:
      this.jdField_a_of_type_Ajfm.a.a(false, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.9.2
 * JD-Core Version:    0.7.0.1
 */