package com.tencent.mobileqq.armap.wealthgod;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.Random;

public class ARMapFlake
{
  private static Random a;
  public float a;
  public int a;
  public Bitmap a;
  public float b;
  public int b;
  public float c;
  public int c;
  public float d;
  public float e;
  
  static
  {
    jdField_a_of_type_JavaUtilRandom = new Random();
  }
  
  public static float a(int paramInt, Resources paramResources)
  {
    switch (paramInt)
    {
    default: 
      return AIOUtils.a(170.0F, paramResources) + (float)Math.random() * AIOUtils.a(110.0F, paramResources);
    case 1: 
      return AIOUtils.a(170.0F, paramResources) + (float)Math.random() * AIOUtils.a(110.0F, paramResources);
    }
    return AIOUtils.a(250.0F, paramResources) + (float)Math.random() * AIOUtils.a(50.0F, paramResources);
  }
  
  public static ARMapFlake a(float paramFloat, Bitmap paramBitmap, int paramInt1, Resources paramResources, int paramInt2)
  {
    ARMapFlake localARMapFlake = new ARMapFlake();
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    localARMapFlake.jdField_c_of_type_Int = paramInt1;
    if (paramInt1 == 1)
    {
      localARMapFlake.jdField_c_of_type_Float = 0.0F;
      localARMapFlake.e = a(paramInt2, paramResources);
      localARMapFlake.jdField_a_of_type_Int = ((int)(AIOUtils.a(30.0F, paramResources) + jdField_a_of_type_JavaUtilRandom.nextFloat() * AIOUtils.a(6.0F, paramResources)));
      localARMapFlake.jdField_b_of_type_Int = ((int)(f * localARMapFlake.jdField_a_of_type_Int));
      localARMapFlake.jdField_b_of_type_Float = (-6.0F * jdField_a_of_type_JavaUtilRandom.nextFloat() * localARMapFlake.jdField_b_of_type_Int);
    }
    for (;;)
    {
      localARMapFlake.jdField_a_of_type_Float = (jdField_a_of_type_JavaUtilRandom.nextFloat() * (paramFloat - localARMapFlake.jdField_a_of_type_Int));
      localARMapFlake.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      return localARMapFlake;
      if (paramInt1 == 2)
      {
        localARMapFlake.jdField_c_of_type_Float = ((float)Math.random() * 30.0F - 15.0F);
        localARMapFlake.e = a(paramInt2, paramResources);
        localARMapFlake.jdField_a_of_type_Int = AIOUtils.a(13.0F, paramResources);
        localARMapFlake.jdField_b_of_type_Int = ((int)(f * localARMapFlake.jdField_a_of_type_Int));
        localARMapFlake.jdField_b_of_type_Float = (-8.0F * jdField_a_of_type_JavaUtilRandom.nextFloat() * localARMapFlake.jdField_b_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.wealthgod.ARMapFlake
 * JD-Core Version:    0.7.0.1
 */