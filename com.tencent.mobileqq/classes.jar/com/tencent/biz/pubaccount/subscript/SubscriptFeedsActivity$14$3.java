package com.tencent.biz.pubaccount.subscript;

import java.io.Serializable;
import java.util.ArrayList;
import sbp;
import sbu;

public class SubscriptFeedsActivity$14$3
  implements Runnable
{
  public SubscriptFeedsActivity$14$3(sbp paramsbp, Serializable paramSerializable) {}
  
  public void run()
  {
    SubscriptFeedsActivity localSubscriptFeedsActivity;
    if ((this.jdField_a_of_type_JavaIoSerializable != null) && (SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbp.a) != null))
    {
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbp.a, (ArrayList)this.jdField_a_of_type_JavaIoSerializable);
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbp.a).b(SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbp.a));
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbp.a).a = true;
      localSubscriptFeedsActivity = this.jdField_a_of_type_Sbp.a;
      if (SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbp.a).f != 1) {
        break label110;
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      SubscriptFeedsActivity.a(localSubscriptFeedsActivity, false, false, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.3
 * JD-Core Version:    0.7.0.1
 */