package com.tencent.mobileqq.activity.contact.troop;

import aike;
import ails;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import anmf;
import bcef;
import bcsz;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopNotifyAndRecommendView$9$1
  implements Runnable
{
  public TroopNotifyAndRecommendView$9$1(ails paramails, boolean paramBoolean1, boolean paramBoolean2, List paramList) {}
  
  public void run()
  {
    TroopNotifyAndRecommendView.g(this.jdField_a_of_type_Ails.a);
    if ((!this.jdField_a_of_type_Boolean) && (this.b) && (this.jdField_a_of_type_Ails.a.i))
    {
      String str = this.jdField_a_of_type_Ails.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718763);
      QQToast.a(this.jdField_a_of_type_Ails.a.jdField_a_of_type_AndroidContentContext, 1, str, 0).b(this.jdField_a_of_type_Ails.a.a());
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "onGetSuspiciousSystemMsgFin.success");
    }
    if ((this.jdField_a_of_type_Ails.a.b != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Ails.a.b.clear();
      this.jdField_a_of_type_Ails.a.b = TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ails.a.b, this.jdField_a_of_type_JavaUtilList);
    }
    bcsz.a().b(this.jdField_a_of_type_Ails.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ails.a) != null)
    {
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ails.a).a();
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ails.a).a(this.jdField_a_of_type_Ails.a.b);
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ails.a).notifyDataSetChanged();
      this.jdField_a_of_type_Ails.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(true);
      if (TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ails.a).getVisibility() == 8) {
        bcef.b(this.jdField_a_of_type_Ails.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ails.a).setVisibility(0);
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.h(this.jdField_a_of_type_Ails.a);
      return;
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ails.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.9.1
 * JD-Core Version:    0.7.0.1
 */