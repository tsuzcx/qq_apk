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
      if (!paramFile.isFile()) {
        break label28;
      }
      if (paramFile.delete()) {
        break label26;
      }
      paramFile.deleteOnExit();
    }
    label26:
    label28:
    while (!paramFile.isDirectory())
    {
      return false;
      return true;
    }
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
  
  /* Error */
  public static String getMd5ByFile(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +17 -> 18
    //   4: aload_0
    //   5: invokevirtual 62	java/io/File:exists	()Z
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: invokevirtual 47	java/io/File:isDirectory	()Z
    //   15: ifeq +7 -> 22
    //   18: aconst_null
    //   19: astore_2
    //   20: aload_2
    //   21: areturn
    //   22: ldc 64
    //   24: invokestatic 70	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 73	java/security/MessageDigest:reset	()V
    //   32: new 75	java/io/FileInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 78	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: astore_1
    //   41: aload_2
    //   42: aload_1
    //   43: invokevirtual 82	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   46: getstatic 88	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   49: lconst_0
    //   50: aload_0
    //   51: invokevirtual 92	java/io/File:length	()J
    //   54: invokevirtual 98	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   57: invokevirtual 102	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   60: aload_2
    //   61: invokevirtual 106	java/security/MessageDigest:digest	()[B
    //   64: invokestatic 110	com/tencent/ditto/utils/FileUtils:toHexString	([B)Ljava/lang/String;
    //   67: astore_0
    //   68: aload_0
    //   69: astore_2
    //   70: aload_1
    //   71: ifnull -51 -> 20
    //   74: aload_1
    //   75: invokevirtual 113	java/io/FileInputStream:close	()V
    //   78: aload_0
    //   79: areturn
    //   80: astore_1
    //   81: aload_0
    //   82: areturn
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_0
    //   86: ldc 115
    //   88: ldc 117
    //   90: aload_1
    //   91: invokestatic 123	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: aload_0
    //   95: ifnull +7 -> 102
    //   98: aload_0
    //   99: invokevirtual 113	java/io/FileInputStream:close	()V
    //   102: aconst_null
    //   103: areturn
    //   104: astore_0
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +7 -> 115
    //   111: aload_1
    //   112: invokevirtual 113	java/io/FileInputStream:close	()V
    //   115: aload_0
    //   116: athrow
    //   117: astore_0
    //   118: goto -16 -> 102
    //   121: astore_1
    //   122: goto -7 -> 115
    //   125: astore_0
    //   126: goto -19 -> 107
    //   129: astore_2
    //   130: aload_0
    //   131: astore_1
    //   132: aload_2
    //   133: astore_0
    //   134: goto -27 -> 107
    //   137: astore_2
    //   138: aload_1
    //   139: astore_0
    //   140: aload_2
    //   141: astore_1
    //   142: goto -56 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramFile	File
    //   40	35	1	localFileInputStream	java.io.FileInputStream
    //   80	1	1	localIOException1	java.io.IOException
    //   83	8	1	localException1	Exception
    //   106	6	1	localObject1	Object
    //   121	1	1	localIOException2	java.io.IOException
    //   131	11	1	localObject2	Object
    //   19	51	2	localObject3	Object
    //   129	4	2	localObject4	Object
    //   137	4	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   74	78	80	java/io/IOException
    //   22	41	83	java/lang/Exception
    //   22	41	104	finally
    //   98	102	117	java/io/IOException
    //   111	115	121	java/io/IOException
    //   41	68	125	finally
    //   86	94	129	finally
    //   41	68	137	java/lang/Exception
  }
  
  public static String getMd5ByStream(InputStream paramInputStream)
  {
    int i = 0;
    try
    {
      byte[] arrayOfByte = new byte[4096];
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
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
    }
    catch (Exception paramInputStream)
    {
      DittoLog.e("DITTO_UI", "", paramInputStream);
      return null;
    }
    return paramInputStream;
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
    catch (Exception paramString) {}
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