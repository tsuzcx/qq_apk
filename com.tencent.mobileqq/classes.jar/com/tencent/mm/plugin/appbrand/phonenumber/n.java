package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "", "addPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", "Landroid/content/Intent;", "data", "bindWxPhone", "Lkotlin/Function1;", "createPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onDone", "Lkotlin/Function0;", "createPhoneNumberManageLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "pagePath", "getExposeSpan", "Landroid/text/SpannableString;", "hideVKB", "managePhoneNumber", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "showEditEntry", "", "showVKB", "verifyPhoneNumber", "extDesc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "isSuccess", "", "result", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public abstract interface n
{
  @NotNull
  public abstract SpannableString a(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2);
  
  @NotNull
  public abstract l a(@NotNull Context paramContext, @NotNull String paramString, @NotNull Function0<Unit> paramFunction0);
  
  public abstract void a(@NotNull Context paramContext);
  
  public abstract void a(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2, @Nullable z paramz, @NotNull r paramr, @NotNull Function2<? super Boolean, ? super Map<String, String>, Unit> paramFunction2);
  
  public abstract void a(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2, @NotNull Function2<? super Integer, ? super Intent, Unit> paramFunction2);
  
  public abstract void a(@NotNull Context paramContext, @NotNull String paramString, @NotNull Function2<? super Integer, ? super Intent, Unit> paramFunction2);
  
  public abstract void a(@NotNull Context paramContext, @NotNull Function1<? super Integer, Unit> paramFunction1);
  
  public abstract void a(@NotNull z paramz);
  
  public abstract boolean a();
  
  @NotNull
  public abstract o b(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void b(@NotNull Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.n
 * JD-Core Version:    0.7.0.1
 */