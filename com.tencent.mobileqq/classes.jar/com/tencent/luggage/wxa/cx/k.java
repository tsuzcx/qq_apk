package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.rl.b;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/WxaAttrSyncHelper;", "", "()V", "TAG", "", "getAppIdByUserName", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "username", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class k
{
  public static final k a = new k();
  
  @NotNull
  public final d<String> a(@Nullable String paramString)
  {
    paramString = h.a().a((b)new k.a(paramString));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "pipeline().next {\n      …\n            \"\"\n        }");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.k
 * JD-Core Version:    0.7.0.1
 */