package com.tencent.android.gldrawable.api.base;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class AsyncDrawable$MyAsyncLoaderCallback$onLoadSucceed$1$1
  extends Lambda
  implements Function0<Unit>
{
  AsyncDrawable$MyAsyncLoaderCallback$onLoadSucceed$1$1(AsyncDrawable paramAsyncDrawable)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject = (Drawable)AsyncDrawable.access$getDoTargetDrawableBuild$p(this.$this_run).invoke();
    if (localObject != null) {
      AsyncDrawable.access$setCurrentDrawable$p(this.$this_run, (Drawable)localObject);
    }
    if (this.$this_run.getCurrentDrawable() == null)
    {
      localObject = this.$this_run;
      AsyncDrawable.access$setCurrentDrawable$p((AsyncDrawable)localObject, (Drawable)AsyncDrawable.access$getDoFailedDrawableBuild$p((AsyncDrawable)localObject).invoke());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.AsyncDrawable.MyAsyncLoaderCallback.onLoadSucceed.1.1
 * JD-Core Version:    0.7.0.1
 */