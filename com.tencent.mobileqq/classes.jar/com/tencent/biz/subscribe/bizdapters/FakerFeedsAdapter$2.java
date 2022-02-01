package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.mobileqq.widget.QQToast;
import zsu;

public class FakerFeedsAdapter$2
  implements Runnable
{
  public FakerFeedsAdapter$2(zsu paramzsu, CertifiedAccountMeta.StFeed paramStFeed, int paramInt) {}
  
  public void run()
  {
    this.this$0.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, this.jdField_a_of_type_Int);
    this.this$0.notifyItemChanged(this.jdField_a_of_type_Int);
    if (zsu.a(this.this$0) != null) {
      QQToast.a(zsu.b(this.this$0), 0, 2131695037, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.2
 * JD-Core Version:    0.7.0.1
 */