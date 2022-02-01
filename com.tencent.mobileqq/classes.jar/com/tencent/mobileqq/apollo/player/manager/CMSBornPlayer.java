package com.tencent.mobileqq.apollo.player.manager;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.ApolloTicker;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.player.action.MODE;
import com.tencent.mobileqq.apollo.api.render.IRenderRunner;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.CMSHelper;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.apollo.script.SpriteAioScript;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.script.SpriteScriptCreator;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer;", "", "()V", "cacheActionContext", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext;", "doPlayAction", "", "actionContext", "getTextureView", "Lcom/tencent/mobileqq/apollo/ApolloTextureView;", "context", "Landroid/content/Context;", "pauseOffscreenTicker", "playAction", "width", "", "height", "action", "Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;", "container", "Landroid/widget/FrameLayout;", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "playActionReal", "callSurfaceReady", "", "recordAction", "resumeOffscreenTicker", "CMSActionContext", "CMSApolloRender", "CMSRecordListener", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayer
{
  private static final long jdField_a_of_type_Long = CmShowWnsUtils.a();
  public static final CMSBornPlayer.Companion a;
  private CMSBornPlayer.CMSActionContext jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$CMSActionContext;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$Companion = new CMSBornPlayer.Companion(null);
  }
  
  private final ApolloTextureView a(Context paramContext)
  {
    paramContext = new ApolloTextureView(paramContext, null);
    paramContext.setDestroyOnAsync(true);
    paramContext.setDispatchEvent2Native(true);
    paramContext.disableTouchEvent(true);
    Object localObject = CMSHelper.a.a();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl");
      }
      paramContext.setDumplicateCreateRenderThread(((ApolloManagerServiceImpl)localObject).isDisableCreateRenderThread());
    }
    return paramContext;
  }
  
  private final void a(CMSBornPlayer.CMSActionContext paramCMSActionContext)
  {
    Object localObject2 = null;
    CMSAction localCMSAction = paramCMSActionContext.a();
    SpriteTaskParam localSpriteTaskParam = localCMSAction.a();
    Object localObject1 = paramCMSActionContext.a();
    SpriteRscBuilder localSpriteRscBuilder = ((SpriteScriptManager)localObject1).getRscBuilder();
    Object localObject3 = ((SpriteScriptManager)localObject1).getSpriteContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "ssm.getSpriteContext()");
    if ((localSpriteTaskParam == null) || (localSpriteRscBuilder == null) || (localObject3 == null) || (!((ISpriteContext)localObject3).c())) {
      CMSBornPlayer.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$Companion, paramCMSActionContext, CMSActionStatus.ERROR_SURFACE_NOT_READY);
    }
    do
    {
      return;
      TraceReportUtil.a(localCMSAction.a().toReportFeatureId(), CMSAction.a(localCMSAction, null, null, 3, null), 4);
      if (localSpriteRscBuilder.a(localSpriteTaskParam)) {
        break;
      }
      localObject1 = CMSHelper.a.a();
    } while (localObject1 == null);
    localObject1 = ((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl");
    }
    if (((ApolloDaoManagerServiceImpl)localObject1).findActionById(localSpriteTaskParam.f) == null) {
      QLog.e("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "[playAction], " + localCMSAction.d() + " fail, can not found action in ApolloDaoManager.");
    }
    for (localObject1 = new Pair(CMSActionStatus.ERROR_ACTION_JSON_OUT_DATE, "action_json out date for action(" + localCMSAction.a() + ')');; localObject1 = new Pair(CMSActionStatus.ERROR_ACTION_RES_MISS, "res missing for action(" + localCMSAction.a() + ')'))
    {
      localObject2 = (CMSActionStatus)((Pair)localObject1).component1();
      localObject1 = (String)((Pair)localObject1).component2();
      TraceReportUtil.a(localCMSAction.a().toReportFeatureId(), CMSAction.a(localCMSAction, null, null, 3, null), 4, ((CMSActionStatus)localObject2).toReportErrorCode(), new Object[] { localObject1 });
      CMSBornPlayer.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$Companion, paramCMSActionContext, (CMSActionStatus)localObject2);
      return;
      QLog.e("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "[playAction], " + localCMSAction.d() + " fail, action res missing.");
    }
    if ((localCMSAction.a() == MODE.ACTION_MODE_FRAME) && (!ApolloUtilImpl.isActionPanelFrameResDone(localSpriteTaskParam.f, localSpriteTaskParam.e)))
    {
      QLog.e("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "[playAction], " + localCMSAction.d() + " fail, panelAction res missing.");
      TraceReportUtil.a(localCMSAction.a().toReportFeatureId(), CMSAction.a(localCMSAction, null, null, 3, null), 4, CMSActionStatus.ERROR_ACTION_PANEL_RES_MISS.toReportErrorCode(), new Object[] { "action(" + localCMSAction.a() + ") panel res missing" });
      CMSBornPlayer.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$Companion, paramCMSActionContext, CMSActionStatus.ERROR_ACTION_PANEL_RES_MISS);
      return;
    }
    TraceReportUtil.a(localCMSAction.a().toReportFeatureId(), CMSAction.a(localCMSAction, null, null, 3, null), 4, 0, new Object[0]);
    TraceReportUtil.a(localCMSAction.a().toReportFeatureId(), CMSAction.a(localCMSAction, null, null, 3, null), 5);
    localObject3 = ((SpriteScriptManager)localObject1).getSpriteCreator().a(localSpriteTaskParam.jdField_c_of_type_Int, localSpriteTaskParam.f);
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      String str = ((SpriteAioScript)localObject3).a();
      localObject1 = localObject2;
      if (str != null) {
        localObject1 = StringsKt.replace$default(str, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo", "", false, 4, null);
      }
    }
    if (localObject3 != null) {}
    for (int i = 1; i == 0; i = 0)
    {
      QLog.e("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "[playAction], " + localCMSAction.d() + " fail to load script. " + (String)localObject1);
      localSpriteTaskParam.jdField_b_of_type_Int = 4;
      CMSBornPlayer.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$Companion, paramCMSActionContext, CMSActionStatus.ERROR_SCRIPT_MISS);
      return;
    }
    localObject2 = localSpriteRscBuilder.a(localSpriteTaskParam);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "rscBuilder.getActionJsParam(task)");
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localSpriteTaskParam.jdField_b_of_type_Int = 4;
      QLog.e("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "[playAction], " + localCMSAction.d() + " fail to build actionJs.");
      CMSBornPlayer.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$Companion, paramCMSActionContext, CMSActionStatus.ERROR_BUILD_ACTION_JS);
      return;
    }
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "[playAction], ready to play, script:" + (String)localObject1 + ", " + localCMSAction.d() + ", actionJs:" + (String)localObject2);
    localSpriteTaskParam.jdField_b_of_type_Int = 2;
    b();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("playAction('").append((String)localObject2).append("');");
    if (localSpriteTaskParam.jdField_c_of_type_Boolean) {
      ((StringBuilder)localObject1).append("startFrameRecord(").append(localSpriteTaskParam.jdField_a_of_type_Int).append(", ").append(localSpriteTaskParam.jdField_b_of_type_Float).append(");");
    }
    ((SpriteAioScript)localObject3).b(((StringBuilder)localObject1).toString());
    ((SpriteAioScript)localObject3).a(localSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
    ((SpriteAioScript)localObject3).a(localSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
    ThreadManager.getSubThreadHandler().postDelayed(paramCMSActionContext.a(), jdField_a_of_type_Long);
  }
  
  private final void a(CMSBornPlayer.CMSActionContext paramCMSActionContext, boolean paramBoolean)
  {
    ISpriteContext localISpriteContext = paramCMSActionContext.a().getSpriteContext();
    Intrinsics.checkExpressionValueIsNotNull(localISpriteContext, "actionContext.ssm.getSpriteContext()");
    Object localObject1 = paramCMSActionContext.a();
    localISpriteContext.a((IApolloRenderView)localObject1);
    Object localObject2 = ApolloUtilImpl.getCmdChannel();
    if (localObject2 != null)
    {
      ((IApolloCmdChannel)localObject2).addRenderRunner((IRenderRunner)localObject1);
      ((IApolloCmdChannel)localObject2).addCmdHandler(paramCMSActionContext.a());
    }
    paramCMSActionContext.a();
    localObject2 = ApolloScreenshotController.a;
    localObject1 = ((ApolloTextureView)localObject1).getRender();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "textureView.render");
    ((ApolloScreenshotController)localObject2).a(((ApolloRender)localObject1).getSavaWrapper().jdField_a_of_type_Long, paramCMSActionContext.a());
    localISpriteContext.d(true);
    if (paramBoolean) {
      paramCMSActionContext.a().onSurfaceReady("", 1, true);
    }
    paramCMSActionContext.b();
    a(paramCMSActionContext);
  }
  
  private final void b()
  {
    Object localObject3 = null;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$CMSActionContext;
    if (localObject1 != null) {}
    for (localObject1 = ((CMSBornPlayer.CMSActionContext)localObject1).a();; localObject1 = null)
    {
      Object localObject2 = localObject3;
      if (localObject1 != null)
      {
        ApolloRender localApolloRender = ((ApolloTextureView)localObject1).getRender();
        localObject2 = localObject3;
        if (localApolloRender != null) {
          localObject2 = localApolloRender.mApolloTicker;
        }
      }
      if (localObject2 != null) {
        ((ApolloTicker)localObject2).resumeTicker(((ApolloTicker)localObject2).ticker, (View)localObject1);
      }
      return;
    }
  }
  
  public final void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$CMSActionContext;
    if (localObject != null)
    {
      localObject = ((CMSBornPlayer.CMSActionContext)localObject).a();
      if (localObject != null)
      {
        localObject = ((ApolloTextureView)localObject).getRender();
        if (localObject == null) {}
      }
    }
    for (localObject = ((ApolloRender)localObject).mApolloTicker;; localObject = null)
    {
      if (localObject != null) {
        ((ApolloTicker)localObject).pauseTicker(((ApolloTicker)localObject).ticker);
      }
      return;
    }
  }
  
  public final void a(@NotNull Context paramContext, int paramInt1, int paramInt2, @NotNull CMSAction paramCMSAction, @NotNull FrameLayout paramFrameLayout, @NotNull ICMSPlayerListener paramICMSPlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramFrameLayout, "container");
    Intrinsics.checkParameterIsNotNull(paramICMSPlayerListener, "listener");
    QQAppInterface localQQAppInterface = CMSHelper.a.a();
    Object localObject = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources");
    float f = ((Resources)localObject).getDisplayMetrics().density;
    localObject = new SpriteScriptManager();
    ((SpriteScriptManager)localObject).onCreate((AppRuntime)localQQAppInterface);
    ((SpriteScriptManager)localObject).getSpriteContext().c(true);
    paramContext = a(paramContext);
    paramCMSAction = new CMSBornPlayer.CMSActionContext(paramCMSAction, (SpriteScriptManager)localObject, paramContext, paramInt1, paramInt2, paramICMSPlayerListener, (Function1)new CMSBornPlayer.playAction.actionContext.1(this));
    paramICMSPlayerListener = new CMSBornPlayer.CMSApolloRender(f, paramCMSAction.a(), (Function0)new CMSBornPlayer.playAction.render.1(paramCMSAction));
    paramContext.init(paramCMSAction.a(), 0, (ApolloRender)paramICMSPlayerListener);
    paramFrameLayout.addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(paramInt1, paramInt2));
  }
  
  public final void a(@NotNull Context paramContext, int paramInt1, int paramInt2, @NotNull CMSAction paramCMSAction, @NotNull ICMSPlayerListener paramICMSPlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramICMSPlayerListener, "listener");
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, "recordAction, " + paramCMSAction.d() + ", width:" + paramInt1 + ", height:" + paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$CMSActionContext == null)
    {
      QQAppInterface localQQAppInterface = CMSHelper.a.a();
      Object localObject = paramContext.getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources");
      float f = ((Resources)localObject).getDisplayMetrics().density;
      localObject = new SpriteScriptManager();
      ((SpriteScriptManager)localObject).onCreate((AppRuntime)localQQAppInterface);
      ((SpriteScriptManager)localObject).getSpriteContext().c(true);
      paramContext = a(paramContext);
      paramContext.setOffscreenSize(paramInt1, paramInt2);
      paramCMSAction = new CMSBornPlayer.CMSActionContext(paramCMSAction, (SpriteScriptManager)localObject, paramContext, paramInt1, paramInt2, paramICMSPlayerListener, (Function1)new CMSBornPlayer.recordAction.actionContext.1(this));
      paramICMSPlayerListener = new CMSBornPlayer.CMSApolloRender(f, paramCMSAction.a(), (Function0)new CMSBornPlayer.recordAction.render.1(paramCMSAction));
      paramContext.init(paramCMSAction.a(), 0, (ApolloRender)paramICMSPlayerListener, true);
      if (localQQAppInterface != null) {
        localQQAppInterface.addObserver((BusinessObserver)paramCMSAction.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer$CMSActionContext = paramCMSAction;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer
 * JD-Core Version:    0.7.0.1
 */