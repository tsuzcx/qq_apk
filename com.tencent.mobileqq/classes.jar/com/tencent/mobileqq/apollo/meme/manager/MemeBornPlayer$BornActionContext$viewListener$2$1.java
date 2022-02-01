package com.tencent.mobileqq.apollo.meme.manager;

import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.render.ISurfaceStateListener;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.script.plugin.IEventPlugin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer$BornActionContext$viewListener$2$1", "Lcom/tencent/mobileqq/cmshow/engine/render/ISurfaceStateListener;", "onSurfaceReady", "", "width", "", "height", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class MemeBornPlayer$BornActionContext$viewListener$2$1
  implements ISurfaceStateListener
{
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceReady, ");
    localStringBuilder.append(this.a.this$0.k().h());
    localStringBuilder.append(" width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height:");
    localStringBuilder.append(paramInt2);
    QLog.w("[cmshow][MemePlayer]MemeBornPlayer", 1, localStringBuilder.toString());
    this.a.this$0.m().e().a((IEventPlugin)this.a.this$0.c());
    this.a.this$0.o().invoke(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayer.BornActionContext.viewListener.2.1
 * JD-Core Version:    0.7.0.1
 */