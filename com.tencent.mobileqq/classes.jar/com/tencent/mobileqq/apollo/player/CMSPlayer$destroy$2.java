package com.tencent.mobileqq.apollo.player;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CMSPlayer$destroy$2
  extends Lambda
  implements Function0<Unit>
{
  CMSPlayer$destroy$2(CMSPlayer paramCMSPlayer)
  {
    super(0);
  }
  
  public final void invoke()
  {
    CMSPlayer.a(this.this$0).removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSPlayer.destroy.2
 * JD-Core Version:    0.7.0.1
 */