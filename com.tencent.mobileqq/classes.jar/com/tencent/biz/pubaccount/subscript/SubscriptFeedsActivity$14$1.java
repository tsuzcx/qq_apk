package com.tencent.biz.pubaccount.subscript;

import com.tencent.widget.SwipListView;
import java.util.List;
import sbp;
import sbu;
import scr;

public class SubscriptFeedsActivity$14$1
  implements Runnable
{
  public SubscriptFeedsActivity$14$1(sbp paramsbp, List paramList) {}
  
  public void run()
  {
    int i;
    if (SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbp.a) != null)
    {
      i = SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbp.a).size();
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label142;
      }
    }
    label142:
    for (int j = this.jdField_a_of_type_JavaUtilList.size();; j = 0)
    {
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbp.a, this.jdField_a_of_type_JavaUtilList);
      if ((SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbp.a)) && (i != j))
      {
        if (this.jdField_a_of_type_Sbp.a.a.a == 2) {
          SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbp.a).setSelectionFromBottom(SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbp.a).getCount() - 1, 0);
        }
        SubscriptFeedsActivity.b(this.jdField_a_of_type_Sbp.a, false);
      }
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.1
 * JD-Core Version:    0.7.0.1
 */