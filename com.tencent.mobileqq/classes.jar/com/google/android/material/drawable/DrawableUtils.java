package com.google.android.material.drawable;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class DrawableUtils
{
  @Nullable
  public static PorterDuffColorFilter a(@NonNull Drawable paramDrawable, @Nullable ColorStateList paramColorStateList, @Nullable PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(paramDrawable.getState(), 0), paramMode);
    }
    return null;
  }
  
  @TargetApi(21)
  public static void a(@Nullable RippleDrawable paramRippleDrawable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramRippleDrawable.setRadius(paramInt);
      return;
    }
    try
    {
      RippleDrawable.class.getDeclaredMethod("setMaxRadius", new Class[] { Integer.TYPE }).invoke(paramRippleDrawable, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (IllegalAccessException paramRippleDrawable) {}catch (InvocationTargetException paramRippleDrawable) {}catch (NoSuchMethodException paramRippleDrawable) {}
    throw new IllegalStateException("Couldn't set RippleDrawable radius", paramRippleDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.drawable.DrawableUtils
 * JD-Core Version:    0.7.0.1
 */