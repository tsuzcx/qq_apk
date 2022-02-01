package com.tencent.android.gldrawable.api.base;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/android/gldrawable/api/base/AsyncDrawable$callbackProxy$1", "Landroid/graphics/drawable/Drawable$Callback;", "invalidateDrawable", "", "who", "Landroid/graphics/drawable/Drawable;", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "time", "", "unscheduleDrawable", "api_release"}, k=1, mv={1, 1, 16})
public final class AsyncDrawable$callbackProxy$1
  implements Drawable.Callback
{
  public void invalidateDrawable(@NotNull Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "who");
    paramDrawable = this.this$0.getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable((Drawable)this.this$0);
    }
  }
  
  public void scheduleDrawable(@NotNull Drawable paramDrawable, @NotNull Runnable paramRunnable, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "who");
    Intrinsics.checkParameterIsNotNull(paramRunnable, "what");
    paramDrawable = this.this$0.getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable((Drawable)this.this$0, paramRunnable, paramLong);
    }
  }
  
  public void unscheduleDrawable(@NotNull Drawable paramDrawable, @NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "who");
    Intrinsics.checkParameterIsNotNull(paramRunnable, "what");
    paramDrawable = this.this$0.getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable((Drawable)this.this$0, paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.AsyncDrawable.callbackProxy.1
 * JD-Core Version:    0.7.0.1
 */