package com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke;

import android.content.Context;
import android.graphics.drawable.Drawable;

public abstract class Stroke
{
  public final int a;
  protected Context a;
  public final int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public Stroke(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("Stroke width <= 0, width:" + paramInt1);
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("Stroke height <= 0, height:" + paramInt2);
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public abstract int a();
  
  public abstract Drawable a();
  
  public abstract Drawable a(float paramFloat1, float paramFloat2);
  
  public void a(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  public abstract Drawable b(float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.Stroke
 * JD-Core Version:    0.7.0.1
 */