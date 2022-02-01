package com.tencent.avgame.ui;

import android.graphics.Bitmap;

class AVGamePKPosterView$1$1
  implements Runnable
{
  AVGamePKPosterView$1$1(AVGamePKPosterView.1 param1, Bitmap paramBitmap) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/avgame/ui/AVGamePKPosterView$1$1:b	Lcom/tencent/avgame/ui/AVGamePKPosterView$1;
    //   4: getfield 32	com/tencent/avgame/ui/AVGamePKPosterView$1:a	Ljava/lang/String;
    //   7: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +17 -> 27
    //   13: aload_0
    //   14: getfield 14	com/tencent/avgame/ui/AVGamePKPosterView$1$1:b	Lcom/tencent/avgame/ui/AVGamePKPosterView$1;
    //   17: getfield 42	com/tencent/avgame/ui/AVGamePKPosterView$1:this$0	Lcom/tencent/avgame/ui/AVGamePKPosterView;
    //   20: invokevirtual 48	com/tencent/avgame/ui/AVGamePKPosterView:c	()Ljava/lang/String;
    //   23: astore_3
    //   24: goto +11 -> 35
    //   27: aload_0
    //   28: getfield 14	com/tencent/avgame/ui/AVGamePKPosterView$1$1:b	Lcom/tencent/avgame/ui/AVGamePKPosterView$1;
    //   31: getfield 32	com/tencent/avgame/ui/AVGamePKPosterView$1:a	Ljava/lang/String;
    //   34: astore_3
    //   35: new 50	java/io/File
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_2
    //   44: aconst_null
    //   45: astore 4
    //   47: aconst_null
    //   48: astore 5
    //   50: aconst_null
    //   51: astore_1
    //   52: new 55	java/io/FileOutputStream
    //   55: dup
    //   56: aload_2
    //   57: invokespecial 58	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 16	com/tencent/avgame/ui/AVGamePKPosterView$1$1:a	Landroid/graphics/Bitmap;
    //   65: getstatic 64	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   68: bipush 90
    //   70: aload_2
    //   71: invokevirtual 70	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   74: pop
    //   75: aload_0
    //   76: getfield 16	com/tencent/avgame/ui/AVGamePKPosterView$1$1:a	Landroid/graphics/Bitmap;
    //   79: invokevirtual 73	android/graphics/Bitmap:recycle	()V
    //   82: aload_0
    //   83: getfield 14	com/tencent/avgame/ui/AVGamePKPosterView$1$1:b	Lcom/tencent/avgame/ui/AVGamePKPosterView$1;
    //   86: getfield 42	com/tencent/avgame/ui/AVGamePKPosterView$1:this$0	Lcom/tencent/avgame/ui/AVGamePKPosterView;
    //   89: invokestatic 76	com/tencent/avgame/ui/AVGamePKPosterView:a	(Lcom/tencent/avgame/ui/AVGamePKPosterView;)Lcom/tencent/avgame/ui/IGamePosterView;
    //   92: ifnull +19 -> 111
    //   95: aload_0
    //   96: getfield 14	com/tencent/avgame/ui/AVGamePKPosterView$1$1:b	Lcom/tencent/avgame/ui/AVGamePKPosterView$1;
    //   99: getfield 42	com/tencent/avgame/ui/AVGamePKPosterView$1:this$0	Lcom/tencent/avgame/ui/AVGamePKPosterView;
    //   102: invokestatic 76	com/tencent/avgame/ui/AVGamePKPosterView:a	(Lcom/tencent/avgame/ui/AVGamePKPosterView;)Lcom/tencent/avgame/ui/IGamePosterView;
    //   105: aload_3
    //   106: invokeinterface 80 2 0
    //   111: aload_2
    //   112: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   115: return
    //   116: astore_1
    //   117: goto +63 -> 180
    //   120: astore_3
    //   121: goto +19 -> 140
    //   124: astore_3
    //   125: goto +34 -> 159
    //   128: astore_3
    //   129: aload_1
    //   130: astore_2
    //   131: aload_3
    //   132: astore_1
    //   133: goto +47 -> 180
    //   136: astore_3
    //   137: aload 4
    //   139: astore_2
    //   140: aload_2
    //   141: astore_1
    //   142: aload_3
    //   143: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   146: aload_2
    //   147: ifnull +32 -> 179
    //   150: aload_2
    //   151: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   154: return
    //   155: astore_3
    //   156: aload 5
    //   158: astore_2
    //   159: aload_2
    //   160: astore_1
    //   161: aload_3
    //   162: invokevirtual 87	java/io/FileNotFoundException:printStackTrace	()V
    //   165: aload_2
    //   166: ifnull +13 -> 179
    //   169: aload_2
    //   170: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   173: return
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   179: return
    //   180: aload_2
    //   181: ifnull +15 -> 196
    //   184: aload_2
    //   185: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   188: goto +8 -> 196
    //   191: astore_2
    //   192: aload_2
    //   193: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   196: aload_1
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	1
    //   51	1	1	localObject1	Object
    //   116	14	1	localObject2	Object
    //   132	29	1	localObject3	Object
    //   174	23	1	localException1	java.lang.Exception
    //   43	142	2	localObject4	Object
    //   191	2	2	localException2	java.lang.Exception
    //   23	83	3	str	java.lang.String
    //   120	1	3	localIOException1	java.io.IOException
    //   124	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   128	4	3	localObject5	Object
    //   136	7	3	localIOException2	java.io.IOException
    //   155	7	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   45	93	4	localObject6	Object
    //   48	109	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   61	111	116	finally
    //   61	111	120	java/io/IOException
    //   61	111	124	java/io/FileNotFoundException
    //   52	61	128	finally
    //   142	146	128	finally
    //   161	165	128	finally
    //   52	61	136	java/io/IOException
    //   52	61	155	java/io/FileNotFoundException
    //   111	115	174	java/lang/Exception
    //   150	154	174	java/lang/Exception
    //   169	173	174	java/lang/Exception
    //   184	188	191	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGamePKPosterView.1.1
 * JD-Core Version:    0.7.0.1
 */