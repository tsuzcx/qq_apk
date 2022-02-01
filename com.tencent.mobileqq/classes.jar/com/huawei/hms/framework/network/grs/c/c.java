package com.huawei.hms.framework.network.grs.c;

import com.huawei.hms.framework.common.Logger;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class c
{
  private static final String a = c.class.getSimpleName();
  
  /* Error */
  public static String a(String paramString, android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +6 -> 10
    //   7: ldc 31
    //   9: areturn
    //   10: aconst_null
    //   11: astore_3
    //   12: new 33	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: invokespecial 34	java/io/ByteArrayOutputStream:<init>	()V
    //   19: astore 4
    //   21: aload_1
    //   22: invokevirtual 40	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   25: aload_0
    //   26: invokevirtual 46	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore_1
    //   30: sipush 8192
    //   33: newarray byte
    //   35: astore_3
    //   36: aload_1
    //   37: aload_3
    //   38: invokevirtual 52	java/io/InputStream:read	([B)I
    //   41: istore_2
    //   42: iload_2
    //   43: iconst_m1
    //   44: if_icmpeq +43 -> 87
    //   47: aload 4
    //   49: aload_3
    //   50: iconst_0
    //   51: iload_2
    //   52: invokevirtual 56	java/io/ByteArrayOutputStream:write	([BII)V
    //   55: goto -19 -> 36
    //   58: astore_3
    //   59: getstatic 16	com/huawei/hms/framework/network/grs/c/c:a	Ljava/lang/String;
    //   62: ldc 58
    //   64: iconst_1
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_0
    //   71: aastore
    //   72: invokestatic 64	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload 4
    //   77: invokestatic 67	com/huawei/hms/framework/network/grs/c/c:a	(Ljava/io/OutputStream;)V
    //   80: aload_1
    //   81: invokestatic 70	com/huawei/hms/framework/network/grs/c/c:a	(Ljava/io/InputStream;)V
    //   84: ldc 31
    //   86: areturn
    //   87: aload 4
    //   89: invokevirtual 73	java/io/ByteArrayOutputStream:flush	()V
    //   92: new 75	java/lang/String
    //   95: dup
    //   96: aload 4
    //   98: invokevirtual 79	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   101: ldc 81
    //   103: invokespecial 84	java/lang/String:<init>	([BLjava/lang/String;)V
    //   106: astore_3
    //   107: aload 4
    //   109: invokestatic 67	com/huawei/hms/framework/network/grs/c/c:a	(Ljava/io/OutputStream;)V
    //   112: aload_1
    //   113: invokestatic 70	com/huawei/hms/framework/network/grs/c/c:a	(Ljava/io/InputStream;)V
    //   116: aload_3
    //   117: areturn
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_1
    //   121: aload 4
    //   123: invokestatic 67	com/huawei/hms/framework/network/grs/c/c:a	(Ljava/io/OutputStream;)V
    //   126: aload_1
    //   127: invokestatic 70	com/huawei/hms/framework/network/grs/c/c:a	(Ljava/io/InputStream;)V
    //   130: aload_0
    //   131: athrow
    //   132: astore_0
    //   133: goto -12 -> 121
    //   136: astore_0
    //   137: goto -16 -> 121
    //   140: astore_1
    //   141: aload_3
    //   142: astore_1
    //   143: goto -84 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramString	String
    //   0	146	1	paramContext	android.content.Context
    //   41	11	2	i	int
    //   11	39	3	arrayOfByte	byte[]
    //   58	1	3	localIOException	IOException
    //   106	36	3	str	String
    //   19	103	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   30	36	58	java/io/IOException
    //   36	42	58	java/io/IOException
    //   47	55	58	java/io/IOException
    //   87	107	58	java/io/IOException
    //   21	30	118	finally
    //   30	36	132	finally
    //   36	42	132	finally
    //   47	55	132	finally
    //   87	107	132	finally
    //   59	75	136	finally
    //   21	30	140	java/io/IOException
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Logger.e(a, "closeQuietly IOException", paramCloseable);
    }
  }
  
  public static void a(InputStream paramInputStream)
  {
    a(paramInputStream);
  }
  
  public static void a(OutputStream paramOutputStream)
  {
    a(paramOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.c
 * JD-Core Version:    0.7.0.1
 */