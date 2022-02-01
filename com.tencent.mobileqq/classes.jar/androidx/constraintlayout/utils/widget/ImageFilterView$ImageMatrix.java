package androidx.constraintlayout.utils.widget;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;

class ImageFilterView$ImageMatrix
{
  float[] m = new float[20];
  float mBrightness = 1.0F;
  ColorMatrix mColorMatrix = new ColorMatrix();
  float mContrast = 1.0F;
  float mSaturation = 1.0F;
  ColorMatrix mTmpColorMatrix = new ColorMatrix();
  float mWarmth = 1.0F;
  
  private void brightness(float paramFloat)
  {
    float[] arrayOfFloat = this.m;
    arrayOfFloat[0] = paramFloat;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = 0.0F;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = paramFloat;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 0.0F;
    arrayOfFloat[9] = 0.0F;
    arrayOfFloat[10] = 0.0F;
    arrayOfFloat[11] = 0.0F;
    arrayOfFloat[12] = paramFloat;
    arrayOfFloat[13] = 0.0F;
    arrayOfFloat[14] = 0.0F;
    arrayOfFloat[15] = 0.0F;
    arrayOfFloat[16] = 0.0F;
    arrayOfFloat[17] = 0.0F;
    arrayOfFloat[18] = 1.0F;
    arrayOfFloat[19] = 0.0F;
  }
  
  private void saturation(float paramFloat)
  {
    float f3 = 1.0F - paramFloat;
    float f1 = 0.2999F * f3;
    float f2 = 0.587F * f3;
    f3 *= 0.114F;
    float[] arrayOfFloat = this.m;
    arrayOfFloat[0] = (f1 + paramFloat);
    arrayOfFloat[1] = f2;
    arrayOfFloat[2] = f3;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = 0.0F;
    arrayOfFloat[5] = f1;
    arrayOfFloat[6] = (f2 + paramFloat);
    arrayOfFloat[7] = f3;
    arrayOfFloat[8] = 0.0F;
    arrayOfFloat[9] = 0.0F;
    arrayOfFloat[10] = f1;
    arrayOfFloat[11] = f2;
    arrayOfFloat[12] = (f3 + paramFloat);
    arrayOfFloat[13] = 0.0F;
    arrayOfFloat[14] = 0.0F;
    arrayOfFloat[15] = 0.0F;
    arrayOfFloat[16] = 0.0F;
    arrayOfFloat[17] = 0.0F;
    arrayOfFloat[18] = 1.0F;
    arrayOfFloat[19] = 0.0F;
  }
  
  private void warmth(float paramFloat)
  {
    float f1 = paramFloat;
    if (paramFloat <= 0.0F) {
      f1 = 0.01F;
    }
    paramFloat = 5000.0F / f1 / 100.0F;
    if (paramFloat > 66.0F)
    {
      double d = paramFloat - 60.0F;
      f2 = (float)Math.pow(d, -0.1332047581672669D) * 329.69873F;
      f1 = (float)Math.pow(d, 0.07551484555006027D) * 288.12216F;
    }
    else
    {
      f1 = (float)Math.log(paramFloat) * 99.470802F - 161.11957F;
      f2 = 255.0F;
    }
    if (paramFloat < 66.0F)
    {
      if (paramFloat > 19.0F) {
        paramFloat = (float)Math.log(paramFloat - 10.0F) * 138.51773F - 305.0448F;
      } else {
        paramFloat = 0.0F;
      }
    }
    else {
      paramFloat = 255.0F;
    }
    float f2 = Math.min(255.0F, Math.max(f2, 0.0F));
    f1 = Math.min(255.0F, Math.max(f1, 0.0F));
    paramFloat = Math.min(255.0F, Math.max(paramFloat, 0.0F));
    float f4 = (float)Math.log(50.0F);
    float f5 = (float)Math.log(40.0F);
    float f3 = Math.min(255.0F, Math.max(255.0F, 0.0F));
    f4 = Math.min(255.0F, Math.max(f4 * 99.470802F - 161.11957F, 0.0F));
    f5 = Math.min(255.0F, Math.max(f5 * 138.51773F - 305.0448F, 0.0F));
    f2 /= f3;
    f1 /= f4;
    paramFloat /= f5;
    float[] arrayOfFloat = this.m;
    arrayOfFloat[0] = f2;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = 0.0F;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = f1;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 0.0F;
    arrayOfFloat[9] = 0.0F;
    arrayOfFloat[10] = 0.0F;
    arrayOfFloat[11] = 0.0F;
    arrayOfFloat[12] = paramFloat;
    arrayOfFloat[13] = 0.0F;
    arrayOfFloat[14] = 0.0F;
    arrayOfFloat[15] = 0.0F;
    arrayOfFloat[16] = 0.0F;
    arrayOfFloat[17] = 0.0F;
    arrayOfFloat[18] = 1.0F;
    arrayOfFloat[19] = 0.0F;
  }
  
  void updateMatrix(ImageView paramImageView)
  {
    this.mColorMatrix.reset();
    float f = this.mSaturation;
    int i;
    if (f != 1.0F)
    {
      saturation(f);
      this.mColorMatrix.set(this.m);
      i = 1;
    }
    else
    {
      i = 0;
    }
    f = this.mContrast;
    if (f != 1.0F)
    {
      this.mTmpColorMatrix.setScale(f, f, f, 1.0F);
      this.mColorMatrix.postConcat(this.mTmpColorMatrix);
      i = 1;
    }
    f = this.mWarmth;
    if (f != 1.0F)
    {
      warmth(f);
      this.mTmpColorMatrix.set(this.m);
      this.mColorMatrix.postConcat(this.mTmpColorMatrix);
      i = 1;
    }
    f = this.mBrightness;
    if (f != 1.0F)
    {
      brightness(f);
      this.mTmpColorMatrix.set(this.m);
      this.mColorMatrix.postConcat(this.mTmpColorMatrix);
      i = 1;
    }
    if (i != 0)
    {
      paramImageView.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
      return;
    }
    paramImageView.clearColorFilter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.utils.widget.ImageFilterView.ImageMatrix
 * JD-Core Version:    0.7.0.1
 */