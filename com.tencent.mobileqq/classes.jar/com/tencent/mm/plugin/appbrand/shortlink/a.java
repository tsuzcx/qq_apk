package com.tencent.mm.plugin.appbrand.shortlink;

import android.app.Activity;
import android.content.Context;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.contracts.ExperimentalContracts;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher;", "LAUNCH_PHASE_RET", "", "()V", "getBusinessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "innerLaunch", "", "ctx", "Landroid/app/Activity;", "params", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "resultCallback", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;", "Lkotlin/ParameterName;", "name", "errorCode", "launchPhaseRet", "judgeIsLaunchSuccess", "", "ret", "(Ljava/lang/Object;)Z", "launch", "Landroid/content/Context;", "launchResultCallback", "Lkotlin/Function1;", "launchWithLink", "link", "", "showLaunchWxaTipDialog", "onDecodeLinkFailed", "url", "onLaunchDone", "success", "onLinkDecodeDone", "onLinkIllegal", "onUserCancel", "Companion", "WxaShortLinkLaunchParams", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public abstract class a<LAUNCH_PHASE_RET>
{
  @NotNull
  private static final Pattern a;
  public static final a.a d = new a.a(null);
  
  static
  {
    Pattern localPattern = Pattern.compile("^mp://\\w+");
    Intrinsics.checkExpressionValueIsNotNull(localPattern, "Pattern.compile(\"^$SHORT_LINK_SCHEME\\\\w+\")");
    a = localPattern;
  }
  
  private final void a(Activity paramActivity, a.b paramb, Function2<? super WxaShortLinkLaunchErrorCode, ? super LAUNCH_PHASE_RET, Unit> paramFunction2)
  {
    a((Context)paramActivity, paramb, (Function1)new a.c(this, paramActivity, paramb, paramFunction2));
  }
  
  @NotNull
  protected abstract com.tencent.luggage.wxa.ow.a.b a();
  
  protected void a(@NotNull Activity paramActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "ctx");
    Intrinsics.checkParameterIsNotNull(paramString, "url");
  }
  
  protected void a(@NotNull Activity paramActivity, @NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "ctx");
    Intrinsics.checkParameterIsNotNull(paramString, "url");
  }
  
  @ExperimentalContracts
  public final void a(@NotNull Activity paramActivity, @NotNull String paramString, boolean paramBoolean, @Nullable Function2<? super WxaShortLinkLaunchErrorCode, ? super LAUNCH_PHASE_RET, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "ctx");
    Intrinsics.checkParameterIsNotNull(paramString, "link");
    if (a.matcher((CharSequence)paramString).matches())
    {
      new com.tencent.luggage.wxa.ow.a().a(paramString, a(), (Function2)new a.d(this, paramActivity, paramFunction2, paramString, paramBoolean));
      return;
    }
    b(paramActivity, paramString);
    if (paramFunction2 != null) {
      paramActivity = (Unit)paramFunction2.invoke(WxaShortLinkLaunchErrorCode.ILLEGAL_LINK, null);
    }
  }
  
  protected abstract void a(@NotNull Context paramContext, @NotNull a.b paramb, @NotNull Function1<? super LAUNCH_PHASE_RET, Unit> paramFunction1);
  
  protected boolean a(@NotNull Activity paramActivity, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "ctx");
    return true;
  }
  
  protected abstract boolean a(LAUNCH_PHASE_RET paramLAUNCH_PHASE_RET);
  
  protected void b(@NotNull Activity paramActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "ctx");
    Intrinsics.checkParameterIsNotNull(paramString, "url");
  }
  
  protected void c(@NotNull Activity paramActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "ctx");
    Intrinsics.checkParameterIsNotNull(paramString, "url");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.a
 * JD-Core Version:    0.7.0.1
 */