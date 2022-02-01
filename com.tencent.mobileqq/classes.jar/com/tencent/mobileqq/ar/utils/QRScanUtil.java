package com.tencent.mobileqq.ar.utils;

public class QRScanUtil
{
  /* Error */
  public static boolean a(android.graphics.Bitmap paramBitmap, java.lang.String paramString, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 17	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 20	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: iconst_0
    //   11: istore 6
    //   13: iconst_0
    //   14: istore 5
    //   16: new 17	java/io/File
    //   19: dup
    //   20: aload_1
    //   21: iconst_0
    //   22: aload_1
    //   23: ldc 22
    //   25: invokevirtual 28	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   28: invokevirtual 32	java/lang/String:substring	(II)Ljava/lang/String;
    //   31: invokespecial 20	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 36	java/io/File:exists	()Z
    //   39: ifne +8 -> 47
    //   42: aload_1
    //   43: invokevirtual 39	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aconst_null
    //   48: astore 8
    //   50: aconst_null
    //   51: astore_1
    //   52: aload 7
    //   54: invokevirtual 36	java/io/File:exists	()Z
    //   57: ifne +24 -> 81
    //   60: aload 7
    //   62: invokevirtual 42	java/io/File:createNewFile	()Z
    //   65: pop
    //   66: goto +15 -> 81
    //   69: astore 9
    //   71: ldc 44
    //   73: iconst_1
    //   74: ldc 46
    //   76: aload 9
    //   78: invokestatic 52	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   81: new 54	java/io/BufferedOutputStream
    //   84: dup
    //   85: new 56	java/io/FileOutputStream
    //   88: dup
    //   89: aload 7
    //   91: invokespecial 59	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: invokespecial 62	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   97: astore 7
    //   99: aload_0
    //   100: aload_2
    //   101: iload_3
    //   102: aload 7
    //   104: invokevirtual 68	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   107: istore 6
    //   109: iload 6
    //   111: istore 5
    //   113: aload 7
    //   115: invokevirtual 71	java/io/BufferedOutputStream:flush	()V
    //   118: iload 4
    //   120: ifeq +11 -> 131
    //   123: iload 6
    //   125: istore 5
    //   127: aload_0
    //   128: invokevirtual 74	android/graphics/Bitmap:recycle	()V
    //   131: iload 6
    //   133: istore 4
    //   135: aload 7
    //   137: invokevirtual 77	java/io/BufferedOutputStream:close	()V
    //   140: iload 6
    //   142: ireturn
    //   143: astore_0
    //   144: aload_0
    //   145: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   148: iload 4
    //   150: ireturn
    //   151: astore_0
    //   152: aload 7
    //   154: astore_1
    //   155: goto +48 -> 203
    //   158: astore_2
    //   159: aload 7
    //   161: astore_0
    //   162: goto +15 -> 177
    //   165: astore_0
    //   166: goto +37 -> 203
    //   169: astore_2
    //   170: aload 8
    //   172: astore_0
    //   173: iload 6
    //   175: istore 5
    //   177: aload_0
    //   178: astore_1
    //   179: ldc 44
    //   181: iconst_1
    //   182: ldc 82
    //   184: aload_2
    //   185: invokestatic 52	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   188: aload_0
    //   189: ifnull +11 -> 200
    //   192: iload 5
    //   194: istore 4
    //   196: aload_0
    //   197: invokevirtual 77	java/io/BufferedOutputStream:close	()V
    //   200: iload 5
    //   202: ireturn
    //   203: aload_1
    //   204: ifnull +15 -> 219
    //   207: aload_1
    //   208: invokevirtual 77	java/io/BufferedOutputStream:close	()V
    //   211: goto +8 -> 219
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   219: aload_0
    //   220: athrow
    //   221: astore_1
    //   222: goto -175 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramBitmap	android.graphics.Bitmap
    //   0	225	1	paramString	java.lang.String
    //   0	225	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	225	3	paramInt	int
    //   0	225	4	paramBoolean	boolean
    //   14	187	5	bool1	boolean
    //   11	163	6	bool2	boolean
    //   8	152	7	localObject1	Object
    //   48	123	8	localObject2	Object
    //   69	8	9	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   60	66	69	java/lang/Exception
    //   135	140	143	java/io/IOException
    //   196	200	143	java/io/IOException
    //   99	109	151	finally
    //   113	118	151	finally
    //   127	131	151	finally
    //   99	109	158	java/lang/Exception
    //   113	118	158	java/lang/Exception
    //   127	131	158	java/lang/Exception
    //   81	99	165	finally
    //   179	188	165	finally
    //   81	99	169	java/lang/Exception
    //   207	211	214	java/io/IOException
    //   16	47	221	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.utils.QRScanUtil
 * JD-Core Version:    0.7.0.1
 */