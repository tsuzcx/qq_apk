package com.huawei.hms.hatool;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;

public final class r0
{
  /* Error */
  public static String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_2
    //   7: new 12	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 16	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_0
    //   16: new 18	com/huawei/hms/hatool/o0
    //   19: dup
    //   20: sipush 1024
    //   23: invokespecial 21	com/huawei/hms/hatool/o0:<init>	(I)V
    //   26: astore_2
    //   27: sipush 1024
    //   30: newarray byte
    //   32: astore_3
    //   33: aload_0
    //   34: aload_3
    //   35: invokevirtual 25	java/io/FileInputStream:read	([B)I
    //   38: istore_1
    //   39: iload_1
    //   40: iconst_m1
    //   41: if_icmpeq +12 -> 53
    //   44: aload_2
    //   45: aload_3
    //   46: iload_1
    //   47: invokevirtual 28	com/huawei/hms/hatool/o0:a	([BI)V
    //   50: goto -17 -> 33
    //   53: aload_2
    //   54: invokevirtual 32	com/huawei/hms/hatool/o0:b	()I
    //   57: istore_1
    //   58: iload_1
    //   59: ifne +10 -> 69
    //   62: aload_0
    //   63: invokestatic 35	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   66: ldc 37
    //   68: areturn
    //   69: new 39	java/lang/String
    //   72: dup
    //   73: aload_2
    //   74: invokevirtual 42	com/huawei/hms/hatool/o0:a	()[B
    //   77: ldc 44
    //   79: invokespecial 47	java/lang/String:<init>	([BLjava/lang/String;)V
    //   82: astore_2
    //   83: aload_0
    //   84: invokestatic 35	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   87: aload_2
    //   88: areturn
    //   89: astore_3
    //   90: aload_0
    //   91: astore_2
    //   92: aload_3
    //   93: astore_0
    //   94: goto +45 -> 139
    //   97: goto +10 -> 107
    //   100: goto +23 -> 123
    //   103: astore_0
    //   104: goto +35 -> 139
    //   107: aload_0
    //   108: astore_2
    //   109: ldc 49
    //   111: ldc 51
    //   113: invokestatic 57	com/huawei/hms/hatool/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_0
    //   117: invokestatic 35	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   120: ldc 37
    //   122: areturn
    //   123: aload_0
    //   124: astore_2
    //   125: ldc 49
    //   127: ldc 59
    //   129: invokestatic 57	com/huawei/hms/hatool/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: invokestatic 35	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   136: ldc 37
    //   138: areturn
    //   139: aload_2
    //   140: invokestatic 35	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   143: goto +5 -> 148
    //   146: aload_0
    //   147: athrow
    //   148: goto -2 -> 146
    //   151: astore_0
    //   152: aload 4
    //   154: astore_0
    //   155: goto -32 -> 123
    //   158: astore_0
    //   159: aload_3
    //   160: astore_0
    //   161: goto -54 -> 107
    //   164: astore_2
    //   165: goto -65 -> 100
    //   168: astore_2
    //   169: goto -72 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramFile	java.io.File
    //   38	21	1	i	int
    //   6	134	2	localObject1	Object
    //   164	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   168	1	2	localIOException	IOException
    //   1	45	3	arrayOfByte	byte[]
    //   89	71	3	localObject2	Object
    //   3	150	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   16	33	89	finally
    //   33	39	89	finally
    //   44	50	89	finally
    //   53	58	89	finally
    //   69	83	89	finally
    //   7	16	103	finally
    //   109	116	103	finally
    //   125	132	103	finally
    //   7	16	151	java/io/FileNotFoundException
    //   7	16	158	java/io/IOException
    //   16	33	164	java/io/FileNotFoundException
    //   33	39	164	java/io/FileNotFoundException
    //   44	50	164	java/io/FileNotFoundException
    //   53	58	164	java/io/FileNotFoundException
    //   69	83	164	java/io/FileNotFoundException
    //   16	33	168	java/io/IOException
    //   33	39	168	java/io/IOException
    //   44	50	168	java/io/IOException
    //   53	58	168	java/io/IOException
    //   69	83	168	java/io/IOException
  }
  
  public static String a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramInputStream = localByteArrayOutputStream.toString("UTF-8");
      a(localByteArrayOutputStream);
      return paramInputStream;
    }
    finally
    {
      a(localByteArrayOutputStream);
    }
    for (;;)
    {
      throw paramInputStream;
    }
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
      label11:
      break label11;
    }
    y.f("hmsSdk", "closeQuietly(): Exception when closing the closeable!");
  }
  
  /* Error */
  public static void a(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 87	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 88	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: aload_0
    //   12: astore_2
    //   13: aload_0
    //   14: aload_1
    //   15: ldc 44
    //   17: invokevirtual 92	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   20: invokevirtual 95	java/io/FileOutputStream:write	([B)V
    //   23: aload_0
    //   24: astore_2
    //   25: aload_0
    //   26: invokevirtual 98	java/io/FileOutputStream:flush	()V
    //   29: goto +37 -> 66
    //   32: astore_1
    //   33: aload_2
    //   34: astore_0
    //   35: goto +36 -> 71
    //   38: astore_1
    //   39: aload_2
    //   40: astore_0
    //   41: goto +30 -> 71
    //   44: aconst_null
    //   45: astore_0
    //   46: ldc 100
    //   48: astore_1
    //   49: aload_0
    //   50: astore_2
    //   51: ldc 49
    //   53: aload_1
    //   54: invokestatic 57	com/huawei/hms/hatool/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: goto +9 -> 66
    //   60: ldc 102
    //   62: astore_1
    //   63: goto -14 -> 49
    //   66: aload_0
    //   67: invokestatic 35	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   70: return
    //   71: aload_0
    //   72: invokestatic 35	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   75: goto +5 -> 80
    //   78: aload_1
    //   79: athrow
    //   80: goto -2 -> 78
    //   83: astore_0
    //   84: goto +15 -> 99
    //   87: astore_0
    //   88: goto -44 -> 44
    //   91: astore_1
    //   92: goto -32 -> 60
    //   95: astore_1
    //   96: goto -50 -> 46
    //   99: aconst_null
    //   100: astore_0
    //   101: goto -41 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramFile	java.io.File
    //   0	104	1	paramString	String
    //   1	50	2	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   13	23	32	finally
    //   25	29	32	finally
    //   51	57	32	finally
    //   2	11	38	finally
    //   2	11	83	java/io/FileNotFoundException
    //   2	11	87	java/io/IOException
    //   13	23	91	java/io/FileNotFoundException
    //   25	29	91	java/io/FileNotFoundException
    //   13	23	95	java/io/IOException
    //   25	29	95	java/io/IOException
  }
  
  public static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream)
    {
      label9:
      break label9;
    }
    y.f("hmsSdk", "closeStream(): Exception: close OutputStream error!");
  }
  
  public static void a(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      paramHttpURLConnection.getInputStream().close();
    }
    catch (Exception localException)
    {
      label10:
      break label10;
    }
    y.f("hmsSdk", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
    paramHttpURLConnection.disconnect();
    y.a("hmsSdk", " connHttp disconnect");
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Deflater localDeflater = new Deflater();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    paramArrayOfByte = new byte[1024];
    while (!localDeflater.finished()) {
      localByteArrayOutputStream.write(paramArrayOfByte, 0, localDeflater.deflate(paramArrayOfByte));
    }
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localDeflater.end();
    a(localByteArrayOutputStream);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.r0
 * JD-Core Version:    0.7.0.1
 */