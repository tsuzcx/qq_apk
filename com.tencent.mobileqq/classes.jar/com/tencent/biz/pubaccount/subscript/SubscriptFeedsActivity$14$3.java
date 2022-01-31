package com.tencent.biz.pubaccount.subscript;

import java.io.Serializable;
import java.util.ArrayList;
import sbs;
import sbx;

public class SubscriptFeedsActivity$14$3
  implements Runnable
{
  public SubscriptFeedsActivity$14$3(sbs paramsbs, Serializable paramSerializable) {}
  
  public void run()
  {
    SubscriptFeedsActivity localSubscriptFeedsActivity;
    if ((this.jdField_a_of_type_JavaIoSerializable != null) && (SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbs.a) != null))
    {
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbs.a, (ArrayList)this.jdField_a_of_type_JavaIoSerializable);
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbs.a).b(SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbs.a));
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbs.a).a = true;
      localSubscriptFeedsActivity = this.jdField_a_of_type_Sbs.a;
      if (SubscriptFeedsActivity.a(this.jdField_a_of_type_Sbs.a).f != 1) {
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