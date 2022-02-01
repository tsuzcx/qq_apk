package com.tencent.biz.pubaccount.readinjoy.reward;

import android.os.Handler;
import kotlin.Metadata;
import rjv;
import rjy;
import rlq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class RIJRewardTaskArticleTimer$resumeTiming$1
  implements Runnable
{
  public RIJRewardTaskArticleTimer$resumeTiming$1(rjv paramrjv, String paramString, int paramInt) {}
  
  public final void run()
  {
    if (rjv.a(this.this$0) <= rjy.d())
    {
      rjv localrjv = this.this$0;
      rjv.a(localrjv, rjv.a(localrjv) + 33);
      rjv.a(this.this$0).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1);
    }
    for (;;)
    {
      rjv.a(this.this$0).postDelayed(rjv.a(this.this$0), 33);
      return;
      rjv.a(this.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskArticleTimer.resumeTiming.1
 * JD-Core Version:    0.7.0.1
 */