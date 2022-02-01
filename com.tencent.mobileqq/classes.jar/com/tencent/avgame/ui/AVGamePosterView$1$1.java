package com.tencent.avgame.ui;

import android.graphics.Bitmap;

class AVGamePosterView$1$1
  implements Runnable
{
  AVGamePosterView$1$1(AVGamePosterView.1 param1, Bitmap paramBitmap) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/avgame/ui/AVGamePosterView$1$1:b	Lcom/tencent/avgame/ui/AVGamePosterView$1;
    //   4: getfield 32	com/tencent/avgame/ui/AVGamePosterView$1:a	Ljava/lang/String;
    //   7: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +17 -> 27
    //   13: aload_0
    //   14: getfield 14	com/tencent/avgame/ui/AVGamePosterView$1$1:b	Lcom/tencent/avgame/ui/AVGamePosterView$1;
    //   17: getfield 42	com/tencent/avgame/ui/AVGamePosterView$1:this$0	Lcom/tencent/avgame/ui/AVGamePosterView;
    //   20: invokevirtual 47	com/tencent/avgame/ui/AVGamePosterView:b	()Ljava/lang/String;
    //   23: astore_3
    //   24: goto +11 -> 35
    //   27: aload_0
    //   28: getfield 14	com/tencent/avgame/ui/AVGamePosterView$1$1:b	Lcom/tencent/avgame/ui/AVGamePosterView$1;
    //   31: getfield 32	com/tencent/avgame/ui/AVGamePosterView$1:a	Ljava/lang/String;
    //   34: astore_3
    //   35: new 49	java/io/File
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aconst_null
    //   45: astore 4
    //   47: aconst_null
    //   48: astore_2
    //   49: new 54	java/io/FileOutputStream
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 57	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   57: astore_1
    //   58: aload_0
    //   59: getfield 16	com/tencent/avgame/ui/AVGamePosterView$1$1:a	Landroid/graphics/Bitmap;
    //   62: getstatic 63	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   65: bipush 90
    //   67: aload_1
    //   68: invokevirtual 69	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   71: pop
    //   72: aload_0
    //   73: getfield 16	com/tencent/avgame/ui/AVGamePosterView$1$1:a	Landroid/graphics/Bitmap;
    //   76: invokevirtual 72	android/graphics/Bitmap:recycle	()V
    //   79: aload_1
    //   80: astore_2
    //   81: aload_0
    //   82: getfield 14	com/tencent/avgame/ui/AVGamePosterView$1$1:b	Lcom/tencent/avgame/ui/AVGamePosterView$1;
    //   85: getfield 42	com/tencent/avgame/ui/AVGamePosterView$1:this$0	Lcom/tencent/avgame/ui/AVGamePosterView;
    //   88: invokestatic 75	com/tencent/avgame/ui/AVGamePosterView:a	(Lcom/tencent/avgame/ui/AVGamePosterView;)Lcom/tencent/avgame/ui/IGamePosterView;
    //   91: ifnull +21 -> 112
    //   94: aload_0
    //   95: getfield 14	com/tencent/avgame/ui/AVGamePosterView$1$1:b	Lcom/tencent/avgame/ui/AVGamePosterView$1;
    //   98: getfield 42	com/tencent/avgame/ui/AVGamePosterView$1:this$0	Lcom/tencent/avgame/ui/AVGamePosterView;
    //   101: invokestatic 75	com/tencent/avgame/ui/AVGamePosterView:a	(Lcom/tencent/avgame/ui/AVGamePosterView;)Lcom/tencent/avgame/ui/IGamePosterView;
    //   104: aload_3
    //   105: invokeinterface 79 2 0
    //   110: aload_1
    //   111: astore_2
    //   112: aload_2
    //   113: invokevirtual 82	java/io/FileOutputStream:close	()V
    //   116: return
    //   117: astore_2
    //   118: goto +48 -> 166
    //   121: goto +17 -> 138
    //   124: astore_3
    //   125: goto +26 -> 151
    //   128: astore_3
    //   129: aload_2
    //   130: astore_1
    //   131: aload_3
    //   132: astore_2
    //   133: goto +33 -> 166
    //   136: aconst_null
    //   137: astore_1
    //   138: aload_1
    //   139: ifnull +26 -> 165
    //   142: aload_1
    //   143: astore_2
    //   144: goto -32 -> 112
    //   147: astore_3
    //   148: aload 4
    //   150: astore_1
    //   151: aload_1
    //   152: astore_2
    //   153: aload_3
    //   154: invokevirtual 85	java/io/FileNotFoundException:printStackTrace	()V
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 82	java/io/FileOutputStream:close	()V
    //   165: return
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 82	java/io/FileOutputStream:close	()V
    //   174: goto +5 -> 179
    //   177: aload_2
    //   178: athrow
    //   179: goto -2 -> 177
    //   182: astore_1
    //   183: goto -47 -> 136
    //   186: astore_2
    //   187: goto -66 -> 121
    //   190: astore_1
    //   191: return
    //   192: astore_1
    //   193: goto -19 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	1
    //   43	128	1	localObject1	Object
    //   182	1	1	localIOException1	java.io.IOException
    //   190	1	1	localException1	java.lang.Exception
    //   192	1	1	localException2	java.lang.Exception
    //   48	65	2	localObject2	Object
    //   117	13	2	localObject3	Object
    //   132	46	2	localObject4	Object
    //   186	1	2	localIOException2	java.io.IOException
    //   23	82	3	str	java.lang.String
    //   124	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   128	4	3	localObject5	Object
    //   147	7	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   45	104	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   58	79	117	finally
    //   81	110	117	finally
    //   58	79	124	java/io/FileNotFoundException
    //   81	110	124	java/io/FileNotFoundException
    //   49	58	128	finally
    //   153	157	128	finally
    //   49	58	147	java/io/FileNotFoundException
    //   49	58	182	java/io/IOException
    //   58	79	186	java/io/IOException
    //   81	110	186	java/io/IOException
    //   112	116	190	java/lang/Exception
    //   161	165	190	java/lang/Exception
    //   170	174	192	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGamePosterView.1.1
 * JD-Core Version:    0.7.0.1
 */