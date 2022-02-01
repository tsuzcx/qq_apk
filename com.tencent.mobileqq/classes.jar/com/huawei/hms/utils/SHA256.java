package com.huawei.hms.utils;

import com.huawei.hms.support.log.HMSLog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class SHA256
{
  /* Error */
  public static byte[] digest(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 5
    //   8: astore_3
    //   9: ldc 17
    //   11: invokestatic 23	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   14: astore 6
    //   16: aload 5
    //   18: astore_3
    //   19: new 25	java/io/BufferedInputStream
    //   22: dup
    //   23: new 27	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: invokespecial 33	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore_0
    //   35: sipush 4096
    //   38: newarray byte
    //   40: astore_3
    //   41: iconst_0
    //   42: istore_1
    //   43: aload_0
    //   44: aload_3
    //   45: invokevirtual 39	java/io/InputStream:read	([B)I
    //   48: istore_2
    //   49: iload_2
    //   50: iconst_m1
    //   51: if_icmpeq +18 -> 69
    //   54: iload_1
    //   55: iload_2
    //   56: iadd
    //   57: istore_1
    //   58: aload 6
    //   60: aload_3
    //   61: iconst_0
    //   62: iload_2
    //   63: invokevirtual 43	java/security/MessageDigest:update	([BII)V
    //   66: goto -23 -> 43
    //   69: iload_1
    //   70: ifle +15 -> 85
    //   73: aload 6
    //   75: invokevirtual 46	java/security/MessageDigest:digest	()[B
    //   78: astore_3
    //   79: aload_0
    //   80: invokestatic 51	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   83: aload_3
    //   84: areturn
    //   85: aload_0
    //   86: invokestatic 51	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   89: goto +26 -> 115
    //   92: astore 4
    //   94: aload_0
    //   95: astore_3
    //   96: aload 4
    //   98: astore_0
    //   99: goto +21 -> 120
    //   102: aload_0
    //   103: astore_3
    //   104: ldc 53
    //   106: ldc 55
    //   108: invokestatic 61	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_0
    //   112: invokestatic 51	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   115: iconst_0
    //   116: newarray byte
    //   118: areturn
    //   119: astore_0
    //   120: aload_3
    //   121: invokestatic 51	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   124: goto +5 -> 129
    //   127: aload_0
    //   128: athrow
    //   129: goto -2 -> 127
    //   132: astore_0
    //   133: aload 4
    //   135: astore_0
    //   136: goto -34 -> 102
    //   139: astore_3
    //   140: goto -38 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramFile	java.io.File
    //   42	28	1	i	int
    //   48	15	2	j	int
    //   8	113	3	localObject1	Object
    //   139	1	3	localNoSuchAlgorithmException	NoSuchAlgorithmException
    //   4	1	4	localObject2	Object
    //   92	42	4	localObject3	Object
    //   1	16	5	localObject4	Object
    //   14	60	6	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   35	41	92	finally
    //   43	49	92	finally
    //   58	66	92	finally
    //   73	79	92	finally
    //   9	16	119	finally
    //   19	35	119	finally
    //   104	111	119	finally
    //   9	16	132	java/security/NoSuchAlgorithmException
    //   9	16	132	java/io/IOException
    //   19	35	132	java/security/NoSuchAlgorithmException
    //   19	35	132	java/io/IOException
    //   35	41	139	java/security/NoSuchAlgorithmException
    //   35	41	139	java/io/IOException
    //   43	49	139	java/security/NoSuchAlgorithmException
    //   43	49	139	java/io/IOException
    //   58	66	139	java/security/NoSuchAlgorithmException
    //   58	66	139	java/io/IOException
    //   73	79	139	java/security/NoSuchAlgorithmException
    //   73	79	139	java/io/IOException
  }
  
  public static byte[] digest(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = MessageDigest.getInstance("SHA-256").digest(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NoSuchAlgorithmException");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      HMSLog.e("SHA256", localStringBuilder.toString());
    }
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.utils.SHA256
 * JD-Core Version:    0.7.0.1
 */