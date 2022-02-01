package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.Log;

public final class MemorySizeCalculator
{
  private final int a;
  private final int b;
  private final Context c;
  private final int d;
  
  MemorySizeCalculator(MemorySizeCalculator.Builder paramBuilder)
  {
    this.c = paramBuilder.b;
    if (a(paramBuilder.c)) {
      i = paramBuilder.i / 2;
    } else {
      i = paramBuilder.i;
    }
    this.d = i;
    int i = a(paramBuilder.c, paramBuilder.g, paramBuilder.h);
    float f = paramBuilder.d.a() * paramBuilder.d.b() * 4;
    int j = Math.round(paramBuilder.f * f);
    int k = Math.round(f * paramBuilder.e);
    int m = i - this.d;
    int n = k + j;
    if (n <= m)
    {
      this.b = k;
      this.a = j;
    }
    else
    {
      f = m / (paramBuilder.f + paramBuilder.e);
      this.b = Math.round(paramBuilder.e * f);
      this.a = Math.round(f * paramBuilder.f);
    }
    if (Log.isLoggable("MemorySizeCalculator", 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Calculation complete, Calculated memory cache size: ");
      localStringBuilder.append(a(this.b));
      localStringBuilder.append(", pool size: ");
      localStringBuilder.append(a(this.a));
      localStringBuilder.append(", byte array size: ");
      localStringBuilder.append(a(this.d));
      localStringBuilder.append(", memory class limited? ");
      boolean bool;
      if (n > i) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append(", max size: ");
      localStringBuilder.append(a(i));
      localStringBuilder.append(", memoryClass: ");
      localStringBuilder.append(paramBuilder.c.getMemoryClass());
      localStringBuilder.append(", isLowMemoryDevice: ");
      localStringBuilder.append(a(paramBuilder.c));
      Log.d("MemorySizeCalculator", localStringBuilder.toString());
    }
  }
  
  private static int a(ActivityManager paramActivityManager, float paramFloat1, float paramFloat2)
  {
    int i = paramActivityManager.getMemoryClass();
    boolean bool = a(paramActivityManager);
    float f = i * 1024 * 1024;
    if (bool) {
      paramFloat1 = paramFloat2;
    }
    return Math.round(f * paramFloat1);
  }
  
  private String a(int paramInt)
  {
    return Formatter.formatFileSize(this.c, paramInt);
  }
  
  @TargetApi(19)
  static boolean a(ActivityManager paramActivityManager)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramActivityManager.isLowRamDevice();
    }
    return true;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.MemorySizeCalculator
 * JD-Core Version:    0.7.0.1
 */