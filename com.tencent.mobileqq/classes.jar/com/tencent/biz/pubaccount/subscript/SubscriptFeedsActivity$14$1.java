package com.tencent.biz.pubaccount.subscript;

import com.tencent.widget.SwipListView;
import java.util.List;
import upk;
import upp;
import uqm;

public class SubscriptFeedsActivity$14$1
  implements Runnable
{
  public SubscriptFeedsActivity$14$1(upk paramupk, List paramList) {}
  
  public void run()
  {
    int i;
    if (SubscriptFeedsActivity.a(this.jdField_a_of_type_Upk.a) != null)
    {
      i = SubscriptFeedsActivity.a(this.jdField_a_of_type_Upk.a).size();
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label142;
      }
    }
    label142:
    for (int j = this.jdField_a_of_type_JavaUtilList.size();; j = 0)
    {
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Upk.a, this.jdField_a_of_type_JavaUtilList);
      if ((SubscriptFeedsActivity.a(this.jdField_a_of_type_Upk.a)) && (i != j))
      {
        if (this.jdField_a_of_type_Upk.a.a.a == 2) {
          SubscriptFeedsActivity.a(this.jdField_a_of_type_Upk.a).setSelectionFromBottom(SubscriptFeedsActivity.a(this.jdField_a_of_type_Upk.a).getCount() - 1, 0);
        }
        SubscriptFeedsActivity.b(this.jdField_a_of_type_Upk.a, false);
      }
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.1
 * JD-Core Version:    0.7.0.1
 */