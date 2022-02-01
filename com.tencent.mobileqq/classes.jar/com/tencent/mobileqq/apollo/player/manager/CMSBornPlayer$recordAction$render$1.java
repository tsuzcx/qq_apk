package com.tencent.mobileqq.apollo.player.manager;

import amqs;
import amvr;
import anch;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
public final class CMSBornPlayer$recordAction$render$1
  extends Lambda
  implements Function0<Unit>
{
  public CMSBornPlayer$recordAction$render$1(QQAppInterface paramQQAppInterface, amvr paramamvr)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject = this.$app;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver((BusinessObserver)this.$actionContext.a());
    }
    this.$actionContext.a().onDestroy();
    localObject = ApolloCmdChannel.getChannel(this.$app);
    ((ApolloCmdChannel)localObject).removeRenderRunner((amqs)this.$actionContext.a());
    ((ApolloCmdChannel)localObject).removeCmdHandler(this.$actionContext.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.recordAction.render.1
 * JD-Core Version:    0.7.0.1
 */