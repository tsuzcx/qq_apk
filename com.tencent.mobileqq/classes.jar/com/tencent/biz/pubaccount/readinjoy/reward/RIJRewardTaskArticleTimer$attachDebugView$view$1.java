package com.tencent.biz.pubaccount.readinjoy.reward;

import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.reward.mvp.IRIJRewardTaskTimingContract.IView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "updateProgress"}, k=3, mv={1, 1, 16})
final class RIJRewardTaskArticleTimer$attachDebugView$view$1
  implements IRIJRewardTaskTimingContract.IView
{
  RIJRewardTaskArticleTimer$attachDebugView$view$1(TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5) {}
  
  public final void a(int paramInt)
  {
    TextView localTextView = this.a;
    if (localTextView != null) {
      localTextView.setText((CharSequence)("完成任务需要的时间：" + RIJRewardTaskConfig.a() / 1000 + " 秒"));
    }
    localTextView = this.b;
    if (localTextView != null) {
      localTextView.setText((CharSequence)("文章最大贡献时长：" + RIJRewardTaskConfig.c() / 1000 + " 秒"));
    }
    localTextView = this.c;
    if (localTextView != null) {
      localTextView.setText((CharSequence)("文章静止时最大贡献时长：" + RIJRewardTaskConfig.d() / 1000 + " 秒"));
    }
    localTextView = this.d;
    if (localTextView != null) {
      localTextView.setText((CharSequence)("已完成任务数：" + RIJRewardTaskLocalRepo.a.a().a() + '/' + RIJRewardTaskConfig.b()));
    }
    localTextView = this.e;
    if (localTextView != null) {
      localTextView.setText((CharSequence)("累积时间：" + paramInt / 1000 + " 秒"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskArticleTimer.attachDebugView.view.1
 * JD-Core Version:    0.7.0.1
 */