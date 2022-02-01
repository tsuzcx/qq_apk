package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ClockHandView
  extends View
{
  private double jdField_a_of_type_Double;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private ClockHandView.OnActionUpListener jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockHandView$OnActionUpListener;
  private final List<ClockHandView.OnRotateListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private final float jdField_c_of_type_Float;
  @Px
  private final int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  
  public ClockHandView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ClockHandView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.B);
  }
  
  public ClockHandView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.n, paramInt, R.style.J);
    this.jdField_d_of_type_Int = paramAttributeSet.getDimensionPixelSize(R.styleable.be, 0);
    this.jdField_b_of_type_Int = paramAttributeSet.getDimensionPixelSize(R.styleable.bf, 0);
    Resources localResources = getResources();
    this.jdField_c_of_type_Int = localResources.getDimensionPixelSize(R.dimen.v);
    this.jdField_c_of_type_Float = localResources.getDimensionPixelSize(R.dimen.t);
    paramInt = paramAttributeSet.getColor(R.styleable.bd, 0);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    a(0.0F);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    ViewCompat.setImportantForAccessibility(this, 2);
    paramAttributeSet.recycle();
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    int i = getWidth() / 2;
    int j = getHeight() / 2;
    double d1 = paramFloat1 - i;
    j = (int)Math.toDegrees(Math.atan2(paramFloat2 - j, d1)) + 90;
    i = j;
    if (j < 0) {
      i = j + 360;
    }
    return i;
  }
  
  private Pair<Float, Float> a(float paramFloat)
  {
    float f4 = a();
    float f3 = f4;
    float f2 = paramFloat;
    if (Math.abs(f4 - paramFloat) > 180.0F)
    {
      float f1 = paramFloat;
      if (f4 > 180.0F)
      {
        f1 = paramFloat;
        if (paramFloat < 180.0F) {
          f1 = paramFloat + 360.0F;
        }
      }
      f3 = f4;
      f2 = f1;
      if (f4 < 180.0F)
      {
        f3 = f4;
        f2 = f1;
        if (f1 > 180.0F)
        {
          f3 = f4 + 360.0F;
          f2 = f1;
        }
      }
    }
    return new Pair(Float.valueOf(f3), Float.valueOf(f2));
  }
  
  private void a(Canvas paramCanvas)
  {
    int i = getHeight() / 2;
    int j = getWidth() / 2;
    float f1 = j;
    float f3 = this.jdField_d_of_type_Int;
    float f4 = (float)Math.cos(this.jdField_a_of_type_Double);
    float f2 = i;
    float f5 = this.jdField_d_of_type_Int;
    float f6 = (float)Math.sin(this.jdField_a_of_type_Double);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(0.0F);
    paramCanvas.drawCircle(f3 * f4 + f1, f5 * f6 + f2, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    double d1 = Math.sin(this.jdField_a_of_type_Double);
    double d2 = Math.cos(this.jdField_a_of_type_Double);
    double d3 = this.jdField_d_of_type_Int - this.jdField_b_of_type_Int;
    Double.isNaN(d3);
    f3 = j + (int)(d2 * d3);
    Double.isNaN(d3);
    f4 = i + (int)(d3 * d1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_c_of_type_Int);
    paramCanvas.drawLine(f1, f2, f3, f4, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawCircle(f1, f2, this.jdField_c_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = a(paramFloat1, paramFloat2);
    paramFloat1 = a();
    paramFloat2 = i;
    boolean bool = false;
    if (paramFloat1 != paramFloat2) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramBoolean2) && (i != 0)) {
      return true;
    }
    if ((i == 0) && (!paramBoolean1)) {
      return false;
    }
    paramBoolean1 = bool;
    if (paramBoolean3)
    {
      paramBoolean1 = bool;
      if (this.jdField_a_of_type_Boolean) {
        paramBoolean1 = true;
      }
    }
    a(paramFloat2, paramBoolean1);
    return true;
  }
  
  private void b(@FloatRange(from=0.0D, to=360.0D) float paramFloat, boolean paramBoolean)
  {
    paramFloat %= 360.0F;
    this.jdField_d_of_type_Float = paramFloat;
    this.jdField_a_of_type_Double = Math.toRadians(this.jdField_d_of_type_Float - 90.0F);
    int i = getHeight() / 2;
    float f1 = getWidth() / 2 + this.jdField_d_of_type_Int * (float)Math.cos(this.jdField_a_of_type_Double);
    float f2 = i + this.jdField_d_of_type_Int * (float)Math.sin(this.jdField_a_of_type_Double);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    i = this.jdField_b_of_type_Int;
    ((RectF)localObject).set(f1 - i, f2 - i, f1 + i, f2 + i);
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ClockHandView.OnRotateListener)((Iterator)localObject).next()).a(paramFloat, paramBoolean);
    }
    invalidate();
  }
  
  @FloatRange(from=0.0D, to=360.0D)
  public float a()
  {
    return this.jdField_d_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public void a(@FloatRange(from=0.0D, to=360.0D) float paramFloat)
  {
    a(paramFloat, false);
  }
  
  public void a(@FloatRange(from=0.0D, to=360.0D) float paramFloat, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
    if (!paramBoolean)
    {
      b(paramFloat, false);
      return;
    }
    localObject = a(paramFloat);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { ((Float)((Pair)localObject).first).floatValue(), ((Float)((Pair)localObject).second).floatValue() });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ClockHandView.1(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new ClockHandView.2(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void a(@Dimension int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    invalidate();
  }
  
  public void a(ClockHandView.OnActionUpListener paramOnActionUpListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockHandView$OnActionUpListener = paramOnActionUpListener;
  }
  
  public void a(ClockHandView.OnRotateListener paramOnRotateListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramOnRotateListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a(a());
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i != 0)
    {
      if ((i != 1) && (i != 2))
      {
        bool2 = false;
        bool1 = false;
      }
      for (;;)
      {
        bool3 = false;
        break;
        int j = (int)(f1 - this.jdField_a_of_type_Float);
        int k = (int)(f2 - this.jdField_b_of_type_Float);
        if (j * j + k * k > this.jdField_a_of_type_Int) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.jdField_b_of_type_Boolean = bool1;
        bool1 = this.jdField_c_of_type_Boolean;
        if (i == 1) {
          bool2 = true;
        } else {
          bool2 = false;
        }
      }
    }
    this.jdField_a_of_type_Float = f1;
    this.jdField_b_of_type_Float = f2;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = true;
    boolean bool4 = this.jdField_c_of_type_Boolean;
    this.jdField_c_of_type_Boolean = (a(f1, f2, bool1, bool3, bool2) | bool4);
    if ((this.jdField_c_of_type_Boolean) && (bool2))
    {
      paramMotionEvent = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockHandView$OnActionUpListener;
      if (paramMotionEvent != null) {
        paramMotionEvent.b(a(f1, f2), this.jdField_b_of_type_Boolean);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.timepicker.ClockHandView
 * JD-Core Version:    0.7.0.1
 */