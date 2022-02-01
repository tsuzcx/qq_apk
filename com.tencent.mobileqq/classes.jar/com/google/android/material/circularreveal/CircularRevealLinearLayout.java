package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CircularRevealLinearLayout
  extends LinearLayout
  implements CircularRevealWidget
{
  @NonNull
  private final CircularRevealHelper a = new CircularRevealHelper(this);
  
  public CircularRevealLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircularRevealLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void b()
  {
    this.a.b();
  }
  
  public boolean c()
  {
    return super.isOpaque();
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
  
  @Nullable
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.a.e();
  }
  
  public int getCircularRevealScrimColor()
  {
    return this.a.d();
  }
  
  @Nullable
  public CircularRevealWidget.RevealInfo getRevealInfo()
  {
    return this.a.c();
  }
  
  public boolean isOpaque()
  {
    CircularRevealHelper localCircularRevealHelper = this.a;
    if (localCircularRevealHelper != null) {
      return localCircularRevealHelper.f();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealLinearLayout
 * JD-Core Version:    0.7.0.1
 */