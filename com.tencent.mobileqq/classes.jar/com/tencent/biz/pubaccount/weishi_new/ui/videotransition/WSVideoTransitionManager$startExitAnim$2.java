package com.tencent.biz.pubaccount.weishi_new.ui.videotransition;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class WSVideoTransitionManager$startExitAnim$2
  extends Lambda
  implements Function0<Unit>
{
  WSVideoTransitionManager$startExitAnim$2(WSVideoTransitionManager.OnExitAnimEndListener paramOnExitAnimEndListener)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.$onExitAnimEndListener.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionManager.startExitAnim.2
 * JD-Core Version:    0.7.0.1
 */