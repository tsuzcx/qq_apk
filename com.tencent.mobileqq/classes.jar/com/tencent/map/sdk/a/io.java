package com.tencent.map.sdk.a;

import android.graphics.Color;
import com.tencent.tencentmap.mapsdk.maps.model.OverlayLevel;

public class io
{
  protected float a = 1.0F;
  protected int b = Color.argb(17, 0, 163, 255);
  protected int c = Color.argb(255, 0, 163, 255);
  protected float d = 0.0F;
  protected boolean e = true;
  protected boolean f = false;
  protected int g = OverlayLevel.OverlayLevelAboveLabels;
  
  public final void a(float paramFloat)
  {
    this.a = paramFloat;
    this.f = true;
  }
  
  public void b(float paramFloat)
  {
    this.d = paramFloat;
    this.f = true;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
    this.f = true;
  }
  
  public final void c(int paramInt)
  {
    this.b = paramInt;
    this.f = true;
  }
  
  public void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void d(int paramInt)
  {
    this.g = paramInt;
    this.f = true;
  }
  
  public final float i()
  {
    return this.d;
  }
  
  public final int j()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.io
 * JD-Core Version:    0.7.0.1
 */