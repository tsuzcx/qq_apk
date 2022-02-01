package com.tencent.biz.qqcircle.widgets.pick;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Transformation;
import androidx.core.view.ViewCompat;

public class WheelView
  extends VerticalGallery
{
  private static final int[] H = { -15658735, 11184810, 11184810 };
  private Rect G = new Rect();
  private Camera I = new Camera();
  private int J = 0;
  private int K = 80;
  private int L = -80;
  private float M = -0.1F;
  private float N = 0.8F;
  private float O = -25.0F;
  private boolean P = false;
  
  public WheelView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setVerticalScrollBarEnabled(false);
    setSlotInCenter(true);
    setOrientation(2);
    setGravity(1);
    setUnselectedAlpha(0.5F);
    setWillNotDraw(false);
    setSoundEffectsEnabled(true);
    setStaticTransformationsEnabled(true);
    setChildrenDrawingOrderEnabled(true);
    if (getResources().getDisplayMetrics().densityDpi <= 160) {
      this.L = -40;
    }
    ViewCompat.setImportantForAccessibility(this, 2);
  }
  
  private void a(View paramView, Transformation paramTransformation, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramTransformation.clear();
    paramTransformation.setTransformationType(3);
    Matrix localMatrix = paramTransformation.getMatrix();
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    this.I.save();
    this.I.translate(0.0F, 0.0F, 100.0F);
    paramTransformation.setAlpha(paramFloat4);
    if ((!Build.MODEL.equals("HUAWEI Y325-T00")) && (!Build.MODEL.equals("Lenovo A318t")) && (!Build.MODEL.equals("Lenovo A308t")) && (!Build.MODEL.equals("Lenovo A269")) && (!Build.MODEL.equals("PRA-TL10")) && (!Build.MODEL.equals("HUAWEI CAZ-TL10")) && (!Build.MODEL.equals("BLN-TL10")) && (!v())) {
      this.I.rotateX(paramFloat1);
    }
    this.I.translate(0.0F, 0.0F, paramFloat2);
    this.I.getMatrix(localMatrix);
    localMatrix.preSkew(paramFloat3, 0.0F);
    localMatrix.preTranslate(paramFloat5, 0.0F);
    localMatrix.preTranslate(-i / 2, -j / 2);
    localMatrix.postTranslate(i / 2, j / 2);
    this.I.restore();
  }
  
  private int d(View paramView)
  {
    return paramView.getTop() + paramView.getHeight() / 2;
  }
  
  private float e(View paramView)
  {
    int i = d(paramView);
    int j = this.J;
    float f1 = (j - i) / j;
    i = this.K;
    float f2 = f1 * i;
    if (f2 > i) {
      return i;
    }
    f1 = f2;
    if (f2 < -i) {
      f1 = -i;
    }
    return f1;
  }
  
  private float f(View paramView)
  {
    int i = d(paramView);
    int j = this.J;
    float f;
    if (i < j) {
      f = i / j;
    }
    for (i = this.L;; i = this.L)
    {
      return f * i;
      if (i <= j) {
        break;
      }
      f = (j * 2 - i) / j;
    }
    return this.L;
  }
  
  private float g(View paramView)
  {
    float f = this.N;
    return (1.0F - Math.abs(d(paramView) - this.J) / this.J) * this.N;
  }
  
  private int getCenterOfCoverflow()
  {
    return (getHeight() - getPaddingTop() - getPaddingBottom()) / 2 + getPaddingTop();
  }
  
  private float h(View paramView)
  {
    int i = d(paramView);
    int j = this.J;
    return (j - i) / j * this.M;
  }
  
  private float i(View paramView)
  {
    int i = d(paramView);
    if (this.P) {
      return Math.abs(this.J - i) / this.J * this.O;
    }
    return 0.0F;
  }
  
  public static boolean v()
  {
    if ((Build.MODEL.equals("VKY-AL00")) && (Build.VERSION.SDK_INT == 24)) {
      return true;
    }
    return (Build.MODEL.equals("NXT-AL10")) && (Build.VERSION.SDK_INT == 24);
  }
  
  protected void f()
  {
    super.f();
    playSoundEffect(0);
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    float f1 = e(paramView);
    float f2 = f(paramView);
    float f3 = h(paramView);
    float f4 = i(paramView);
    a(paramView, paramTransformation, f1, f2, f3, g(paramView), f4);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.J = getCenterOfCoverflow();
    paramInt2 = getCenterOfGallery();
    View localView = getChildAt(0);
    if (localView != null) {
      paramInt1 = localView.getMeasuredHeight();
    } else {
      paramInt1 = 50;
    }
    paramInt2 -= paramInt1 / 2;
    this.G.set(getPaddingLeft(), paramInt2, getWidth() - getPaddingRight(), paramInt1 + paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.J = getCenterOfCoverflow();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.J = getCenterOfCoverflow();
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3) {
          break label46;
        }
      }
      else
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        break label46;
      }
    }
    getParent().requestDisallowInterceptTouchEvent(false);
    label46:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setNeedTranslate(boolean paramBoolean)
  {
    this.P = paramBoolean;
  }
  
  public void setmMaxRotationAngle(int paramInt)
  {
    this.K = paramInt;
  }
  
  public void setmMaxSkew(float paramFloat)
  {
    this.M = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.WheelView
 * JD-Core Version:    0.7.0.1
 */