package com.tencent.luggage.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import com.tencent.mm.plugin.appbrand.phonenumber.i;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/ui/PhoneNumberVerifyCodeUI$Companion$init$1", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic;", "showEditEntry", "", "verifyPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "", "extDesc", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "callback", "Lkotlin/Function2;", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class PhoneNumberVerifyCodeUI$a$a
  extends i
{
  public void a(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2, @Nullable z paramz, @NotNull r paramr, @NotNull Function2<? super Boolean, ? super Map<String, String>, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString1, "appId");
    Intrinsics.checkParameterIsNotNull(paramString2, "extDesc");
    Intrinsics.checkParameterIsNotNull(paramr, "phoneItem");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    paramz = new Intent(paramContext, PhoneNumberVerifyCodeUI.class);
    paramz.putExtra("APPID", paramString1);
    paramz.putExtra("PHONEITEM", paramr.a());
    paramz.putExtra("EXTDESC", paramString2);
    LuggageActivityHelper.FOR(paramContext).startActivityForResult(paramz, (LuggageActivityHelper.ActivityResultCallback)new PhoneNumberVerifyCodeUI.a.a.a(paramFunction2));
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.PhoneNumberVerifyCodeUI.a.a
 * JD-Core Version:    0.7.0.1
 */