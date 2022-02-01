package com.tencent.av.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;

public class RotateLayout
  extends ViewGroup
{
  private int a;
  private final Matrix b = new Matrix();
  private final Rect c = new Rect();
  private final RectF d = new RectF();
  private final RectF e = new RectF();
  private final float[] f = new float[2];
  private final float[] g = new float[2];
  private boolean h = true;
  
  public RotateLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RotateLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof RotateLayout.LayoutParams;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.rotate(-this.a, getWidth() / 2.0F, getHeight() / 2.0F);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.f[0] = paramMotionEvent.getX();
    this.f[1] = paramMotionEvent.getY();
    this.b.mapPoints(this.g, this.f);
    float[] arrayOfFloat = this.g;
    paramMotionEvent.setLocation(arrayOfFloat[0], arrayOfFloat[1]);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new RotateLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new RotateLayout.LayoutParams(paramLayoutParams);
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    invalidate();
    return super.invalidateChildInParent(paramArrayOfInt, paramRect);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.h)
    {
      localObject = this.d;
      RectF localRectF = this.e;
      ((RectF)localObject).set(0.0F, 0.0F, paramInt3 - paramInt1, paramInt4 - paramInt2);
      this.b.setRotate(this.a, ((RectF)localObject).centerX(), ((RectF)localObject).centerY());
      this.b.mapRect(localRectF, (RectF)localObject);
      localRectF.round(this.c);
      this.h = false;
    }
    Object localObject = getChildAt(0);
    if (localObject != null) {
      ((View)localObject).layout(this.c.left, this.c.top, this.c.right, this.c.bottom);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(0);
    if (localView != null)
    {
      RotateLayout.LayoutParams localLayoutParams = (RotateLayout.LayoutParams)localView.getLayoutParams();
      if (this.a != localLayoutParams.a)
      {
        this.a = localLayoutParams.a;
        this.h = true;
      }
      if (Math.abs(this.a % 180) == 90)
      {
        measureChild(localView, paramInt2, paramInt1);
        setMeasuredDimension(resolveSize(localView.getMeasuredHeight(), paramInt1), resolveSize(localView.getMeasuredWidth(), paramInt2));
        return;
      }
      measureChild(localView, paramInt1, paramInt2);
      setMeasuredDimension(resolveSize(localView.getMeasuredWidth(), paramInt1), resolveSize(localView.getMeasuredHeight(), paramInt2));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    this.h = true;
    super.setLayoutParams(paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.RotateLayout
 * JD-Core Version:    0.7.0.1
 */