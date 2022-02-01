package com.tencent.mobileqq.activity.contact.troop;

import adab;
import ajpe;
import ajqv;
import ajqw;
import android.app.Activity;
import antf;
import bdzi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopNotifyAndRecommendView$9$2
  implements Runnable
{
  public TroopNotifyAndRecommendView$9$2(ajqv paramajqv, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    TroopNotifyAndRecommendView.d(this.jdField_a_of_type_Ajqv.a);
    if (((Activity)this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_AndroidContentContext).isFinishing()) {}
    while ((this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_Ajpe == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "onGetSystemMsgFin.success");
    }
    List localList1 = ajqw.a();
    List localList2 = ajqw.b();
    List localList3 = ajqw.c();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "dataListWithOutExit Size =", Integer.valueOf(localList3.size()), "exitDataList Size =", Integer.valueOf(localList1.size()), "undealDataList Size=", Integer.valueOf(localList2.size()) });
      }
      if ((this.jdField_a_of_type_Ajqv.a.c == 1) && (localList2 != null) && (localList2.size() > 0)) {
        this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_Ajpe.a(localList2);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Ajqv.a.c == 0) {
        break label470;
      }
      this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_Ajpe.a = 0;
      label219:
      this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_Ajpe.notifyDataSetChanged();
      this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_Aoga.c = bdzi.a().a(this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_Ajqv.a.b) {
        this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(antf.W, 9000, 0 - bdzi.a().a(this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      this.jdField_a_of_type_Ajqv.a.b(localList2);
      this.jdField_a_of_type_Ajqv.a.c(localList1);
      if (!ajqw.b()) {
        this.jdField_a_of_type_Ajqv.a.a(false, 2);
      }
      if (!ajqw.a()) {
        break label502;
      }
      this.jdField_a_of_type_Ajqv.a.a(true, 1);
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajqv.a);
      return;
      if ((this.jdField_a_of_type_Ajqv.a.c == 2) && (localList1 != null) && (localList1.size() > 0))
      {
        this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_Ajpe.a(localList1);
        break;
      }
      if ((this.jdField_a_of_type_Ajqv.a.c != 0) || (localList3 == null) || (localList3.size() <= 0)) {
        break;
      }
      this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_Ajpe.a(localList3);
      break;
      label470:
      this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_Ajpe.a = bdzi.a().a(this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break label219;
      label502:
      this.jdField_a_of_type_Ajqv.a.a(false, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.9.2
 * JD-Core Version:    0.7.0.1
 */