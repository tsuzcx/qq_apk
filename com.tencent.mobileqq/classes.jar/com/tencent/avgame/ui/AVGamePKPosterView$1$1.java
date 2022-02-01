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
    //   1: getfield 13	com/tencent/avgame/ui/AVGamePKPosterView$1$1:jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView$1	Lcom/tencent/avgame/ui/AVGamePKPosterView$1;
    //   4: getfield 31	com/tencent/avgame/ui/AVGamePKPosterView$1:a	Ljava/lang/String;
    //   7: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +99 -> 109
    //   13: aload_0
    //   14: getfield 13	com/tencent/avgame/ui/AVGamePKPosterView$1$1:jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView$1	Lcom/tencent/avgame/ui/AVGamePKPosterView$1;
    //   17: getfield 41	com/tencent/avgame/ui/AVGamePKPosterView$1:this$0	Lcom/tencent/avgame/ui/AVGamePKPosterView;
    //   20: invokevirtual 46	com/tencent/avgame/ui/AVGamePKPosterView:a	()Ljava/lang/String;
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
    //   45: getfield 15	com/tencent/avgame/ui/AVGamePKPosterView$1$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   48: getstatic 62	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   51: bipush 90
    //   53: aload_2
    //   54: invokevirtual 68	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   57: pop
    //   58: aload_2
    //   59: astore_1
    //   60: aload_0
    //   61: getfield 15	com/tencent/avgame/ui/AVGamePKPosterView$1$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   64: invokevirtual 71	android/graphics/Bitmap:recycle	()V
    //   67: aload_2
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 13	com/tencent/avgame/ui/AVGamePKPosterView$1$1:jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView$1	Lcom/tencent/avgame/ui/AVGamePKPosterView$1;
    //   73: getfield 41	com/tencent/avgame/ui/AVGamePKPosterView$1:this$0	Lcom/tencent/avgame/ui/AVGamePKPosterView;
    //   76: invokestatic 74	com/tencent/avgame/ui/AVGamePKPosterView:a	(Lcom/tencent/avgame/ui/AVGamePKPosterView;)Lnpz;
    //   79: ifnull +21 -> 100
    //   82: aload_2
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 13	com/tencent/avgame/ui/AVGamePKPosterView$1$1:jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView$1	Lcom/tencent/avgame/ui/AVGamePKPosterView$1;
    //   88: getfield 41	com/tencent/avgame/ui/AVGamePKPosterView$1:this$0	Lcom/tencent/avgame/ui/AVGamePKPosterView;
    //   91: invokestatic 74	com/tencent/avgame/ui/AVGamePKPosterView:a	(Lcom/tencent/avgame/ui/AVGamePKPosterView;)Lnpz;
    //   94: aload_3
    //   95: invokeinterface 79 2 0
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 82	java/io/FileOutputStream:close	()V
    //   108: return
    //   109: aload_0
    //   110: getfield 13	com/tencent/avgame/ui/AVGamePKPosterView$1$1:jdField_a_of_type_ComTencentAvgameUiAVGamePKPosterView$1	Lcom/tencent/avgame/ui/AVGamePKPosterView$1;
    //   113: getfield 31	com/tencent/avgame/ui/AVGamePKPosterView$1:a	Ljava/lang/String;
    //   116: astore_3
    //   117: goto -93 -> 24
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 85	java/lang/Exception:printStackTrace	()V
    //   125: return
    //   126: astore_3
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_2
    //   130: astore_1
    //   131: aload_3
    //   132: invokevirtual 86	java/io/FileNotFoundException:printStackTrace	()V
    //   135: aload_2
    //   136: ifnull -28 -> 108
    //   139: aload_2
    //   140: invokevirtual 82	java/io/FileOutputStream:close	()V
    //   143: return
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 85	java/lang/Exception:printStackTrace	()V
    //   149: return
    //   150: astore_3
    //   151: aconst_null
    //   152: astore_2
    //   153: aload_2
    //   154: astore_1
    //   155: aload_3
    //   156: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   159: aload_2
    //   160: ifnull -52 -> 108
    //   163: aload_2
    //   164: invokevirtual 82	java/io/FileOutputStream:close	()V
    //   167: return
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 85	java/lang/Exception:printStackTrace	()V
    //   173: return
    //   174: astore_2
    //   175: aconst_null
    //   176: astore_1
    //   177: aload_1
    //   178: ifnull +7 -> 185
    //   181: aload_1
    //   182: invokevirtual 82	java/io/FileOutputStream:close	()V
    //   185: aload_2
    //   186: athrow
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 85	java/lang/Exception:printStackTrace	()V
    //   192: goto -7 -> 185
    //   195: astore_2
    //   196: goto -19 -> 177
    //   199: astore_3
    //   200: goto -47 -> 153
    //   203: astore_3
    //   204: goto -75 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	1
    //   32	52	1	localObject1	Object
    //   120	2	1	localException1	java.lang.Exception
    //   130	1	1	localObject2	Object
    //   144	2	1	localException2	java.lang.Exception
    //   154	1	1	localObject3	Object
    //   168	2	1	localException3	java.lang.Exception
    //   176	6	1	localObject4	Object
    //   187	2	1	localException4	java.lang.Exception
    //   41	123	2	localFileOutputStream	java.io.FileOutputStream
    //   174	12	2	localObject5	Object
    //   195	1	2	localObject6	Object
    //   23	94	3	str	java.lang.String
    //   126	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   150	6	3	localIOException1	java.io.IOException
    //   199	1	3	localIOException2	java.io.IOException
    //   203	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   104	108	120	java/lang/Exception
    //   33	42	126	java/io/FileNotFoundException
    //   139	143	144	java/lang/Exception
    //   33	42	150	java/io/IOException
    //   163	167	168	java/lang/Exception
    //   33	42	174	finally
    //   181	185	187	java/lang/Exception
    //   44	58	195	finally
    //   60	67	195	finally
    //   69	82	195	finally
    //   84	100	195	finally
    //   131	135	195	finally
    //   155	159	195	finally
    //   44	58	199	java/io/IOException
    //   60	67	199	java/io/IOException
    //   69	82	199	java/io/IOException
    //   84	100	199	java/io/IOException
    //   44	58	203	java/io/FileNotFoundException
    //   60	67	203	java/io/FileNotFoundException
    //   69	82	203	java/io/FileNotFoundException
    //   84	100	203	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGamePKPosterView.1.1
 * JD-Core Version:    0.7.0.1
 */