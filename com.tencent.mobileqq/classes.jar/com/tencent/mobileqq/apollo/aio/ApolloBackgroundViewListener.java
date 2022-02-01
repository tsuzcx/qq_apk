package com.tencent.mobileqq.apollo.aio;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.script.SpriteBackgroundManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderCallback;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.render.ISurfaceStateListener;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.plugin.BackgroundPlugin;
import com.tencent.mobileqq.cmshow.engine.script.task.BackgroundInitTask;
import com.tencent.mobileqq.cmshow.engine.script.task.IScriptTaskBuilder;
import com.tencent.mobileqq.cmshow.engine.script.task.ScriptTaskType;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloBackgroundViewListener
  implements IRenderCallback, ISurfaceStateListener
{
  public WeakReference<BaseChatPie> a;
  private WeakReference<IRenderCallback> b;
  private ICMShowEngine c;
  
  public ApolloBackgroundViewListener(BaseChatPie paramBaseChatPie, ICMShowEngine paramICMShowEngine)
  {
    if (((paramBaseChatPie instanceof FriendChatPie)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof DiscussChatPie)) || ((paramBaseChatPie instanceof HotChatPie))) {
      this.a = new WeakReference(paramBaseChatPie);
    }
    this.c = paramICMShowEngine;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (BaseChatPie)((WeakReference)localObject1).get();
    if (localObject1 == null) {
      return;
    }
    if (this.c == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mCMShowEngine:");
      ((StringBuilder)localObject2).append(this.c);
      QLog.d("[cmshow]ApolloBackgroundViewListener", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.c.e();
    Object localObject3 = (BackgroundInitTask)((IScriptService)localObject2).b().a(ScriptTaskType.BACKGROUND_INIT);
    ((BackgroundInitTask)localObject3).c(1).a(250.0F, 0.0F);
    localObject3 = ((BackgroundInitTask)localObject3).a();
    this.c.k();
    ((IScriptService)localObject2).a((Script)localObject3);
    localObject1 = ((SpriteScriptManagerImpl)((BaseChatPie)localObject1).d.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBackgroundManager();
    if (localObject1 != null) {
      ((SpriteBackgroundManager)localObject1).b();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloBackgroundViewListener", 2, "onCompleteRender");
    }
    WeakReference localWeakReference = this.b;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((IRenderCallback)this.b.get()).a(paramInt1, paramInt2, paramString);
    }
  }
  
  public void a(IRenderCallback paramIRenderCallback)
  {
    this.b = new WeakReference(paramIRenderCallback);
    paramIRenderCallback = this.c;
    if (paramIRenderCallback != null) {
      paramIRenderCallback.e().a(new BackgroundPlugin(this.b));
    }
  }
  
  public void b_(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloBackgroundViewListener", 2, "onStartRender");
    }
    WeakReference localWeakReference = this.b;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((IRenderCallback)this.b.get()).b_(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ApolloBackgroundViewListener
 * JD-Core Version:    0.7.0.1
 */