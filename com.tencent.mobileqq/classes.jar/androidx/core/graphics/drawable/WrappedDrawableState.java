package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class WrappedDrawableState
  extends Drawable.ConstantState
{
  int mChangingConfigurations;
  Drawable.ConstantState mDrawableState;
  ColorStateList mTint = null;
  PorterDuff.Mode mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;
  
  WrappedDrawableState(@Nullable WrappedDrawableState paramWrappedDrawableState)
  {
    if (paramWrappedDrawableState != null)
    {
      this.mChangingConfigurations = paramWrappedDrawableState.mChangingConfigurations;
      this.mDrawableState = paramWrappedDrawableState.mDrawableState;
      this.mTint = paramWrappedDrawableState.mTint;
      this.mTintMode = paramWrappedDrawableState.mTintMode;
    }
  }
  
  boolean canConstantState()
  {
    return this.mDrawableState != null;
  }
  
  public int getChangingConfigurations()
  {
    int j = this.mChangingConfigurations;
    if (this.mDrawableState != null) {}
    for (int i = this.mDrawableState.getChangingConfigurations();; i = 0) {
      return i | j;
    }
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    return newDrawable(null);
  }
  
  @NonNull
  public Drawable newDrawable(@Nullable Resources paramResources)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new WrappedDrawableApi21(this, paramResources);
    }
    return new WrappedDrawableApi14(this, paramResources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.graphics.drawable.WrappedDrawableState
 * JD-Core Version:    0.7.0.1
 */