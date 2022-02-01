package androidx.appcompat.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import androidx.annotation.NonNull;

class DrawableContainer$BlockInvalidateCallback
  implements Drawable.Callback
{
  private Drawable.Callback mCallback;
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable) {}
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
  {
    Drawable.Callback localCallback = this.mCallback;
    if (localCallback != null) {
      localCallback.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
    }
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
  {
    Drawable.Callback localCallback = this.mCallback;
    if (localCallback != null) {
      localCallback.unscheduleDrawable(paramDrawable, paramRunnable);
    }
  }
  
  public Drawable.Callback unwrap()
  {
    Drawable.Callback localCallback = this.mCallback;
    this.mCallback = null;
    return localCallback;
  }
  
  public BlockInvalidateCallback wrap(Drawable.Callback paramCallback)
  {
    this.mCallback = paramCallback;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.graphics.drawable.DrawableContainer.BlockInvalidateCallback
 * JD-Core Version:    0.7.0.1
 */