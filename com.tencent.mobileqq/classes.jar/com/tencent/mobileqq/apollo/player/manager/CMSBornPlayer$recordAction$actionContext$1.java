package com.tencent.mobileqq.apollo.player.manager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext;", "invoke"}, k=3, mv={1, 1, 16})
final class CMSBornPlayer$recordAction$actionContext$1
  extends Lambda
  implements Function1<CMSBornPlayer.CMSActionContext, Unit>
{
  CMSBornPlayer$recordAction$actionContext$1(CMSBornPlayer paramCMSBornPlayer)
  {
    super(1);
  }
  
  public final void invoke(@NotNull CMSBornPlayer.CMSActionContext paramCMSActionContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSActionContext, "it");
    CMSBornPlayer.a(this.this$0, paramCMSActionContext, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.recordAction.actionContext.1
 * JD-Core Version:    0.7.0.1
 */