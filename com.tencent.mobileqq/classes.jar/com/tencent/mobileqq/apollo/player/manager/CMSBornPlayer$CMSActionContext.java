package com.tencent.mobileqq.apollo.player.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.apollo.screenshot.IApolloActionRecordListener;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.render.IRecordFrameListener;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.render.ISurfaceStateListener;
import com.tencent.mobileqq.cmshow.engine.script.plugin.BornPlayerPlugin;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext;", "", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "ssm", "Lcom/tencent/mobileqq/apollo/script/SpriteScriptManager;", "engine", "Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;", "width", "", "height", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "start", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "context", "", "(Lcom/tencent/mobileqq/apollo/player/action/CMSAction;Lcom/tencent/mobileqq/apollo/script/SpriteScriptManager;Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;IILcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;Lkotlin/jvm/functions/Function1;)V", "getAction", "()Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "setAction", "(Lcom/tencent/mobileqq/apollo/player/action/CMSAction;)V", "cacheUins", "", "", "getCacheUins", "()Ljava/util/Set;", "cmdPlugin", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/BornPlayerPlugin;", "getCmdPlugin", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/BornPlayerPlugin;", "dressChangeListener", "Lcom/tencent/mobileqq/apollo/handler/ApolloExtensionObserver;", "getDressChangeListener", "()Lcom/tencent/mobileqq/apollo/handler/ApolloExtensionObserver;", "dressChangeListener$delegate", "Lkotlin/Lazy;", "getEngine", "()Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;", "getHeight", "()I", "getListener", "()Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "setListener", "(Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;)V", "recordListener", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "getRecordListener", "()Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "setRecordListener", "(Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;)V", "screenshotController", "Lcom/tencent/mobileqq/apollo/screenshot/ApolloScreenshotController;", "getScreenshotController", "()Lcom/tencent/mobileqq/apollo/screenshot/ApolloScreenshotController;", "getSsm", "()Lcom/tencent/mobileqq/apollo/script/SpriteScriptManager;", "getStart", "()Lkotlin/jvm/functions/Function1;", "timeoutRunnable", "Ljava/lang/Runnable;", "getTimeoutRunnable", "()Ljava/lang/Runnable;", "setTimeoutRunnable", "(Ljava/lang/Runnable;)V", "viewListener", "Lcom/tencent/mobileqq/cmshow/engine/render/ISurfaceStateListener;", "getViewListener", "()Lcom/tencent/mobileqq/cmshow/engine/render/ISurfaceStateListener;", "viewListener$delegate", "getWidth", "addCacheUins", "reset", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
final class CMSBornPlayer$CMSActionContext
{
  private final int jdField_a_of_type_Int;
  @NotNull
  private ICMSPlayerListener jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
  @NotNull
  private CMSAction jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
  @NotNull
  private final ApolloScreenshotController jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloScreenshotController;
  @NotNull
  public IApolloActionRecordListener a;
  @NotNull
  private final SpriteScriptManager jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptManager;
  @NotNull
  private final ICMShowEngine jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
  @NotNull
  private final BornPlayerPlugin jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginBornPlayerPlugin;
  @NotNull
  public Runnable a;
  @NotNull
  private final Set<String> jdField_a_of_type_JavaUtilSet;
  @NotNull
  private final Lazy jdField_a_of_type_KotlinLazy;
  @NotNull
  private final Function1<CMSActionContext, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private final int jdField_b_of_type_Int;
  @NotNull
  private final Lazy jdField_b_of_type_KotlinLazy;
  
  public CMSBornPlayer$CMSActionContext(@NotNull CMSAction paramCMSAction, @NotNull SpriteScriptManager paramSpriteScriptManager, @NotNull ICMShowEngine paramICMShowEngine, int paramInt1, int paramInt2, @NotNull ICMSPlayerListener paramICMSPlayerListener, @NotNull Function1<? super CMSActionContext, Unit> paramFunction1)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction = paramCMSAction;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptManager = paramSpriteScriptManager;
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine = paramICMShowEngine;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener = paramICMSPlayerListener;
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
    this.jdField_a_of_type_JavaUtilSet = ((Set)new LinkedHashSet());
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new CMSBornPlayer.CMSActionContext.viewListener.2(this));
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginBornPlayerPlugin = new BornPlayerPlugin(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener);
    this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloScreenshotController = new ApolloScreenshotController(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine.a());
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine.a().a((IRecordFrameListener)new CMSBornPlayer.CMSActionContext.1(this));
    this.jdField_b_of_type_KotlinLazy = LazyKt.lazy((Function0)new CMSBornPlayer.CMSActionContext.dressChangeListener.2(this));
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final ApolloExtensionObserver a()
  {
    return (ApolloExtensionObserver)this.jdField_b_of_type_KotlinLazy.getValue();
  }
  
  @NotNull
  public final ICMSPlayerListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
  }
  
  @NotNull
  public final CMSAction a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
  }
  
  @NotNull
  public final ApolloScreenshotController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloScreenshotController;
  }
  
  @NotNull
  public final IApolloActionRecordListener a()
  {
    IApolloActionRecordListener localIApolloActionRecordListener = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
    if (localIApolloActionRecordListener == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recordListener");
    }
    return localIApolloActionRecordListener;
  }
  
  @NotNull
  public final SpriteScriptManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptManager;
  }
  
  @NotNull
  public final ICMShowEngine a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
  }
  
  @NotNull
  public final ISurfaceStateListener a()
  {
    return (ISurfaceStateListener)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  @NotNull
  public final BornPlayerPlugin a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginBornPlayerPlugin;
  }
  
  @NotNull
  public final Runnable a()
  {
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable == null) {
      Intrinsics.throwUninitializedPropertyAccessException("timeoutRunnable");
    }
    return localRunnable;
  }
  
  @NotNull
  public final Set<String> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  @NotNull
  public final Function1<CMSActionContext, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_JavaLangRunnable = ((Runnable)new CMSBornPlayer.CMSActionContext.reset.1(this));
    CMSAction localCMSAction = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
    ICMSPlayerListener localICMSPlayerListener = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable == null) {
      Intrinsics.throwUninitializedPropertyAccessException("timeoutRunnable");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener = ((IApolloActionRecordListener)new CMSBornPlayer.CMSRecordListener(localCMSAction, localICMSPlayerListener, localRunnable));
  }
  
  public final void a(@NotNull ICMSPlayerListener paramICMSPlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramICMSPlayerListener, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener = paramICMSPlayerListener;
  }
  
  public final void a(@NotNull CMSAction paramCMSAction)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction = paramCMSAction;
  }
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public final void b()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a().a;
    Set localSet;
    if ((!TextUtils.isEmpty((CharSequence)str)) && (!this.jdField_a_of_type_JavaUtilSet.contains(str)))
    {
      localSet = this.jdField_a_of_type_JavaUtilSet;
      Intrinsics.checkExpressionValueIsNotNull(str, "senderUin");
      localSet.add(str);
    }
    str = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a().b;
    if ((!TextUtils.isEmpty((CharSequence)str)) && (!this.jdField_a_of_type_JavaUtilSet.contains(str)))
    {
      localSet = this.jdField_a_of_type_JavaUtilSet;
      Intrinsics.checkExpressionValueIsNotNull(str, "receiverUin");
      localSet.add(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSActionContext
 * JD-Core Version:    0.7.0.1
 */