package com.tencent.mobileqq.activity.contact.troop;

import ahot;
import ambh;
import bdes;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

class TroopNotifyAndRecommendView$12
  implements Runnable
{
  TroopNotifyAndRecommendView$12(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView, List paramList) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Ahot != null)
    {
      this.this$0.jdField_a_of_type_Ahot.b = true;
      this.this$0.jdField_a_of_type_Ahot.notifyDataSetChanged();
    }
    TroopNotifyAndRecommendView.c(this.this$0);
    Object localObject = (ambh)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(22);
    if ((this.a != null) && (this.a.size() > 0))
    {
      if (this.this$0.jdField_a_of_type_Ahot != null)
      {
        this.this$0.jdField_a_of_type_Ahot.b(this.a);
        this.this$0.jdField_a_of_type_Ahot.notifyDataSetChanged();
      }
      if (!this.this$0.d)
      {
        bdes.a("Grp_contacts_news", "notice", "enter_recom", 1, 0, new String[0]);
        this.this$0.d = true;
      }
    }
    for (;;)
    {
      this.this$0.n();
      if (!this.this$0.e)
      {
        this.this$0.l();
        this.this$0.e = true;
      }
      return;
      if (this.this$0.jdField_a_of_type_Ahot != null)
      {
        localObject = new ArrayList();
        this.this$0.jdField_a_of_type_Ahot.b((List)localObject);
        this.this$0.jdField_a_of_type_Ahot.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.12
 * JD-Core Version:    0.7.0.1
 */