package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.color.MaterialColors;

public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec>
  extends DrawableWithAnimatedVisibilityChange
{
  private static final FloatPropertyCompat<DeterminateDrawable> j = new DeterminateDrawable.1("indicatorLevel");
  private DrawingDelegate<S> e;
  private final SpringForce f;
  private final SpringAnimation g;
  private float h;
  private boolean i = false;
  
  DeterminateDrawable(@NonNull Context paramContext, @NonNull BaseProgressIndicatorSpec paramBaseProgressIndicatorSpec, @NonNull DrawingDelegate<S> paramDrawingDelegate)
  {
    super(paramContext, paramBaseProgressIndicatorSpec);
    a(paramDrawingDelegate);
    this.f = new SpringForce();
    this.f.setDampingRatio(1.0F);
    this.f.setStiffness(50.0F);
    this.g = new SpringAnimation(this, j);
    this.g.setSpring(this.f);
    b(1.0F);
  }
  
  @NonNull
  public static DeterminateDrawable<CircularProgressIndicatorSpec> a(@NonNull Context paramContext, @NonNull CircularProgressIndicatorSpec paramCircularProgressIndicatorSpec)
  {
    return new DeterminateDrawable(paramContext, paramCircularProgressIndicatorSpec, new CircularDrawingDelegate(paramCircularProgressIndicatorSpec));
  }
  
  @NonNull
  public static DeterminateDrawable<LinearProgressIndicatorSpec> a(@NonNull Context paramContext, @NonNull LinearProgressIndicatorSpec paramLinearProgressIndicatorSpec)
  {
    return new DeterminateDrawable(paramContext, paramLinearProgressIndicatorSpec, new LinearDrawingDelegate(paramLinearProgressIndicatorSpec));
  }
  
  private void c(float paramFloat)
  {
    this.h = paramFloat;
    invalidateSelf();
  }
  
  private float f()
  {
    return this.h;
  }
  
  @NonNull
  DrawingDelegate<S> a()
  {
    return this.e;
  }
  
  void a(float paramFloat)
  {
    setLevel((int)(paramFloat * 10000.0F));
  }
  
  void a(@NonNull DrawingDelegate<S> paramDrawingDelegate)
  {
    this.e = paramDrawingDelegate;
    paramDrawingDelegate.a(this);
  }
  
  boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramBoolean1 = super.a(paramBoolean1, paramBoolean2, paramBoolean3);
    float f1 = this.c.a(this.a.getContentResolver());
    if (f1 == 0.0F)
    {
      this.i = true;
      return paramBoolean1;
    }
    this.i = false;
    this.f.setStiffness(50.0F / f1);
    return paramBoolean1;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Rect localRect = new Rect();
    if ((!getBounds().isEmpty()) && (isVisible()))
    {
      if (!paramCanvas.getClipBounds(localRect)) {
        return;
      }
      paramCanvas.save();
      this.e.b(paramCanvas, e());
      this.e.a(paramCanvas, this.d);
      int k = MaterialColors.b(this.b.c[0], getAlpha());
      this.e.a(paramCanvas, this.d, 0.0F, f(), k);
      paramCanvas.restore();
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.e.b();
  }
  
  public int getIntrinsicWidth()
  {
    return this.e.a();
  }
  
  public void jumpToCurrentState()
  {
    this.g.cancel();
    c(getLevel() / 10000.0F);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.i)
    {
      this.g.cancel();
      c(paramInt / 10000.0F);
    }
    else
    {
      this.g.setStartValue(f() * 10000.0F);
      this.g.animateToFinalPosition(paramInt);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.DeterminateDrawable
 * JD-Core Version:    0.7.0.1
 */