package com.tencent.imageboost;

import bjdb;

public class ImgProcessScan
{
  public static int ArrayConvert(int paramInt, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    return bjdb.a(paramInt, paramArrayOfByte, paramArrayOfInt);
  }
  
  public static int CropGray2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    return bjdb.a(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramInt3);
  }
  
  public static int TransBytes(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return bjdb.b(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int TransPixels(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return bjdb.a(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int YUVrotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    return bjdb.a(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
  }
  
  public static int YUVrotateLessMemCost(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return bjdb.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int YuvToCropIntArray(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return bjdb.a(paramArrayOfByte, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public static int gray_rotate_crop_sub(byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    return bjdb.a(paramArrayOfByte1, paramArrayOfInt, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public static int gray_rotate_sub(byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return bjdb.a(paramArrayOfByte1, paramArrayOfInt, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imageboost.ImgProcessScan
 * JD-Core Version:    0.7.0.1
 */