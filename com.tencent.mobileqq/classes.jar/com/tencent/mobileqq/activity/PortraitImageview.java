package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.mobileqq.activity.photo.RegionView;

@SuppressLint({"NewApi"})
public class PortraitImageview
  extends View
{
  private static int i = 20;
  private double jdField_a_of_type_Double = 0.0D;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  PortraitImageview.OnImageTouchedListener jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview$OnImageTouchedListener;
  RegionView jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private Runnable jdField_b_of_type_JavaLangRunnable = null;
  private float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  private Matrix jdField_c_of_type_AndroidGraphicsMatrix = new Matrix();
  RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private Runnable jdField_c_of_type_JavaLangRunnable = null;
  private float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  private Matrix jdField_d_of_type_AndroidGraphicsMatrix = new Matrix();
  private float jdField_e_of_type_Float;
  int jdField_e_of_type_Int;
  private Matrix jdField_e_of_type_AndroidGraphicsMatrix = new Matrix();
  private float jdField_f_of_type_Float;
  int jdField_f_of_type_Int;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int = -1;
  private int h = -1;
  private int j = -1;
  
  public PortraitImageview(Context paramContext)
  {
    this(paramContext, null);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public PortraitImageview(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PortraitImageview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a(RectF paramRectF1, RectF paramRectF2)
  {
    if (paramRectF1.left > paramRectF2.left) {
      m = 1;
    } else {
      m = 0;
    }
    int k = m;
    if (paramRectF1.right < paramRectF2.right) {
      k = m | 0x2;
    }
    int m = k;
    if (paramRectF1.top > paramRectF2.top) {
      m = k | 0x4;
    }
    k = m;
    if (paramRectF1.bottom < paramRectF2.bottom) {
      k = m | 0x8;
    }
    return k;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_JavaLangRunnable = new PortraitImageview.1(this);
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, new PortraitImageview.ScaleListener(this));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new PortraitImageview.MyGestureListener(this, null));
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(2, null);
    }
  }
  
  private void a(Bitmap paramBitmap, Matrix paramMatrix)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    paramMatrix.reset();
    float f3 = this.jdField_c_of_type_Int / paramBitmap.getWidth();
    float f4 = this.jdField_d_of_type_Int / paramBitmap.getHeight();
    if ((f3 < 1.0F) && (f4 < 1.0F))
    {
      float f5 = f1 / paramBitmap.getWidth();
      float f6 = f2 / paramBitmap.getHeight();
      this.jdField_b_of_type_Float = Math.min(f5, f5);
      float f7 = this.jdField_b_of_type_Float;
      if (f7 >= 1.0F) {
        this.jdField_b_of_type_Float = 1.0F;
      } else if ((f7 < f3) || (f7 < f4)) {
        this.jdField_b_of_type_Float = Math.max(f5, f6);
      }
    }
    else
    {
      this.jdField_b_of_type_Float = Math.max(f3, f4);
    }
    f3 = this.jdField_b_of_type_Float;
    paramMatrix.setScale(f3, f3);
    paramMatrix.postTranslate((f1 - paramBitmap.getWidth() * this.jdField_b_of_type_Float) / 2.0F, (f2 - paramBitmap.getHeight() * this.jdField_b_of_type_Float) / 2.0F);
    RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
    localRectF.left = 0.0F;
    localRectF.right = (localRectF.left + paramBitmap.getWidth());
    localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
    localRectF.top = 0.0F;
    localRectF.bottom = (localRectF.top + paramBitmap.getHeight());
    paramMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF);
  }
  
  public float a()
  {
    return a(this.jdField_b_of_type_AndroidGraphicsMatrix);
  }
  
  float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat1 / paramFloat4 - 1.0F;
    return paramFloat3 * (paramFloat1 * paramFloat1 * paramFloat1 + 1.0F) + paramFloat2;
  }
  
  protected float a(Matrix paramMatrix)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return a(paramMatrix, 0);
    }
    return 1.0F;
  }
  
  protected float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    return this.jdField_a_of_type_ArrayOfFloat[paramInt];
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public Matrix a()
  {
    this.jdField_c_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_c_of_type_AndroidGraphicsMatrix.postConcat(this.jdField_b_of_type_AndroidGraphicsMatrix);
    return this.jdField_c_of_type_AndroidGraphicsMatrix;
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public void a(float paramFloat)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    a(paramFloat, f1 / 2.0F, f2 / 2.0F);
  }
  
  protected void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_e_of_type_AndroidGraphicsMatrix.set(this.jdField_b_of_type_AndroidGraphicsMatrix);
    this.jdField_e_of_type_AndroidGraphicsMatrix.postTranslate(paramFloat1, paramFloat2);
    this.jdField_e_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
    int k = a(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsRectF);
    if (((k & 0x1) == 0) && ((k & 0x2) == 0)) {
      this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(paramFloat1, 0.0F);
    }
    if (((k & 0x4) == 0) && ((k & 0x8) == 0)) {
      this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(0.0F, paramFloat2);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f2 = this.jdField_c_of_type_Float;
    float f1 = paramFloat1;
    if (paramFloat1 > f2) {
      f1 = f2;
    }
    b(f1 / a(), paramFloat2, paramFloat3);
    setImageMatrix(a());
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = (paramFloat1 - a()) / paramFloat4;
    float f1 = a();
    post(new PortraitImageview.3(this, paramFloat4, System.currentTimeMillis(), f1, paramFloat1, paramFloat2, paramFloat3));
  }
  
  protected float b()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap == null) {
      return 1.0F;
    }
    return Math.max(localBitmap.getWidth() / this.jdField_g_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / this.h) * 16.0F;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  protected void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramFloat3;
    if (paramFloat3 > this.jdField_a_of_type_AndroidGraphicsRectF.bottom) {
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.bottom;
    }
    float f2 = f1;
    if (f1 < this.jdField_a_of_type_AndroidGraphicsRectF.top) {
      f2 = this.jdField_a_of_type_AndroidGraphicsRectF.top;
    }
    paramFloat3 = paramFloat2;
    if (paramFloat2 > this.jdField_a_of_type_AndroidGraphicsRectF.right) {
      paramFloat3 = this.jdField_a_of_type_AndroidGraphicsRectF.right;
    }
    paramFloat2 = paramFloat3;
    if (paramFloat3 < this.jdField_a_of_type_AndroidGraphicsRectF.left) {
      paramFloat2 = this.jdField_a_of_type_AndroidGraphicsRectF.left;
    }
    this.jdField_e_of_type_AndroidGraphicsMatrix.set(this.jdField_b_of_type_AndroidGraphicsMatrix);
    this.jdField_e_of_type_AndroidGraphicsMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, f2);
    this.jdField_e_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
    if (a(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsRectF) == 0)
    {
      this.jdField_b_of_type_AndroidGraphicsMatrix.set(this.jdField_e_of_type_AndroidGraphicsMatrix);
      return;
    }
    if ((this.jdField_c_of_type_AndroidGraphicsRectF.width() / this.jdField_a_of_type_AndroidGraphicsRectF.width() >= 1.0F) && (this.jdField_c_of_type_AndroidGraphicsRectF.height() / this.jdField_a_of_type_AndroidGraphicsRectF.height() >= 1.0F))
    {
      this.jdField_b_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
      paramFloat2 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_c_of_type_AndroidGraphicsRectF.width();
      paramFloat3 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_c_of_type_AndroidGraphicsRectF.height();
      if (paramFloat2 < paramFloat3) {
        paramFloat2 = paramFloat3;
      }
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.centerX();
      f2 = this.jdField_c_of_type_AndroidGraphicsRectF.centerX();
      paramFloat3 = 1.0F - paramFloat2;
      f1 = (f1 - f2 * paramFloat2) / paramFloat3;
      paramFloat2 = (this.jdField_a_of_type_AndroidGraphicsRectF.centerY() - this.jdField_c_of_type_AndroidGraphicsRectF.centerY() * paramFloat2) / paramFloat3;
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(paramFloat1, paramFloat1, f1, paramFloat2);
    }
  }
  
  public float c()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap == null) {
      return 1.0F;
    }
    return Math.max(Math.min(this.jdField_g_of_type_Int / localBitmap.getWidth(), this.h / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()), 1.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = paramCanvas.save();
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      if ((Build.VERSION.SDK_INT >= 11) && (getLayerType() == 2))
      {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_AndroidGraphicsMatrix, null);
      }
      else
      {
        double d1 = System.currentTimeMillis();
        double d2 = this.jdField_a_of_type_Double;
        Double.isNaN(d1);
        if (d1 - d2 > 250.0D)
        {
          paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_Double = System.currentTimeMillis();
        }
        else
        {
          paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_AndroidGraphicsMatrix, null);
          removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
          postDelayed(this.jdField_c_of_type_JavaLangRunnable, 250L);
        }
      }
    }
    paramCanvas.restoreToCount(k);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_g_of_type_Int = (paramInt3 - paramInt1);
    this.h = (paramInt4 - paramInt2);
    Object localObject = this.jdField_b_of_type_JavaLangRunnable;
    if (localObject != null)
    {
      this.jdField_b_of_type_JavaLangRunnable = null;
      ((Runnable)localObject).run();
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      a((Bitmap)localObject, this.jdField_a_of_type_AndroidGraphicsMatrix);
      setImageMatrix(a());
    }
    this.jdField_a_of_type_Int = (getWidth() / 2);
    this.jdField_b_of_type_Int = (getHeight() / 2);
    setRestrict(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    paramInt1 = this.jdField_a_of_type_Int;
    paramInt2 = this.jdField_c_of_type_Int;
    ((RectF)localObject).left = (paramInt1 - paramInt2 / 2);
    ((RectF)localObject).right = (paramInt1 + paramInt2 / 2);
    paramInt1 = this.jdField_b_of_type_Int;
    paramInt2 = this.jdField_d_of_type_Int;
    ((RectF)localObject).top = (paramInt1 - paramInt2 / 2);
    ((RectF)localObject).bottom = (paramInt1 + paramInt2 / 2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
      if (!this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress()) {
        this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      }
      int m = paramMotionEvent.getAction() & 0xFF;
      int k = 0;
      float f1;
      float f2;
      if (m != 0)
      {
        if (m != 1)
        {
          if (m != 2)
          {
            if (m != 3)
            {
              if (m != 6) {
                return true;
              }
              m = (paramMotionEvent.getAction() & 0xFF00) >> 8;
              if (paramMotionEvent.getPointerId(m) == this.j)
              {
                if (m == 0) {
                  k = 1;
                }
                this.jdField_f_of_type_Float = paramMotionEvent.getX(k);
                this.jdField_g_of_type_Float = paramMotionEvent.getY(k);
                this.j = paramMotionEvent.getPointerId(k);
                return true;
              }
            }
            else
            {
              this.j = -1;
              return true;
            }
          }
          else
          {
            k = paramMotionEvent.findPointerIndex(this.j);
            if ((k != -1) && (k < paramMotionEvent.getPointerCount()))
            {
              f1 = paramMotionEvent.getX(k);
              f2 = paramMotionEvent.getY(k);
              if (!this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress())
              {
                float f3 = f1 - this.jdField_f_of_type_Float;
                float f4 = f2 - this.jdField_g_of_type_Float;
                if (this.jdField_a_of_type_AndroidGraphicsRectF != null)
                {
                  this.jdField_d_of_type_Float += f3;
                  this.jdField_e_of_type_Float += f4;
                }
                else
                {
                  this.jdField_d_of_type_Float += f3;
                  this.jdField_e_of_type_Float += f4;
                }
                invalidate();
              }
              this.jdField_f_of_type_Float = f1;
              this.jdField_g_of_type_Float = f2;
              return true;
            }
          }
        }
        else
        {
          this.j = -1;
          return true;
        }
      }
      else
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.jdField_f_of_type_Float = f1;
        this.jdField_g_of_type_Float = f2;
        this.j = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      }
    }
    return true;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    if (getWidth() <= 0)
    {
      this.jdField_b_of_type_JavaLangRunnable = new PortraitImageview.2(this, paramBitmap);
      return;
    }
    if (paramBitmap != null)
    {
      a(paramBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix);
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    }
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    setImageMatrix(a());
    this.jdField_c_of_type_Float = b();
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    Matrix localMatrix = paramMatrix;
    if (paramMatrix != null)
    {
      localMatrix = paramMatrix;
      if (paramMatrix.isIdentity()) {
        localMatrix = null;
      }
    }
    if (((localMatrix == null) && (!this.jdField_d_of_type_AndroidGraphicsMatrix.isIdentity())) || ((localMatrix != null) && (!this.jdField_d_of_type_AndroidGraphicsMatrix.equals(localMatrix))))
    {
      this.jdField_d_of_type_AndroidGraphicsMatrix.set(localMatrix);
      invalidate();
    }
  }
  
  public void setOnImageTouchedListener(PortraitImageview.OnImageTouchedListener paramOnImageTouchedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview$OnImageTouchedListener = paramOnImageTouchedListener;
  }
  
  public void setRegionView(RegionView paramRegionView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView = paramRegionView;
  }
  
  public void setRestrict(int paramInt1, int paramInt2)
  {
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_f_of_type_Int = paramInt2;
    paramInt1 = this.jdField_g_of_type_Int;
    if ((paramInt1 > 0) && ((this.jdField_e_of_type_Int > paramInt1) || (this.jdField_f_of_type_Int > this.h)))
    {
      float f2 = this.jdField_g_of_type_Int;
      paramInt2 = i;
      float f3 = paramInt2;
      float f1 = this.jdField_a_of_type_Float;
      paramInt1 = this.jdField_e_of_type_Int;
      f2 = (f2 - f3 * f1) / paramInt1;
      f3 = this.h;
      float f4 = paramInt2;
      paramInt2 = this.jdField_f_of_type_Int;
      f1 = (f3 - f4 * f1) / paramInt2;
      if (f2 <= f1)
      {
        this.jdField_c_of_type_Int = ((int)(paramInt1 * f2));
        this.jdField_d_of_type_Int = ((int)(paramInt2 * f2));
        return;
      }
      this.jdField_c_of_type_Int = ((int)(paramInt1 * f1));
      this.jdField_d_of_type_Int = ((int)(paramInt2 * f1));
      return;
    }
    this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
    this.jdField_d_of_type_Int = this.jdField_f_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PortraitImageview
 * JD-Core Version:    0.7.0.1
 */