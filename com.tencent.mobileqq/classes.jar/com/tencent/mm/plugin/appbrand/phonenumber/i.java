package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import com.tencent.mm.ui.BaseActivity;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "()V", "addPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", "Landroid/content/Intent;", "data", "bindWxPhone", "Lkotlin/Function1;", "createPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onDone", "Lkotlin/Function0;", "createPhoneNumberManageLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "pagePath", "getExposeSpan", "Landroid/text/SpannableString;", "hideVKB", "managePhoneNumber", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "showEditEntry", "", "showVKB", "verifyPhoneNumber", "extDesc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "isSuccess", "", "result", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public class i
  implements n
{
  @Deprecated
  public static final i.a a = new i.a(null);
  
  @NotNull
  public SpannableString a(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString1, "appId");
    Intrinsics.checkParameterIsNotNull(paramString2, "pagePath");
    paramString1 = paramContext.getString(2131886963);
    paramString2 = StringCompanionObject.INSTANCE;
    paramContext = paramContext.getString(2131886964);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.getString(R.stri…mber_expose_slogan_start)");
    paramString2 = new Object[1];
    paramString2[0] = paramString1;
    paramContext = String.format(paramContext, Arrays.copyOf(paramString2, paramString2.length));
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "java.lang.String.format(format, *args)");
    return new SpannableString((CharSequence)paramContext);
  }
  
  @NotNull
  public l a(@NotNull Context paramContext, @NotNull String paramString, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "onDone");
    return (l)new t(paramContext, paramString, paramFunction0);
  }
  
  public void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if ((paramContext instanceof BaseActivity)) {}
  }
  
  public void a(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2, @Nullable z paramz, @NotNull r paramr, @NotNull Function2<? super Boolean, ? super Map<String, String>, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString1, "appId");
    Intrinsics.checkParameterIsNotNull(paramString2, "extDesc");
    Intrinsics.checkParameterIsNotNull(paramr, "phoneItem");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    new ab(paramContext, paramString1, paramz, paramString2, paramr, (ab.b)new i.d(paramFunction2)).a();
  }
  
  public void a(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2, @NotNull Function2<? super Integer, ? super Intent, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString1, "appId");
    Intrinsics.checkParameterIsNotNull(paramString2, "pagePath");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    LuggageActivityHelper localLuggageActivityHelper = LuggageActivityHelper.FOR(paramContext);
    paramContext = new Intent(paramContext, PhoneNumberManagerUI.class);
    paramContext.putExtra("APPID", paramString1);
    paramContext.putExtra("PAGEPATH", paramString2);
    localLuggageActivityHelper.startActivityForResult(paramContext, (LuggageActivityHelper.ActivityResultCallback)new i.c(paramFunction2));
  }
  
  public void a(@NotNull Context paramContext, @NotNull String paramString, @NotNull Function2<? super Integer, ? super Intent, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    LuggageActivityHelper localLuggageActivityHelper = LuggageActivityHelper.FOR(paramContext);
    paramContext = new Intent(paramContext, PhoneNumberAddUI.class);
    paramContext.putExtra("APPID", paramString);
    localLuggageActivityHelper.startActivityForResult(paramContext, (LuggageActivityHelper.ActivityResultCallback)new i.b(paramFunction2));
  }
  
  public void a(@NotNull Context paramContext, @NotNull Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    paramFunction1.invoke(Integer.valueOf(0));
  }
  
  public void a(@NotNull z paramz)
  {
    Intrinsics.checkParameterIsNotNull(paramz, "report");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report:");
    localStringBuilder.append(paramz);
    com.tencent.luggage.wxa.qz.o.d("Luggage.FULL.DefaultPhoneNumberLogic", localStringBuilder.toString());
  }
  
  public boolean a()
  {
    return true;
  }
  
  @NotNull
  public o b(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString1, "appId");
    Intrinsics.checkParameterIsNotNull(paramString2, "pagePath");
    return (o)new x(paramContext, paramString1, paramString2);
  }
  
  public void b(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if ((paramContext instanceof BaseActivity)) {
      ((BaseActivity)paramContext).showVKB((Activity)paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.i
 * JD-Core Version:    0.7.0.1
 */