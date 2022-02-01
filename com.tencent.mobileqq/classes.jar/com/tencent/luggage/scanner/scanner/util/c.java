package com.tencent.luggage.scanner.scanner.util;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/scanner/scanner/util/ScanYuvUtils;", "", "()V", "encodeYUV420SP", "", "yuv420sp", "", "argb", "", "width", "", "height", "getNV21", "inputWidth", "inputHeight", "scaled", "Landroid/graphics/Bitmap;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c
{
  public static final c a = new c();
  
  private final void a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int k = paramInt1 * paramInt2;
    int n = 0;
    int i = 0;
    int m;
    for (int j = 0; n < paramInt2; j = m)
    {
      m = i;
      int i1 = 0;
      i = j;
      j = m;
      while (i1 < paramInt1)
      {
        m = paramArrayOfInt[j];
        m = (paramArrayOfInt[j] & 0xFF0000) >> 16;
        int i4 = (paramArrayOfInt[j] & 0xFF00) >> 8;
        int i3 = paramArrayOfInt[j];
        int i2 = 255;
        int i6 = (i3 & 0xFF) >> 0;
        int i5 = (m * 66 + i4 * 129 + i6 * 25 + 128 >> 8) + 16;
        i3 = (m * -38 - i4 * 74 + i6 * 112 + 128 >> 8) + 128;
        i4 = (m * 112 - i4 * 94 - i6 * 18 + 128 >> 8) + 128;
        if (i5 < 0)
        {
          m = 0;
        }
        else
        {
          m = i5;
          if (i5 > 255) {
            m = 255;
          }
        }
        paramArrayOfByte[i] = ((byte)m);
        m = k;
        if (n % 2 == 0)
        {
          m = k;
          if (j % 2 == 0)
          {
            i5 = k + 1;
            if (i4 < 0)
            {
              m = 0;
            }
            else
            {
              m = i4;
              if (i4 > 255) {
                m = 255;
              }
            }
            paramArrayOfByte[k] = ((byte)m);
            m = i5 + 1;
            if (i3 < 0) {
              k = 0;
            } else if (i3 > 255) {
              k = i2;
            } else {
              k = i3;
            }
            paramArrayOfByte[i5] = ((byte)k);
          }
        }
        j += 1;
        i1 += 1;
        i += 1;
        k = m;
      }
      n += 1;
      m = i;
      i = j;
    }
  }
  
  @JvmStatic
  @Nullable
  public static final byte[] a(int paramInt1, int paramInt2, @Nullable Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int i = paramInt1 * paramInt2;
      int[] arrayOfInt = new int[i];
      paramBitmap.getPixels(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
      byte[] arrayOfByte = new byte[i * 3 / 2];
      a.a(arrayOfByte, arrayOfInt, paramInt1, paramInt2);
      paramBitmap.recycle();
      return arrayOfByte;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.util.c
 * JD-Core Version:    0.7.0.1
 */