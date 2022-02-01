package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.utils.Base64Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;

public class Encrypt
{
  public static byte[] a(boolean paramBoolean, byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte != null)
    {
      int i = 128;
      if (paramBoolean)
      {
        i = 117;
        localObject = "RSA/ECB/PKCS1Padding";
      }
      else
      {
        localObject = "RSA";
      }
      paramString = new X509EncodedKeySpec(Base64Util.decode(paramString, 0));
      paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
      Object localObject = Cipher.getInstance((String)localObject);
      ((Cipher)localObject).init(1, paramString);
      int k = paramArrayOfByte.length;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      int j = 0;
      for (;;)
      {
        int m = k - j;
        if (m <= 0) {
          break;
        }
        if (m > i) {
          paramString = ((Cipher)localObject).doFinal(paramArrayOfByte, j, i);
        } else {
          paramString = ((Cipher)localObject).doFinal(paramArrayOfByte, j, m);
        }
        localByteArrayOutputStream.write(paramString, 0, paramString.length);
        j += i;
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    paramArrayOfByte = new IllegalArgumentException("encryptByPublicKey data null");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject1 = localObject2;
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
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.Encrypt
 * JD-Core Version:    0.7.0.1
 */