package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.render.IRenderRunner;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CMSBornPlayer$playAction$render$1$1
  extends Lambda
  implements Function0<Unit>
{
  CMSBornPlayer$playAction$render$1$1(CMSBornPlayer.playAction.render.1 param1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.this$0.$actionContext.a().onDestroy();
    IApolloCmdChannel localIApolloCmdChannel = ApolloUtilImpl.getCmdChannel();
    if (localIApolloCmdChannel != null)
    {
      localIApolloCmdChannel.removeRenderRunner((IRenderRunner)this.this$0.$actionContext.a());
      localIApolloCmdChannel.removeCmdHandler(this.this$0.$actionContext.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.playAction.render.1.1
 * JD-Core Version:    0.7.0.1
 */