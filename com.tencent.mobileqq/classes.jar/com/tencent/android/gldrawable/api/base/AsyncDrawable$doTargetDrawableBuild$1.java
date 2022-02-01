package com.tencent.android.gldrawable.api.base;

import android.graphics.drawable.Drawable;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IReporter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "invoke"}, k=3, mv={1, 1, 16})
final class AsyncDrawable$doTargetDrawableBuild$1
  extends Lambda
  implements Function0<Drawable>
{
  AsyncDrawable$doTargetDrawableBuild$1(AsyncDrawable paramAsyncDrawable)
  {
    super(0);
  }
  
  @Nullable
  public final Drawable invoke()
  {
    try
    {
      Drawable localDrawable = (Drawable)this.this$0.getTargetDrawableBuild().invoke();
      return localDrawable;
    }
    catch (Throwable localThrowable)
    {
      GLDrawableApi.INSTANCE.getLogger$api_release().logE("error", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.AsyncDrawable.doTargetDrawableBuild.1
 * JD-Core Version:    0.7.0.1
 */