package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Companion;", "", "()V", "TAG", "", "create", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class a$a
{
  @JvmStatic
  @NotNull
  public final a a(@NotNull MBRuntime paramMBRuntime, @NotNull com.tencent.magicbrush.handler.c paramc, @NotNull a.b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramMBRuntime, "runtime");
    Intrinsics.checkParameterIsNotNull(paramc, "jsThreadHandler");
    Intrinsics.checkParameterIsNotNull(paramb, "strategy");
    int i = b.a[paramb.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              paramMBRuntime = (a)new k(paramMBRuntime, paramc);
            } else {
              throw new NoWhenBranchMatchedException();
            }
          }
          else {
            paramMBRuntime = (a)new l(paramMBRuntime, paramc);
          }
        }
        else {
          paramMBRuntime = (a)new e(paramMBRuntime, paramc);
        }
      }
      else {
        paramMBRuntime = (a)new d(paramMBRuntime, paramc);
      }
    }
    else {
      paramMBRuntime = (a)new c(paramMBRuntime, paramc);
    }
    a.a(paramMBRuntime);
    return paramMBRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.a.a
 * JD-Core Version:    0.7.0.1
 */