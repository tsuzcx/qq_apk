package com.tencent.android.gldrawable.api.base;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/android/gldrawable/api/base/AutoReleaseThreadHandler;", "invoke"}, k=3, mv={1, 1, 16})
final class EmptyLoadUtils$workHandler$2
  extends Lambda
  implements Function0<AutoReleaseThreadHandler>
{
  public static final 2 INSTANCE = new 2();
  
  EmptyLoadUtils$workHandler$2()
  {
    super(0);
  }
  
  @NotNull
  public final AutoReleaseThreadHandler invoke()
  {
    return new AutoReleaseThreadHandler();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.EmptyLoadUtils.workHandler.2
 * JD-Core Version:    0.7.0.1
 */