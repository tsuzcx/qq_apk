package com.tencent.image;

import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import java.util.concurrent.CountDownLatch;

final class SafeBitmapFactory$1
  implements Runnable
{
  SafeBitmapFactory$1(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject, Canvas paramCanvas, CountDownLatch paramCountDownLatch) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/image/SafeBitmapFactory$1:val$fopts	Landroid/graphics/BitmapFactory$Options;
    //   4: getfield 49	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   7: ifle +172 -> 179
    //   10: aload_0
    //   11: getfield 23	com/tencent/image/SafeBitmapFactory$1:val$fopts	Landroid/graphics/BitmapFactory$Options;
    //   14: getfield 49	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   17: istore_1
    //   18: goto +3 -> 21
    //   21: new 51	android/graphics/Rect
    //   24: dup
    //   25: aload_0
    //   26: getfield 25	com/tencent/image/SafeBitmapFactory$1:val$fj	I
    //   29: aload_0
    //   30: getfield 27	com/tencent/image/SafeBitmapFactory$1:val$perWidth	I
    //   33: imul
    //   34: iload_1
    //   35: imul
    //   36: aload_0
    //   37: getfield 29	com/tencent/image/SafeBitmapFactory$1:val$fi	I
    //   40: aload_0
    //   41: getfield 31	com/tencent/image/SafeBitmapFactory$1:val$perHeight	I
    //   44: imul
    //   45: iload_1
    //   46: imul
    //   47: aload_0
    //   48: getfield 25	com/tencent/image/SafeBitmapFactory$1:val$fj	I
    //   51: iconst_1
    //   52: iadd
    //   53: aload_0
    //   54: getfield 27	com/tencent/image/SafeBitmapFactory$1:val$perWidth	I
    //   57: imul
    //   58: iload_1
    //   59: imul
    //   60: aload_0
    //   61: getfield 29	com/tencent/image/SafeBitmapFactory$1:val$fi	I
    //   64: iconst_1
    //   65: iadd
    //   66: aload_0
    //   67: getfield 31	com/tencent/image/SafeBitmapFactory$1:val$perHeight	I
    //   70: imul
    //   71: iload_1
    //   72: imul
    //   73: invokespecial 54	android/graphics/Rect:<init>	(IIII)V
    //   76: astore_3
    //   77: aload_0
    //   78: getfield 33	com/tencent/image/SafeBitmapFactory$1:val$dataSource	Ljava/lang/Object;
    //   81: iconst_1
    //   82: invokestatic 60	com/tencent/image/SafeBitmapFactory:access$000	(Ljava/lang/Object;Z)Landroid/graphics/BitmapRegionDecoder;
    //   85: astore_2
    //   86: aload_2
    //   87: aload_3
    //   88: aload_0
    //   89: getfield 23	com/tencent/image/SafeBitmapFactory$1:val$fopts	Landroid/graphics/BitmapFactory$Options;
    //   92: invokevirtual 66	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   95: astore 4
    //   97: aload_0
    //   98: getfield 35	com/tencent/image/SafeBitmapFactory$1:val$canvas	Landroid/graphics/Canvas;
    //   101: astore_3
    //   102: aload_3
    //   103: monitorenter
    //   104: aload_0
    //   105: getfield 35	com/tencent/image/SafeBitmapFactory$1:val$canvas	Landroid/graphics/Canvas;
    //   108: aload 4
    //   110: aload_0
    //   111: getfield 25	com/tencent/image/SafeBitmapFactory$1:val$fj	I
    //   114: aload_0
    //   115: getfield 27	com/tencent/image/SafeBitmapFactory$1:val$perWidth	I
    //   118: imul
    //   119: i2f
    //   120: aload_0
    //   121: getfield 29	com/tencent/image/SafeBitmapFactory$1:val$fi	I
    //   124: aload_0
    //   125: getfield 31	com/tencent/image/SafeBitmapFactory$1:val$perHeight	I
    //   128: imul
    //   129: i2f
    //   130: aconst_null
    //   131: invokevirtual 72	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   134: aload_3
    //   135: monitorexit
    //   136: aload 4
    //   138: invokevirtual 77	android/graphics/Bitmap:recycle	()V
    //   141: aload_2
    //   142: invokevirtual 78	android/graphics/BitmapRegionDecoder:recycle	()V
    //   145: goto +17 -> 162
    //   148: astore_2
    //   149: aload_3
    //   150: monitorexit
    //   151: aload_2
    //   152: athrow
    //   153: astore_2
    //   154: goto +16 -> 170
    //   157: astore_2
    //   158: aload_2
    //   159: invokevirtual 81	java/io/IOException:printStackTrace	()V
    //   162: aload_0
    //   163: getfield 37	com/tencent/image/SafeBitmapFactory$1:val$countDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   166: invokevirtual 86	java/util/concurrent/CountDownLatch:countDown	()V
    //   169: return
    //   170: aload_0
    //   171: getfield 37	com/tencent/image/SafeBitmapFactory$1:val$countDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   174: invokevirtual 86	java/util/concurrent/CountDownLatch:countDown	()V
    //   177: aload_2
    //   178: athrow
    //   179: iconst_1
    //   180: istore_1
    //   181: goto -160 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	1
    //   17	164	1	i	int
    //   85	57	2	localBitmapRegionDecoder	android.graphics.BitmapRegionDecoder
    //   148	4	2	localObject1	Object
    //   153	1	2	localObject2	Object
    //   157	21	2	localIOException	java.io.IOException
    //   95	42	4	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   104	136	148	finally
    //   149	151	148	finally
    //   0	18	153	finally
    //   21	104	153	finally
    //   136	145	153	finally
    //   151	153	153	finally
    //   158	162	153	finally
    //   0	18	157	java/io/IOException
    //   21	104	157	java/io/IOException
    //   136	145	157	java/io/IOException
    //   151	153	157	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.SafeBitmapFactory.1
 * JD-Core Version:    0.7.0.1
 */