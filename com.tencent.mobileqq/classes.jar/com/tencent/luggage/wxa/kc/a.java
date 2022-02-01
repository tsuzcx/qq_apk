package com.tencent.luggage.wxa.kc;

import com.tencent.luggage.wxa.on.g;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "appBrandName", "", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "phoneItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "showPrivacyExplainEntry", "show", "", "Factory", "FactoryInterface", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public abstract interface a
  extends g
{
  public abstract void a(@Nullable String paramString);
  
  public abstract void a(@NotNull ArrayList<r> paramArrayList);
  
  public abstract void a(@NotNull Function0<Unit> paramFunction0);
  
  public abstract void a(@NotNull Function1<? super r, Unit> paramFunction1);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(@Nullable String paramString);
  
  public abstract void b(@NotNull Function0<Unit> paramFunction0);
  
  public abstract void c(@NotNull Function0<Unit> paramFunction0);
  
  public abstract void d(@NotNull Function0<Unit> paramFunction0);
  
  public abstract void e(@NotNull Function0<Unit> paramFunction0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kc.a
 * JD-Core Version:    0.7.0.1
 */