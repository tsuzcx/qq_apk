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
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = TEXTURE_NO_ROTATION2;
      if (paramBoolean1)
      {
        float[] arrayOfFloat = new float[8];
        arrayOfFloat[0] = flip(localObject[0]);
        arrayOfFloat[1] = localObject[1];
        arrayOfFloat[2] = flip(localObject[2]);
        arrayOfFloat[3] = localObject[3];
        arrayOfFloat[4] = flip(localObject[4]);
        arrayOfFloat[5] = localObject[5];
        arrayOfFloat[6] = flip(localObject[6]);
        arrayOfFloat[7] = localObject[7];
        localObject = arrayOfFloat;
      }
      break;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        return new float[] { localObject[0], flip(localObject[1]), localObject[2], flip(localObject[3]), localObject[4], flip(localObject[5]), localObject[6], flip(localObject[7]) };
        localObject = TEXTURE_ROTATED2_90;
        break;
        localObject = TEXTURE_ROTATED2_180;
        break;
        localObject = TEXTURE_ROTATED2_270;
        break;
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.util.TextureRotationUtil
 * JD-Core Version:    0.7.0.1
 */