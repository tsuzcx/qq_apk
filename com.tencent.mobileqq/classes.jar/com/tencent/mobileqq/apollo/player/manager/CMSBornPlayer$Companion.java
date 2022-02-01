package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$Companion;", "", "()V", "TAG", "", "timeout", "", "getTimeout", "()J", "callBackError", "", "actionContext", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext;", "errorState", "Lcom/tencent/mobileqq/apollo/player/CMSActionStatus;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayer$Companion
{
  private final void a(CMSBornPlayer.CMSActionContext paramCMSActionContext, CMSActionStatus paramCMSActionStatus)
  {
    CMSAction localCMSAction = paramCMSActionContext.a();
    paramCMSActionContext.a().a(localCMSAction, paramCMSActionStatus);
    paramCMSActionContext.a().a(localCMSAction, false, CMSAction.a(localCMSAction, null, null, 3, null), null);
  }
  
  public final long a()
  {
    return CMSBornPlayer.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.Companion
 * JD-Core Version:    0.7.0.1
 */