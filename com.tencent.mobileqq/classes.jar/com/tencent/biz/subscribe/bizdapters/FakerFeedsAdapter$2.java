package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.mobileqq.widget.QQToast;

class FakerFeedsAdapter$2
  implements Runnable
{
  FakerFeedsAdapter$2(FakerFeedsAdapter paramFakerFeedsAdapter, CertifiedAccountMeta.StFeed paramStFeed, int paramInt) {}
  
  public void run()
  {
    this.this$0.a(this.a, this.b);
    this.this$0.notifyItemChanged(this.b);
    if (FakerFeedsAdapter.a(this.this$0) != null) {
      QQToast.makeText(FakerFeedsAdapter.b(this.this$0), 0, 2131893015, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.2
 * JD-Core Version:    0.7.0.1
 */