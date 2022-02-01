package com.tencent.mobileqq.activity.contact.troop;

import ajdv;
import antq;
import bgjt;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

class TroopNotifyAndRecommendView$19
  implements Runnable
{
  TroopNotifyAndRecommendView$19(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView, List paramList) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Ajdv != null)
    {
      this.this$0.jdField_a_of_type_Ajdv.b = true;
      this.this$0.jdField_a_of_type_Ajdv.notifyDataSetChanged();
    }
    TroopNotifyAndRecommendView.d(this.this$0);
    Object localObject = (antq)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(22);
    if ((this.a != null) && (this.a.size() > 0))
    {
      if (this.this$0.jdField_a_of_type_Ajdv != null)
      {
        this.this$0.jdField_a_of_type_Ajdv.b(this.a);
        this.this$0.jdField_a_of_type_Ajdv.notifyDataSetChanged();
        this.this$0.c = this.a;
      }
      if (!this.this$0.d)
      {
        bgjt.a("Grp_contacts_news", "notice", "enter_recom", 1, 0, new String[0]);
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
      if (this.this$0.jdField_a_of_type_Ajdv != null)
      {
        localObject = new ArrayList();
        this.this$0.jdField_a_of_type_Ajdv.b((List)localObject);
        this.this$0.jdField_a_of_type_Ajdv.notifyDataSetChanged();
        this.this$0.c = ((List)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.19
 * JD-Core Version:    0.7.0.1
 */