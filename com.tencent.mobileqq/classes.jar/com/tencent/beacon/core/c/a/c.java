package com.tencent.beacon.core.c.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Base64;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class c
{
  public static byte[] a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if (paramInt == 1) {
      return c(paramString, paramArrayOfByte);
    }
    if (paramInt == 3) {
      return a(paramString, paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsAxNCSLyNUCOP1QqYStE8ZeiU\nv4afaMqEmoLCKb0mUZYvYOoVN7LPMi2IVY2MRaFJvuND3glVw1RDm2VJJtjQkwUd\n3kpR9TrHAf7UQOVTpNo3Vi7pXTOqZ6bh3ZA/fs56jDCCKV6+wT/pCeu8N6vVnPrD\nz3SdHIeNeWb/woazCwIDAQAB", 0));
        int i = paramContext.getApplicationInfo().targetSdkVersion;
        if (i < 28) {
          continue;
        }
        paramContext = KeyFactory.getInstance("RSA");
        paramContext = (RSAPublicKey)paramContext.generatePublic((KeySpec)localObject);
        localObject = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        ((Cipher)localObject).init(1, paramContext);
        paramContext = ((Cipher)localObject).doFinal(paramString.getBytes(Charset.forName("UTF-8")));
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        paramContext = null;
        continue;
      }
      return paramContext;
      paramContext = KeyFactory.getInstance("RSA", "BC");
    }
  }
  
  private static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    paramString = new StringBuilder(paramString);
    int i = paramString.length();
    while (i < 16)
    {
      paramString.append("0");
      i += 1;
    }
    paramString = paramString.toString().substring(0, 16);
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(Charset.forName("UTF-8")), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, localSecretKeySpec, new IvParameterSpec(paramString.getBytes(Charset.forName("UTF-8"))));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static byte[] b(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if (paramInt == 1) {
      return d(paramString, paramArrayOfByte);
    }
    if (paramInt == 3) {
      return b(paramString, paramArrayOfByte);
    }
    return null;
  }
  
  private static byte[] b(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    paramString = new StringBuilder(paramString);
    int i = paramString.length();
    while (i < 16)
    {
      paramString.append("0");
      i += 1;
    }
    paramString = paramString.toString().substring(0, 16);
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(Charset.forName("UTF-8")), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(1, localSecretKeySpec, new IvParameterSpec(paramString.getBytes(Charset.forName("UTF-8"))));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  private static byte[] c(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    DESKeySpec localDESKeySpec = new DESKeySpec(paramString.getBytes("UTF-8"));
    localCipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(paramString.getBytes("UTF-8")));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  private static byte[] d(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    DESKeySpec localDESKeySpec = new DESKeySpec(paramString.getBytes("UTF-8"));
    localCipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(paramString.getBytes("UTF-8")));
    return localCipher.doFinal(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.c.a.c
 * JD-Core Version:    0.7.0.1
 */