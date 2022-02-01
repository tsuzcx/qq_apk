package com.tencent.mobileqq.activity.contact.troop;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import java.util.List;

class TroopNotifyAndRecommendView$9$1
  implements Runnable
{
  TroopNotifyAndRecommendView$9$1(TroopNotifyAndRecommendView.9 param9) {}
  
  public void run()
  {
    if ((this.a.this$0.b == null) || (this.a.this$0.b.isEmpty()))
    {
      TroopNotifyAndRecommendView.a(this.a.this$0).a();
      TroopNotifyAndRecommendView.a(this.a.this$0).setVisibility(8);
      this.a.this$0.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(0);
      this.a.this$0.setType(0);
    }
    if ((this.a.this$0.b != null) && (this.a.this$0.b.size() > 0))
    {
      if (TroopNotifyAndRecommendView.a(this.a.this$0).getVisibility() == 8) {
        ReportController.b(this.a.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      TroopNotifyAndRecommendView.a(this.a.this$0).setVisibility(0);
      if (!(this.a.this$0.b.get(0) instanceof MessageForSystemMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyAndRecommendView", 2, "initListData error");
        }
        this.a.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSystemMsgHistory();
        TroopNotifyAndRecommendView.a(this.a.this$0).a(null);
      }
    }
    else
    {
      TroopNotifyAndRecommendView.a(this.a.this$0).setVisibility(8);
    }
    TroopNotifyAndRecommendView.a(this.a.this$0).a();
    TroopNotifyAndRecommendView.a(this.a.this$0).a(this.a.this$0.b);
    TroopNotifyAndRecommendView.a(this.a.this$0).notifyDataSetChanged();
    TroopNotifyAndRecommendView.h(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.9.1
 * JD-Core Version:    0.7.0.1
 */