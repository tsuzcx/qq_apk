package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.api.impl.ApolloAIOHelperImpl;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class SpriteUIHandler$SpriteVisibleRunnable
  implements Runnable
{
  private boolean a;
  private boolean b;
  private SpriteContext c;
  private String d;
  
  public SpriteUIHandler$SpriteVisibleRunnable(SpriteContext paramSpriteContext, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.b = paramBoolean1;
    this.a = paramBoolean2;
    this.c = paramSpriteContext;
    this.d = paramString;
  }
  
  public void run()
  {
    Object localObject1 = this.c;
    if (localObject1 == null)
    {
      QLog.e("[cmshow][scripted]SpriteUIHandler", 1, "[onDoubleTap], mContext is null.");
      return;
    }
    if (this.a)
    {
      ((SpriteContext)localObject1).e(this.b);
    }
    else
    {
      localObject2 = this.d;
      if (localObject2 != null) {
        ((SpriteContext)localObject1).a((String)localObject2, this.b);
      }
    }
    Object localObject2 = this.c.l();
    if (localObject2 == null) {
      return;
    }
    if (this.c.n() != null) {
      localObject1 = this.c.n().c().a();
    } else {
      localObject1 = null;
    }
    QLog.d("[cmshow][scripted]SpriteUIHandler", 1, new Object[] { "[showOrHideSprite], isHide:", Boolean.valueOf(this.b), ", from:", this.d, ", cmshowView:", localObject1, ", canInit:", Boolean.valueOf(this.c.f), ", isViewReady:", Boolean.valueOf(this.c.r()) });
    Object localObject3;
    if (!this.b)
    {
      if ((localObject1 == null) && (!this.c.f))
      {
        QLog.i("[cmshow][scripted]SpriteUIHandler", 1, "view is going to be created in basechatpie, pls wait.");
        return;
      }
      if ((localObject1 != null) && (!this.c.r()))
      {
        QLog.i("[cmshow][scripted]SpriteUIHandler", 1, "view is being created but NOT yet ready, pls wait.");
        return;
      }
      localObject3 = this.c.m();
      if ((localObject3 != null) && (((BaseChatPie)localObject3).aY))
      {
        QLog.i("[cmshow][scripted]SpriteUIHandler", 1, "want to show apollo but AIO finish now");
        return;
      }
      if ((localObject1 != null) && (this.c.r()))
      {
        ((SpriteScriptManagerImpl)((QQAppInterface)localObject2).getRuntimeService(ISpriteScriptManager.class, "all")).onSurfaceReady(this.c.b, this.c.a);
      }
      else if ((localObject3 != null) && (this.c.f))
      {
        localObject2 = (ApolloAIOHelperImpl)((BaseChatPie)localObject3).q(8);
        if (localObject2 != null) {
          ((ApolloAIOHelperImpl)localObject2).validateCmShowFun();
        }
      }
    }
    else
    {
      localObject3 = SpriteUtil.i((AppRuntime)localObject2);
      if (localObject3 != null) {
        ((SpriteActionScript)localObject3).b(2);
      }
      localObject2 = ((SpriteScriptManagerImpl)((QQAppInterface)localObject2).getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBackgroundManager();
      if (localObject2 != null) {
        ((SpriteBackgroundManager)localObject2).e();
      }
    }
    ThreadManager.getUIHandler().post(new SpriteUIHandler.SpriteVisibleRunnable.1(this, (ICMShowView)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.SpriteVisibleRunnable
 * JD-Core Version:    0.7.0.1
 */