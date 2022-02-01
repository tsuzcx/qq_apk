package com.tencent.luggage.wxa.fm;

import androidx.annotation.ColorInt;
import com.tencent.luggage.wxa.standalone_open_runtime.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/WxaMenuInfo$Companion;", "", "()V", "make", "Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/WxaMenuInfo;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "desc", "", "iconRes", "", "isMainGroup", "", "color", "menuItemId", "isDefaultDisabled", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class c$a
{
  @NotNull
  public final c<e> a(@NotNull String paramString, int paramInt1, boolean paramBoolean1, @ColorInt int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "desc");
    b localb = new b(paramInt3);
    paramString = new c(paramInt3, paramString, paramInt1, paramBoolean1, paramInt2, localb);
    if (paramBoolean2) {
      paramString.a(true);
    }
    localb.a(paramString);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fm.c.a
 * JD-Core Version:    0.7.0.1
 */