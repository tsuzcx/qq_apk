package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import pyc;
import qbm;
import qbn;
import qcn;

public class VideoFeedsFloatWindowDragLayout
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private PointF jdField_a_of_type_AndroidGraphicsPointF;
  private pyc jdField_a_of_type_Pyc;
  private qbn jdField_a_of_type_Qbn;
  public boolean a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Point jdField_b_of_type_AndroidGraphicsPoint;
  private PointF jdField_b_of_type_AndroidGraphicsPointF;
  public boolean b;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  
  public VideoFeedsFloatWindowDragLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsFloatWindowDragLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsFloatWindowDragLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    a(paramContext);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofObject(this.jdField_a_of_type_Pyc, new Object[] { this.jdField_a_of_type_AndroidGraphicsPoint, this.jdField_b_of_type_AndroidGraphicsPoint });
    localValueAnimator.addUpdateListener(new qbm(this, paramInt1, paramInt2));
    localValueAnimator.start();
  }
  
  private void a(Context paramContext)
  {
    int[] arrayOfInt = qcn.a(paramContext);
    this.jdField_a_of_type_Long = arrayOfInt[0];
    this.jdField_b_of_type_Long = arrayOfInt[1];
    this.jdField_a_of_type_Pyc = new pyc();
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point();
    this.jdField_b_of_type_AndroidGraphicsPoint = new Point();
    int i = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.f = (i * i);
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF();
    this.jdField_b_of_type_AndroidGraphicsPointF = new PointF();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getRawX();
    this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getRawY();
    this.jdField_b_of_type_AndroidGraphicsPointF.x = this.jdField_a_of_type_AndroidGraphicsPointF.x;
    this.jdField_b_of_type_AndroidGraphicsPointF.y = this.jdField_a_of_type_AndroidGraphicsPointF.y;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    int i = (int)(f1 - this.jdField_a_of_type_AndroidGraphicsPointF.x);
    int j = (int)(f2 - this.jdField_a_of_type_AndroidGraphicsPointF.y);
    if (i * i + j * j < this.f)
    {
      this.jdField_c_of_type_Boolean = false;
      return false;
    }
    i = (int)(f1 - this.jdField_b_of_type_AndroidGraphicsPointF.x);
    j = (int)(f2 - this.jdField_b_of_type_AndroidGraphicsPointF.y);
    this.jdField_b_of_type_AndroidGraphicsPointF.x = f1;
    this.jdField_b_of_type_AndroidGraphicsPointF.y = f2;
    paramMotionEvent = (WindowManager.LayoutParams)getLayoutParams();
    paramMotionEvent.x -= i;
    paramMotionEvent.y -= j;
    if (this.jdField_a_of_type_Qbn != null)
    {
      this.jdField_a_of_type_Qbn.b();
      this.jdField_a_of_type_Qbn.a();
    }
    this.jdField_c_of_type_Boolean = true;
    return true;
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Qbn != null) {
        this.jdField_a_of_type_Qbn.c();
      }
      a();
      return true;
    }
    return false;
  }
  
  public void a()
  {
    int k = 0;
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
    int m = localLayoutParams.x;
    int n = localLayoutParams.y;
    int i = getWidth();
    int i1 = getHeight();
    if (this.jdField_b_of_type_Int + i + m >= this.jdField_a_of_type_Long) {}
    for (i = (int)(this.jdField_a_of_type_Long - this.jdField_b_of_type_Int - i - m);; i = 0)
    {
      int j = i;
      if (m <= this.jdField_c_of_type_Int) {
        j = this.jdField_c_of_type_Int - m;
      }
      i = k;
      if (this.d + i1 + n >= this.jdField_b_of_type_Long) {
        i = (int)(this.jdField_b_of_type_Long - i1 - this.d - n);
      }
      if (n <= this.e) {
        i = this.e - n;
      }
      if ((j == 0) && (i == 0)) {
        break;
      }
      this.jdField_b_of_type_AndroidGraphicsPoint.x = j;
      this.jdField_b_of_type_AndroidGraphicsPoint.y = i;
      a(m, n);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.d = (this.jdField_a_of_type_Int + paramInt);
  }
  
  public void b(int paramInt)
  {
    this.e = (this.jdField_a_of_type_Int + paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!this.jdField_b_of_type_Boolean)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      return bool1;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (!super.onTouchEvent(paramMotionEvent)) {
          break;
        }
      }
      return true;
      a(paramMotionEvent);
      bool1 = false;
      continue;
      bool1 = a(paramMotionEvent);
      continue;
      bool1 = b(paramMotionEvent);
    }
  }
  
  public void setDragListener(qbn paramqbn)
  {
    this.jdField_a_of_type_Qbn = paramqbn;
  }
  
  public void setEdge(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramInt = this.jdField_a_of_type_Int;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFloatWindowDragLayout
 * JD-Core Version:    0.7.0.1
 */