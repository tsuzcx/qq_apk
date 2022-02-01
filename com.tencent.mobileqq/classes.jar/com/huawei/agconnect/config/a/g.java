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

class g
  extends f
{
  private final Map<String, String> a = new HashMap();
  private final Object b = new Object();
  private SecretKey c;
  
  g(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    try
    {
      paramContext = a("/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138");
      paramString = a("/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C");
      String str1 = a("/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B");
      String str2 = a("/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD");
      if ((paramContext != null) && (paramString != null) && (str1 != null) && (str2 != null)) {
        this.c = e.a(c.a(paramContext), c.a(paramString), c.a(str1), c.a(str2));
      }
      return;
    }
    catch (NoSuchAlgorithmException paramContext)
    {
      Log.e("SecurityResourcesReader", "Exception when reading the 'K&I' for 'Config'.");
      this.c = null;
      return;
    }
    catch (InvalidKeySpecException paramContext)
    {
      label100:
      break label100;
    }
  }
  
  private String a(String paramString)
  {
    return super.a(paramString, null);
  }
  
  private static byte[] a(SecretKey paramSecretKey, byte[] paramArrayOfByte)
  {
    if ((paramSecretKey == null) || (paramArrayOfByte == null)) {
      throw new NullPointerException("key or cipherText must not be null.");
    }
    byte[] arrayOfByte = Arrays.copyOfRange(paramArrayOfByte, 1, 17);
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, paramSecretKey, new IvParameterSpec(arrayOfByte));
    return localCipher.doFinal(paramArrayOfByte, arrayOfByte.length + 1, paramArrayOfByte.length - arrayOfByte.length - 1);
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (this.c == null)
    {
      Log.e("SecurityResourcesReader", "KEY is null return def directly");
      return paramString2;
    }
    String str;
    synchronized (this.b)
    {
      str = (String)this.a.get(paramString1);
      if (str != null) {
        return str;
      }
      str = a(paramString1);
      if (str == null) {
        return paramString2;
      }
    }
    try
    {
      str = new String(a(this.c, c.a(str)), "UTF-8");
      this.a.put(paramString1, str);
      return str;
    }
    catch (GeneralSecurityException paramString1)
    {
      break label111;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      label111:
      break label111;
    }
    Log.e("SecurityResourcesReader", "Exception when reading the 'V' for 'Config'.");
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.config.a.g
 * JD-Core Version:    0.7.0.1
 */