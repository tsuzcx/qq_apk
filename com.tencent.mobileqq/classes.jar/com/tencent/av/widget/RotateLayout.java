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
  private int jdField_a_of_type_Int;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_a_of_type_Boolean = true;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private final float[] jdField_b_of_type_ArrayOfFloat = new float[2];
  
  public RotateLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RotateLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof RotateLayout.LayoutParams;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.rotate(-this.jdField_a_of_type_Int, getWidth() / 2.0F, getHeight() / 2.0F);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent.getX();
    this.jdField_a_of_type_ArrayOfFloat[1] = paramMotionEvent.getY();
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat);
    paramMotionEvent.setLocation(this.jdField_b_of_type_ArrayOfFloat[0], this.jdField_b_of_type_ArrayOfFloat[1]);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new RotateLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new RotateLayout.LayoutParams(paramLayoutParams);
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    invalidate();
    return super.invalidateChildInParent(paramArrayOfInt, paramRect);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
      ((RectF)localObject).set(0.0F, 0.0F, paramInt3 - paramInt1, paramInt4 - paramInt2);
      this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(this.jdField_a_of_type_Int, ((RectF)localObject).centerX(), ((RectF)localObject).centerY());
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF, (RectF)localObject);
      localRectF.round(this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_a_of_type_Boolean = false;
    }
    Object localObject = getChildAt(0);
    if (localObject != null) {
      ((View)localObject).layout(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(0);
    if (localView != null)
    {
      RotateLayout.LayoutParams localLayoutParams = (RotateLayout.LayoutParams)localView.getLayoutParams();
      if (this.jdField_a_of_type_Int != localLayoutParams.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Int = localLayoutParams.jdField_a_of_type_Int;
        this.jdField_a_of_type_Boolean = true;
      }
      if (Math.abs(this.jdField_a_of_type_Int % 180) == 90)
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
    this.jdField_a_of_type_Boolean = true;
    super.setLayoutParams(paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.widget.RotateLayout
 * JD-Core Version:    0.7.0.1
 */