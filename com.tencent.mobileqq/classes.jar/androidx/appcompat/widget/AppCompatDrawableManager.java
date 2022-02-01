package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class AppCompatDrawableManager
{
  private static final boolean DEBUG = false;
  private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
  private static AppCompatDrawableManager INSTANCE;
  private static final String TAG = "AppCompatDrawableManag";
  private ResourceManagerInternal mResourceManager;
  
  public static AppCompatDrawableManager get()
  {
    try
    {
      if (INSTANCE == null) {
        preload();
      }
      AppCompatDrawableManager localAppCompatDrawableManager = INSTANCE;
      return localAppCompatDrawableManager;
    }
    finally {}
  }
  
  public static PorterDuffColorFilter getPorterDuffColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      paramMode = ResourceManagerInternal.getPorterDuffColorFilter(paramInt, paramMode);
      return paramMode;
    }
    finally
    {
      paramMode = finally;
      throw paramMode;
    }
  }
  
  public static void preload()
  {
    try
    {
      if (INSTANCE == null)
      {
        INSTANCE = new AppCompatDrawableManager();
        INSTANCE.mResourceManager = ResourceManagerInternal.get();
        INSTANCE.mResourceManager.setHooks(new AppCompatDrawableManager.1());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static void tintDrawable(Drawable paramDrawable, TintInfo paramTintInfo, int[] paramArrayOfInt)
  {
    ResourceManagerInternal.tintDrawable(paramDrawable, paramTintInfo, paramArrayOfInt);
  }
  
  public Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    try
    {
      paramContext = this.mResourceManager.getDrawable(paramContext, paramInt);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt, boolean paramBoolean)
  {
    try
    {
      paramContext = this.mResourceManager.getDrawable(paramContext, paramInt, paramBoolean);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  ColorStateList getTintList(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    try
    {
      paramContext = this.mResourceManager.getTintList(paramContext, paramInt);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void onConfigurationChanged(@NonNull Context paramContext)
  {
    try
    {
      this.mResourceManager.onConfigurationChanged(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  Drawable onDrawableLoadedFromResources(@NonNull Context paramContext, @NonNull VectorEnabledTintResources paramVectorEnabledTintResources, @DrawableRes int paramInt)
  {
    try
    {
      paramContext = this.mResourceManager.onDrawableLoadedFromResources(paramContext, paramVectorEnabledTintResources, paramInt);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  boolean tintDrawableUsingColorFilter(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull Drawable paramDrawable)
  {
    return this.mResourceManager.tintDrawableUsingColorFilter(paramContext, paramInt, paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatDrawableManager
 * JD-Core Version:    0.7.0.1
 */