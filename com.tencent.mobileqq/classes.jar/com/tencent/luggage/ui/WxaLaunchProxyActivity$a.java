package com.tencent.luggage.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.luggage.wxa.da.g;
import com.tencent.luggage.wxa.ew.b;
import com.tencent.luggage.wxa.jj.j;
import com.tencent.luggage.wxa.ou.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WxaLaunchProxyActivity$Companion;", "", "()V", "KEY_ACTION", "", "getKEY_ACTION", "()Ljava/lang/String;", "KEY_REFERRER", "getKEY_REFERRER", "KEY_STAT_OBJECT", "getKEY_STAT_OBJECT", "startApp", "", "ctx", "Landroid/content/Context;", "action", "Lcom/tencent/luggage/struct/LaunchContainerAction;", "statObject", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "referrer", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaLaunchProxyActivity$a
{
  @NotNull
  public final String a()
  {
    return WxaLaunchProxyActivity.a();
  }
  
  public final void a(@Nullable Context paramContext, @NotNull b paramb, @Nullable d paramd, @Nullable j paramj)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "action");
    if (paramContext != null)
    {
      Intent localIntent = new Intent(paramContext, WxaLaunchProxyActivity.class);
      localIntent.putExtra("intentForStartWxa", true);
      g.a(paramb, localIntent, WxaLaunchProxyActivity.a.a());
      if (paramd != null) {
        localIntent.putExtra(WxaLaunchProxyActivity.a.b(), (Parcelable)paramd);
      }
      if (paramj != null) {
        localIntent.putExtra(WxaLaunchProxyActivity.a.c(), (Parcelable)paramj);
      }
      paramContext.startActivity(localIntent);
    }
  }
  
  @NotNull
  public final String b()
  {
    return WxaLaunchProxyActivity.b();
  }
  
  @NotNull
  public final String c()
  {
    return WxaLaunchProxyActivity.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaLaunchProxyActivity.a
 * JD-Core Version:    0.7.0.1
 */