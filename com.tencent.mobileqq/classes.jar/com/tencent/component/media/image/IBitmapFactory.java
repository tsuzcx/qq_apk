package com.tencent.component.media.image;

import android.graphics.Bitmap.Config;

public abstract class IBitmapFactory
{
  static final byte[] EMPTY_JPEG_PREFIX = { -1, -40, -1, -37, 0, 67, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -64, 0, 17, 8 };
  static final byte[] EMPTY_JPEG_SUFFIX = { 3, 1, 34, 0, 2, 17, 0, 3, 17, 0, -1, -60, 0, 31, 0, 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 16, 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125, 1, 2, 3, 0, 4, 17, 5, 18, 33, 49, 65, 6, 19, 81, 97, 7, 34, 113, 20, 50, -127, -111, -95, 8, 35, 66, -79, -63, 21, 82, -47, -16, 36, 51, 98, 114, -126, 9, 10, 22, 23, 24, 25, 26, 37, 38, 39, 40, 41, 42, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -60, 0, 31, 1, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 17, 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119, 0, 1, 2, 3, 17, 4, 5, 33, 49, 6, 18, 65, 81, 7, 97, 113, 19, 34, 50, -127, 8, 20, 66, -111, -95, -79, -63, 9, 35, 51, 82, -16, 21, 98, 114, -47, 10, 22, 36, 52, -31, 37, -15, 23, 24, 25, 26, 38, 39, 40, 41, 42, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -126, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -30, -29, -28, -27, -26, -25, -24, -23, -22, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -38, 0, 12, 3, 1, 0, 2, 17, 3, 17, 0, 63, 0, -114, -118, 40, -96, 15, -1, -39 };
  private static final String TAG = "BitmapFactory";
  static int sEmptyByteSize = EMPTY_JPEG_PREFIX.length + EMPTY_JPEG_SUFFIX.length + 4;
  
  public static void arraycopy(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte1 == null) {
      throw new NullPointerException("src == null");
    }
    if (paramArrayOfByte2 == null) {
      throw new NullPointerException("dst == null");
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt1 > paramArrayOfByte1.length - paramInt3) || (paramInt2 > paramArrayOfByte2.length - paramInt3)) {
      throw new ArrayIndexOutOfBoundsException("src.length=" + paramArrayOfByte1.length + " srcPos=" + paramInt1 + " dst.length=" + paramArrayOfByte2.length + " dstPos=" + paramInt2 + " length=" + paramInt3);
    }
    if ((paramArrayOfByte1 == paramArrayOfByte2) && (paramInt1 < paramInt2) && (paramInt2 < paramInt1 + paramInt3)) {
      paramInt3 -= 1;
    }
    while (paramInt3 >= 0)
    {
      paramArrayOfByte2[(paramInt2 + paramInt3)] = paramArrayOfByte1[(paramInt1 + paramInt3)];
      paramInt3 -= 1;
      continue;
      int i = 0;
      while (i < paramInt3)
      {
        paramArrayOfByte2[(paramInt2 + i)] = paramArrayOfByte1[(paramInt1 + i)];
        i += 1;
      }
    }
  }
  
  static byte[] generate(short paramShort1, short paramShort2, ByteArrayPool paramByteArrayPool)
  {
    paramByteArrayPool = (byte[])paramByteArrayPool.get(sEmptyByteSize);
    arraycopy(EMPTY_JPEG_PREFIX, 0, paramByteArrayPool, 0, EMPTY_JPEG_PREFIX.length);
    paramByteArrayPool[EMPTY_JPEG_PREFIX.length] = ((byte)(paramShort2 >> 8));
    paramByteArrayPool[(EMPTY_JPEG_PREFIX.length + 1)] = ((byte)(paramShort2 & 0xFF));
    paramByteArrayPool[(EMPTY_JPEG_PREFIX.length + 2)] = ((byte)(paramShort1 >> 8));
    paramByteArrayPool[(EMPTY_JPEG_PREFIX.length + 3)] = ((byte)(paramShort1 & 0xFF));
    arraycopy(EMPTY_JPEG_SUFFIX, 0, paramByteArrayPool, EMPTY_JPEG_PREFIX.length + 4, EMPTY_JPEG_SUFFIX.length);
    return paramByteArrayPool;
  }
  
  public abstract BitmapReference createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.IBitmapFactory
 * JD-Core Version:    0.7.0.1
 */