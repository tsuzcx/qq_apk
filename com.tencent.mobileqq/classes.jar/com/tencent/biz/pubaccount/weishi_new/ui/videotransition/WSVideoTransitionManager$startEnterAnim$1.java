package com.tencent.biz.pubaccount.weishi_new.ui.videotransition;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class WSVideoTransitionManager$startEnterAnim$1
  extends Lambda
  implements Function0<Unit>
{
  WSVideoTransitionManager$startEnterAnim$1(View paramView, WSAnimConfig paramWSAnimConfig)
  {
    super(0);
  }
  
  public final void invoke()
  {
    WSVideoTransitionAnimator.a.a(this.$rootView, this.$animConfig.a(1));
    WSVideoTransitionAnimator.a.a(this.$rootView, this.$animConfig.a(2), this.$animConfig.a(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionManager.startEnterAnim.1
 * JD-Core Version:    0.7.0.1
 */