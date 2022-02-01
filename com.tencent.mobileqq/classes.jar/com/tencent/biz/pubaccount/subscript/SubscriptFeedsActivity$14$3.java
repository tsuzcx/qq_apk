package com.tencent.biz.pubaccount.subscript;

import java.io.Serializable;
import java.util.ArrayList;
import upk;
import upp;

public class SubscriptFeedsActivity$14$3
  implements Runnable
{
  public SubscriptFeedsActivity$14$3(upk paramupk, Serializable paramSerializable) {}
  
  public void run()
  {
    SubscriptFeedsActivity localSubscriptFeedsActivity;
    if ((this.jdField_a_of_type_JavaIoSerializable != null) && (SubscriptFeedsActivity.a(this.jdField_a_of_type_Upk.a) != null))
    {
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Upk.a, (ArrayList)this.jdField_a_of_type_JavaIoSerializable);
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Upk.a).b(SubscriptFeedsActivity.a(this.jdField_a_of_type_Upk.a));
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Upk.a).a = true;
      localSubscriptFeedsActivity = this.jdField_a_of_type_Upk.a;
      if (SubscriptFeedsActivity.a(this.jdField_a_of_type_Upk.a).f != 1) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.3
 * JD-Core Version:    0.7.0.1
 */