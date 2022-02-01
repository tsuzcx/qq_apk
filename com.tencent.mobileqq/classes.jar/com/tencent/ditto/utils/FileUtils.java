package com.tencent.ditto.utils;

import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

public class FileUtils
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static boolean deleteFile(File paramFile)
  {
    int i = 0;
    if (paramFile != null)
    {
      if (paramFile.isFile())
      {
        if (!paramFile.delete())
        {
          paramFile.deleteOnExit();
          return false;
        }
        return true;
      }
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          while (i < j)
          {
            deleteFile(arrayOfFile[i]);
            i += 1;
          }
        }
        return paramFile.delete();
      }
    }
    return false;
  }
  
  /* Error */
  public static String getMd5ByFile(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +123 -> 124
    //   4: aload_0
    //   5: invokevirtual 62	java/io/File:exists	()Z
    //   8: ifeq +116 -> 124
    //   11: aload_0
    //   12: invokevirtual 47	java/io/File:isDirectory	()Z
    //   15: ifeq +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: ldc 64
    //   22: invokestatic 70	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   25: astore_3
    //   26: aload_3
    //   27: invokevirtual 73	java/security/MessageDigest:reset	()V
    //   30: new 75	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 78	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore_2
    //   39: aload_2
    //   40: astore_1
    //   41: aload_3
    //   42: aload_2
    //   43: invokevirtual 82	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   46: getstatic 88	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   49: lconst_0
    //   50: aload_0
    //   51: invokevirtual 92	java/io/File:length	()J
    //   54: invokevirtual 98	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   57: invokevirtual 102	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   60: aload_2
    //   61: astore_1
    //   62: aload_3
    //   63: invokevirtual 106	java/security/MessageDigest:digest	()[B
    //   66: invokestatic 110	com/tencent/ditto/utils/FileUtils:toHexString	([B)Ljava/lang/String;
    //   69: astore_0
    //   70: aload_2
    //   71: invokevirtual 113	java/io/FileInputStream:close	()V
    //   74: aload_0
    //   75: areturn
    //   76: astore_1
    //   77: aload_2
    //   78: astore_0
    //   79: aload_1
    //   80: astore_2
    //   81: goto +12 -> 93
    //   84: astore_0
    //   85: aconst_null
    //   86: astore_1
    //   87: goto +27 -> 114
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_0
    //   93: aload_0
    //   94: astore_1
    //   95: ldc 115
    //   97: ldc 117
    //   99: aload_2
    //   100: invokestatic 123	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 113	java/io/FileInputStream:close	()V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_0
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 113	java/io/FileInputStream:close	()V
    //   122: aload_0
    //   123: athrow
    //   124: aconst_null
    //   125: areturn
    //   126: astore_1
    //   127: aload_0
    //   128: areturn
    //   129: astore_0
    //   130: aconst_null
    //   131: areturn
    //   132: astore_1
    //   133: goto -11 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramFile	File
    //   40	22	1	localObject1	Object
    //   76	4	1	localException1	Exception
    //   86	33	1	localFile	File
    //   126	1	1	localIOException1	java.io.IOException
    //   132	1	1	localIOException2	java.io.IOException
    //   38	43	2	localObject2	Object
    //   90	10	2	localException2	Exception
    //   25	38	3	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   41	60	76	java/lang/Exception
    //   62	70	76	java/lang/Exception
    //   20	39	84	finally
    //   20	39	90	java/lang/Exception
    //   41	60	113	finally
    //   62	70	113	finally
    //   95	103	113	finally
    //   70	74	126	java/io/IOException
    //   107	111	129	java/io/IOException
    //   118	122	132	java/io/IOException
  }
  
  public static String getMd5ByStream(InputStream paramInputStream)
  {
    try
    {
      byte[] arrayOfByte = new byte[4096];
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      int i = 0;
      while (i != -1)
      {
        int j = paramInputStream.read(arrayOfByte);
        i = j;
        if (j > 0)
        {
          localMessageDigest.update(arrayOfByte, 0, j);
          i = j;
        }
      }
      paramInputStream = toHexString(localMessageDigest.digest());
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      DittoLog.e("DITTO_UI", "", paramInputStream);
    }
    return null;
  }
  
  public static String getMd5ByString(String paramString)
  {
    try
    {
      paramString = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString, 0, paramString.length);
      paramString = toHexString(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString)
    {
      label29:
      break label29;
    }
    return null;
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(HEX_DIGITS[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(HEX_DIGITS[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */