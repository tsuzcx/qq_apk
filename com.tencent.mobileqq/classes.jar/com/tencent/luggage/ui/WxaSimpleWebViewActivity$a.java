package com.tencent.luggage.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WxaSimpleWebViewActivity$Companion;", "", "()V", "KEY_URL", "", "TAG", "viewURL", "", "context", "Landroid/content/Context;", "url", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaSimpleWebViewActivity$a
{
  public final void a(@Nullable Context paramContext, @Nullable String paramString)
  {
    paramString = new Intent().setClass(r.a(), WxaSimpleWebViewActivity.class).putExtra("KEY_URL", paramString);
    if (!(paramContext instanceof Activity)) {
      paramString.addFlags(268435456);
    }
    if (paramContext == null) {
      paramContext = r.a();
    }
    paramContext.startActivity(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaSimpleWebViewActivity.a
 * JD-Core Version:    0.7.0.1
 */