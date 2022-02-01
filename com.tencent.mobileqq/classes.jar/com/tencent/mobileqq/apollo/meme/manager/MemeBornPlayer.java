package com.tencent.mobileqq.apollo.meme.manager;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.meme.ERROR_ACTION_JSON_OUT_DATE;
import com.tencent.mobileqq.apollo.meme.ERROR_ACTION_PANEL_RES_MISS;
import com.tencent.mobileqq.apollo.meme.ERROR_ACTION_RES_MISS;
import com.tencent.mobileqq.apollo.meme.ERROR_BUILD_ACTION_JS;
import com.tencent.mobileqq.apollo.meme.ERROR_ENGINE_DESTROYED;
import com.tencent.mobileqq.apollo.meme.ERROR_SCRIPT_MISS;
import com.tencent.mobileqq.apollo.meme.ERROR_SURFACE_NOT_READY;
import com.tencent.mobileqq.apollo.meme.MemeHelper;
import com.tencent.mobileqq.apollo.meme.action.MODE;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.apollo.screenshot.IApolloActionRecordListener;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.script.SpriteScriptCreator;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.EngineState;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import com.tencent.mobileqq.cmshow.engine.action.ExtendActionStatus;
import com.tencent.mobileqq.cmshow.engine.action.PlayActionScript;
import com.tencent.mobileqq.cmshow.engine.model.RenderConfig;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.render.RenderMode;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.resource.IResourceService;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer;", "", "()V", "cacheActionContext", "Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer$BornActionContext;", "doPlayAction", "", "actionContext", "getSpriteScriptManager", "Lcom/tencent/mobileqq/apollo/script/SpriteScriptManager;", "initActionContext", "context", "Landroid/content/Context;", "action", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "width", "", "height", "listener", "Lcom/tencent/mobileqq/apollo/meme/manager/InnerMemePlayerListener;", "onDestroy", "recordAction", "recordActionReal", "callSurfaceReady", "", "BornActionContext", "BornRecordListener", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class MemeBornPlayer
{
  public static final MemeBornPlayer.Companion a = new MemeBornPlayer.Companion(null);
  private static final long c = CmShowWnsUtils.k();
  private volatile MemeBornPlayer.BornActionContext b;
  
  private final void a(Context paramContext, MemeAction paramMemeAction, int paramInt1, int paramInt2, InnerMemePlayerListener paramInnerMemePlayerListener)
  {
    QQAppInterface localQQAppInterface = MemeHelper.a.a();
    Object localObject = new SpriteScriptManager();
    ((SpriteScriptManager)localObject).onCreate((AppRuntime)localQQAppInterface);
    ((SpriteScriptManager)localObject).getSpriteContext().c(true);
    paramContext = CMShowPlatform.a.a(paramContext, Scene.MEME_PLAYER);
    paramMemeAction = new MemeBornPlayer.BornActionContext(paramMemeAction, (SpriteScriptManager)localObject, paramContext, paramInnerMemePlayerListener, (Function1)new MemeBornPlayer.initActionContext.actionContext.1(this));
    paramInnerMemePlayerListener = paramContext.c();
    localObject = new RenderConfig();
    ((RenderConfig)localObject).f = RenderMode.OFF_SCREEN;
    ((RenderConfig)localObject).g = new android.util.Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    ((RenderConfig)localObject).a = true;
    ((RenderConfig)localObject).c = true;
    if (localQQAppInterface != null) {
      paramContext = (IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    } else {
      paramContext = null;
    }
    if (paramContext != null)
    {
      ((RenderConfig)localObject).d = ((ApolloManagerServiceImpl)paramContext).isDisableCreateRenderThread();
      paramInnerMemePlayerListener.a((RenderConfig)localObject);
      paramInnerMemePlayerListener.a(paramMemeAction.b());
      paramInnerMemePlayerListener.a();
      if (localQQAppInterface != null) {
        localQQAppInterface.addObserver((BusinessObserver)paramMemeAction.i());
      }
      this.b = paramMemeAction;
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl");
  }
  
  private final void a(MemeBornPlayer.BornActionContext paramBornActionContext)
  {
    MemeAction localMemeAction = paramBornActionContext.k();
    Object localObject2 = localMemeAction.c();
    Object localObject3 = paramBornActionContext.l();
    Object localObject1 = ((SpriteScriptManager)localObject3).getRscBuilder();
    ISpriteContext localISpriteContext = ((SpriteScriptManager)localObject3).getSpriteContext();
    Intrinsics.checkExpressionValueIsNotNull(localISpriteContext, "ssm.getSpriteContext()");
    if ((localObject2 != null) && (localObject1 != null) && (localISpriteContext != null) && (localISpriteContext.c()))
    {
      Object localObject4 = paramBornActionContext.m();
      if (((ICMShowEngine)localObject4).a() == EngineState.DESTROYED)
      {
        MemeBornPlayer.Companion.a(a, paramBornActionContext, (ActionStatus)ERROR_ENGINE_DESTROYED.a);
        return;
      }
      TraceReportUtil.a(MemeHelper.a.a(localMemeAction.i()), MemeAction.a(localMemeAction, null, null, 3, null), 4);
      QQAppInterface localQQAppInterface = MemeHelper.a.a();
      if (localQQAppInterface != null)
      {
        localObject4 = ((ICMShowEngine)localObject4).g().a();
        boolean bool = ((IApolloResManager)localObject4).a(((SpriteTaskParam)localObject2).v, ((SpriteTaskParam)localObject2).f, ((SpriteTaskParam)localObject2).c, ((SpriteTaskParam)localObject2).i, ((SpriteTaskParam)localObject2).d, ((SpriteTaskParam)localObject2).t, ((SpriteTaskParam)localObject2).h);
        int i = 0;
        if (!bool)
        {
          localObject1 = localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
          if (localObject1 != null)
          {
            if (((ApolloDaoManagerServiceImpl)localObject1).findActionById(((SpriteTaskParam)localObject2).f) == null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[playAction], ");
              ((StringBuilder)localObject1).append(localMemeAction.h());
              ((StringBuilder)localObject1).append(" fail, can not found action in ApolloDaoManager.");
              QLog.e("[cmshow][MemePlayer]MemeBornPlayer", 1, ((StringBuilder)localObject1).toString());
              localObject1 = ERROR_ACTION_JSON_OUT_DATE.a;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("action_json out date for ");
              ((StringBuilder)localObject2).append(localMemeAction.h());
              localObject1 = new kotlin.Pair(localObject1, ((StringBuilder)localObject2).toString());
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[playAction], ");
              ((StringBuilder)localObject1).append(localMemeAction.h());
              ((StringBuilder)localObject1).append(" fail, action res missing.");
              QLog.e("[cmshow][MemePlayer]MemeBornPlayer", 1, ((StringBuilder)localObject1).toString());
              localObject1 = ERROR_ACTION_RES_MISS.a;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("res missing for ");
              ((StringBuilder)localObject2).append(localMemeAction.h());
              localObject1 = new kotlin.Pair(localObject1, ((StringBuilder)localObject2).toString());
            }
            localObject2 = (ExtendActionStatus)((kotlin.Pair)localObject1).component1();
            localObject1 = (String)((kotlin.Pair)localObject1).component2();
            TraceReportUtil.a(MemeHelper.a.a(localMemeAction.i()), MemeAction.a(localMemeAction, null, null, 3, null), 4, ((ExtendActionStatus)localObject2).a(), new Object[] { localObject1 });
            MemeBornPlayer.Companion.a(a, paramBornActionContext, (ActionStatus)localObject2);
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl");
        }
        if ((localMemeAction.i() == MODE.ACTION_MODE_FRAME) && (!((IApolloResManager)localObject4).e(((SpriteTaskParam)localObject2).f, ((SpriteTaskParam)localObject2).e)))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[playAction], ");
          ((StringBuilder)localObject1).append(localMemeAction.h());
          ((StringBuilder)localObject1).append(" fail, panelAction res missing.");
          QLog.e("[cmshow][MemePlayer]MemeBornPlayer", 1, ((StringBuilder)localObject1).toString());
          i = MemeHelper.a.a(localMemeAction.i());
          localObject1 = MemeAction.a(localMemeAction, null, null, 3, null);
          j = ERROR_ACTION_PANEL_RES_MISS.a.a();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("panel res missing for ");
          ((StringBuilder)localObject2).append(localMemeAction.h());
          TraceReportUtil.a(i, (String)localObject1, 4, j, new Object[] { ((StringBuilder)localObject2).toString() });
          MemeBornPlayer.Companion.a(a, paramBornActionContext, (ActionStatus)ERROR_ACTION_PANEL_RES_MISS.a);
          return;
        }
        TraceReportUtil.a(MemeHelper.a.a(localMemeAction.i()), MemeAction.a(localMemeAction, null, null, 3, null), 4, 0, new Object[] { localMemeAction.h() });
        TraceReportUtil.a(MemeHelper.a.a(localMemeAction.i()), MemeAction.a(localMemeAction, null, null, 3, null), 5);
        localObject3 = ((SpriteScriptManager)localObject3).getSpriteCreator();
        int j = ((SpriteTaskParam)localObject2).c;
        if (((SpriteScriptCreator)localObject3).a(j) != null) {
          i = 1;
        }
        if (i == 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[playAction], ");
          ((StringBuilder)localObject1).append(localMemeAction.h());
          ((StringBuilder)localObject1).append(" fail to load business script, businessType:");
          ((StringBuilder)localObject1).append(j);
          QLog.e("[cmshow][MemePlayer]MemeBornPlayer", 1, ((StringBuilder)localObject1).toString());
          ((SpriteTaskParam)localObject2).b = 4;
          MemeBornPlayer.Companion.a(a, paramBornActionContext, (ActionStatus)ERROR_SCRIPT_MISS.a);
          return;
        }
        StringBuilder localStringBuilder;
        try
        {
          localObject1 = ((SpriteRscBuilder)localObject1).a((SpriteTaskParam)localObject2, "playAction");
          ((PlayActionScript)localObject1).a((Function2)new MemeBornPlayer.doPlayAction..inlined.apply.lambda.1((PlayActionScript)localObject1, localMemeAction));
        }
        catch (RuntimeException localRuntimeException)
        {
          QLog.e("[cmshow][MemePlayer]MemeBornPlayer", 1, "build platAction exception:", (Throwable)localRuntimeException);
          localStringBuilder = null;
        }
        if (localStringBuilder == null)
        {
          ((SpriteTaskParam)localObject2).b = 4;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[playAction], ");
          localStringBuilder.append(localMemeAction.h());
          localStringBuilder.append(" fail to build actionJs.");
          QLog.e("[cmshow][MemePlayer]MemeBornPlayer", 1, localStringBuilder.toString());
          MemeBornPlayer.Companion.a(a, paramBornActionContext, (ActionStatus)ERROR_BUILD_ACTION_JS.a);
          return;
        }
        paramBornActionContext.a(localStringBuilder);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[playAction], ready to play, ");
        ((StringBuilder)localObject3).append("businessType:");
        ((StringBuilder)localObject3).append(j);
        ((StringBuilder)localObject3).append(", ");
        ((StringBuilder)localObject3).append(localMemeAction.h());
        ((StringBuilder)localObject3).append(", actionJs:");
        ((StringBuilder)localObject3).append(localStringBuilder.e());
        QLog.w("[cmshow][MemePlayer]MemeBornPlayer", 1, ((StringBuilder)localObject3).toString());
        ((SpriteTaskParam)localObject2).b = 2;
        ((SpriteContext)localISpriteContext).a((Script)localStringBuilder);
        if (((SpriteTaskParam)localObject2).A)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("startFrameRecord(");
          localStringBuilder.append(((SpriteTaskParam)localObject2).a);
          localStringBuilder.append(", ");
          localStringBuilder.append(((SpriteTaskParam)localObject2).B);
          localStringBuilder.append(");");
          localISpriteContext.b(localStringBuilder.toString());
        }
        ThreadManager.getSubThreadHandler().postDelayed(paramBornActionContext.f(), c);
      }
      return;
    }
    MemeBornPlayer.Companion.a(a, paramBornActionContext, (ActionStatus)ERROR_SURFACE_NOT_READY.a);
  }
  
  private final void a(MemeBornPlayer.BornActionContext paramBornActionContext, boolean paramBoolean)
  {
    Object localObject = paramBornActionContext.l().getSpriteContext();
    if (localObject != null)
    {
      localObject = (SpriteContext)localObject;
      ((SpriteContext)localObject).a(paramBornActionContext.m());
      paramBornActionContext.h();
      paramBornActionContext.g().a((IApolloActionRecordListener)paramBornActionContext.e());
      ((SpriteContext)localObject).d(true);
      if (paramBoolean) {
        paramBornActionContext.l().onSurfaceReady("", 1, true);
      }
      paramBornActionContext.j();
      a(paramBornActionContext);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.script.SpriteContext");
  }
  
  public final void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" destroy");
    QLog.w("[cmshow][MemePlayer]MemeBornPlayer", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null)
    {
      localObject = ((MemeBornPlayer.BornActionContext)localObject).m();
      if (localObject != null) {
        ((ICMShowEngine)localObject).m();
      }
    }
    localObject = this.b;
    if (localObject != null)
    {
      localObject = ((MemeBornPlayer.BornActionContext)localObject).l();
      if (localObject != null) {
        ((SpriteScriptManager)localObject).onDestroy();
      }
    }
    this.b = ((MemeBornPlayer.BornActionContext)null);
  }
  
  public final void a(@NotNull Context paramContext, int paramInt1, int paramInt2, @NotNull MemeAction paramMemeAction, @NotNull InnerMemePlayerListener paramInnerMemePlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramMemeAction, "action");
    Intrinsics.checkParameterIsNotNull(paramInnerMemePlayerListener, "listener");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recordAction, ");
    localStringBuilder.append(paramMemeAction.h());
    localStringBuilder.append(", width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height:");
    localStringBuilder.append(paramInt2);
    QLog.w("[cmshow][MemePlayer]MemeBornPlayer", 1, localStringBuilder.toString());
    if (this.b == null)
    {
      if (CmShowWnsUtils.P())
      {
        ThreadManager.getUIHandler().post((Runnable)new MemeBornPlayer.recordAction.1(this, paramContext, paramMemeAction, paramInt1, paramInt2, paramInnerMemePlayerListener));
        return;
      }
      a(paramContext, paramMemeAction, paramInt1, paramInt2, paramInnerMemePlayerListener);
      return;
    }
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwNpe();
    }
    paramContext.a(paramMemeAction);
    paramContext.a(paramInnerMemePlayerListener);
    a(paramContext, false);
  }
  
  @VisibleForTesting
  @Nullable
  public final SpriteScriptManager b()
  {
    MemeBornPlayer.BornActionContext localBornActionContext = this.b;
    if (localBornActionContext != null) {
      return localBornActionContext.l();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayer
 * JD-Core Version:    0.7.0.1
 */