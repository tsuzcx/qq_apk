package com.huawei.agconnect.config.a;

import android.content.Context;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

class i
  extends h
{
  private final Map<String, String> c = new HashMap();
  private final Object d = new Object();
  private SecretKey e;
  private boolean f = true;
  
  i(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    try
    {
      paramContext = b("/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138");
      paramString = b("/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C");
      String str1 = b("/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B");
      String str2 = b("/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD");
      if ((paramContext != null) && (paramString != null) && (str1 != null) && (str2 != null))
      {
        this.e = g.a(e.a(paramContext), e.a(paramString), e.a(str1), e.a(str2));
        return;
      }
      this.f = false;
      return;
    }
    catch (NoSuchAlgorithmException|InvalidKeySpecException paramContext)
    {
      label110:
      break label110;
    }
    Log.e("SecurityResourcesReader", "Exception when reading the 'K&I' for 'Config'.");
    this.e = null;
  }
  
  private static byte[] a(SecretKey paramSecretKey, byte[] paramArrayOfByte)
  {
    if ((paramSecretKey != null) && (paramArrayOfByte != null))
    {
      byte[] arrayOfByte = Arrays.copyOfRange(paramArrayOfByte, 1, 17);
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, paramSecretKey, new IvParameterSpec(arrayOfByte));
      return localCipher.doFinal(paramArrayOfByte, arrayOfByte.length + 1, paramArrayOfByte.length - arrayOfByte.length - 1);
    }
    throw new NullPointerException("key or cipherText must not be null.");
  }
  
  private String b(String paramString)
  {
    return super.getString(paramString, null);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    if (!this.f)
    {
      paramString1 = b(paramString1);
      if (paramString1 != null) {
        return paramString1;
      }
      return paramString2;
    }
    if (this.e == null)
    {
      Log.e("SecurityResourcesReader", "KEY is null return def directly");
      return paramString2;
    }
    synchronized (this.d)
    {
      Object localObject2 = (String)this.c.get(paramString1);
      if (localObject2 != null) {
        return localObject2;
      }
      localObject2 = b(paramString1);
      if (localObject2 == null) {
        return paramString2;
      }
      try
      {
        localObject2 = a(this.e, e.a((String)localObject2));
        localObject2 = new String((byte[])localObject2, "UTF-8");
        this.c.put(paramString1, localObject2);
        return localObject2;
      }
      catch (GeneralSecurityException|UnsupportedEncodingException paramString1)
      {
        label131:
        break label131;
      }
      Log.e("SecurityResourcesReader", "Exception when reading the 'V' for 'Config'.");
      return paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.config.a.i
 * JD-Core Version:    0.7.0.1
 */