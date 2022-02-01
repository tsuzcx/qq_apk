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
    catch (Exception paramArrayOfByte)
    {
      label18:
      break label18;
    }
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
    //   5: astore_2
    //   6: new 48	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 51	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: sipush 16384
    //   18: newarray byte
    //   20: astore_3
    //   21: aload_0
    //   22: aload_3
    //   23: invokevirtual 55	java/io/FileInputStream:read	([B)I
    //   26: istore_1
    //   27: iload_1
    //   28: iconst_m1
    //   29: if_icmpeq +13 -> 42
    //   32: aload_2
    //   33: aload_3
    //   34: iconst_0
    //   35: iload_1
    //   36: invokevirtual 58	java/security/MessageDigest:update	([BII)V
    //   39: goto -18 -> 21
    //   42: aload_2
    //   43: invokevirtual 29	java/security/MessageDigest:digest	()[B
    //   46: astore_2
    //   47: aload_0
    //   48: invokevirtual 61	java/io/FileInputStream:close	()V
    //   51: aload_2
    //   52: areturn
    //   53: astore_2
    //   54: aload_0
    //   55: invokevirtual 61	java/io/FileInputStream:close	()V
    //   58: aload_2
    //   59: athrow
    //   60: aload_0
    //   61: invokevirtual 61	java/io/FileInputStream:close	()V
    //   64: aconst_null
    //   65: areturn
    //   66: astore_0
    //   67: aconst_null
    //   68: areturn
    //   69: astore_2
    //   70: goto -10 -> 60
    //   73: astore_0
    //   74: aload_2
    //   75: areturn
    //   76: astore_0
    //   77: goto -19 -> 58
    //   80: astore_0
    //   81: goto -17 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramString	String
    //   26	10	1	i	int
    //   5	47	2	localObject1	Object
    //   53	6	2	localObject2	Object
    //   69	6	2	localIOException	java.io.IOException
    //   20	14	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   21	27	53	finally
    //   32	39	53	finally
    //   42	47	53	finally
    //   0	21	66	java/io/FileNotFoundException
    //   0	21	66	java/security/NoSuchAlgorithmException
    //   47	51	66	java/io/FileNotFoundException
    //   47	51	66	java/security/NoSuchAlgorithmException
    //   54	58	66	java/io/FileNotFoundException
    //   54	58	66	java/security/NoSuchAlgorithmException
    //   58	60	66	java/io/FileNotFoundException
    //   58	60	66	java/security/NoSuchAlgorithmException
    //   60	64	66	java/io/FileNotFoundException
    //   60	64	66	java/security/NoSuchAlgorithmException
    //   21	27	69	java/io/IOException
    //   32	39	69	java/io/IOException
    //   42	47	69	java/io/IOException
    //   47	51	73	java/io/IOException
    //   54	58	76	java/io/IOException
    //   60	64	80	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.commonsdk.util.MD5Coding
 * JD-Core Version:    0.7.0.1
 */