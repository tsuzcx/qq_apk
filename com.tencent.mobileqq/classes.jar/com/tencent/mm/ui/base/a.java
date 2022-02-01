package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class a
  extends com.tencent.mm.plugin.appbrand.widget.a
{
  private final Resources a;
  private DisplayMetrics b;
  private Configuration c;
  private k.a d;
  
  public a(Resources paramResources, DisplayMetrics paramDisplayMetrics, @NonNull Configuration paramConfiguration, k.a parama)
  {
    super(paramResources);
    this.d = parama;
    this.a = paramResources;
    this.b = a(paramDisplayMetrics, paramConfiguration);
    paramResources = new Configuration(this.a.getConfiguration());
    paramDisplayMetrics = new DisplayMetrics();
    paramDisplayMetrics.setTo(this.a.getDisplayMetrics());
    updateConfiguration(paramResources, paramDisplayMetrics);
  }
  
  private Drawable a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      DisplayMetrics localDisplayMetrics = this.b;
      if (localDisplayMetrics != null) {
        ((BitmapDrawable)paramDrawable).setTargetDensity(localDisplayMetrics.densityDpi);
      }
    }
    return paramDrawable;
  }
  
  private DisplayMetrics a(@NonNull DisplayMetrics paramDisplayMetrics, @NonNull Configuration paramConfiguration)
  {
    return this.d.a(paramDisplayMetrics, paramConfiguration);
  }
  
  public Configuration getConfiguration()
  {
    Configuration localConfiguration = this.c;
    if (localConfiguration != null) {
      return localConfiguration;
    }
    return super.getConfiguration();
  }
  
  public int getDimensionPixelOffset(int paramInt)
  {
    return a(paramInt);
  }
  
  public int getDimensionPixelSize(int paramInt)
  {
    return b(paramInt);
  }
  
  public DisplayMetrics getDisplayMetrics()
  {
    DisplayMetrics localDisplayMetrics = this.b;
    if (localDisplayMetrics != null) {
      return localDisplayMetrics;
    }
    return super.getDisplayMetrics();
  }
  
  public Drawable getDrawable(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = this.b;
    if (localDisplayMetrics != null) {
      return getDrawableForDensity(paramInt, localDisplayMetrics.densityDpi);
    }
    return a(this.a.getDrawable(paramInt));
  }
  
  @TargetApi(21)
  public Drawable getDrawable(int paramInt, @Nullable Resources.Theme paramTheme)
  {
    DisplayMetrics localDisplayMetrics = this.b;
    if (localDisplayMetrics != null) {
      return getDrawableForDensity(paramInt, localDisplayMetrics.densityDpi, paramTheme);
    }
    return a(this.a.getDrawable(paramInt, paramTheme));
  }
  
  @TargetApi(21)
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 == 0)
    {
      DisplayMetrics localDisplayMetrics = this.b;
      i = paramInt2;
      if (localDisplayMetrics != null) {
        i = localDisplayMetrics.densityDpi;
      }
    }
    return this.a.getDrawableForDensity(paramInt1, i);
  }
  
  @TargetApi(21)
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2, @Nullable Resources.Theme paramTheme)
  {
    int i = paramInt2;
    if (paramInt2 == 0)
    {
      DisplayMetrics localDisplayMetrics = this.b;
      i = paramInt2;
      if (localDisplayMetrics != null) {
        i = localDisplayMetrics.densityDpi;
      }
    }
    return this.a.getDrawableForDensity(paramInt1, i, paramTheme);
  }
  
  public void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    if (this.b != null)
    {
      this.c = new Configuration(paramConfiguration);
      this.c.densityDpi = this.b.densityDpi;
      super.updateConfiguration(this.c, this.b);
      this.a.updateConfiguration(paramConfiguration, paramDisplayMetrics);
      return;
    }
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.a
 * JD-Core Version:    0.7.0.1
 */