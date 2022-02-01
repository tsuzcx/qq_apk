package com.tencent.mobileqq.activity.contact.troop;

import ajoe;
import ajqv;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import aoti;
import bdll;
import bdzi;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopNotifyAndRecommendView$9$1
  implements Runnable
{
  public TroopNotifyAndRecommendView$9$1(ajqv paramajqv, boolean paramBoolean1, boolean paramBoolean2, List paramList) {}
  
  public void run()
  {
    TroopNotifyAndRecommendView.c(this.jdField_a_of_type_Ajqv.a);
    if ((!this.jdField_a_of_type_Boolean) && (this.b) && (this.jdField_a_of_type_Ajqv.a.i))
    {
      String str = this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718515);
      QQToast.a(this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_AndroidContentContext, 1, str, 0).b(this.jdField_a_of_type_Ajqv.a.a());
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "onGetSuspiciousSystemMsgFin.success");
    }
    if ((this.jdField_a_of_type_Ajqv.a.b != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Ajqv.a.b.clear();
      this.jdField_a_of_type_Ajqv.a.b = TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajqv.a.b, this.jdField_a_of_type_JavaUtilList);
    }
    bdzi.a().b(this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajqv.a) != null)
    {
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajqv.a).a();
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajqv.a).a(this.jdField_a_of_type_Ajqv.a.b);
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajqv.a).notifyDataSetChanged();
      this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true);
      if (TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajqv.a).getVisibility() == 8) {
        bdll.b(this.jdField_a_of_type_Ajqv.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajqv.a).setVisibility(0);
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajqv.a);
      return;
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajqv.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.9.1
 * JD-Core Version:    0.7.0.1
 */