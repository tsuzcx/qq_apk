package com.tencent.android.gldrawable.api.base;

import com.tencent.android.gldrawable.api.IGLDrawableLoader;
import com.tencent.android.gldrawable.api.ILoadUtils;
import com.tencent.android.gldrawable.api.IReporter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/android/gldrawable/api/IReporter;", "invoke"}, k=3, mv={1, 1, 16})
final class InternalApiImpl$logger$2
  extends Lambda
  implements Function0<IReporter>
{
  InternalApiImpl$logger$2(InternalApiImpl paramInternalApiImpl)
  {
    super(0);
  }
  
  @NotNull
  public final IReporter invoke()
  {
    return this.this$0.getLoader().getLoaderUtils().getReport();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.InternalApiImpl.logger.2
 * JD-Core Version:    0.7.0.1
 */