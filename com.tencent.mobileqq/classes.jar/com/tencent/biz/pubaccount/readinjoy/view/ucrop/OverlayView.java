package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import sxc;
import sxg;

public class OverlayView
  extends View
{
  private float jdField_a_of_type_Float;
  protected int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private sxc jdField_a_of_type_Sxc;
  private boolean jdField_a_of_type_Boolean;
  protected float[] a;
  private float jdField_b_of_type_Float = -1.0F;
  protected int b;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean;
  protected float[] b;
  private float jdField_c_of_type_Float = -1.0F;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
  private boolean jdField_c_of_type_Boolean;
  private float[] jdField_c_of_type_ArrayOfFloat;
  private int jdField_d_of_type_Int;
  private Paint jdField_d_of_type_AndroidGraphicsPaint = new Paint(1);
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f = 0;
  private int g = -1;
  private int h = getResources().getDimensionPixelSize(2131299086);
  private int i = getResources().getDimensionPixelSize(2131299087);
  private int j = getResources().getDimensionPixelSize(2131299085);
  
  public OverlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OverlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OverlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    int k = -1;
    double d1 = this.h;
    int m = 0;
    if (m < 8)
    {
      double d2 = Math.sqrt(Math.pow(paramFloat1 - this.jdField_a_of_type_ArrayOfFloat[m], 2.0D) + Math.pow(paramFloat2 - this.jdField_a_of_type_ArrayOfFloat[(m + 1)], 2.0D));
      if (d2 >= d1) {
        break label127;
      }
      k = m / 2;
      d1 = d2;
    }
    label127:
    for (;;)
    {
      m += 2;
      break;
      m = k;
      if (this.f == 1)
      {
        m = k;
        if (k < 0)
        {
          m = k;
          if (this.jdField_a_of_type_AndroidGraphicsRectF.contains(paramFloat1, paramFloat2)) {
            m = 4;
          }
        }
      }
      return m;
    }
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    int m = 1;
    this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
    int k;
    label71:
    label87:
    RectF localRectF;
    label106:
    label119:
    float f1;
    switch (this.g)
    {
    default: 
      if (this.jdField_b_of_type_AndroidGraphicsRectF.height() >= this.i)
      {
        k = 1;
        if (this.jdField_b_of_type_AndroidGraphicsRectF.width() < this.i) {
          break label388;
        }
        localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
        if (m == 0) {
          break label394;
        }
        paramFloat1 = this.jdField_b_of_type_AndroidGraphicsRectF.left;
        if (k == 0) {
          break label405;
        }
        paramFloat2 = this.jdField_b_of_type_AndroidGraphicsRectF.top;
        if (m == 0) {
          break label416;
        }
        f1 = this.jdField_b_of_type_AndroidGraphicsRectF.right;
        label132:
        if (k == 0) {
          break label427;
        }
      }
      break;
    }
    label388:
    label394:
    label405:
    label416:
    label427:
    for (float f2 = this.jdField_b_of_type_AndroidGraphicsRectF.bottom;; f2 = this.jdField_a_of_type_AndroidGraphicsRectF.bottom)
    {
      localRectF.set(paramFloat1, paramFloat2, f1, f2);
      if ((k != 0) || (m != 0))
      {
        b();
        postInvalidate();
      }
      do
      {
        return;
        this.jdField_b_of_type_AndroidGraphicsRectF.set(paramFloat1, paramFloat2, this.jdField_a_of_type_AndroidGraphicsRectF.right, this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
        break;
        this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF.left, paramFloat2, paramFloat1, this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
        break;
        this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF.left, this.jdField_a_of_type_AndroidGraphicsRectF.top, paramFloat1, paramFloat2);
        break;
        this.jdField_b_of_type_AndroidGraphicsRectF.set(paramFloat1, this.jdField_a_of_type_AndroidGraphicsRectF.top, this.jdField_a_of_type_AndroidGraphicsRectF.right, paramFloat2);
        break;
        this.jdField_b_of_type_AndroidGraphicsRectF.offset(paramFloat1 - this.jdField_b_of_type_Float, paramFloat2 - this.jdField_c_of_type_Float);
      } while ((this.jdField_b_of_type_AndroidGraphicsRectF.left <= getLeft()) || (this.jdField_b_of_type_AndroidGraphicsRectF.top <= getTop()) || (this.jdField_b_of_type_AndroidGraphicsRectF.right >= getRight()) || (this.jdField_b_of_type_AndroidGraphicsRectF.bottom >= getBottom()));
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_AndroidGraphicsRectF);
      b();
      postInvalidate();
      return;
      k = 0;
      break label71;
      m = 0;
      break label87;
      paramFloat1 = this.jdField_a_of_type_AndroidGraphicsRectF.left;
      break label106;
      paramFloat2 = this.jdField_a_of_type_AndroidGraphicsRectF.top;
      break label119;
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.right;
      break label132;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ArrayOfFloat = sxg.a(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_b_of_type_ArrayOfFloat = sxg.b(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_c_of_type_ArrayOfFloat = null;
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.addCircle(this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), Math.min(this.jdField_a_of_type_AndroidGraphicsRectF.width(), this.jdField_a_of_type_AndroidGraphicsRectF.height()) / 2.0F, Path.Direction.CW);
  }
  
  private void b(@NonNull TypedArray paramTypedArray)
  {
    int k = paramTypedArray.getDimensionPixelSize(5, getResources().getDimensionPixelSize(2131299082));
    int m = paramTypedArray.getColor(4, getResources().getColor(2131167268));
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(k);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(m);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(k * 3);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(m);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
  }
  
  private void c(@NonNull TypedArray paramTypedArray)
  {
    int k = paramTypedArray.getDimensionPixelSize(9, getResources().getDimensionPixelSize(2131299083));
    int m = paramTypedArray.getColor(6, getResources().getColor(2131167269));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(k);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(m);
    this.jdField_c_of_type_Int = paramTypedArray.getInt(8, 2);
    this.jdField_d_of_type_Int = paramTypedArray.getInt(7, 2);
  }
  
  @NonNull
  public RectF a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  protected void a()
  {
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
  }
  
  protected void a(@NonNull TypedArray paramTypedArray)
  {
    this.jdField_c_of_type_Boolean = paramTypedArray.getBoolean(2, false);
    this.e = paramTypedArray.getColor(3, getResources().getColor(2131167270));
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    b(paramTypedArray);
    this.jdField_a_of_type_Boolean = paramTypedArray.getBoolean(10, true);
    c(paramTypedArray);
    this.jdField_b_of_type_Boolean = paramTypedArray.getBoolean(11, true);
  }
  
  protected void a(@NonNull Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.jdField_c_of_type_Boolean) {
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath, Region.Op.DIFFERENCE);
    }
    for (;;)
    {
      paramCanvas.drawColor(this.e);
      paramCanvas.restore();
      if (this.jdField_c_of_type_Boolean) {
        paramCanvas.drawCircle(this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), Math.min(this.jdField_a_of_type_AndroidGraphicsRectF.width(), this.jdField_a_of_type_AndroidGraphicsRectF.height()) / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      return;
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF, Region.Op.DIFFERENCE);
    }
  }
  
  protected void b(@NonNull Canvas paramCanvas)
  {
    int i2 = 0;
    if (this.jdField_b_of_type_Boolean)
    {
      if ((this.jdField_c_of_type_ArrayOfFloat == null) && (!this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty()))
      {
        this.jdField_c_of_type_ArrayOfFloat = new float[this.jdField_c_of_type_Int * 4 + this.jdField_d_of_type_Int * 4];
        int m = 0;
        int k = 0;
        int n;
        int i1;
        float[] arrayOfFloat;
        for (;;)
        {
          n = i2;
          i1 = k;
          if (m >= this.jdField_c_of_type_Int) {
            break;
          }
          arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
          n = k + 1;
          arrayOfFloat[k] = this.jdField_a_of_type_AndroidGraphicsRectF.left;
          arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
          k = n + 1;
          arrayOfFloat[n] = (this.jdField_a_of_type_AndroidGraphicsRectF.height() * ((m + 1.0F) / (this.jdField_c_of_type_Int + 1)) + this.jdField_a_of_type_AndroidGraphicsRectF.top);
          arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
          n = k + 1;
          arrayOfFloat[k] = this.jdField_a_of_type_AndroidGraphicsRectF.right;
          arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
          k = n + 1;
          arrayOfFloat[n] = (this.jdField_a_of_type_AndroidGraphicsRectF.height() * ((m + 1.0F) / (this.jdField_c_of_type_Int + 1)) + this.jdField_a_of_type_AndroidGraphicsRectF.top);
          m += 1;
        }
        while (n < this.jdField_d_of_type_Int)
        {
          arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
          k = i1 + 1;
          arrayOfFloat[i1] = (this.jdField_a_of_type_AndroidGraphicsRectF.width() * ((n + 1.0F) / (this.jdField_d_of_type_Int + 1)) + this.jdField_a_of_type_AndroidGraphicsRectF.left);
          arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
          m = k + 1;
          arrayOfFloat[k] = this.jdField_a_of_type_AndroidGraphicsRectF.top;
          arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
          k = m + 1;
          arrayOfFloat[m] = (this.jdField_a_of_type_AndroidGraphicsRectF.width() * ((n + 1.0F) / (this.jdField_d_of_type_Int + 1)) + this.jdField_a_of_type_AndroidGraphicsRectF.left);
          arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
          i1 = k + 1;
          arrayOfFloat[k] = this.jdField_a_of_type_AndroidGraphicsRectF.bottom;
          n += 1;
        }
      }
      if (this.jdField_c_of_type_ArrayOfFloat != null) {
        paramCanvas.drawLines(this.jdField_c_of_type_ArrayOfFloat, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
    }
    if (this.jdField_a_of_type_Boolean) {
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    if (this.f != 0)
    {
      paramCanvas.save();
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
      this.jdField_b_of_type_AndroidGraphicsRectF.inset(this.j, -this.j);
      paramCanvas.clipRect(this.jdField_b_of_type_AndroidGraphicsRectF, Region.Op.DIFFERENCE);
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
      this.jdField_b_of_type_AndroidGraphicsRectF.inset(-this.j, this.j);
      paramCanvas.clipRect(this.jdField_b_of_type_AndroidGraphicsRectF, Region.Op.DIFFERENCE);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
    b(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      paramInt1 = getPaddingLeft();
      paramInt2 = getPaddingTop();
      paramInt3 = getWidth();
      paramInt4 = getPaddingRight();
      int k = getHeight();
      int m = getPaddingBottom();
      this.jdField_a_of_type_Int = (paramInt3 - paramInt4 - paramInt1);
      this.jdField_b_of_type_Int = (k - m - paramInt2);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        setTargetAspectRatio(this.jdField_a_of_type_Float);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty()) || (this.f == 0)) {
      bool2 = false;
    }
    float f2;
    float f1;
    do
    {
      return bool2;
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      if ((paramMotionEvent.getAction() & 0xFF) != 0) {
        break;
      }
      this.g = a(f2, f1);
      if (this.g != -1) {}
      while (!bool1)
      {
        this.jdField_b_of_type_Float = -1.0F;
        this.jdField_c_of_type_Float = -1.0F;
        return bool1;
        bool1 = false;
      }
      bool2 = bool1;
    } while (this.jdField_b_of_type_Float >= 0.0F);
    this.jdField_b_of_type_Float = f2;
    this.jdField_c_of_type_Float = f1;
    return bool1;
    if (((paramMotionEvent.getAction() & 0xFF) == 2) && (paramMotionEvent.getPointerCount() == 1) && (this.g != -1))
    {
      f2 = Math.min(Math.max(f2, getPaddingLeft()), getWidth() - getPaddingRight());
      f1 = Math.min(Math.max(f1, getPaddingTop()), getHeight() - getPaddingBottom());
      a(f2, f1);
      this.jdField_b_of_type_Float = f2;
      this.jdField_c_of_type_Float = f1;
      return true;
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 1)
    {
      this.jdField_b_of_type_Float = -1.0F;
      this.jdField_c_of_type_Float = -1.0F;
      this.g = -1;
      if (this.jdField_a_of_type_Sxc != null) {
        this.jdField_a_of_type_Sxc.a(this.jdField_a_of_type_AndroidGraphicsRectF);
      }
    }
    return false;
  }
  
  public void setCircleDimmedLayer(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setCropFrameColor(@ColorInt int paramInt)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public void setCropFrameStrokeWidth(@IntRange(from=0L) int paramInt)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(paramInt);
  }
  
  public void setCropGridColor(@ColorInt int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public void setCropGridColumnCount(@IntRange(from=0L) int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_c_of_type_ArrayOfFloat = null;
  }
  
  public void setCropGridRowCount(@IntRange(from=0L) int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_c_of_type_ArrayOfFloat = null;
  }
  
  public void setCropGridStrokeWidth(@IntRange(from=0L) int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(paramInt);
  }
  
  public void setDimmedColor(@ColorInt int paramInt)
  {
    this.e = paramInt;
  }
  
  @Deprecated
  public void setFreestyleCropEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int k = 1;; k = 0)
    {
      this.f = k;
      return;
    }
  }
  
  public void setFreestyleCropMode(int paramInt)
  {
    this.f = paramInt;
    postInvalidate();
  }
  
  public void setOverlayViewChangeListener(sxc paramsxc)
  {
    this.jdField_a_of_type_Sxc = paramsxc;
  }
  
  public void setShowCropFrame(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setShowCropGrid(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setTargetAspectRatio(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Int > 0)
    {
      setupCropBounds();
      postInvalidate();
      return;
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void setupCropBounds()
  {
    int k = (int)(this.jdField_a_of_type_Int / this.jdField_a_of_type_Float);
    int m;
    if (k > this.jdField_b_of_type_Int)
    {
      k = (int)(this.jdField_b_of_type_Int * this.jdField_a_of_type_Float);
      m = (this.jdField_a_of_type_Int - k) / 2;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(getPaddingLeft() + m, getPaddingTop(), k + getPaddingLeft() + m, getPaddingTop() + this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Sxc != null) {
        this.jdField_a_of_type_Sxc.a(this.jdField_a_of_type_AndroidGraphicsRectF);
      }
      b();
      return;
      m = (this.jdField_b_of_type_Int - k) / 2;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(getPaddingLeft(), getPaddingTop() + m, getPaddingLeft() + this.jdField_a_of_type_Int, k + getPaddingTop() + m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.OverlayView
 * JD-Core Version:    0.7.0.1
 */