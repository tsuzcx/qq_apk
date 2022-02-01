import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSActionContext.cmdHandler.2;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSActionContext.dressChangeListener.2;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSActionContext.reset.1;
import com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSActionContext.viewListener.2;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext;", "", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "ssm", "Lcom/tencent/mobileqq/apollo/script/SpriteScriptManager;", "view", "Lcom/tencent/mobileqq/apollo/ApolloTextureView;", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "start", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "context", "", "(Lcom/tencent/mobileqq/apollo/player/action/CMSAction;Lcom/tencent/mobileqq/apollo/script/SpriteScriptManager;Lcom/tencent/mobileqq/apollo/ApolloTextureView;Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;Lkotlin/jvm/functions/Function1;)V", "getAction", "()Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "setAction", "(Lcom/tencent/mobileqq/apollo/player/action/CMSAction;)V", "cacheUins", "", "", "getCacheUins", "()Ljava/util/Set;", "cmdHandler", "Lcom/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel$IRequestHandler;", "getCmdHandler", "()Lcom/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel$IRequestHandler;", "cmdHandler$delegate", "Lkotlin/Lazy;", "dressChangeListener", "Lcom/tencent/mobileqq/vas/VasExtensionObserver;", "getDressChangeListener", "()Lcom/tencent/mobileqq/vas/VasExtensionObserver;", "dressChangeListener$delegate", "getListener", "()Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "setListener", "(Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;)V", "recordListener", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "getRecordListener", "()Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "setRecordListener", "(Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;)V", "getSsm", "()Lcom/tencent/mobileqq/apollo/script/SpriteScriptManager;", "getStart", "()Lkotlin/jvm/functions/Function1;", "timeoutRunnable", "Ljava/lang/Runnable;", "getTimeoutRunnable", "()Ljava/lang/Runnable;", "setTimeoutRunnable", "(Ljava/lang/Runnable;)V", "getView", "()Lcom/tencent/mobileqq/apollo/ApolloTextureView;", "viewListener", "Lcom/tencent/mobileqq/apollo/OnApolloViewListener;", "getViewListener", "()Lcom/tencent/mobileqq/apollo/OnApolloViewListener;", "viewListener$delegate", "addCacheUins", "reset", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amvr
{
  @NotNull
  private amvk jdField_a_of_type_Amvk;
  @NotNull
  public anbp a;
  @NotNull
  private final anch jdField_a_of_type_Anch;
  @NotNull
  private final ApolloTextureView jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  @NotNull
  private CMSAction jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
  @NotNull
  public Runnable a;
  @NotNull
  private final Set<String> jdField_a_of_type_JavaUtilSet;
  @NotNull
  private final Lazy jdField_a_of_type_KotlinLazy;
  @NotNull
  private final Function1<amvr, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  @NotNull
  private final Lazy b;
  @NotNull
  private final Lazy c;
  
  public amvr(@NotNull CMSAction paramCMSAction, @NotNull anch paramanch, @NotNull ApolloTextureView paramApolloTextureView, @NotNull amvk paramamvk, @NotNull Function1<? super amvr, Unit> paramFunction1)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction = paramCMSAction;
    this.jdField_a_of_type_Anch = paramanch;
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = paramApolloTextureView;
    this.jdField_a_of_type_Amvk = paramamvk;
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
    this.jdField_a_of_type_JavaUtilSet = ((Set)new LinkedHashSet());
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new CMSBornPlayer.CMSActionContext.viewListener.2(this));
    this.b = LazyKt.lazy((Function0)new CMSBornPlayer.CMSActionContext.cmdHandler.2(this));
    this.c = LazyKt.lazy((Function0)new CMSBornPlayer.CMSActionContext.dressChangeListener.2(this));
  }
  
  @NotNull
  public final ampy a()
  {
    return (ampy)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  @NotNull
  public final amql a()
  {
    return (amql)this.b.getValue();
  }
  
  @NotNull
  public final amvk a()
  {
    return this.jdField_a_of_type_Amvk;
  }
  
  @NotNull
  public final anbp a()
  {
    anbp localanbp = this.jdField_a_of_type_Anbp;
    if (localanbp == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recordListener");
    }
    return localanbp;
  }
  
  @NotNull
  public final anch a()
  {
    return this.jdField_a_of_type_Anch;
  }
  
  @NotNull
  public final bhow a()
  {
    return (bhow)this.c.getValue();
  }
  
  @NotNull
  public final ApolloTextureView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  }
  
  @NotNull
  public final CMSAction a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
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
  public final Function1<amvr, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_JavaLangRunnable = ((Runnable)new CMSBornPlayer.CMSActionContext.reset.1(this));
    CMSAction localCMSAction = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
    amvk localamvk = this.jdField_a_of_type_Amvk;
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable == null) {
      Intrinsics.throwUninitializedPropertyAccessException("timeoutRunnable");
    }
    this.jdField_a_of_type_Anbp = ((anbp)new amvw(localCMSAction, localamvk, localRunnable));
  }
  
  public final void a(@NotNull amvk paramamvk)
  {
    Intrinsics.checkParameterIsNotNull(paramamvk, "<set-?>");
    this.jdField_a_of_type_Amvk = paramamvk;
  }
  
  public final void a(@NotNull CMSAction paramCMSAction)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction = paramCMSAction;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvr
 * JD-Core Version:    0.7.0.1
 */