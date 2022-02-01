package com.tencent.biz.pubaccount.readinjoy.reward;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.reward.mvp.RIJRewardTaskTimingPresenter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJRewardTaskArticleTimer$resumeTiming$1
  implements Runnable
{
  RIJRewardTaskArticleTimer$resumeTiming$1(RIJRewardTaskArticleTimer paramRIJRewardTaskArticleTimer, String paramString, int paramInt) {}
  
  public final void run()
  {
    if (RIJRewardTaskArticleTimer.a(this.this$0) <= RIJRewardTaskConfig.d())
    {
      RIJRewardTaskArticleTimer localRIJRewardTaskArticleTimer = this.this$0;
      RIJRewardTaskArticleTimer.a(localRIJRewardTaskArticleTimer, RIJRewardTaskArticleTimer.a(localRIJRewardTaskArticleTimer) + 33);
      RIJRewardTaskArticleTimer.a(this.this$0).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1);
    }
    for (;;)
    {
      RIJRewardTaskArticleTimer.a(this.this$0).postDelayed(RIJRewardTaskArticleTimer.a(this.this$0), 33);
      return;
      RIJRewardTaskArticleTimer.a(this.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskArticleTimer.resumeTiming.1
 * JD-Core Version:    0.7.0.1
 */