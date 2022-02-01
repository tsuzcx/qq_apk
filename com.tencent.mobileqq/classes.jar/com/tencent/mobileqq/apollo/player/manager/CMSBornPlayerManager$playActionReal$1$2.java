package com.tencent.mobileqq.apollo.player.manager;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CMSBornPlayerManager$playActionReal$1$2
  extends Lambda
  implements Function0<Unit>
{
  CMSBornPlayerManager$playActionReal$1$2(CMSBornPlayerManager.ActionItem paramActionItem)
  {
    super(0);
  }
  
  public final void invoke()
  {
    FrameLayout localFrameLayout = this.$lowPriAction.a();
    if (localFrameLayout == null) {
      Intrinsics.throwNpe();
    }
    localFrameLayout.removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.playActionReal.1.2
 * JD-Core Version:    0.7.0.1
 */