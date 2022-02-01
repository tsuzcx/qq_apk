package com.tencent.biz.pubaccount.weishi_new.ui.videotransition;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class WSVideoTransitionManager$startExitAnim$1
  extends Lambda
  implements Function0<Unit>
{
  WSVideoTransitionManager$startExitAnim$1(WSVideoTransitionManager paramWSVideoTransitionManager)
  {
    super(0);
  }
  
  public final void invoke()
  {
    ViewGroup localViewGroup = WSVideoTransitionManager.a(this.this$0);
    if (localViewGroup != null) {
      localViewGroup.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.videotransition.WSVideoTransitionManager.startExitAnim.1
 * JD-Core Version:    0.7.0.1
 */