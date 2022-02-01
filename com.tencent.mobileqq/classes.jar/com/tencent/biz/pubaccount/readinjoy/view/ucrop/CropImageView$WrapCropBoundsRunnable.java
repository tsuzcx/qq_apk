package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import android.graphics.RectF;
import java.lang.ref.WeakReference;
import tbf;

class CropImageView$WrapCropBoundsRunnable
  implements Runnable
{
  private final float jdField_a_of_type_Float;
  private final long jdField_a_of_type_Long;
  private final WeakReference<CropImageView> jdField_a_of_type_JavaLangRefWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  private final float jdField_b_of_type_Float;
  private final long jdField_b_of_type_Long;
  private final float c;
  private final float d;
  private final float e;
  private final float f;
  
  public CropImageView$WrapCropBoundsRunnable(CropImageView paramCropImageView, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCropImageView);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.e = paramFloat5;
    this.f = paramFloat6;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    CropImageView localCropImageView = (CropImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localCropImageView == null) {}
    do
    {
      float f1;
      float f2;
      float f3;
      float f4;
      do
      {
        return;
        long l = System.currentTimeMillis();
        f1 = (float)Math.min(this.jdField_a_of_type_Long, l - this.jdField_b_of_type_Long);
        f2 = tbf.a(f1, 0.0F, this.c, (float)this.jdField_a_of_type_Long);
        f3 = tbf.a(f1, 0.0F, this.d, (float)this.jdField_a_of_type_Long);
        f4 = tbf.b(f1, 0.0F, this.f, (float)this.jdField_a_of_type_Long);
      } while (f1 >= (float)this.jdField_a_of_type_Long);
      localCropImageView.a(f2 - (localCropImageView.b[0] - this.jdField_a_of_type_Float), f3 - (localCropImageView.b[1] - this.jdField_b_of_type_Float));
      if (!this.jdField_a_of_type_Boolean) {
        localCropImageView.b(this.e + f4, CropImageView.a(localCropImageView).centerX(), CropImageView.a(localCropImageView).centerY());
      }
    } while (localCropImageView.a());
    localCropImageView.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.CropImageView.WrapCropBoundsRunnable
 * JD-Core Version:    0.7.0.1
 */