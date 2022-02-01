package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.os.MqqHandler;
import swx;
import sxa;
import sxb;
import sxe;
import sxg;

public class CropImageView
  extends TransformImageView
{
  private long jdField_a_of_type_Long = 500L;
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private sxa jdField_a_of_type_Sxa;
  private final Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float = 10.0F;
  private int jdField_d_of_type_Int;
  private float e;
  private float f;
  
  public CropImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Object paramObject)
  {
    if (paramObject != null) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(String paramString, boolean paramBoolean, @Nullable sxb paramsxb)
  {
    if (paramsxb == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new CropImageView.2(this, paramBoolean, paramsxb, paramString));
  }
  
  private float[] a()
  {
    float f3 = 0.0F;
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_b_of_type_AndroidGraphicsMatrix.setRotate(-e());
    Object localObject2 = Arrays.copyOf(this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat.length);
    Object localObject1 = sxg.a(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_b_of_type_AndroidGraphicsMatrix.mapPoints((float[])localObject2);
    this.jdField_b_of_type_AndroidGraphicsMatrix.mapPoints((float[])localObject1);
    localObject2 = sxg.a((float[])localObject2);
    localObject1 = sxg.a((float[])localObject1);
    float f1 = ((RectF)localObject2).left - ((RectF)localObject1).left;
    float f5 = ((RectF)localObject2).top - ((RectF)localObject1).top;
    float f4 = ((RectF)localObject2).right - ((RectF)localObject1).right;
    float f2 = ((RectF)localObject2).bottom - ((RectF)localObject1).bottom;
    localObject1 = new float[4];
    if (f1 > 0.0F)
    {
      localObject1[0] = f1;
      if (f5 <= 0.0F) {
        break label222;
      }
      f1 = f5;
      label152:
      localObject1[1] = f1;
      if (f4 >= 0.0F) {
        break label227;
      }
    }
    label222:
    label227:
    for (f1 = f4;; f1 = 0.0F)
    {
      localObject1[2] = f1;
      f1 = f3;
      if (f2 < 0.0F) {
        f1 = f2;
      }
      localObject1[3] = f1;
      this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_b_of_type_AndroidGraphicsMatrix.setRotate(e());
      this.jdField_b_of_type_AndroidGraphicsMatrix.mapPoints((float[])localObject1);
      return localObject1;
      f1 = 0.0F;
      break;
      f1 = 0.0F;
      break label152;
    }
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    this.f = Math.min(Math.min(this.jdField_a_of_type_AndroidGraphicsRectF.width() / paramFloat1, this.jdField_a_of_type_AndroidGraphicsRectF.width() / paramFloat2), Math.min(this.jdField_a_of_type_AndroidGraphicsRectF.height() / paramFloat2, this.jdField_a_of_type_AndroidGraphicsRectF.height() / paramFloat1));
    if (this.jdField_d_of_type_Float != -1.0F) {
      this.e = (this.f * this.jdField_d_of_type_Float);
    }
  }
  
  private void c(float paramFloat1, float paramFloat2)
  {
    float f3 = this.jdField_a_of_type_AndroidGraphicsRectF.width();
    float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.height();
    float f1 = Math.max(this.jdField_a_of_type_AndroidGraphicsRectF.width() / paramFloat1, this.jdField_a_of_type_AndroidGraphicsRectF.height() / paramFloat2);
    paramFloat1 = (f3 - paramFloat1 * f1) / 2.0F;
    f3 = this.jdField_a_of_type_AndroidGraphicsRectF.left;
    paramFloat2 = (f2 - paramFloat2 * f1) / 2.0F;
    f2 = this.jdField_a_of_type_AndroidGraphicsRectF.top;
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f1);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramFloat1 + f3, paramFloat2 + f2);
    setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  private void d()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    b(localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
  }
  
  public float a()
  {
    return this.e;
  }
  
  public void a()
  {
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 >= b()) {
      c(paramFloat1 / d(), paramFloat2, paramFloat3);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    a(paramFloat1, paramFloat2, paramFloat3, paramLong, false);
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropImageView", 2, "zoomImageToPosition scale:" + paramFloat1 + " ,centerX:" + paramFloat2 + " ,centerY:" + paramFloat3 + " ,durationMs:" + paramLong + " ，isZoomOut：" + paramBoolean);
    }
    float f1 = paramFloat1;
    if (paramFloat1 > a()) {
      f1 = a();
    }
    paramFloat1 = d();
    CropImageView.ZoomImageToPosition localZoomImageToPosition = new CropImageView.ZoomImageToPosition(this, paramLong, paramFloat1, f1 - paramFloat1, paramFloat2, paramFloat3, paramBoolean);
    this.jdField_b_of_type_JavaLangRunnable = localZoomImageToPosition;
    post(localZoomImageToPosition);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    if ((paramFloat1 > 1.0F) && ((paramBoolean) || (d() * paramFloat1 <= a()))) {
      super.c(paramFloat1, paramFloat2, paramFloat3);
    }
    while ((paramFloat1 >= 1.0F) || ((!paramBoolean) && (d() * paramFloat1 < b()))) {
      return;
    }
    super.c(paramFloat1, paramFloat2, paramFloat3);
  }
  
  protected void a(@NonNull TypedArray paramTypedArray)
  {
    float f1 = Math.abs(paramTypedArray.getFloat(0, 0.0F));
    float f2 = Math.abs(paramTypedArray.getFloat(1, 0.0F));
    if ((f1 == 0.0F) || (f2 == 0.0F))
    {
      this.jdField_c_of_type_Float = 0.0F;
      return;
    }
    this.jdField_c_of_type_Float = (f1 / f2);
  }
  
  public void a(@NonNull Bitmap.CompressFormat paramCompressFormat, int paramInt1, int paramInt2, int paramInt3, @Nullable sxb paramsxb)
  {
    a();
    setImageToWrapCropBounds(false);
    Bitmap localBitmap = a();
    if (localBitmap == null)
    {
      if (paramsxb != null) {
        paramsxb.a();
      }
      return;
    }
    ThreadManager.executeOnFileThread(new CropImageView.1(this, localBitmap, new sxe(this.jdField_a_of_type_AndroidGraphicsRectF, sxg.a(this.jdField_a_of_type_ArrayOfFloat), d(), e()), paramCompressFormat, paramInt1, paramsxb));
  }
  
  protected boolean a()
  {
    return a(this.jdField_a_of_type_ArrayOfFloat);
  }
  
  protected boolean a(float[] paramArrayOfFloat)
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
    this.jdField_b_of_type_AndroidGraphicsMatrix.setRotate(-e());
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    this.jdField_b_of_type_AndroidGraphicsMatrix.mapPoints(paramArrayOfFloat);
    float[] arrayOfFloat = sxg.a(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_b_of_type_AndroidGraphicsMatrix.mapPoints(arrayOfFloat);
    return sxg.a(paramArrayOfFloat).contains(sxg.a(arrayOfFloat));
  }
  
  public float b()
  {
    return this.f;
  }
  
  protected void b()
  {
    super.b();
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    float f1 = localDrawable.getIntrinsicWidth();
    float f2 = localDrawable.getIntrinsicHeight();
    if (this.jdField_c_of_type_Float == 0.0F) {
      this.jdField_c_of_type_Float = (f1 / f2);
    }
    int i = (int)(this.jdField_a_of_type_Int / this.jdField_c_of_type_Float);
    int j;
    if (i > this.jdField_b_of_type_Int)
    {
      i = (int)(this.jdField_b_of_type_Int * this.jdField_c_of_type_Float);
      j = (this.jdField_a_of_type_Int - i) / 2;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(j, 0.0F, i + j, this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      b(f1, f2);
      c(f1, f2);
      if (this.jdField_a_of_type_Sxa != null) {
        this.jdField_a_of_type_Sxa.a(this.jdField_c_of_type_Float);
      }
      if (this.jdField_a_of_type_Swx == null) {
        break;
      }
      this.jdField_a_of_type_Swx.b(d());
      this.jdField_a_of_type_Swx.a(e());
      return;
      j = (this.jdField_b_of_type_Int - i) / 2;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, j, this.jdField_a_of_type_Int, i + j);
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 <= a()) {
      c(paramFloat1 / d(), paramFloat2, paramFloat3);
    }
  }
  
  public void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a(paramFloat1, paramFloat2, paramFloat3, false);
  }
  
  public void setCropBoundsChangeListener(@Nullable sxa paramsxa)
  {
    this.jdField_a_of_type_Sxa = paramsxa;
  }
  
  public void setCropRect(RectF paramRectF)
  {
    this.jdField_c_of_type_Float = (paramRectF.width() / paramRectF.height());
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF.left - getPaddingLeft(), paramRectF.top - getPaddingTop(), paramRectF.right - getPaddingRight(), paramRectF.bottom - getPaddingBottom());
    d();
    setImageToWrapCropBounds();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    a(paramBitmap);
    super.setImageBitmap(paramBitmap);
  }
  
  @Deprecated
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    a(paramDrawable);
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageToLowerMaxScale()
  {
    if (d() > a())
    {
      float[] arrayOfFloat = new float[9];
      this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(arrayOfFloat);
      a(a(), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, 200L, true);
    }
  }
  
  public void setImageToWrapCropBounds()
  {
    setImageToWrapCropBounds(true);
  }
  
  public void setImageToWrapCropBounds(boolean paramBoolean)
  {
    float f6;
    float f1;
    float f2;
    float f3;
    Object localObject;
    boolean bool;
    if ((this.jdField_b_of_type_Boolean) && (!a()))
    {
      float f4 = this.jdField_b_of_type_ArrayOfFloat[0];
      float f5 = this.jdField_b_of_type_ArrayOfFloat[1];
      f6 = d();
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.centerX() - f4;
      f2 = this.jdField_a_of_type_AndroidGraphicsRectF.centerY() - f5;
      f3 = 0.0F;
      this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_b_of_type_AndroidGraphicsMatrix.setTranslate(f1, f2);
      localObject = Arrays.copyOf(this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfFloat.length);
      this.jdField_b_of_type_AndroidGraphicsMatrix.mapPoints((float[])localObject);
      bool = a((float[])localObject);
      if (!bool) {
        break label187;
      }
      localObject = a();
      f1 = -(localObject[0] + localObject[2]);
      f2 = localObject[1];
      f2 = -(localObject[3] + f2);
      if (!paramBoolean) {
        break label271;
      }
      localObject = new CropImageView.WrapCropBoundsRunnable(this, this.jdField_a_of_type_Long, f4, f5, f1, f2, f6, f3, bool);
      this.jdField_a_of_type_JavaLangRunnable = ((Runnable)localObject);
      post((Runnable)localObject);
    }
    label187:
    do
    {
      return;
      localObject = new RectF(this.jdField_a_of_type_AndroidGraphicsRectF);
      this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_b_of_type_AndroidGraphicsMatrix.setRotate(e());
      this.jdField_b_of_type_AndroidGraphicsMatrix.mapRect((RectF)localObject);
      float[] arrayOfFloat = sxg.a(this.jdField_a_of_type_ArrayOfFloat);
      f3 = Math.max(((RectF)localObject).width() / arrayOfFloat[0], ((RectF)localObject).height() / arrayOfFloat[1]) * f6 - f6;
      break;
      a(f1, f2);
    } while (bool);
    label271:
    b(f6 + f3, this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY());
  }
  
  public void setImageToWrapCropBoundsAnimDuration(@IntRange(from=100L) long paramLong)
  {
    if (paramLong > 0L)
    {
      this.jdField_a_of_type_Long = paramLong;
      return;
    }
    throw new IllegalArgumentException("Animation duration cannot be negative value.");
  }
  
  public void setMaxResultImageSizeX(@IntRange(from=10L) int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setMaxResultImageSizeY(@IntRange(from=10L) int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.e = paramFloat;
    this.jdField_d_of_type_Float = -1.0F;
  }
  
  public void setMaxScaleMultiplier(float paramFloat)
  {
    this.jdField_d_of_type_Float = paramFloat;
  }
  
  public void setTargetAspectRatio(float paramFloat)
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      this.jdField_c_of_type_Float = paramFloat;
    }
    for (;;)
    {
      return;
      if (paramFloat == 0.0F) {}
      for (this.jdField_c_of_type_Float = (localDrawable.getIntrinsicWidth() / localDrawable.getIntrinsicHeight()); this.jdField_a_of_type_Sxa != null; this.jdField_c_of_type_Float = paramFloat)
      {
        this.jdField_a_of_type_Sxa.a(this.jdField_c_of_type_Float);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.CropImageView
 * JD-Core Version:    0.7.0.1
 */