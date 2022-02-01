package com.tencent.mobileqq.apollo.player;

import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.player.action.MODE;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CMSPlayer$destroy$1$1
  extends Lambda
  implements Function0<Unit>
{
  CMSPlayer$destroy$1$1(CMSAction paramCMSAction)
  {
    super(0);
  }
  
  public final void invoke()
  {
    MODE localMODE = this.$it.a();
    switch (CMSPlayer.WhenMappings.c[localMODE.ordinal()])
    {
    default: 
      return;
    }
    CMSBornPlayerManager.a.c(this.$it);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSPlayer.destroy.1.1
 * JD-Core Version:    0.7.0.1
 */