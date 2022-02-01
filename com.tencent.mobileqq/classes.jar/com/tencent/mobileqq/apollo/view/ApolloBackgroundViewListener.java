package com.tencent.mobileqq.apollo.view;

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
  private ICMShowEngine a;
  public WeakReference<BaseChatPie> a;
  private WeakReference<IRenderCallback> b;
  
  public ApolloBackgroundViewListener(BaseChatPie paramBaseChatPie, ICMShowEngine paramICMShowEngine)
  {
    if (((paramBaseChatPie instanceof FriendChatPie)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof DiscussChatPie)) || ((paramBaseChatPie instanceof HotChatPie))) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    }
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine = paramICMShowEngine;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (BaseChatPie)((WeakReference)localObject1).get();
    if (localObject1 == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mCMShowEngine:");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine);
      QLog.d("[cmshow]ApolloBackgroundViewListener", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine.a();
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine.a();
    Object localObject3 = (BackgroundInitTask)((IScriptService)localObject2).a().a(ScriptTaskType.BACKGROUND_INIT);
    ((BackgroundInitTask)localObject3).a(1).a(250.0F, 0.0F);
    localObject3 = new Script(((BackgroundInitTask)localObject3).a());
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine.a();
    ((IScriptService)localObject2).a((Script)localObject3);
    localObject1 = ((SpriteScriptManagerImpl)((BaseChatPie)localObject1).a.getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBackgroundManager();
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
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloBackgroundViewListener", 2, "onStartRender");
    }
    WeakReference localWeakReference = this.b;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((IRenderCallback)this.b.get()).a(paramInt, paramString);
    }
  }
  
  public void a(IRenderCallback paramIRenderCallback)
  {
    this.b = new WeakReference(paramIRenderCallback);
    paramIRenderCallback = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
    if (paramIRenderCallback != null) {
      paramIRenderCallback.a().a(new BackgroundPlugin(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloBackgroundViewListener
 * JD-Core Version:    0.7.0.1
 */