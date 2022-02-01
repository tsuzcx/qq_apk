package com.tencent.mobileqq.apollo.player.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.api.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.api.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.screenshot.IApolloActionRecordListener;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext;", "", "action", "Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;", "ssm", "Lcom/tencent/mobileqq/apollo/script/SpriteScriptManager;", "view", "Lcom/tencent/mobileqq/apollo/ApolloTextureView;", "width", "", "height", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "start", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "context", "", "(Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;Lcom/tencent/mobileqq/apollo/script/SpriteScriptManager;Lcom/tencent/mobileqq/apollo/ApolloTextureView;IILcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;Lkotlin/jvm/functions/Function1;)V", "getAction", "()Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;", "setAction", "(Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;)V", "cacheUins", "", "", "getCacheUins", "()Ljava/util/Set;", "cmdHandler", "Lcom/tencent/mobileqq/apollo/api/channel/IRequestHandler;", "getCmdHandler", "()Lcom/tencent/mobileqq/apollo/api/channel/IRequestHandler;", "cmdHandler$delegate", "Lkotlin/Lazy;", "dressChangeListener", "Lcom/tencent/mobileqq/apollo/api/handler/impl/ApolloExtensionObserverImpl;", "getDressChangeListener", "()Lcom/tencent/mobileqq/apollo/api/handler/impl/ApolloExtensionObserverImpl;", "dressChangeListener$delegate", "getHeight", "()I", "getListener", "()Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "setListener", "(Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;)V", "recordListener", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "getRecordListener", "()Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "setRecordListener", "(Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;)V", "getSsm", "()Lcom/tencent/mobileqq/apollo/script/SpriteScriptManager;", "getStart", "()Lkotlin/jvm/functions/Function1;", "timeoutRunnable", "Ljava/lang/Runnable;", "getTimeoutRunnable", "()Ljava/lang/Runnable;", "setTimeoutRunnable", "(Ljava/lang/Runnable;)V", "getView", "()Lcom/tencent/mobileqq/apollo/ApolloTextureView;", "viewListener", "Lcom/tencent/mobileqq/apollo/api/listener/OnApolloViewListener;", "getViewListener", "()Lcom/tencent/mobileqq/apollo/api/listener/OnApolloViewListener;", "viewListener$delegate", "getWidth", "addCacheUins", "reset", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class CMSBornPlayer$CMSActionContext
{
  private final int jdField_a_of_type_Int;
  @NotNull
  private final ApolloTextureView jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  @NotNull
  private CMSAction jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction;
  @NotNull
  private ICMSPlayerListener jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
  @NotNull
  public IApolloActionRecordListener a;
  @NotNull
  private final SpriteScriptManager jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptManager;
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
  @NotNull
  private final Lazy c;
  
  public CMSBornPlayer$CMSActionContext(@NotNull CMSAction paramCMSAction, @NotNull SpriteScriptManager paramSpriteScriptManager, @NotNull ApolloTextureView paramApolloTextureView, int paramInt1, int paramInt2, @NotNull ICMSPlayerListener paramICMSPlayerListener, @NotNull Function1<? super CMSActionContext, Unit> paramFunction1)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction = paramCMSAction;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptManager = paramSpriteScriptManager;
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = paramApolloTextureView;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener = paramICMSPlayerListener;
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
    this.jdField_a_of_type_JavaUtilSet = ((Set)new LinkedHashSet());
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new CMSBornPlayer.CMSActionContext.viewListener.2(this));
    this.jdField_b_of_type_KotlinLazy = LazyKt.lazy((Function0)new CMSBornPlayer.CMSActionContext.cmdHandler.2(this));
    this.c = LazyKt.lazy((Function0)new CMSBornPlayer.CMSActionContext.dressChangeListener.2(this));
  }
  
  @NotNull
  public final ApolloTextureView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  }
  
  @NotNull
  public final IRequestHandler a()
  {
    return (IRequestHandler)this.jdField_b_of_type_KotlinLazy.getValue();
  }
  
  @NotNull
  public final ApolloExtensionObserverImpl a()
  {
    return (ApolloExtensionObserverImpl)this.c.getValue();
  }
  
  @NotNull
  public final OnApolloViewListener a()
  {
    return (OnApolloViewListener)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  @NotNull
  public final CMSAction a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction;
  }
  
  @NotNull
  public final ICMSPlayerListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
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
    CMSAction localCMSAction = this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction;
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    ICMSPlayerListener localICMSPlayerListener = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable == null) {
      Intrinsics.throwUninitializedPropertyAccessException("timeoutRunnable");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener = ((IApolloActionRecordListener)new CMSBornPlayer.CMSRecordListener(localCMSAction, i, j, localICMSPlayerListener, localRunnable));
  }
  
  public final void a(@NotNull CMSAction paramCMSAction)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction = paramCMSAction;
  }
  
  public final void a(@NotNull ICMSPlayerListener paramICMSPlayerListener)
  {
    Intrinsics.checkParameterIsNotNull(paramICMSPlayerListener, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener = paramICMSPlayerListener;
  }
  
  public final void b()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction.a().a;
    Set localSet;
    if ((!TextUtils.isEmpty((CharSequence)str)) && (!this.jdField_a_of_type_JavaUtilSet.contains(str)))
    {
      localSet = this.jdField_a_of_type_JavaUtilSet;
      Intrinsics.checkExpressionValueIsNotNull(str, "senderUin");
      localSet.add(str);
    }
    str = this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction.a().b;
    if ((!TextUtils.isEmpty((CharSequence)str)) && (!this.jdField_a_of_type_JavaUtilSet.contains(str)))
    {
      localSet = this.jdField_a_of_type_JavaUtilSet;
      Intrinsics.checkExpressionValueIsNotNull(str, "receiverUin");
      localSet.add(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSActionContext
 * JD-Core Version:    0.7.0.1
 */