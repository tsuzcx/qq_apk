package com.tencent.av.ui.guide;

import com.tencent.mobileqq.dinifly.ImageAssetDelegate;

class GuideHelper$LottieDrawableHelper$1$1
  implements ImageAssetDelegate
{
  GuideHelper$LottieDrawableHelper$1$1(GuideHelper.LottieDrawableHelper.1 param1) {}
  
  /* Error */
  @android.support.annotation.Nullable
  public android.graphics.Bitmap fetchBitmap(com.tencent.mobileqq.dinifly.LottieImageAsset paramLottieImageAsset)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 12	com/tencent/av/ui/guide/GuideHelper$LottieDrawableHelper$1$1:a	Lcom/tencent/av/ui/guide/GuideHelper$LottieDrawableHelper$1;
    //   6: getfield 28	com/tencent/av/ui/guide/GuideHelper$LottieDrawableHelper$1:a	Landroid/content/Context;
    //   9: invokevirtual 34	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: astore_2
    //   13: new 36	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: getstatic 43	com/tencent/av/ui/guide/GuideHelper:b	Ljava/lang/String;
    //   27: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 4
    //   33: aload_1
    //   34: invokevirtual 53	com/tencent/mobileqq/dinifly/LottieImageAsset:getFileName	()Ljava/lang/String;
    //   37: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_2
    //   42: aload 4
    //   44: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 62	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: new 64	android/graphics/BitmapFactory$Options
    //   56: dup
    //   57: invokespecial 65	android/graphics/BitmapFactory$Options:<init>	()V
    //   60: astore_3
    //   61: aload_2
    //   62: astore_1
    //   63: aload_3
    //   64: iconst_0
    //   65: putfield 69	android/graphics/BitmapFactory$Options:inScaled	Z
    //   68: aload_2
    //   69: astore_1
    //   70: aload_2
    //   71: aconst_null
    //   72: checkcast 71	android/graphics/Rect
    //   75: aload_3
    //   76: invokestatic 77	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   79: astore_3
    //   80: aload_2
    //   81: astore_1
    //   82: aload_2
    //   83: invokevirtual 82	java/io/InputStream:close	()V
    //   86: aload_2
    //   87: ifnull +7 -> 94
    //   90: aload_2
    //   91: invokevirtual 82	java/io/InputStream:close	()V
    //   94: aload_3
    //   95: areturn
    //   96: astore_3
    //   97: goto +12 -> 109
    //   100: astore_2
    //   101: aload_3
    //   102: astore_1
    //   103: goto +28 -> 131
    //   106: astore_3
    //   107: aconst_null
    //   108: astore_2
    //   109: aload_2
    //   110: astore_1
    //   111: ldc 84
    //   113: iconst_2
    //   114: ldc 86
    //   116: aload_3
    //   117: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload_2
    //   121: ifnull +7 -> 128
    //   124: aload_2
    //   125: invokevirtual 82	java/io/InputStream:close	()V
    //   128: aconst_null
    //   129: areturn
    //   130: astore_2
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 82	java/io/InputStream:close	()V
    //   139: aload_2
    //   140: athrow
    //   141: astore_1
    //   142: aload_3
    //   143: areturn
    //   144: astore_1
    //   145: aconst_null
    //   146: areturn
    //   147: astore_1
    //   148: goto -9 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	1
    //   0	151	1	paramLottieImageAsset	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   12	79	2	localObject1	Object
    //   100	1	2	localObject2	Object
    //   108	17	2	localObject3	Object
    //   130	10	2	localObject4	Object
    //   1	94	3	localObject5	Object
    //   96	6	3	localThrowable1	java.lang.Throwable
    //   106	37	3	localThrowable2	java.lang.Throwable
    //   20	23	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   53	61	96	java/lang/Throwable
    //   63	68	96	java/lang/Throwable
    //   70	80	96	java/lang/Throwable
    //   82	86	96	java/lang/Throwable
    //   2	51	100	finally
    //   2	51	106	java/lang/Throwable
    //   53	61	130	finally
    //   63	68	130	finally
    //   70	80	130	finally
    //   82	86	130	finally
    //   111	120	130	finally
    //   90	94	141	java/lang/Exception
    //   124	128	144	java/lang/Exception
    //   135	139	147	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper.LottieDrawableHelper.1.1
 * JD-Core Version:    0.7.0.1
 */