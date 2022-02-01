import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

public class axkr
{
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBitmap == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap1 = b(paramBitmap, paramInt1, paramInt2, paramInt3);
        if (localBitmap1 != null)
        {
          paramInt1 = (int)(localBitmap1.getWidth() * 0.03F);
          paramInt2 = (int)(0.03F * localBitmap1.getHeight());
          if (paramInt2 > 0)
          {
            Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, paramInt1, paramInt2, localBitmap1.getWidth() - (paramInt1 << 1), localBitmap1.getHeight() - (paramInt2 << 1));
            paramBitmap = localBitmap2;
            if (!localBitmap1.isRecycled())
            {
              localBitmap1.recycle();
              paramBitmap = localBitmap2;
            }
            return paramBitmap;
          }
          paramBitmap = localBitmap1;
          continue;
        }
        paramBitmap = null;
      }
      catch (Exception paramBitmap)
      {
        QLog.e("BitmapAlgorithms", 1, paramBitmap.toString());
        return null;
      }
    }
  }
  
  private static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, float paramFloat)
  {
    paramFloat -= (int)paramFloat;
    float f = 1.0F / (1.0F + 2.0F * paramFloat);
    int j = 0;
    int i = 0;
    while (j < paramInt2)
    {
      paramArrayOfInt2[j] = paramArrayOfInt1[0];
      int m = j + paramInt2;
      int k = 1;
      while (k < paramInt1 - 1)
      {
        int i1 = i + k;
        int i3 = paramArrayOfInt1[(i1 - 1)];
        int n = paramArrayOfInt1[i1];
        int i5 = paramArrayOfInt1[(i1 + 1)];
        int i4 = (int)(((i3 >> 24 & 0xFF) + (i5 >> 24 & 0xFF)) * paramFloat);
        int i2 = (int)(((i3 >> 16 & 0xFF) + (i5 >> 16 & 0xFF)) * paramFloat);
        i1 = (int)(((i3 >> 8 & 0xFF) + (i5 >> 8 & 0xFF)) * paramFloat);
        i3 = (int)(((i5 & 0xFF) + (i3 & 0xFF)) * paramFloat);
        i4 = (int)((i4 + (n >> 24 & 0xFF)) * f);
        i2 = (int)((i2 + (n >> 16 & 0xFF)) * f);
        i1 = (int)((i1 + (n >> 8 & 0xFF)) * f);
        paramArrayOfInt2[m] = ((int)((i3 + (n & 0xFF)) * f) | i4 << 24 | i2 << 16 | i1 << 8);
        m += paramInt2;
        k += 1;
      }
      paramArrayOfInt2[m] = paramArrayOfInt1[(paramInt1 - 1)];
      j += 1;
      i += paramInt1;
    }
  }
  
  /* Error */
  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 8
    //   9: aload_0
    //   10: ifnonnull +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: invokevirtual 19	android/graphics/Bitmap:getWidth	()I
    //   19: istore 5
    //   21: aload_0
    //   22: invokevirtual 23	android/graphics/Bitmap:getHeight	()I
    //   25: istore 6
    //   27: iload 5
    //   29: iload 6
    //   31: imul
    //   32: newarray int
    //   34: astore 11
    //   36: iload 5
    //   38: iload 6
    //   40: imul
    //   41: newarray int
    //   43: astore 12
    //   45: iload 5
    //   47: iload 6
    //   49: getstatic 58	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   52: invokestatic 61	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   55: astore 7
    //   57: aload_0
    //   58: aload 11
    //   60: iconst_0
    //   61: iload 5
    //   63: iconst_0
    //   64: iconst_0
    //   65: iload 5
    //   67: iload 6
    //   69: invokevirtual 65	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   72: iconst_0
    //   73: istore 4
    //   75: iload 4
    //   77: iload_1
    //   78: if_icmpge +38 -> 116
    //   81: aload 11
    //   83: aload 12
    //   85: iload 5
    //   87: iload 6
    //   89: iload_2
    //   90: i2f
    //   91: invokestatic 67	axkr:b	([I[IIIF)V
    //   94: aload 12
    //   96: aload 11
    //   98: iload 6
    //   100: iload 5
    //   102: iload_3
    //   103: i2f
    //   104: invokestatic 67	axkr:b	([I[IIIF)V
    //   107: iload 4
    //   109: iconst_1
    //   110: iadd
    //   111: istore 4
    //   113: goto -38 -> 75
    //   116: aload 11
    //   118: aload 12
    //   120: iload 5
    //   122: iload 6
    //   124: iload_2
    //   125: i2f
    //   126: invokestatic 69	axkr:a	([I[IIIF)V
    //   129: aload 12
    //   131: aload 11
    //   133: iload 6
    //   135: iload 5
    //   137: iload_3
    //   138: i2f
    //   139: invokestatic 69	axkr:a	([I[IIIF)V
    //   142: aload 7
    //   144: aload 11
    //   146: iconst_0
    //   147: iload 5
    //   149: iconst_0
    //   150: iconst_0
    //   151: iload 5
    //   153: iload 6
    //   155: invokevirtual 72	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   158: aload 7
    //   160: areturn
    //   161: astore_0
    //   162: aload 8
    //   164: astore 7
    //   166: ldc 37
    //   168: iconst_1
    //   169: aload_0
    //   170: invokevirtual 41	java/lang/Exception:toString	()Ljava/lang/String;
    //   173: invokestatic 47	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload 7
    //   178: areturn
    //   179: astore_0
    //   180: aload 9
    //   182: astore 7
    //   184: ldc 37
    //   186: iconst_1
    //   187: aload_0
    //   188: invokevirtual 73	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   191: invokestatic 47	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload 7
    //   196: areturn
    //   197: astore_0
    //   198: aload 10
    //   200: astore 7
    //   202: ldc 37
    //   204: iconst_1
    //   205: aload_0
    //   206: invokevirtual 74	java/lang/Error:toString	()Ljava/lang/String;
    //   209: invokestatic 47	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload 7
    //   214: areturn
    //   215: astore_0
    //   216: goto -14 -> 202
    //   219: astore_0
    //   220: goto -36 -> 184
    //   223: astore_0
    //   224: goto -58 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramBitmap	Bitmap
    //   0	227	1	paramInt1	int
    //   0	227	2	paramInt2	int
    //   0	227	3	paramInt3	int
    //   73	39	4	i	int
    //   19	133	5	j	int
    //   25	129	6	k	int
    //   55	158	7	localObject1	Object
    //   7	156	8	localObject2	Object
    //   1	180	9	localObject3	Object
    //   4	195	10	localObject4	Object
    //   34	111	11	arrayOfInt1	int[]
    //   43	87	12	arrayOfInt2	int[]
    // Exception table:
    //   from	to	target	type
    //   15	57	161	java/lang/Exception
    //   15	57	179	java/lang/OutOfMemoryError
    //   15	57	197	java/lang/Error
    //   57	72	215	java/lang/Error
    //   81	107	215	java/lang/Error
    //   116	158	215	java/lang/Error
    //   57	72	219	java/lang/OutOfMemoryError
    //   81	107	219	java/lang/OutOfMemoryError
    //   116	158	219	java/lang/OutOfMemoryError
    //   57	72	223	java/lang/Exception
    //   81	107	223	java/lang/Exception
    //   116	158	223	java/lang/Exception
  }
  
  private static void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, float paramFloat)
  {
    int i6 = paramInt1 - 1;
    int i8 = (int)paramFloat;
    int j = i8 * 2 + 1;
    int[] arrayOfInt = new int[j * 256];
    int i = 0;
    while (i < j * 256)
    {
      arrayOfInt[i] = (i / j);
      i += 1;
    }
    i = 0;
    int i1 = 0;
    int m;
    int n;
    int k;
    int i2;
    int i3;
    int i4;
    int i5;
    if (i < paramInt2)
    {
      m = 0;
      n = 0;
      j = 0;
      k = 0;
      i2 = -i8;
      while (i2 <= i8)
      {
        i3 = paramArrayOfInt1[(a(i2, 0, paramInt1 - 1) + i1)];
        m += (i3 >> 24 & 0xFF);
        n += (i3 >> 16 & 0xFF);
        j += (i3 >> 8 & 0xFF);
        k += (i3 & 0xFF);
        i2 += 1;
      }
      i2 = i;
      i4 = j;
      i5 = 0;
      j = i2;
      i3 = m;
      i2 = n;
      n = i4;
      m = i5;
      label206:
      if (m < paramInt1)
      {
        paramArrayOfInt2[j] = (arrayOfInt[i3] << 24 | arrayOfInt[i2] << 16 | arrayOfInt[n] << 8 | arrayOfInt[k]);
        i4 = m + i8 + 1;
        if (i4 <= i6) {
          break label416;
        }
        i4 = i6;
      }
    }
    label416:
    for (;;)
    {
      int i7 = m - i8;
      i5 = i7;
      if (i7 < 0) {
        i5 = 0;
      }
      i4 = paramArrayOfInt1[(i4 + i1)];
      i5 = paramArrayOfInt1[(i5 + i1)];
      i3 += (i4 >> 24 & 0xFF) - (i5 >> 24 & 0xFF);
      i2 += ((0xFF0000 & i4) - (0xFF0000 & i5) >> 16);
      n += ((0xFF00 & i4) - (0xFF00 & i5) >> 8);
      m += 1;
      j += paramInt2;
      k += (i4 & 0xFF) - (i5 & 0xFF);
      break label206;
      i += 1;
      i1 += paramInt1;
      break;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkr
 * JD-Core Version:    0.7.0.1
 */