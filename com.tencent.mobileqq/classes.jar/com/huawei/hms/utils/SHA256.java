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
    //   1: astore_3
    //   2: ldc 17
    //   4: invokestatic 23	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   7: astore 4
    //   9: new 25	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 28	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore_0
    //   18: new 30	java/io/BufferedInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 33	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_0
    //   27: aload_0
    //   28: astore_3
    //   29: sipush 4096
    //   32: newarray byte
    //   34: astore 5
    //   36: iconst_0
    //   37: istore_1
    //   38: aload_0
    //   39: astore_3
    //   40: aload_0
    //   41: aload 5
    //   43: invokevirtual 39	java/io/InputStream:read	([B)I
    //   46: istore_2
    //   47: iload_2
    //   48: iconst_m1
    //   49: if_icmpeq +39 -> 88
    //   52: iload_1
    //   53: iload_2
    //   54: iadd
    //   55: istore_1
    //   56: aload_0
    //   57: astore_3
    //   58: aload 4
    //   60: aload 5
    //   62: iconst_0
    //   63: iload_2
    //   64: invokevirtual 43	java/security/MessageDigest:update	([BII)V
    //   67: goto -29 -> 38
    //   70: astore_3
    //   71: aload_0
    //   72: astore_3
    //   73: ldc 45
    //   75: ldc 47
    //   77: invokestatic 53	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload_0
    //   81: invokestatic 58	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   84: iconst_0
    //   85: newarray byte
    //   87: areturn
    //   88: iload_1
    //   89: ifle +19 -> 108
    //   92: aload_0
    //   93: astore_3
    //   94: aload 4
    //   96: invokevirtual 61	java/security/MessageDigest:digest	()[B
    //   99: astore 4
    //   101: aload_0
    //   102: invokestatic 58	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   105: aload 4
    //   107: areturn
    //   108: aload_0
    //   109: invokestatic 58	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   112: goto -28 -> 84
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_3
    //   118: aload_3
    //   119: invokestatic 58	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   122: aload_0
    //   123: athrow
    //   124: astore_0
    //   125: goto -7 -> 118
    //   128: astore_0
    //   129: aload_3
    //   130: astore_0
    //   131: goto -60 -> 71
    //   134: astore_0
    //   135: aload_3
    //   136: astore_0
    //   137: goto -66 -> 71
    //   140: astore_0
    //   141: goto -70 -> 71
    //   144: astore_0
    //   145: goto -74 -> 71
    //   148: astore_0
    //   149: aload_3
    //   150: astore_0
    //   151: goto -80 -> 71
    //   154: astore_0
    //   155: aload_3
    //   156: astore_0
    //   157: goto -86 -> 71
    //   160: astore_3
    //   161: goto -90 -> 71
    //   164: astore_3
    //   165: goto -94 -> 71
    //   168: astore_3
    //   169: goto -98 -> 71
    //   172: astore_3
    //   173: goto -102 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramFile	java.io.File
    //   37	52	1	i	int
    //   46	18	2	j	int
    //   1	57	3	localFile1	java.io.File
    //   70	1	3	localNoSuchAlgorithmException	NoSuchAlgorithmException
    //   72	64	3	localFile2	java.io.File
    //   7	99	4	localObject	Object
    //   34	27	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   29	36	70	java/security/NoSuchAlgorithmException
    //   40	47	70	java/security/NoSuchAlgorithmException
    //   58	67	70	java/security/NoSuchAlgorithmException
    //   94	101	70	java/security/NoSuchAlgorithmException
    //   2	9	115	finally
    //   9	18	115	finally
    //   18	27	115	finally
    //   29	36	124	finally
    //   40	47	124	finally
    //   58	67	124	finally
    //   73	80	124	finally
    //   94	101	124	finally
    //   2	9	128	java/security/NoSuchAlgorithmException
    //   9	18	128	java/security/NoSuchAlgorithmException
    //   18	27	128	java/security/NoSuchAlgorithmException
    //   2	9	134	java/io/IOException
    //   9	18	148	java/io/IOException
    //   18	27	154	java/io/IOException
    //   29	36	160	java/io/IOException
    //   40	47	164	java/io/IOException
    //   58	67	168	java/io/IOException
    //   94	101	172	java/io/IOException
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
      HMSLog.e("SHA256", "NoSuchAlgorithmException" + paramArrayOfByte.getMessage());
    }
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.utils.SHA256
 * JD-Core Version:    0.7.0.1
 */