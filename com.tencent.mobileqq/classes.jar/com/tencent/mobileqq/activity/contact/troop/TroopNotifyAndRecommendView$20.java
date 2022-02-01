package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.util.TroopReportor;
import java.util.ArrayList;
import java.util.List;

class TroopNotifyAndRecommendView$20
  implements Runnable
{
  TroopNotifyAndRecommendView$20(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView, List paramList) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.b = true;
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
    }
    TroopNotifyAndRecommendView.i(this.this$0);
    Object localObject = (RecommendTroopManagerImp)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER);
    if ((this.a != null) && (this.a.size() > 0))
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.b(this.a);
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
        this.this$0.c = this.a;
      }
      if (!this.this$0.d)
      {
        TroopReportor.a("Grp_contacts_news", "notice", "enter_recom", 1, 0, new String[0]);
        this.this$0.d = true;
      }
    }
    for (;;)
    {
      this.this$0.o();
      if (!this.this$0.f)
      {
        this.this$0.m();
        this.this$0.f = true;
      }
      return;
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter != null)
      {
        localObject = new ArrayList();
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.b((List)localObject);
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotifyAndRecAdapter.notifyDataSetChanged();
        this.this$0.c = ((List)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.20
 * JD-Core Version:    0.7.0.1
 */