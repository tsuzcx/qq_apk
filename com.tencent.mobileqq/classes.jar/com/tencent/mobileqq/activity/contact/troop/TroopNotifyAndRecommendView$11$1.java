package com.tencent.mobileqq.activity.contact.troop;

import aijs;
import aikq;
import java.util.List;

class TroopNotifyAndRecommendView$11$1
  implements Runnable
{
  TroopNotifyAndRecommendView$11$1(TroopNotifyAndRecommendView.11 param11, aikq paramaikq, List paramList) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aikq.a(this.jdField_a_of_type_JavaUtilList, 0);
    List localList1 = this.jdField_a_of_type_Aikq.c();
    List localList2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0.c == 1)
    {
      localList2 = this.jdField_a_of_type_Aikq.b();
      if ((localList2 != null) && (!localList2.isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0.a.a(localList2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0.b(this.jdField_a_of_type_Aikq.b());
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0.c(this.jdField_a_of_type_Aikq.a());
      TroopNotifyAndRecommendView.h(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0.a.a = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0.a.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0.setType(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0.a.a(localList1);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0.c == 2)
      {
        localList2 = this.jdField_a_of_type_Aikq.a();
        if ((localList2 != null) && (!localList2.isEmpty()))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0.a.a(this.jdField_a_of_type_Aikq.a());
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0.setType(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0.a.a(localList1);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0.c == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView$11.this$0.a.a(localList1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.11.1
 * JD-Core Version:    0.7.0.1
 */