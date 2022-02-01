package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import aacm;
import com.tencent.mobileqq.widget.QQToast;

public class FakerFeedsAdapter$2
  implements Runnable
{
  public FakerFeedsAdapter$2(aacm paramaacm, CertifiedAccountMeta.StFeed paramStFeed, int paramInt) {}
  
  public void run()
  {
    this.this$0.updateData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, this.jdField_a_of_type_Int);
    this.this$0.notifyItemChanged(this.jdField_a_of_type_Int);
    if (aacm.a(this.this$0) != null) {
      QQToast.a(aacm.b(this.this$0), 0, 2131694667, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.2
 * JD-Core Version:    0.7.0.1
 */