package com.tencent.mobileqq.apollo.meme.manager;

import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer$Companion;", "", "()V", "TAG", "", "timeout", "", "getTimeout", "()J", "callBackError", "", "actionContext", "Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer$BornActionContext;", "errorState", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class MemeBornPlayer$Companion
{
  private final void a(MemeBornPlayer.BornActionContext paramBornActionContext, ActionStatus paramActionStatus)
  {
    MemeAction localMemeAction = paramBornActionContext.k();
    localMemeAction.a(paramActionStatus);
    paramBornActionContext.n().a(localMemeAction, paramActionStatus);
    paramBornActionContext.n().a(localMemeAction, false, MemeAction.a(localMemeAction, null, null, 3, null), null);
  }
  
  public final long a()
  {
    return MemeBornPlayer.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayer.Companion
 * JD-Core Version:    0.7.0.1
 */