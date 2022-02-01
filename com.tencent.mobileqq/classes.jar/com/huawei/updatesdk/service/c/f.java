package com.huawei.updatesdk.service.c;

import com.huawei.updatesdk.a.a.b.a.a.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class f
{
  public static boolean a(File paramFile1, File paramFile2)
  {
    int i = 0;
    if (!paramFile1.renameTo(paramFile2))
    {
      if (!b(paramFile1, paramFile2))
      {
        a.d("PkgManageUtils", "can not copy the file to new Path");
        return false;
      }
      i = 1;
    }
    if ((i != 0) && (!paramFile1.delete())) {
      a.d("PkgManageUtils", "can not delete old file");
    }
    return true;
  }
  
  /* Error */
  private static boolean a(InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 38	java/io/File:exists	()Z
    //   4: ifeq +17 -> 21
    //   7: aload_1
    //   8: invokevirtual 29	java/io/File:delete	()Z
    //   11: ifne +10 -> 21
    //   14: ldc 17
    //   16: ldc 40
    //   18: invokestatic 42	com/huawei/updatesdk/a/a/b/a/a/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: new 44	java/io/FileOutputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 48	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: astore_1
    //   30: sipush 4096
    //   33: newarray byte
    //   35: astore_3
    //   36: aload_0
    //   37: aload_3
    //   38: invokevirtual 54	java/io/InputStream:read	([B)I
    //   41: istore_2
    //   42: iload_2
    //   43: iflt +34 -> 77
    //   46: aload_1
    //   47: aload_3
    //   48: iconst_0
    //   49: iload_2
    //   50: invokevirtual 58	java/io/FileOutputStream:write	([BII)V
    //   53: goto -17 -> 36
    //   56: astore_0
    //   57: aload_1
    //   58: invokevirtual 62	java/io/FileOutputStream:flush	()V
    //   61: aload_1
    //   62: invokevirtual 66	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   65: invokevirtual 71	java/io/FileDescriptor:sync	()V
    //   68: aload_1
    //   69: invokevirtual 74	java/io/FileOutputStream:close	()V
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: iconst_0
    //   76: ireturn
    //   77: aload_1
    //   78: invokevirtual 62	java/io/FileOutputStream:flush	()V
    //   81: aload_1
    //   82: invokevirtual 66	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   85: invokevirtual 71	java/io/FileDescriptor:sync	()V
    //   88: aload_1
    //   89: invokevirtual 74	java/io/FileOutputStream:close	()V
    //   92: iconst_1
    //   93: ireturn
    //   94: astore_0
    //   95: ldc 17
    //   97: ldc 76
    //   99: aload_0
    //   100: invokestatic 79	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: goto -22 -> 81
    //   106: astore_0
    //   107: ldc 17
    //   109: ldc 76
    //   111: aload_0
    //   112: invokestatic 79	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: goto -27 -> 88
    //   118: astore_0
    //   119: ldc 17
    //   121: ldc 76
    //   123: aload_0
    //   124: invokestatic 79	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: goto -35 -> 92
    //   130: astore_3
    //   131: ldc 17
    //   133: ldc 76
    //   135: aload_3
    //   136: invokestatic 79	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   139: goto -78 -> 61
    //   142: astore_3
    //   143: ldc 17
    //   145: ldc 76
    //   147: aload_3
    //   148: invokestatic 79	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   151: goto -83 -> 68
    //   154: astore_1
    //   155: ldc 17
    //   157: ldc 76
    //   159: aload_1
    //   160: invokestatic 79	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: goto -91 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramInputStream	InputStream
    //   0	166	1	paramFile	File
    //   41	9	2	i	int
    //   35	13	3	arrayOfByte	byte[]
    //   130	6	3	localIOException1	IOException
    //   142	6	3	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   30	36	56	finally
    //   36	42	56	finally
    //   46	53	56	finally
    //   0	21	74	java/io/IOException
    //   21	30	74	java/io/IOException
    //   72	74	74	java/io/IOException
    //   95	103	74	java/io/IOException
    //   107	115	74	java/io/IOException
    //   119	127	74	java/io/IOException
    //   131	139	74	java/io/IOException
    //   143	151	74	java/io/IOException
    //   155	163	74	java/io/IOException
    //   77	81	94	java/io/IOException
    //   81	88	106	java/io/IOException
    //   88	92	118	java/io/IOException
    //   57	61	130	java/io/IOException
    //   61	68	142	java/io/IOException
    //   68	72	154	java/io/IOException
  }
  
  private static boolean b(File paramFile1, File paramFile2)
  {
    try
    {
      paramFile1 = new FileInputStream(paramFile1);
      try
      {
        boolean bool = a(paramFile1, paramFile2);
        return bool;
      }
      finally
      {
        paramFile1.close();
      }
      return false;
    }
    catch (IOException paramFile1)
    {
      a.d("PkgManageUtils", "copyFile IOException");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.c.f
 * JD-Core Version:    0.7.0.1
 */