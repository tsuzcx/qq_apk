package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.api.listener.OnApolloViewListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSApolloRender;", "Lcom/tencent/mobileqq/apollo/ApolloRender;", "scale", "", "callback", "Lcom/tencent/mobileqq/apollo/api/listener/OnApolloViewListener;", "destroy", "Lkotlin/Function0;", "", "(FLcom/tencent/mobileqq/apollo/api/listener/OnApolloViewListener;Lkotlin/jvm/functions/Function0;)V", "onDestroy", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class CMSBornPlayer$CMSApolloRender
  extends ApolloRender
{
  private final Function0<Unit> a;
  
  public CMSBornPlayer$CMSApolloRender(float paramFloat, @NotNull OnApolloViewListener paramOnApolloViewListener, @NotNull Function0<Unit> paramFunction0)
  {
    super(paramFloat, paramOnApolloViewListener, 0);
    this.a = paramFunction0;
  }
  
  public void onDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("destroy, apolloRender:").append(this).append(", director:").append(getSavaWrapper().a).append(", ticker:{");
    ApolloEngine localApolloEngine = getSavaWrapper();
    Intrinsics.checkExpressionValueIsNotNull(localApolloEngine, "this.savaWrapper");
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 2, localApolloEngine.a() + '}');
    super.onDestroy();
    this.a.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSApolloRender
 * JD-Core Version:    0.7.0.1
 */