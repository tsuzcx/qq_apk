package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import shi;
import shm;
import shv;

public class TransformImageView
  extends ImageView
{
  protected float a;
  protected int a;
  protected Matrix a;
  protected shm a;
  protected boolean a;
  protected final float[] a;
  protected float b;
  protected int b;
  protected boolean b;
  protected final float[] b;
  private int jdField_c_of_type_Int;
  private final float[] jdField_c_of_type_ArrayOfFloat = new float[9];
  private float[] d;
  private float[] e;
  
  public TransformImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TransformImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TransformImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ArrayOfFloat = new float[8];
    this.jdField_b_of_type_ArrayOfFloat = new float[2];
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    c();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(this.jdField_a_of_type_ArrayOfFloat, this.d);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(this.jdField_b_of_type_ArrayOfFloat, this.e);
  }
  
  public float a(@NonNull Matrix paramMatrix)
  {
    return (float)Math.sqrt(Math.pow(a(paramMatrix, 0), 2.0D) + Math.pow(a(paramMatrix, 3), 2.0D));
  }
  
  protected float a(@NonNull Matrix paramMatrix, @IntRange(from=0L, to=9L) int paramInt)
  {
    paramMatrix.getValues(this.jdField_c_of_type_ArrayOfFloat);
    return this.jdField_c_of_type_ArrayOfFloat[paramInt];
  }
  
  @Nullable
  public Bitmap a()
  {
    if (getDrawable() == null) {}
    do
    {
      return null;
      if ((getDrawable() instanceof shi)) {
        return ((shi)getDrawable()).a();
      }
    } while (!(getDrawable() instanceof BitmapDrawable));
    return ((BitmapDrawable)getDrawable()).getBitmap();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F))
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramFloat1, paramFloat2);
      setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
    }
  }
  
  public float b(@NonNull Matrix paramMatrix)
  {
    return (float)-(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  protected void b()
  {
    Object localObject = getDrawable();
    if (localObject == null) {}
    do
    {
      return;
      float f1 = ((Drawable)localObject).getIntrinsicWidth();
      float f2 = ((Drawable)localObject).getIntrinsicHeight();
      Log.d("TransformImageView", String.format("Image size: [%d:%d]", new Object[] { Integer.valueOf((int)f1), Integer.valueOf((int)f2) }));
      localObject = new RectF(0.0F, 0.0F, f1, f2);
      this.d = shv.a((RectF)localObject);
      this.e = shv.b((RectF)localObject);
      this.jdField_b_of_type_Boolean = true;
    } while (this.jdField_a_of_type_Shm == null);
    this.jdField_a_of_type_Shm.a();
  }
  
  protected void c()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  public void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 != 0.0F)
    {
      this.jdField_a_of_type_Float = paramFloat2;
      this.jdField_b_of_type_Float = paramFloat3;
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      if (this.jdField_a_of_type_Shm != null) {
        this.jdField_a_of_type_Shm.b(a(this.jdField_a_of_type_AndroidGraphicsMatrix));
      }
    }
  }
  
  public float d()
  {
    return a(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  public float e()
  {
    return b(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) || ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)))
    {
      paramInt1 = getPaddingLeft();
      paramInt2 = getPaddingTop();
      paramInt3 = getWidth();
      paramInt4 = getPaddingRight();
      int i = getHeight();
      int j = getPaddingBottom();
      this.jdField_a_of_type_Int = (paramInt3 - paramInt4 - paramInt1);
      this.jdField_b_of_type_Int = (i - j - paramInt2);
      b();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageDrawable(new shi(paramBitmap));
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    super.setImageMatrix(paramMatrix);
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(paramMatrix);
    a();
  }
  
  public void setMaxBitmapSize(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == ImageView.ScaleType.MATRIX)
    {
      super.setScaleType(paramScaleType);
      return;
    }
    Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
  }
  
  public void setTransformImageListener(shm paramshm)
  {
    this.jdField_a_of_type_Shm = paramshm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.TransformImageView
 * JD-Core Version:    0.7.0.1
 */