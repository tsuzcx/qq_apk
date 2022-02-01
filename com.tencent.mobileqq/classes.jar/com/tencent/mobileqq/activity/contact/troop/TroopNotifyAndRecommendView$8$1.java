package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopNotifyAndRecommendView$8$1
  implements Runnable
{
  TroopNotifyAndRecommendView$8$1(TroopNotifyAndRecommendView.8 param8, boolean paramBoolean1, boolean paramBoolean2, List paramList) {}
  
  public void run()
  {
    TroopNotifyAndRecommendView.g(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a);
    if ((!this.jdField_a_of_type_Boolean) && (this.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.i))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719695);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_AndroidContentContext, 1, str, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.a());
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "onGetSuspiciousSystemMsgFin.success");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.b != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.b.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.b = TroopNotifyAndRecommendView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.b, this.jdField_a_of_type_JavaUtilList);
    }
    GroupSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (TroopNotifyAndRecommendView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a) != null)
    {
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a).a();
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a).a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.b);
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a).notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(true);
      if (TroopNotifyAndRecommendView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a).getVisibility() == 8) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a).setVisibility(0);
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.h(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a);
      return;
      TroopNotifyAndRecommendView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$8.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.8.1
 * JD-Core Version:    0.7.0.1
 */