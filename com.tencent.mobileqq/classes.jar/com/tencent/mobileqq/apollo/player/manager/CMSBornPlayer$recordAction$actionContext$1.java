package com.tencent.mobileqq.apollo.player.manager;

import amvq;
import amvr;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext;", "invoke"}, k=3, mv={1, 1, 16})
public final class CMSBornPlayer$recordAction$actionContext$1
  extends Lambda
  implements Function1<amvr, Unit>
{
  public CMSBornPlayer$recordAction$actionContext$1(amvq paramamvq)
  {
    super(1);
  }
  
  public final void invoke(@NotNull amvr paramamvr)
  {
    Intrinsics.checkParameterIsNotNull(paramamvr, "it");
    amvq.a(this.this$0, paramamvr, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.recordAction.actionContext.1
 * JD-Core Version:    0.7.0.1
 */