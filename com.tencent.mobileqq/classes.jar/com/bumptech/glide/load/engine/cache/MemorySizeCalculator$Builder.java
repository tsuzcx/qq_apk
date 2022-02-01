package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;

public final class MemorySizeCalculator$Builder
{
  static final int a;
  final Context b;
  ActivityManager c;
  MemorySizeCalculator.ScreenDimensions d;
  float e = 2.0F;
  float f = a;
  float g = 0.4F;
  float h = 0.33F;
  int i = 4194304;
  
  static
  {
    int j;
    if (Build.VERSION.SDK_INT < 26) {
      j = 4;
    } else {
      j = 1;
    }
    a = j;
  }
  
  public MemorySizeCalculator$Builder(Context paramContext)
  {
    this.b = paramContext;
    this.c = ((ActivityManager)paramContext.getSystemService("activity"));
    this.d = new MemorySizeCalculator.DisplayMetricsScreenDimensions(paramContext.getResources().getDisplayMetrics());
    if ((Build.VERSION.SDK_INT >= 26) && (MemorySizeCalculator.a(this.c))) {
      this.f = 0.0F;
    }
  }
  
  public MemorySizeCalculator a()
  {
    return new MemorySizeCalculator(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder
 * JD-Core Version:    0.7.0.1
 */