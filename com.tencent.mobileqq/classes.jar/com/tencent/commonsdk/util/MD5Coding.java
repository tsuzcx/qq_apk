package com.tencent.commonsdk.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class MD5Coding
{
  public static byte[] encode(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static String encode2HexStr(byte[] paramArrayOfByte)
  {
    return HexUtil.bytes2HexStr(encode(paramArrayOfByte));
  }
  
  /* Error */
  public static byte[] encodeFile(String paramString)
  {
    // Byte code:
    //   0: ldc 15
    //   2: invokestatic 21	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_3
    //   6: new 48	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 51	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_2
    //   15: sipush 16384
    //   18: newarray byte
    //   20: astore_0
    //   21: aload_2
    //   22: aload_0
    //   23: invokevirtual 55	java/io/FileInputStream:read	([B)I
    //   26: istore_1
    //   27: iload_1
    //   28: iconst_m1
    //   29: if_icmpeq +22 -> 51
    //   32: aload_3
    //   33: aload_0
    //   34: iconst_0
    //   35: iload_1
    //   36: invokevirtual 58	java/security/MessageDigest:update	([BII)V
    //   39: goto -18 -> 21
    //   42: astore_0
    //   43: aload_2
    //   44: invokevirtual 61	java/io/FileInputStream:close	()V
    //   47: aconst_null
    //   48: astore_0
    //   49: aload_0
    //   50: areturn
    //   51: aload_3
    //   52: invokevirtual 29	java/security/MessageDigest:digest	()[B
    //   55: astore_0
    //   56: aload_2
    //   57: invokevirtual 61	java/io/FileInputStream:close	()V
    //   60: goto -11 -> 49
    //   63: astore_2
    //   64: goto -15 -> 49
    //   67: astore_0
    //   68: aconst_null
    //   69: astore_0
    //   70: goto -21 -> 49
    //   73: astore_0
    //   74: aload_2
    //   75: invokevirtual 61	java/io/FileInputStream:close	()V
    //   78: aload_0
    //   79: athrow
    //   80: astore_0
    //   81: aconst_null
    //   82: areturn
    //   83: astore_2
    //   84: goto -6 -> 78
    //   87: astore_0
    //   88: aconst_null
    //   89: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramString	String
    //   26	10	1	i	int
    //   14	43	2	localFileInputStream	java.io.FileInputStream
    //   63	12	2	localIOException1	java.io.IOException
    //   83	1	2	localIOException2	java.io.IOException
    //   5	47	3	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   21	27	42	java/io/IOException
    //   32	39	42	java/io/IOException
    //   51	56	42	java/io/IOException
    //   56	60	63	java/io/IOException
    //   43	47	67	java/io/IOException
    //   21	27	73	finally
    //   32	39	73	finally
    //   51	56	73	finally
    //   0	21	80	java/io/FileNotFoundException
    //   43	47	80	java/io/FileNotFoundException
    //   56	60	80	java/io/FileNotFoundException
    //   74	78	80	java/io/FileNotFoundException
    //   78	80	80	java/io/FileNotFoundException
    //   74	78	83	java/io/IOException
    //   0	21	87	java/security/NoSuchAlgorithmException
    //   43	47	87	java/security/NoSuchAlgorithmException
    //   56	60	87	java/security/NoSuchAlgorithmException
    //   74	78	87	java/security/NoSuchAlgorithmException
    //   78	80	87	java/security/NoSuchAlgorithmException
  }
  
  public static String encodeFile2HexStr(String paramString)
  {
    return HexUtil.bytes2HexStr(encodeFile(paramString));
  }
  
  public static String encodeHexStr(String paramString)
  {
    try
    {
      paramString = HexUtil.bytes2HexStr(encode(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.util.MD5Coding
 * JD-Core Version:    0.7.0.1
 */