package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
abstract interface ResourceManagerInternal$ResourceManagerHooks
{
  public abstract Drawable createDrawableFor(@NonNull ResourceManagerInternal paramResourceManagerInternal, @NonNull Context paramContext, @DrawableRes int paramInt);
  
  public abstract ColorStateList getTintListForDrawableRes(@NonNull Context paramContext, @DrawableRes int paramInt);
  
  public abstract PorterDuff.Mode getTintModeForDrawableRes(int paramInt);
  
  public abstract boolean tintDrawable(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull Drawable paramDrawable);
  
  public abstract boolean tintDrawableUsingColorFilter(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull Drawable paramDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
 * JD-Core Version:    0.7.0.1
 */