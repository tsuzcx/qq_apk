package com.tencent.luggage.wxa.cx;

import android.content.Context;
import com.tencent.luggage.ui.WxaLaunchProxyActivity;
import com.tencent.luggage.ui.WxaLaunchProxyActivity.a;
import com.tencent.luggage.wxa.da.f;
import com.tencent.luggage.wxa.da.f.a;
import com.tencent.luggage.wxa.ew.b;
import com.tencent.luggage.wxa.jj.j;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.s.a;
import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/WxaLaunchLogic;", "", "()V", "TAG", "", "installTask", "", "uiClass", "", "Ljava/lang/Class;", "Landroid/app/Activity;", "landscapeModeUiClass", "transparentUiClassList", "startApp", "ctx", "Landroid/content/Context;", "action", "Lcom/tencent/luggage/struct/LaunchContainerAction;", "statObject", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "referrer", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "startAppInner", "checkIsGame", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class q
{
  public static final q a = new q();
  private static final String b = "Luggage.WxaLaunchLogic";
  
  @JvmStatic
  public static final void a(@Nullable Context paramContext, @NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "action");
    a(a, paramContext, paramb, null, null, 8, null);
  }
  
  @JvmStatic
  public static final void a(@Nullable Context paramContext, @NotNull b paramb, @Nullable com.tencent.luggage.wxa.ou.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "action");
    a.b(paramContext, paramb, paramd, null);
  }
  
  @JvmStatic
  public static final void a(@Nullable Context paramContext, @NotNull b paramb, @Nullable com.tencent.luggage.wxa.ou.d paramd, @Nullable j paramj)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "action");
    a.b(paramContext, paramb, paramd, paramj);
  }
  
  private final boolean a(@NotNull b paramb)
  {
    if (paramb.a == null) {
      Intrinsics.throwNpe();
    }
    try
    {
      localObject = u.a().b(paramb.a, new String[] { "appInfo" });
      if (localObject != null)
      {
        localObject = ((s)localObject).c();
        if (localObject != null)
        {
          boolean bool = ((s.a)localObject).a();
          if (bool == true) {
            return true;
          }
        }
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Object localObject = b;
      Throwable localThrowable = (Throwable)localIllegalStateException;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LaunchContainerAction(");
      localStringBuilder.append(paramb.a);
      localStringBuilder.append(").checkIsGame()");
      o.a((String)localObject, localThrowable, localStringBuilder.toString(), new Object[0]);
    }
    return false;
  }
  
  private final void b(Context paramContext, b paramb, com.tencent.luggage.wxa.ou.d paramd, j paramj)
  {
    Object localObject1 = com.tencent.luggage.wxa.fb.a.a;
    Object localObject2 = paramb.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "action.appId");
    if (!((com.tencent.luggage.wxa.fb.a)localObject1).c((String)localObject2))
    {
      com.tencent.mm.plugin.appbrand.keylogger.d.a(com.tencent.luggage.wxa.oy.a.class, paramb.a);
      localObject1 = paramb.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Network:");
      ((StringBuilder)localObject2).append(x.b(r.a()));
      com.tencent.mm.plugin.appbrand.keylogger.d.a(com.tencent.luggage.wxa.oy.a.class, (String)localObject1, ((StringBuilder)localObject2).toString());
    }
    if (r.h())
    {
      if (paramContext == null) {
        paramContext = r.a();
      }
      localObject1 = f.a.a();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "nonNullContext");
      localObject2 = paramb.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "action.appId");
      ((f)localObject1).a(paramContext, (com.tencent.luggage.wxa.ea.h)new com.tencent.luggage.wxa.da.h((String)localObject2, a(paramb), paramb.e, paramb, paramd, paramj));
      return;
    }
    WxaLaunchProxyActivity.a.a(paramContext, paramb, paramd, paramj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.q
 * JD-Core Version:    0.7.0.1
 */