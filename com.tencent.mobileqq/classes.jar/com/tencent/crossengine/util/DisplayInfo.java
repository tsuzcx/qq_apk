package com.tencent.crossengine.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class DisplayInfo
{
  private int a;
  private int b;
  private boolean c = false;
  private float d = 1.0F;
  
  public DisplayInfo(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.d = 1.0F;
    this.a = paramContext.widthPixels;
    this.b = paramContext.heightPixels;
    this.c = paramBoolean;
  }
  
  public float a()
  {
    return this.d;
  }
  
  public boolean b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.util.DisplayInfo
 * JD-Core Version:    0.7.0.1
 */