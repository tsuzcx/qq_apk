package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.render.IRenderRunner;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.player.CMSHelper;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CMSBornPlayer$recordAction$render$1
  extends Lambda
  implements Function0<Unit>
{
  CMSBornPlayer$recordAction$render$1(CMSBornPlayer.CMSActionContext paramCMSActionContext)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject = CMSHelper.a.a();
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver((BusinessObserver)this.$actionContext.a());
    }
    this.$actionContext.a().onDestroy();
    localObject = ApolloUtilImpl.getCmdChannel();
    if (localObject != null)
    {
      ((IApolloCmdChannel)localObject).removeRenderRunner((IRenderRunner)this.$actionContext.a());
      ((IApolloCmdChannel)localObject).removeCmdHandler(this.$actionContext.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.recordAction.render.1
 * JD-Core Version:    0.7.0.1
 */