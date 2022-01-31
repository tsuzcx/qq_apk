package com.google.android.filament;

import androidx.annotation.IntRange;

public class Viewport
{
  public int bottom;
  @IntRange(from=0L)
  public int height;
  public int left;
  @IntRange(from=0L)
  public int width;
  
  public Viewport(int paramInt1, int paramInt2, @IntRange(from=0L) int paramInt3, @IntRange(from=0L) int paramInt4)
  {
    this.left = paramInt1;
    this.bottom = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.Viewport
 * JD-Core Version:    0.7.0.1
 */