package com.tencent.biz.pubaccount.weishi_new.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class GZipUtil
{
  private static void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
        return;
      }
      catch (IOException paramInputStream)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("closeQuietly(), InputStream IOIOException: ");
        localStringBuilder.append(paramInputStream.getMessage());
        WSLog.d("GZipUtil", localStringBuilder.toString());
      }
    }
  }
  
  /* Error */
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 45	java/util/zip/GZIPInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 47	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   13: astore_0
    //   14: sipush 1024
    //   17: newarray byte
    //   19: astore_3
    //   20: aload_0
    //   21: aload_3
    //   22: iconst_0
    //   23: sipush 1024
    //   26: invokevirtual 51	java/util/zip/GZIPInputStream:read	([BII)I
    //   29: istore_2
    //   30: iload_2
    //   31: iconst_m1
    //   32: if_icmpeq +13 -> 45
    //   35: aload_1
    //   36: aload_3
    //   37: iconst_0
    //   38: iload_2
    //   39: invokevirtual 57	java/io/OutputStream:write	([BII)V
    //   42: goto -22 -> 20
    //   45: aload_0
    //   46: invokestatic 59	com/tencent/biz/pubaccount/weishi_new/util/GZipUtil:a	(Ljava/io/InputStream;)V
    //   49: return
    //   50: astore_1
    //   51: aload_0
    //   52: astore_3
    //   53: aload_1
    //   54: astore_0
    //   55: goto +64 -> 119
    //   58: astore_1
    //   59: goto +11 -> 70
    //   62: astore_0
    //   63: goto +56 -> 119
    //   66: astore_1
    //   67: aload 4
    //   69: astore_0
    //   70: aload_0
    //   71: astore_3
    //   72: new 20	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   79: astore 4
    //   81: aload_0
    //   82: astore_3
    //   83: aload 4
    //   85: ldc 61
    //   87: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_0
    //   92: astore_3
    //   93: aload 4
    //   95: aload_1
    //   96: invokevirtual 31	java/io/IOException:getMessage	()Ljava/lang/String;
    //   99: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_0
    //   104: astore_3
    //   105: ldc 33
    //   107: aload 4
    //   109: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 42	com/tencent/biz/pubaccount/weishi_new/util/WSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_0
    //   116: astore_3
    //   117: aload_1
    //   118: athrow
    //   119: aload_3
    //   120: invokestatic 59	com/tencent/biz/pubaccount/weishi_new/util/GZipUtil:a	(Ljava/io/InputStream;)V
    //   123: goto +5 -> 128
    //   126: aload_0
    //   127: athrow
    //   128: goto -2 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramInputStream	InputStream
    //   0	131	1	paramOutputStream	OutputStream
    //   29	10	2	i	int
    //   4	116	3	localObject	Object
    //   1	107	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   14	20	50	finally
    //   20	30	50	finally
    //   35	42	50	finally
    //   14	20	58	java/io/IOException
    //   20	30	58	java/io/IOException
    //   35	42	58	java/io/IOException
    //   5	14	62	finally
    //   72	81	62	finally
    //   83	91	62	finally
    //   93	103	62	finally
    //   105	115	62	finally
    //   117	119	62	finally
    //   5	14	66	java/io/IOException
  }
  
  private static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {
      try
      {
        paramOutputStream.close();
        return;
      }
      catch (IOException paramOutputStream)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("closeQuietly(), OutputStream IOIOException: ");
        localStringBuilder.append(paramOutputStream.getMessage());
        WSLog.d("GZipUtil", localStringBuilder.toString());
      }
    }
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 68	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 71	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_0
    //   9: new 73	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 74	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: invokestatic 76	com/tencent/biz/pubaccount/weishi_new/util/GZipUtil:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   22: aload_1
    //   23: invokevirtual 80	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   26: astore_2
    //   27: aload_1
    //   28: invokevirtual 83	java/io/ByteArrayOutputStream:flush	()V
    //   31: aload_1
    //   32: invokestatic 85	com/tencent/biz/pubaccount/weishi_new/util/GZipUtil:a	(Ljava/io/OutputStream;)V
    //   35: aload_0
    //   36: invokestatic 59	com/tencent/biz/pubaccount/weishi_new/util/GZipUtil:a	(Ljava/io/InputStream;)V
    //   39: aload_2
    //   40: areturn
    //   41: astore_2
    //   42: goto +39 -> 81
    //   45: astore_2
    //   46: new 20	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   53: astore_3
    //   54: aload_3
    //   55: ldc 61
    //   57: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_3
    //   62: aload_2
    //   63: invokevirtual 31	java/io/IOException:getMessage	()Ljava/lang/String;
    //   66: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: ldc 33
    //   72: aload_3
    //   73: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 42	com/tencent/biz/pubaccount/weishi_new/util/WSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_2
    //   80: athrow
    //   81: aload_1
    //   82: invokestatic 85	com/tencent/biz/pubaccount/weishi_new/util/GZipUtil:a	(Ljava/io/OutputStream;)V
    //   85: aload_0
    //   86: invokestatic 59	com/tencent/biz/pubaccount/weishi_new/util/GZipUtil:a	(Ljava/io/InputStream;)V
    //   89: aload_2
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramArrayOfByte	byte[]
    //   16	66	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   26	14	2	arrayOfByte	byte[]
    //   41	1	2	localObject	Object
    //   45	45	2	localIOException	IOException
    //   53	20	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   17	31	41	finally
    //   46	81	41	finally
    //   17	31	45	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.GZipUtil
 * JD-Core Version:    0.7.0.1
 */