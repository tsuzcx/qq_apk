package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CircularRevealGridLayout
  extends GridLayout
  implements CircularRevealWidget
{
  @NonNull
  private final CircularRevealHelper a = new CircularRevealHelper(this);
  
  public CircularRevealGridLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircularRevealGridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a()
  {
    return this.a.a();
  }
  
  @Nullable
  public CircularRevealWidget.RevealInfo a()
  {
    return this.a.a();
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public boolean a()
  {
    return super.isOpaque();
  }
  
  public void b()
  {
    this.a.b();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    CircularRevealHelper localCircularRevealHelper = this.a;
    if (localCircularRevealHelper != null)
    {
      localCircularRevealHelper.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public boolean isOpaque()
  {
    CircularRevealHelper localCircularRevealHelper = this.a;
    if (localCircularRevealHelper != null) {
      return localCircularRevealHelper.a();
    }
    return super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(@Nullable Drawable paramDrawable)
  {
    this.a.a(paramDrawable);
  }
  
  public void setCircularRevealScrimColor(@ColorInt int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo paramRevealInfo)
  {
    this.a.a(paramRevealInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealGridLayout
 * JD-Core Version:    0.7.0.1
 */