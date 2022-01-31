package com.tencent.beacon.core.protocol.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Base64;
import com.tencent.beacon.core.d.i;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class c
{
  public static byte[] a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if (paramInt == 1) {
      if ((paramString != null) && (paramArrayOfByte != null)) {}
    }
    while (paramInt != 3)
    {
      return null;
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      DESKeySpec localDESKeySpec = new DESKeySpec(paramString.getBytes("UTF-8"));
      localCipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(paramString.getBytes("UTF-8")));
      return localCipher.doFinal(paramArrayOfByte);
    }
    return a(paramString, paramArrayOfByte);
  }
  
  public static byte[] a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsAxNCSLyNUCOP1QqYStE8ZeiU\nv4afaMqEmoLCKb0mUZYvYOoVN7LPMi2IVY2MRaFJvuND3glVw1RDm2VJJtjQkwUd\n3kpR9TrHAf7UQOVTpNo3Vi7pXTOqZ6bh3ZA/fs56jDCCKV6+wT/pCeu8N6vVnPrD\nz3SdHIeNeWb/woazCwIDAQAB", 0));
      if (paramContext.getApplicationInfo().targetSdkVersion >= 28) {}
      for (paramContext = KeyFactory.getInstance("RSA");; paramContext = KeyFactory.getInstance("RSA", "BC"))
      {
        paramContext = (RSAPublicKey)paramContext.generatePublic((KeySpec)localObject);
        localObject = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        ((Cipher)localObject).init(1, paramContext);
        paramContext = ((Cipher)localObject).doFinal(paramString.getBytes());
        break;
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      i.a(paramContext);
      paramContext.printStackTrace();
      paramContext = null;
    }
  }
  
  private static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    int i = paramString.length();
    while (i < 16)
    {
      paramString = paramString + "0";
      i += 1;
    }
    paramString = paramString.substring(0, 16);
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, localSecretKeySpec, new IvParameterSpec(paramString.getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static byte[] b(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if (paramInt == 1) {
      if ((paramString != null) && (paramArrayOfByte != null)) {}
    }
    while (paramInt != 3)
    {
      return null;
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      DESKeySpec localDESKeySpec = new DESKeySpec(paramString.getBytes("UTF-8"));
      localCipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(paramString.getBytes("UTF-8")));
      return localCipher.doFinal(paramArrayOfByte);
    }
    return b(paramString, paramArrayOfByte);
  }
  
  private static byte[] b(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    int i = paramString.length();
    while (i < 16)
    {
      paramString = paramString + "0";
      i += 1;
    }
    paramString = paramString.substring(0, 16);
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(1, localSecretKeySpec, new IvParameterSpec(paramString.getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.protocol.a.c
 * JD-Core Version:    0.7.0.1
 */