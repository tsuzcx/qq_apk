package com.tencent.mm.plugin.appbrand.phonenumber;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic$verifyPhoneNumber$1", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "onVerifyCallback", "", "isSuccess", "", "result", "", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class i$d
  implements ab.b
{
  i$d(Function2 paramFunction2) {}
  
  public void a(boolean paramBoolean, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "result");
    this.a.invoke(Boolean.valueOf(paramBoolean), paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.i.d
 * JD-Core Version:    0.7.0.1
 */