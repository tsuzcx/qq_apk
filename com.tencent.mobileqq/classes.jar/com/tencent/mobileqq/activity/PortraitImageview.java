package com.tencent.mobileqq.activity;

import adnp;
import adnq;
import adnr;
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
  private double jdField_a_of_type_Double;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  public adnq a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public ScaleGestureDetector a;
  RegionView jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView;
  public Runnable a;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  private Matrix jdField_c_of_type_AndroidGraphicsMatrix = new Matrix();
  RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private Runnable jdField_c_of_type_JavaLangRunnable;
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
    this.jdField_a_of_type_JavaLangRunnable = null;
    a(paramContext);
  }
  
  private int a(RectF paramRectF1, RectF paramRectF2)
  {
    int m = 0;
    if (paramRectF1.left > paramRectF2.left) {
      m = 1;
    }
    int k = m;
    if (paramRectF1.right < paramRectF2.right) {
      k = m | 0x2;
    }
    m = k;
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
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, new adnr(this));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new adnp(this, null));
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
    if ((f3 >= 1.0F) || (f4 >= 1.0F)) {
      this.jdField_b_of_type_Float = Math.max(f3, f4);
    }
    for (;;)
    {
      paramMatrix.setScale(this.jdField_b_of_type_Float, this.jdField_b_of_type_Float);
      paramMatrix.postTranslate((f1 - paramBitmap.getWidth() * this.jdField_b_of_type_Float) / 2.0F, (f2 - paramBitmap.getHeight() * this.jdField_b_of_type_Float) / 2.0F);
      this.jdField_b_of_type_AndroidGraphicsRectF.left = 0.0F;
      this.jdField_b_of_type_AndroidGraphicsRectF.right = (this.jdField_b_of_type_AndroidGraphicsRectF.left + paramBitmap.getWidth());
      this.jdField_b_of_type_AndroidGraphicsRectF.top = 0.0F;
      this.jdField_b_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_AndroidGraphicsRectF.top + paramBitmap.getHeight());
      paramMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF);
      return;
      float f5 = f1 / paramBitmap.getWidth();
      float f6 = f2 / paramBitmap.getHeight();
      this.jdField_b_of_type_Float = Math.min(f5, f5);
      if (this.jdField_b_of_type_Float >= 1.0F) {
        this.jdField_b_of_type_Float = 1.0F;
      } else if ((this.jdField_b_of_type_Float < f3) || (this.jdField_b_of_type_Float < f4)) {
        this.jdField_b_of_type_Float = Math.max(f5, f6);
      }
    }
  }
  
  public float a()
  {
    return a(this.jdField_b_of_type_AndroidGraphicsMatrix);
  }
  
  float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat1 / paramFloat4 - 1.0F;
    return (paramFloat1 * (paramFloat1 * paramFloat1) + 1.0F) * paramFloat3 + paramFloat2;
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
  
  public void a(float paramFloat1, float paramFloat2)
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
    float f1 = paramFloat1;
    if (paramFloat1 > this.jdField_c_of_type_Float) {
      f1 = this.jdField_c_of_type_Float;
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
  
  public float b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return 1.0F;
    }
    return Math.max(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / this.jdField_g_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / this.h) * 16.0F;
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
    if (a(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsRectF) == 0) {
      this.jdField_b_of_type_AndroidGraphicsMatrix.set(this.jdField_e_of_type_AndroidGraphicsMatrix);
    }
    while ((this.jdField_c_of_type_AndroidGraphicsRectF.width() / this.jdField_a_of_type_AndroidGraphicsRectF.width() < 1.0F) || (this.jdField_c_of_type_AndroidGraphicsRectF.height() / this.jdField_a_of_type_AndroidGraphicsRectF.height() < 1.0F)) {
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
    paramFloat2 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_c_of_type_AndroidGraphicsRectF.width();
    paramFloat3 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_c_of_type_AndroidGraphicsRectF.height();
    if (paramFloat2 >= paramFloat3) {}
    for (;;)
    {
      paramFloat3 = (this.jdField_a_of_type_AndroidGraphicsRectF.centerX() - this.jdField_c_of_type_AndroidGraphicsRectF.centerX() * paramFloat2) / (1.0F - paramFloat2);
      paramFloat2 = (this.jdField_a_of_type_AndroidGraphicsRectF.centerY() - this.jdField_c_of_type_AndroidGraphicsRectF.centerY() * paramFloat2) / (1.0F - paramFloat2);
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(paramFloat1, paramFloat1, paramFloat3, paramFloat2);
      return;
      paramFloat2 = paramFloat3;
    }
  }
  
  public float c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return 1.0F;
    }
    return Math.max(Math.min(this.jdField_g_of_type_Int / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.h / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()), 1.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = paramCanvas.save();
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      if ((Build.VERSION.SDK_INT < 11) || (getLayerType() != 2)) {
        break label57;
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_AndroidGraphicsMatrix, null);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(k);
      return;
      label57:
      if (System.currentTimeMillis() - this.jdField_a_of_type_Double > 250.0D)
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
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_g_of_type_Int = (paramInt3 - paramInt1);
    this.h = (paramInt4 - paramInt2);
    Runnable localRunnable = this.jdField_b_of_type_JavaLangRunnable;
    if (localRunnable != null)
    {
      this.jdField_b_of_type_JavaLangRunnable = null;
      localRunnable.run();
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix);
      setImageMatrix(a());
    }
    this.jdField_a_of_type_Int = (getWidth() / 2);
    this.jdField_b_of_type_Int = (getHeight() / 2);
    setRestrict(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.jdField_a_of_type_Int - this.jdField_c_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_Int + this.jdField_c_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.jdField_b_of_type_Int - this.jdField_d_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_Int + this.jdField_d_of_type_Int / 2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = 0;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
      if (!this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress()) {
        this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      }
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
    }
    label231:
    int m;
    do
    {
      do
      {
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.jdField_f_of_type_Float = f1;
        this.jdField_g_of_type_Float = f2;
        this.j = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        return true;
        k = paramMotionEvent.findPointerIndex(this.j);
      } while ((k == -1) || (k >= paramMotionEvent.getPointerCount()));
      float f1 = paramMotionEvent.getX(k);
      float f2 = paramMotionEvent.getY(k);
      float f3;
      float f4;
      if (!this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress())
      {
        f3 = f1 - this.jdField_f_of_type_Float;
        f4 = f2 - this.jdField_g_of_type_Float;
        if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
          break label231;
        }
        this.jdField_d_of_type_Float = (f3 + this.jdField_d_of_type_Float);
      }
      for (this.jdField_e_of_type_Float += f4;; this.jdField_e_of_type_Float += f4)
      {
        invalidate();
        this.jdField_f_of_type_Float = f1;
        this.jdField_g_of_type_Float = f2;
        return true;
        this.jdField_d_of_type_Float = (f3 + this.jdField_d_of_type_Float);
      }
      this.j = -1;
      return true;
      this.j = -1;
      return true;
      m = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    } while (paramMotionEvent.getPointerId(m) != this.j);
    if (m == 0) {
      k = 1;
    }
    this.jdField_f_of_type_Float = paramMotionEvent.getX(k);
    this.jdField_g_of_type_Float = paramMotionEvent.getY(k);
    this.j = paramMotionEvent.getPointerId(k);
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
    if (paramBitmap != null) {
      a(paramBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix);
    }
    for (this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;; this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap)
    {
      this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
      setImageMatrix(a());
      this.jdField_c_of_type_Float = b();
      return;
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    }
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
  
  public void setOnImageTouchedListener(adnq paramadnq)
  {
    this.jdField_a_of_type_Adnq = paramadnq;
  }
  
  public void setRegionView(RegionView paramRegionView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView = paramRegionView;
  }
  
  public void setRestrict(int paramInt1, int paramInt2)
  {
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_f_of_type_Int = paramInt2;
    if ((this.jdField_g_of_type_Int > 0) && ((this.jdField_e_of_type_Int > this.jdField_g_of_type_Int) || (this.jdField_f_of_type_Int > this.h)))
    {
      float f1 = (this.jdField_g_of_type_Int - i * this.jdField_a_of_type_Float) / this.jdField_e_of_type_Int;
      float f2 = (this.h - i * this.jdField_a_of_type_Float) / this.jdField_f_of_type_Int;
      if (f1 <= f2)
      {
        this.jdField_c_of_type_Int = ((int)(this.jdField_e_of_type_Int * f1));
        this.jdField_d_of_type_Int = ((int)(f1 * this.jdField_f_of_type_Int));
        return;
      }
      this.jdField_c_of_type_Int = ((int)(this.jdField_e_of_type_Int * f2));
      this.jdField_d_of_type_Int = ((int)(this.jdField_f_of_type_Int * f2));
      return;
    }
    this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
    this.jdField_d_of_type_Int = this.jdField_f_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PortraitImageview
 * JD-Core Version:    0.7.0.1
 */