package com.tencent.avgame.gameroom;

import com.tencent.mobileqq.dinifly.ImageAssetDelegate;

class AVGameLottieHelper$1$1
  implements ImageAssetDelegate
{
  AVGameLottieHelper$1$1(AVGameLottieHelper.1 param1) {}
  
  /* Error */
  @android.support.annotation.Nullable
  public android.graphics.Bitmap fetchBitmap(com.tencent.mobileqq.dinifly.LottieImageAsset paramLottieImageAsset)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 27	com/tencent/mobileqq/dinifly/LottieImageAsset:getFileName	()Ljava/lang/String;
    //   4: astore_1
    //   5: new 29	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: aload_0
    //   15: getfield 12	com/tencent/avgame/gameroom/AVGameLottieHelper$1$1:a	Lcom/tencent/avgame/gameroom/AVGameLottieHelper$1;
    //   18: getfield 35	com/tencent/avgame/gameroom/AVGameLottieHelper$1:a	Ljava/lang/String;
    //   21: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_3
    //   26: aload_1
    //   27: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_3
    //   32: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore_1
    //   36: new 44	java/io/File
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: invokevirtual 51	java/io/File:exists	()Z
    //   47: istore_2
    //   48: iload_2
    //   49: ifne +55 -> 104
    //   52: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +74 -> 129
    //   58: new 29	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   65: astore_3
    //   66: aload_3
    //   67: ldc 58
    //   69: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_3
    //   74: iload_2
    //   75: invokevirtual 61	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: ldc 63
    //   82: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_3
    //   87: aload_1
    //   88: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: ldc 65
    //   94: iconst_2
    //   95: aload_3
    //   96: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aconst_null
    //   103: areturn
    //   104: aload_1
    //   105: invokestatic 74	com/tencent/avgame/gameroom/AVGameLottieHelper:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   108: astore_1
    //   109: aload_1
    //   110: areturn
    //   111: astore_1
    //   112: goto +15 -> 127
    //   115: astore_1
    //   116: ldc 65
    //   118: iconst_2
    //   119: ldc 76
    //   121: aload_1
    //   122: invokestatic 80	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   125: aconst_null
    //   126: areturn
    //   127: aload_1
    //   128: athrow
    //   129: aconst_null
    //   130: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	1
    //   0	131	1	paramLottieImageAsset	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   47	28	2	bool	boolean
    //   12	84	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	48	111	finally
    //   52	102	111	finally
    //   104	109	111	finally
    //   116	125	111	finally
    //   0	48	115	java/lang/Throwable
    //   52	102	115	java/lang/Throwable
    //   104	109	115	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.AVGameLottieHelper.1.1
 * JD-Core Version:    0.7.0.1
 */