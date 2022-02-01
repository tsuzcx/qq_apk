package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import com.tencent.luggage.sdk.customize.impl.a;
import com.tencent.luggage.wxa.fc.b.e;
import com.tencent.luggage.wxa.iu.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaRuntimeUIAnimationStyle;", "Lcom/tencent/luggage/sdk/customize/impl/FullSdkUIAnimationStyle;", "()V", "setRuntimeOpenAnimation", "", "toEnter", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "enterEndAction", "Ljava/lang/Runnable;", "toExit", "exitEndAction", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class f
  extends a
{
  public static final f a = new f();
  
  public void a(@NotNull d paramd1, @Nullable Runnable paramRunnable1, @Nullable d paramd2, @Nullable Runnable paramRunnable2)
  {
    Intrinsics.checkParameterIsNotNull(paramd1, "toEnter");
    if ((paramd1 instanceof b.e))
    {
      b.e locale = (b.e)paramd1;
      b(paramd1, 2130772509, paramRunnable1);
      if (paramd2 != null) {
        b(paramd2, 2130772508, paramRunnable2);
      }
    }
    else
    {
      super.a(paramd1, paramRunnable1, paramd2, paramRunnable2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.f
 * JD-Core Version:    0.7.0.1
 */