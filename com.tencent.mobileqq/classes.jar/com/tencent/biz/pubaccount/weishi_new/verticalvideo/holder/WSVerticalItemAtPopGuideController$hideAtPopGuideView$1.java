package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lorg/libpag/PAGView;", "invoke"}, k=3, mv={1, 1, 16})
final class WSVerticalItemAtPopGuideController$hideAtPopGuideView$1
  extends Lambda
  implements Function1<PAGView, Unit>
{
  public static final 1 INSTANCE = new 1();
  
  WSVerticalItemAtPopGuideController$hideAtPopGuideView$1()
  {
    super(1);
  }
  
  public final void invoke(@NotNull PAGView paramPAGView)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGView, "it");
    paramPAGView.stop();
    paramPAGView.setProgress(0.0D);
    paramPAGView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemAtPopGuideController.hideAtPopGuideView.1
 * JD-Core Version:    0.7.0.1
 */