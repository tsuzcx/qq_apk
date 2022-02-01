package com.tencent.mobileqq.apollo.meme.manager;

import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.meme.MemeHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer$BornActionContext;", "invoke"}, k=3, mv={1, 1, 16})
final class MemeBornPlayer$initActionContext$actionContext$1
  extends Lambda
  implements Function1<MemeBornPlayer.BornActionContext, Unit>
{
  MemeBornPlayer$initActionContext$actionContext$1(MemeBornPlayer paramMemeBornPlayer)
  {
    super(1);
  }
  
  public final void invoke(@NotNull MemeBornPlayer.BornActionContext paramBornActionContext)
  {
    Intrinsics.checkParameterIsNotNull(paramBornActionContext, "it");
    if (CmShowWnsUtils.P())
    {
      MemeHelper.a.a((Function0)new MemeBornPlayer.initActionContext.actionContext.1.1(this, paramBornActionContext));
      return;
    }
    MemeBornPlayer.a(this.this$0, paramBornActionContext, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayer.initActionContext.actionContext.1
 * JD-Core Version:    0.7.0.1
 */