package com.tencent.android.gldrawable.api.base;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class AsyncDrawable$updateDrawableState$1
  extends Lambda
  implements Function0<Unit>
{
  AsyncDrawable$updateDrawableState$1(AsyncDrawable paramAsyncDrawable)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Drawable localDrawable = this.this$0.getCurrentDrawable();
    if (localDrawable != null)
    {
      AsyncDrawable.access$applyToDrawable(this.this$0, localDrawable);
      AsyncDrawable.access$applyToBaseDrawable(this.this$0, localDrawable);
      this.this$0.invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.AsyncDrawable.updateDrawableState.1
 * JD-Core Version:    0.7.0.1
 */