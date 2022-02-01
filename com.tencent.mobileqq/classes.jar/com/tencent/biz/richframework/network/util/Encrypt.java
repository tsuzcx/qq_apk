package com.tencent.biz.richframework.network.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPOutputStream;

public class Encrypt
{
  private static final int MAX_ENCRYPT_BLOCK = 117;
  protected static final String MODE = "RSA";
  private static final int PADDING_MAX_ENCRYPT_BLOCK = 128;
  protected static final String PADDING_MODE = "RSA/ECB/PKCS1Padding";
  private static final int RADIX = 16;
  private static final String SEED = "51901";
  
  public static byte[] compress(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject1 = localObject2;
    try
    {
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localObject1 = localObject2;
      localGZIPOutputStream.write(paramArrayOfByte);
      localObject1 = localObject2;
      localGZIPOutputStream.close();
      localObject1 = localObject2;
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject1 = paramArrayOfByte;
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localObject1;
  }
  
  public static final String decrypt(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.length() == 0) {
      return "";
    }
    BigInteger localBigInteger = new BigInteger("51901");
    try
    {
      paramString = new String(new BigInteger(paramString, 16).xor(localBigInteger).toByteArray());
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static final String encrypt(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.length() == 0) {
      return "";
    }
    paramString = new BigInteger(paramString.getBytes());
    return new BigInteger("51901").xor(paramString).toString(16);
  }
  
  public static String md5(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      if (localMessageDigest != null)
      {
        localMessageDigest.reset();
        localMessageDigest.update(paramString.getBytes());
        return StringUtils.byte2HexString(localMessageDigest.digest());
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        localNoSuchAlgorithmException.printStackTrace();
        Object localObject = null;
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.util.Encrypt
 * JD-Core Version:    0.7.0.1
 */