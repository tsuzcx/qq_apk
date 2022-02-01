package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaProfileActivity$Companion;", "", "()V", "KEY_APPID", "", "TAG", "show", "", "ctx", "Landroid/content/Context;", "wxaAppID", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class WxaProfileActivity$Companion
{
  @JvmStatic
  public final void show(@NotNull Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "ctx");
    Intrinsics.checkParameterIsNotNull(paramString, "wxaAppID");
    Intent localIntent = new Intent(paramContext, WxaProfileActivity.class);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("_key_appid", paramString);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity.Companion
 * JD-Core Version:    0.7.0.1
 */