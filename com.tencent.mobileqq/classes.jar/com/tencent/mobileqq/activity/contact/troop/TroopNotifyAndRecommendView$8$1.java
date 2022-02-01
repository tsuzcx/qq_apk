package com.tencent.mobileqq.activity.contact.troop;

import ajfb;
import ajgp;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import aooy;
import bdla;
import bdzy;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopNotifyAndRecommendView$8$1
  implements Runnable
{
  public TroopNotifyAndRecommendView$8$1(ajgp paramajgp, boolean paramBoolean1, boolean paramBoolean2, List paramList) {}
  
  public void run()
  {
    TroopNotifyAndRecommendView.g(this.jdField_a_of_type_Ajgp.a);
    if ((!this.jdField_a_of_type_Boolean) && (this.b) && (this.jdField_a_of_type_Ajgp.a.i))
    {
      String str = this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719153);
      QQToast.a(this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_AndroidContentContext, 1, str, 0).b(this.jdField_a_of_type_Ajgp.a.a());
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "onGetSuspiciousSystemMsgFin.success");
    }
    if ((this.jdField_a_of_type_Ajgp.a.b != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_Ajgp.a.b.clear();
      this.jdField_a_of_type_Ajgp.a.b = TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajgp.a.b, this.jdField_a_of_type_JavaUtilList);
    }
    bdzy.a().b(this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajgp.a) != null)
    {
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajgp.a).a();
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajgp.a).a(this.jdField_a_of_type_Ajgp.a.b);
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajgp.a).notifyDataSetChanged();
      this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(true);
      if (TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajgp.a).getVisibility() == 8) {
        bdla.b(this.jdField_a_of_type_Ajgp.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajgp.a).setVisibility(0);
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.h(this.jdField_a_of_type_Ajgp.a);
      return;
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_Ajgp.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.8.1
 * JD-Core Version:    0.7.0.1
 */