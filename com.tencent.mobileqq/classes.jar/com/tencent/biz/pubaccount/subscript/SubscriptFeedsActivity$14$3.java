package com.tencent.biz.pubaccount.subscript;

import java.io.Serializable;
import java.util.ArrayList;

class SubscriptFeedsActivity$14$3
  implements Runnable
{
  SubscriptFeedsActivity$14$3(SubscriptFeedsActivity.14 param14, Serializable paramSerializable) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaIoSerializable != null) && (SubscriptFeedsActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity$14.a) != null))
    {
      SubscriptFeedsActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity$14.a, (ArrayList)this.jdField_a_of_type_JavaIoSerializable);
      SubscriptFeedsActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity$14.a).b(SubscriptFeedsActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity$14.a));
      Object localObject = SubscriptFeedsActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity$14.a);
      boolean bool = true;
      ((SubscriptFeedsAdapter)localObject).a = true;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity$14.a;
      if (SubscriptFeedsActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity$14.a).f != 1) {
        bool = false;
      }
      SubscriptFeedsActivity.a((SubscriptFeedsActivity)localObject, false, false, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.14.3
 * JD-Core Version:    0.7.0.1
 */