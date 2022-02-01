package com.tencent.mobileqq.apollo.player.manager;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.CMSHelper;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.MODE;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteAioScript;
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
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.model.RenderConfig;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.render.RenderMode;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer;", "", "()V", "cacheActionContext", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext;", "doPlayAction", "", "actionContext", "initActionContext", "context", "Landroid/content/Context;", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "width", "", "height", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "onDestroy", "playActionReal", "callSurfaceReady", "", "recordAction", "CMSActionContext", "CMSRecordListener", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayer
{
  private static final long jdField_a_of_type_Long = CmShowWnsUtils.a();
  public static final CMSBornPlayer.Companion a;
  private volatile CMSBornPlayer.CMSActionContext jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$CMSActionContext;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$Companion = new CMSBornPlayer.Companion(null);
  }
  
  private final void a(Context paramContext, CMSAction paramCMSAction, int paramInt1, int paramInt2, ICMSPlayerListener paramICMSPlayerListener)
  {
    QQAppInterface localQQAppInterface = CMSHelper.a.a();
    Object localObject = new SpriteScriptManager();
    ((SpriteScriptManager)localObject).onCreate((AppRuntime)localQQAppInterface);
    ((SpriteScriptManager)localObject).getSpriteContext().c(true);
    paramContext = CMShowPlatform.a.a(paramContext, Scene.MEME_PLAYER);
    paramCMSAction = new CMSBornPlayer.CMSActionContext(paramCMSAction, (SpriteScriptManager)localObject, paramContext, paramInt1, paramInt2, paramICMSPlayerListener, (Function1)new CMSBornPlayer.initActionContext.actionContext.1(this));
    paramICMSPlayerListener = paramContext.a();
    localObject = new RenderConfig();
    ((RenderConfig)localObject).jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderRenderMode = RenderMode.OFF_SCREEN;
    ((RenderConfig)localObject).jdField_a_of_type_AndroidUtilPair = new android.util.Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    ((RenderConfig)localObject).jdField_a_of_type_Boolean = true;
    ((RenderConfig)localObject).b = true;
    if (localQQAppInterface != null) {
      paramContext = (IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    } else {
      paramContext = null;
    }
    if (paramContext != null)
    {
      ((RenderConfig)localObject).jdField_c_of_type_Boolean = ((ApolloManagerServiceImpl)paramContext).isDisableCreateRenderThread();
      paramICMSPlayerListener.a((RenderConfig)localObject);
      paramICMSPlayerListener.a(paramCMSAction.a());
      paramICMSPlayerListener.a();
      if (localQQAppInterface != null) {
        localQQAppInterface.addObserver((BusinessObserver)paramCMSAction.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$CMSActionContext = paramCMSAction;
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl");
  }
  
  private final void a(CMSBornPlayer.CMSActionContext paramCMSActionContext)
  {
    CMSAction localCMSAction = paramCMSActionContext.a();
    Object localObject2 = localCMSAction.a();
    Object localObject1 = paramCMSActionContext.a();
    Object localObject4 = ((SpriteScriptManager)localObject1).getRscBuilder();
    Object localObject3 = ((SpriteScriptManager)localObject1).getSpriteContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "ssm.getSpriteContext()");
    if ((localObject2 != null) && (localObject4 != null) && (localObject3 != null) && (((ISpriteContext)localObject3).c()))
    {
      TraceReportUtil.a(CMSHelper.a.a(localCMSAction.a()), CMSAction.a(localCMSAction, null, null, 3, null), 4);
      if (!SpriteRscBuilder.a(((SpriteTaskParam)localObject2).k, ((SpriteTaskParam)localObject2).f, ((SpriteTaskParam)localObject2).jdField_c_of_type_Int, ((SpriteTaskParam)localObject2).h, ((SpriteTaskParam)localObject2).jdField_d_of_type_Int, ((SpriteTaskParam)localObject2).jdField_d_of_type_JavaLangString, ((SpriteTaskParam)localObject2).jdField_a_of_type_Long))
      {
        localObject1 = CMSHelper.a.a();
        if (localObject1 != null)
        {
          localObject1 = ((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
          if (localObject1 != null)
          {
            if (((ApolloDaoManagerServiceImpl)localObject1).findActionById(((SpriteTaskParam)localObject2).f) == null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[playAction], ");
              ((StringBuilder)localObject1).append(localCMSAction.d());
              ((StringBuilder)localObject1).append(" fail, can not found action in ApolloDaoManager.");
              QLog.e("[cmshow][scripted][CMSPlayer]CMSBornPlayer", 1, ((StringBuilder)localObject1).toString());
              localObject1 = CMSActionStatus.ERROR_ACTION_JSON_OUT_DATE;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("action_json out date for action(");
              ((StringBuilder)localObject2).append(localCMSAction.a());
              ((StringBuilder)localObject2).append(')');
              localObject1 = new kotlin.Pair(localObject1, ((StringBuilder)localObject2).toString());
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[playAction], ");
              ((StringBuilder)localObject1).append(localCMSAction.d());
              ((StringBuilder)localObject1).append(" fail, action res missing.");
              QLog.e("[cmshow][scripted][CMSPlayer]CMSBornPlayer", 1, ((StringBuilder)localObject1).toString());
              localObject1 = CMSActionStatus.ERROR_ACTION_RES_MISS;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("res missing for action(");
              ((StringBuilder)localObject2).append(localCMSAction.a());
              ((StringBuilder)localObject2).append(')');
              localObject1 = new kotlin.Pair(localObject1, ((StringBuilder)localObject2).toString());
            }
            localObject2 = (CMSActionStatus)((kotlin.Pair)localObject1).component1();
            localObject1 = (String)((kotlin.Pair)localObject1).component2();
            TraceReportUtil.a(CMSHelper.a.a(localCMSAction.a()), CMSAction.a(localCMSAction, null, null, 3, null), 4, ((CMSActionStatus)localObject2).toReportErrorCode(), new Object[] { localObject1 });
            CMSBornPlayer.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$Companion, paramCMSActionContext, (CMSActionStatus)localObject2);
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl");
        }
        return;
      }
      int i;
      if ((localCMSAction.a() == MODE.ACTION_MODE_FRAME) && (!CMResUtil.b(((SpriteTaskParam)localObject2).f, ((SpriteTaskParam)localObject2).e)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[playAction], ");
        ((StringBuilder)localObject1).append(localCMSAction.d());
        ((StringBuilder)localObject1).append(" fail, panelAction res missing.");
        QLog.e("[cmshow][scripted][CMSPlayer]CMSBornPlayer", 1, ((StringBuilder)localObject1).toString());
        i = CMSHelper.a.a(localCMSAction.a());
        localObject1 = CMSAction.a(localCMSAction, null, null, 3, null);
        int j = CMSActionStatus.ERROR_ACTION_PANEL_RES_MISS.toReportErrorCode();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("action(");
        ((StringBuilder)localObject2).append(localCMSAction.a());
        ((StringBuilder)localObject2).append(") panel res missing");
        TraceReportUtil.a(i, (String)localObject1, 4, j, new Object[] { ((StringBuilder)localObject2).toString() });
        CMSBornPlayer.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$Companion, paramCMSActionContext, CMSActionStatus.ERROR_ACTION_PANEL_RES_MISS);
        return;
      }
      TraceReportUtil.a(CMSHelper.a.a(localCMSAction.a()), CMSAction.a(localCMSAction, null, null, 3, null), 4, 0, new Object[0]);
      TraceReportUtil.a(CMSHelper.a.a(localCMSAction.a()), CMSAction.a(localCMSAction, null, null, 3, null), 5);
      SpriteAioScript localSpriteAioScript = ((SpriteScriptManager)localObject1).getSpriteCreator().a(((SpriteTaskParam)localObject2).jdField_c_of_type_Int);
      if (localSpriteAioScript != null)
      {
        localObject1 = localSpriteAioScript.a();
        if (localObject1 != null)
        {
          localObject1 = StringsKt.replace$default((String)localObject1, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo", "", false, 4, null);
          break label761;
        }
      }
      localObject1 = null;
      label761:
      if (localSpriteAioScript != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[playAction], ");
        ((StringBuilder)localObject3).append(localCMSAction.d());
        ((StringBuilder)localObject3).append(" fail to load script. ");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.e("[cmshow][scripted][CMSPlayer]CMSBornPlayer", 1, ((StringBuilder)localObject3).toString());
        ((SpriteTaskParam)localObject2).jdField_b_of_type_Int = 4;
        CMSBornPlayer.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$Companion, paramCMSActionContext, CMSActionStatus.ERROR_SCRIPT_MISS);
        return;
      }
      localObject4 = ((SpriteRscBuilder)localObject4).a((SpriteTaskParam)localObject2, "playAction");
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "rscBuilder.getActionJsParam(task, \"playAction\")");
      if (TextUtils.isEmpty((CharSequence)localObject4))
      {
        ((SpriteTaskParam)localObject2).jdField_b_of_type_Int = 4;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[playAction], ");
        ((StringBuilder)localObject1).append(localCMSAction.d());
        ((StringBuilder)localObject1).append(" fail to build actionJs.");
        QLog.e("[cmshow][scripted][CMSPlayer]CMSBornPlayer", 1, ((StringBuilder)localObject1).toString());
        CMSBornPlayer.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$Companion, paramCMSActionContext, CMSActionStatus.ERROR_BUILD_ACTION_JS);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[playAction], ready to play, script:");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(", ");
      localStringBuilder.append(localCMSAction.d());
      localStringBuilder.append(", actionJs:");
      localStringBuilder.append((String)localObject4);
      QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayer", 1, localStringBuilder.toString());
      ((SpriteTaskParam)localObject2).jdField_b_of_type_Int = 2;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject4);
      if (((SpriteTaskParam)localObject2).jdField_c_of_type_Boolean)
      {
        ((StringBuilder)localObject1).append("startFrameRecord(");
        ((StringBuilder)localObject1).append(((SpriteTaskParam)localObject2).jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(((SpriteTaskParam)localObject2).jdField_b_of_type_Float);
        ((StringBuilder)localObject1).append(");");
      }
      ((ISpriteContext)localObject3).a(((StringBuilder)localObject1).toString());
      localSpriteAioScript.a(((SpriteTaskParam)localObject2).jdField_a_of_type_JavaLangString, false);
      localSpriteAioScript.a(((SpriteTaskParam)localObject2).jdField_b_of_type_JavaLangString, false);
      ThreadManager.getSubThreadHandler().postDelayed(paramCMSActionContext.a(), jdField_a_of_type_Long);
      return;
    }
    CMSBornPlayer.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$Companion, paramCMSActionContext, CMSActionStatus.ERROR_SURFACE_NOT_READY);
  }
  
  private final void a(CMSBornPlayer.CMSActionContext paramCMSActionContext, boolean paramBoolean)
  {
    Object localObject = paramCMSActionContext.a().getSpriteContext();
    if (localObject != null)
    {
      localObject = (SpriteContext)localObject;
      ((SpriteContext)localObject).a(paramCMSActionContext.a());
      paramCMSActionContext.a();
      paramCMSActionContext.a().a(paramCMSActionContext.a());
      ((SpriteContext)localObject).d(true);
      if (paramBoolean) {
        paramCMSActionContext.a().onSurfaceReady("", 1, true);
      }
      paramCMSActionContext.b();
      a(paramCMSActionContext);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.script.SpriteContext");
  }
  
  public final void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" destroy");
    QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayer", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$CMSActionContext;
    if (localObject != null)
    {
      localObject = ((CMSBornPlayer.CMSActionContext)localObject).a();
      if (localObject != null) {
        ((ICMShowEngine)localObject).c();
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$CMSActionContext;
    if (localObject != null)
    {
      localObject = ((CMSBornPlayer.CMSActionContext)localObject).a();
      if (localObject != null) {
        ((SpriteScriptManager)localObject).onDestroy();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$CMSActionContext = ((CMSBornPlayer.CMSActionContext)null);
  }
  
  public final void a(@NotNull Context paramContext, int paramInt1, int paramInt2, @NotNull CMSAction paramCMSAction, @NotNull ICMSPlayerListener paramICMSPlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramICMSPlayerListener, "listener");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recordAction, ");
    localStringBuilder.append(paramCMSAction.d());
    localStringBuilder.append(", width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height:");
    localStringBuilder.append(paramInt2);
    QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayer", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$CMSActionContext == null)
    {
      if (CmShowWnsUtils.C())
      {
        ThreadManager.getUIHandler().post((Runnable)new CMSBornPlayer.recordAction.1(this, paramContext, paramCMSAction, paramInt1, paramInt2, paramICMSPlayerListener));
        return;
      }
      a(paramContext, paramCMSAction, paramInt1, paramInt2, paramICMSPlayerListener);
      return;
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$CMSActionContext;
    if (paramContext == null) {
      Intrinsics.throwNpe();
    }
    paramContext.a(paramCMSAction);
    paramContext.a(paramICMSPlayerListener);
    a(paramContext, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer
 * JD-Core Version:    0.7.0.1
 */