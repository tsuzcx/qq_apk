package com.tencent.av.video.effect.core.qqavimage.util;

public class TextureRotationUtil
{
  public static final float[] TEXTURE_NO_ROTATION;
  public static final float[] TEXTURE_NO_ROTATION2 = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  public static final float[] TEXTURE_ROTATED2_180;
  public static final float[] TEXTURE_ROTATED2_270;
  public static final float[] TEXTURE_ROTATED2_90 = { 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public static final float[] TEXTURE_ROTATED_180 = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  public static final float[] TEXTURE_ROTATED_270 = { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  public static final float[] TEXTURE_ROTATED_90;
  
  static
  {
    TEXTURE_ROTATED2_180 = new float[] { 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
    TEXTURE_ROTATED2_270 = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
    TEXTURE_NO_ROTATION = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    TEXTURE_ROTATED_90 = new float[] { 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F };
  }
  
  private static float flip(float paramFloat)
  {
    float f = 0.0F;
    if (paramFloat == 0.0F) {
      f = 1.0F;
    }
    return f;
  }
  
  public static float[] getRotation(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    float[] arrayOfFloat1;
    switch (paramInt)
    {
    default: 
      arrayOfFloat1 = TEXTURE_NO_ROTATION2;
    }
    float[] arrayOfFloat2;
    for (;;)
    {
      arrayOfFloat2 = arrayOfFloat1;
      if (paramBoolean1) {
        arrayOfFloat2 = new float[] { flip(arrayOfFloat1[0]), arrayOfFloat1[1], flip(arrayOfFloat1[2]), arrayOfFloat1[3], flip(arrayOfFloat1[4]), arrayOfFloat1[5], flip(arrayOfFloat1[6]), arrayOfFloat1[7] };
      }
      if (!paramBoolean2) {
        break;
      }
      return new float[] { arrayOfFloat2[0], flip(arrayOfFloat2[1]), arrayOfFloat2[2], flip(arrayOfFloat2[3]), arrayOfFloat2[4], flip(arrayOfFloat2[5]), arrayOfFloat2[6], flip(arrayOfFloat2[7]) };
      arrayOfFloat1 = TEXTURE_ROTATED2_90;
      continue;
      arrayOfFloat1 = TEXTURE_ROTATED2_180;
      continue;
      arrayOfFloat1 = TEXTURE_ROTATED2_270;
    }
    return arrayOfFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.util.TextureRotationUtil
 * JD-Core Version:    0.7.0.1
 */