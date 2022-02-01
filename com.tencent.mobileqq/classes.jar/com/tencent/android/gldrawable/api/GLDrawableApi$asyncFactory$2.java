package com.tencent.android.gldrawable.api;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "invoke"}, k=3, mv={1, 1, 16})
final class GLDrawableApi$asyncFactory$2
  extends Lambda
  implements Function0<Drawable>
{
  GLDrawableApi$asyncFactory$2(Function1 paramFunction1)
  {
    super(0);
  }
  
  @Nullable
  public final Drawable invoke()
  {
    return (Drawable)this.$sucessBlock.invoke(GLDrawableApi.factory());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.GLDrawableApi.asyncFactory.2
 * JD-Core Version:    0.7.0.1
 */