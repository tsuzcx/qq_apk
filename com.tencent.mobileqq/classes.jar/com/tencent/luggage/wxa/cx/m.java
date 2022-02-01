package com.tencent.luggage.wxa.cx;

import android.app.Activity;
import com.tencent.luggage.wxa.em.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/WxaLaunchErrorAction;", "Ljava/lang/Error;", "Lkotlin/Error;", "()V", "handleError", "", "rt", "Lcom/tencent/luggage/standalone_ext/Runtime;", "showError", "activity", "Landroid/app/Activity;", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public abstract class m
  extends Error
{
  public static final m.a a = new m.a(null);
  
  public abstract void a(@Nullable Activity paramActivity);
  
  public final void a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    paramd.b((Runnable)new m.b(this, paramd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.m
 * JD-Core Version:    0.7.0.1
 */