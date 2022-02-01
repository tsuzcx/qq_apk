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
    //   1: getfield 13	com/tencent/avgame/ui/AVGamePosterView$1$1:jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1	Lcom/tencent/avgame/ui/AVGamePosterView$1;
    //   4: getfield 31	com/tencent/avgame/ui/AVGamePosterView$1:a	Ljava/lang/String;
    //   7: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +99 -> 109
    //   13: aload_0
    //   14: getfield 13	com/tencent/avgame/ui/AVGamePosterView$1$1:jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1	Lcom/tencent/avgame/ui/AVGamePosterView$1;
    //   17: getfield 41	com/tencent/avgame/ui/AVGamePosterView$1:this$0	Lcom/tencent/avgame/ui/AVGamePosterView;
    //   20: invokevirtual 46	com/tencent/avgame/ui/AVGamePosterView:a	()Ljava/lang/String;
    //   23: astore_3
    //   24: new 48	java/io/File
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: new 53	java/io/FileOutputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 56	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: aload_0
    //   45: getfield 15	com/tencent/avgame/ui/AVGamePosterView$1$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   48: getstatic 62	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   51: bipush 90
    //   53: aload_2
    //   54: invokevirtual 68	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   57: pop
    //   58: aload_2
    //   59: astore_1
    //   60: aload_0
    //   61: getfield 15	com/tencent/avgame/ui/AVGamePosterView$1$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   64: invokevirtual 71	android/graphics/Bitmap:recycle	()V
    //   67: aload_2
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 13	com/tencent/avgame/ui/AVGamePosterView$1$1:jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1	Lcom/tencent/avgame/ui/AVGamePosterView$1;
    //   73: getfield 41	com/tencent/avgame/ui/AVGamePosterView$1:this$0	Lcom/tencent/avgame/ui/AVGamePosterView;
    //   76: invokestatic 74	com/tencent/avgame/ui/AVGamePosterView:a	(Lcom/tencent/avgame/ui/AVGamePosterView;)Lcom/tencent/avgame/ui/IGamePosterView;
    //   79: ifnull +21 -> 100
    //   82: aload_2
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 13	com/tencent/avgame/ui/AVGamePosterView$1$1:jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1	Lcom/tencent/avgame/ui/AVGamePosterView$1;
    //   88: getfield 41	com/tencent/avgame/ui/AVGamePosterView$1:this$0	Lcom/tencent/avgame/ui/AVGamePosterView;
    //   91: invokestatic 74	com/tencent/avgame/ui/AVGamePosterView:a	(Lcom/tencent/avgame/ui/AVGamePosterView;)Lcom/tencent/avgame/ui/IGamePosterView;
    //   94: aload_3
    //   95: invokeinterface 79 2 0
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 82	java/io/FileOutputStream:close	()V
    //   108: return
    //   109: aload_0
    //   110: getfield 13	com/tencent/avgame/ui/AVGamePosterView$1$1:jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1	Lcom/tencent/avgame/ui/AVGamePosterView$1;
    //   113: getfield 31	com/tencent/avgame/ui/AVGamePosterView$1:a	Ljava/lang/String;
    //   116: astore_3
    //   117: goto -93 -> 24
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: astore_1
    //   125: aload_3
    //   126: invokevirtual 85	java/io/FileNotFoundException:printStackTrace	()V
    //   129: aload_2
    //   130: ifnull -22 -> 108
    //   133: aload_2
    //   134: invokevirtual 82	java/io/FileOutputStream:close	()V
    //   137: return
    //   138: astore_1
    //   139: return
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_2
    //   143: aload_2
    //   144: ifnull -36 -> 108
    //   147: aload_2
    //   148: invokevirtual 82	java/io/FileOutputStream:close	()V
    //   151: return
    //   152: astore_1
    //   153: return
    //   154: astore_2
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 82	java/io/FileOutputStream:close	()V
    //   165: aload_2
    //   166: athrow
    //   167: astore_1
    //   168: return
    //   169: astore_1
    //   170: goto -5 -> 165
    //   173: astore_2
    //   174: goto -17 -> 157
    //   177: astore_1
    //   178: goto -35 -> 143
    //   181: astore_3
    //   182: goto -59 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	1
    //   32	93	1	localObject1	Object
    //   138	1	1	localException1	java.lang.Exception
    //   140	1	1	localIOException1	java.io.IOException
    //   152	1	1	localException2	java.lang.Exception
    //   156	6	1	localObject2	Object
    //   167	1	1	localException3	java.lang.Exception
    //   169	1	1	localException4	java.lang.Exception
    //   177	1	1	localIOException2	java.io.IOException
    //   41	107	2	localFileOutputStream	java.io.FileOutputStream
    //   154	12	2	localObject3	Object
    //   173	1	2	localObject4	Object
    //   23	94	3	str	java.lang.String
    //   120	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   181	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   33	42	120	java/io/FileNotFoundException
    //   133	137	138	java/lang/Exception
    //   33	42	140	java/io/IOException
    //   147	151	152	java/lang/Exception
    //   33	42	154	finally
    //   104	108	167	java/lang/Exception
    //   161	165	169	java/lang/Exception
    //   44	58	173	finally
    //   60	67	173	finally
    //   69	82	173	finally
    //   84	100	173	finally
    //   125	129	173	finally
    //   44	58	177	java/io/IOException
    //   60	67	177	java/io/IOException
    //   69	82	177	java/io/IOException
    //   84	100	177	java/io/IOException
    //   44	58	181	java/io/FileNotFoundException
    //   60	67	181	java/io/FileNotFoundException
    //   69	82	181	java/io/FileNotFoundException
    //   84	100	181	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGamePosterView.1.1
 * JD-Core Version:    0.7.0.1
 */