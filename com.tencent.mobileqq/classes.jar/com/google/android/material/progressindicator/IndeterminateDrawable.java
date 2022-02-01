package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;

public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec>
  extends DrawableWithAnimatedVisibilityChange
{
  private DrawingDelegate<S> e;
  private IndeterminateAnimatorDelegate<ObjectAnimator> f;
  
  IndeterminateDrawable(@NonNull Context paramContext, @NonNull BaseProgressIndicatorSpec paramBaseProgressIndicatorSpec, @NonNull DrawingDelegate<S> paramDrawingDelegate, @NonNull IndeterminateAnimatorDelegate<ObjectAnimator> paramIndeterminateAnimatorDelegate)
  {
    super(paramContext, paramBaseProgressIndicatorSpec);
    a(paramDrawingDelegate);
    a(paramIndeterminateAnimatorDelegate);
  }
  
  @NonNull
  public static IndeterminateDrawable<CircularProgressIndicatorSpec> a(@NonNull Context paramContext, @NonNull CircularProgressIndicatorSpec paramCircularProgressIndicatorSpec)
  {
    return new IndeterminateDrawable(paramContext, paramCircularProgressIndicatorSpec, new CircularDrawingDelegate(paramCircularProgressIndicatorSpec), new CircularIndeterminateAnimatorDelegate(paramCircularProgressIndicatorSpec));
  }
  
  @NonNull
  public static IndeterminateDrawable<LinearProgressIndicatorSpec> a(@NonNull Context paramContext, @NonNull LinearProgressIndicatorSpec paramLinearProgressIndicatorSpec)
  {
    LinearDrawingDelegate localLinearDrawingDelegate = new LinearDrawingDelegate(paramLinearProgressIndicatorSpec);
    Object localObject;
    if (paramLinearProgressIndicatorSpec.g == 0) {
      localObject = new LinearIndeterminateContiguousAnimatorDelegate(paramLinearProgressIndicatorSpec);
    } else {
      localObject = new LinearIndeterminateDisjointAnimatorDelegate(paramContext, paramLinearProgressIndicatorSpec);
    }
    return new IndeterminateDrawable(paramContext, paramLinearProgressIndicatorSpec, localLinearDrawingDelegate, (IndeterminateAnimatorDelegate)localObject);
  }
  
  @NonNull
  IndeterminateAnimatorDelegate<ObjectAnimator> a()
  {
    return this.f;
  }
  
  void a(@NonNull DrawingDelegate<S> paramDrawingDelegate)
  {
    this.e = paramDrawingDelegate;
    paramDrawingDelegate.a(this);
  }
  
  void a(@NonNull IndeterminateAnimatorDelegate<ObjectAnimator> paramIndeterminateAnimatorDelegate)
  {
    this.f = paramIndeterminateAnimatorDelegate;
    paramIndeterminateAnimatorDelegate.a(this);
  }
  
  boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramBoolean2 = super.a(paramBoolean1, paramBoolean2, paramBoolean3);
    if (!isRunning()) {
      this.f.b();
    }
    float f1 = this.c.a(this.a.getContentResolver());
    if ((paramBoolean1) && ((paramBoolean3) || ((Build.VERSION.SDK_INT <= 21) && (f1 > 0.0F)))) {
      this.f.a();
    }
    return paramBoolean2;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Object localObject = new Rect();
    if ((!getBounds().isEmpty()) && (isVisible()))
    {
      if (!paramCanvas.getClipBounds((Rect)localObject)) {
        return;
      }
      paramCanvas.save();
      this.e.b(paramCanvas, e());
      this.e.a(paramCanvas, this.d);
      int i = 0;
      while (i < this.f.d.length)
      {
        localObject = this.e;
        Paint localPaint = this.d;
        float[] arrayOfFloat = this.f.c;
        int j = i * 2;
        ((DrawingDelegate)localObject).a(paramCanvas, localPaint, arrayOfFloat[j], this.f.c[(j + 1)], this.f.d[i]);
        i += 1;
      }
      paramCanvas.restore();
    }
  }
  
  @NonNull
  DrawingDelegate<S> f()
  {
    return this.e;
  }
  
  public int getIntrinsicHeight()
  {
    return this.e.b();
  }
  
  public int getIntrinsicWidth()
  {
    return this.e.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.IndeterminateDrawable
 * JD-Core Version:    0.7.0.1
 */