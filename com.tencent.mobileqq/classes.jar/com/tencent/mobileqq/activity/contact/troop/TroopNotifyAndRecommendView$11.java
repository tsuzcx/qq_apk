package com.tencent.mobileqq.activity.contact.troop;

import afbk;
import ajqt;
import azzx;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

class TroopNotifyAndRecommendView$11
  implements Runnable
{
  TroopNotifyAndRecommendView$11(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView, List paramList) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Afbk != null)
    {
      this.this$0.jdField_a_of_type_Afbk.b = true;
      this.this$0.jdField_a_of_type_Afbk.notifyDataSetChanged();
    }
    TroopNotifyAndRecommendView.b(this.this$0);
    Object localObject = (ajqt)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(22);
    if ((this.a != null) && (this.a.size() > 0))
    {
      if (this.this$0.jdField_a_of_type_Afbk != null)
      {
        this.this$0.jdField_a_of_type_Afbk.b(this.a);
        this.this$0.jdField_a_of_type_Afbk.notifyDataSetChanged();
      }
      if (!this.this$0.d)
      {
        azzx.a("Grp_contacts_news", "notice", "enter_recom", 1, 0, new String[0]);
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
      if (this.this$0.jdField_a_of_type_Afbk != null)
      {
        localObject = new ArrayList();
        this.this$0.jdField_a_of_type_Afbk.b((List)localObject);
        this.this$0.jdField_a_of_type_Afbk.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.11
 * JD-Core Version:    0.7.0.1
 */