package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import bgln;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import zby;

class FastWebActivity$2$1
  implements Runnable
{
  FastWebActivity$2$1(FastWebActivity.2 param2, int[] paramArrayOfInt) {}
  
  public void run()
  {
    long l1 = bgln.k();
    long l2 = FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$2.this$0).getWidth();
    long l3 = zby.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$2.this$0, 10.0F);
    int i = this.jdField_a_of_type_ArrayOfInt[1];
    int j = zby.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$2.this$0, 5.0F);
    FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$2.this$0, FastWebActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$2.this$0), (int)(l1 - l2 - l3), i + j, true, true, RIJRedPacketManager.a().c(), RIJRedPacketManager.a().h());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.2.1
 * JD-Core Version:    0.7.0.1
 */