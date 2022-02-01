package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.os.Build.VERSION;
import android.security.keystore.KeyGenParameterSpec.Builder;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class AesGcmKS
{
  private static final String C = "AndroidKeyStore";
  private static final int F = 256;
  private static final String TAG = AesGcmKS.class.getSimpleName();
  private static final String i = "";
  private static final String l = "AES/GCM/NoPadding";
  private static final int n = 12;
  
  @RequiresApi(api=23)
  public static String decrypt(String paramString1, String paramString2)
  {
    b.d(TAG, "a g ks de begin 1");
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      b.f(TAG, "alias or encrypt content is null");
      return "";
    }
    try
    {
      paramString1 = new String(decrypt(paramString1, HexUtil.hexStr2ByteArray(paramString2)), "UTF-8");
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      b.f(TAG, "decrypt: UnsupportedEncodingException : " + paramString1.getMessage());
    }
    return "";
  }
  
  @RequiresApi(api=23)
  public static byte[] decrypt(String paramString, byte[] paramArrayOfByte)
  {
    b.d(TAG, "a g ks de begin 2");
    byte[] arrayOfByte1 = new byte[0];
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null))
    {
      b.f(TAG, "alias or encrypt content is null");
      return arrayOfByte1;
    }
    if (!isBuildVersionHigherThan22())
    {
      b.f(TAG, "sdk version is too low");
      return arrayOfByte1;
    }
    if (paramArrayOfByte.length <= 12)
    {
      b.f(TAG, "Decrypt source data is invalid.");
      return arrayOfByte1;
    }
    paramString = e(paramString);
    if (paramString == null)
    {
      b.f(TAG, "Decrypt secret key is null");
      return arrayOfByte1;
    }
    byte[] arrayOfByte2 = Arrays.copyOf(paramArrayOfByte, 12);
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/GCM/NoPadding");
      localCipher.init(2, paramString, new GCMParameterSpec(128, arrayOfByte2));
      paramString = localCipher.doFinal(paramArrayOfByte, 12, paramArrayOfByte.length - 12);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      b.f(TAG, "NoSuchAlgorithmException : " + paramString.getMessage());
      return arrayOfByte1;
    }
    catch (NoSuchPaddingException paramString)
    {
      b.f(TAG, "NoSuchPaddingException : " + paramString.getMessage());
      return arrayOfByte1;
    }
    catch (InvalidKeyException paramString)
    {
      b.f(TAG, "InvalidKeyException : " + paramString.getMessage());
      return arrayOfByte1;
    }
    catch (InvalidAlgorithmParameterException paramString)
    {
      b.f(TAG, "InvalidAlgorithmParameterException : " + paramString.getMessage());
      return arrayOfByte1;
    }
    catch (IllegalBlockSizeException paramString)
    {
      b.f(TAG, "IllegalBlockSizeException : " + paramString.getMessage());
      return arrayOfByte1;
    }
    catch (BadPaddingException paramString)
    {
      b.f(TAG, "BadPaddingException : " + paramString.getMessage());
      return arrayOfByte1;
    }
    catch (Exception paramString)
    {
      b.f(TAG, "Exception: " + paramString.getMessage());
    }
    return arrayOfByte1;
  }
  
  @RequiresApi(api=23)
  private static SecretKey e(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = KeyStore.getInstance("AndroidKeyStore");
        ((KeyStore)localObject).load(null);
        localObject = ((KeyStore)localObject).getKey(paramString, null);
        if ((localObject == null) || (!(localObject instanceof SecretKey))) {
          continue;
        }
        paramString = (SecretKey)localObject;
      }
      catch (KeyStoreException paramString)
      {
        Object localObject;
        b.f(TAG, "KeyStoreException : " + paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (IOException paramString)
      {
        b.f(TAG, "IOException : " + paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (CertificateException paramString)
      {
        b.f(TAG, "CertificateException : " + paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (NoSuchAlgorithmException paramString)
      {
        b.f(TAG, "NoSuchAlgorithmException : " + paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (UnrecoverableKeyException paramString)
      {
        b.f(TAG, "UnrecoverableKeyException : " + paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (InvalidAlgorithmParameterException paramString)
      {
        b.f(TAG, "InvalidAlgorithmParameterException : " + paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (NoSuchProviderException paramString)
      {
        b.f(TAG, "NoSuchProviderException : " + paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (Exception paramString)
      {
        b.f(TAG, "Exception: " + paramString.getMessage());
        paramString = null;
        continue;
      }
      finally {}
      return paramString;
      localObject = KeyGenerator.getInstance("AES", "AndroidKeyStore");
      ((KeyGenerator)localObject).init(new KeyGenParameterSpec.Builder(paramString, 3).setBlockModes(new String[] { "GCM" }).setEncryptionPaddings(new String[] { "NoPadding" }).setKeySize(256).build());
      paramString = ((KeyGenerator)localObject).generateKey();
    }
  }
  
  @RequiresApi(api=23)
  public static String encrypt(String paramString1, String paramString2)
  {
    b.d(TAG, "a g ks en begin 1");
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      b.f(TAG, "alias or encrypt content is null");
      return "";
    }
    try
    {
      paramString1 = HexUtil.byteArray2HexStr(encrypt(paramString1, paramString2.getBytes("UTF-8")));
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      b.f(TAG, "encrypt: UnsupportedEncodingException : " + paramString1.getMessage());
    }
    return "";
  }
  
  @RequiresApi(api=23)
  public static byte[] encrypt(String paramString, byte[] paramArrayOfByte)
  {
    b.d(TAG, "a g ks en begin 2");
    byte[] arrayOfByte = new byte[0];
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null))
    {
      b.f(TAG, "alias or encrypt content is null");
      return arrayOfByte;
    }
    if (!isBuildVersionHigherThan22())
    {
      b.f(TAG, "sdk version is too low");
      return arrayOfByte;
    }
    Object localObject1 = arrayOfByte;
    Object localObject2 = arrayOfByte;
    Object localObject3 = arrayOfByte;
    Object localObject4 = arrayOfByte;
    Object localObject5 = arrayOfByte;
    Object localObject6 = arrayOfByte;
    try
    {
      localObject7 = Cipher.getInstance("AES/GCM/NoPadding");
      localObject1 = arrayOfByte;
      localObject2 = arrayOfByte;
      localObject3 = arrayOfByte;
      localObject4 = arrayOfByte;
      localObject5 = arrayOfByte;
      localObject6 = arrayOfByte;
      paramString = e(paramString);
      if (paramString == null)
      {
        localObject1 = arrayOfByte;
        localObject2 = arrayOfByte;
        localObject3 = arrayOfByte;
        localObject4 = arrayOfByte;
        localObject5 = arrayOfByte;
        localObject6 = arrayOfByte;
        b.f(TAG, "Encrypt secret key is null");
        return arrayOfByte;
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      b.f(TAG, "NoSuchAlgorithmException : " + paramString.getMessage());
      return localObject1;
      localObject1 = arrayOfByte;
      localObject2 = arrayOfByte;
      localObject3 = arrayOfByte;
      localObject4 = arrayOfByte;
      localObject5 = arrayOfByte;
      localObject6 = arrayOfByte;
      ((Cipher)localObject7).init(1, paramString);
      localObject1 = arrayOfByte;
      localObject2 = arrayOfByte;
      localObject3 = arrayOfByte;
      localObject4 = arrayOfByte;
      localObject5 = arrayOfByte;
      localObject6 = arrayOfByte;
      paramArrayOfByte = ((Cipher)localObject7).doFinal(paramArrayOfByte);
      localObject1 = arrayOfByte;
      localObject2 = arrayOfByte;
      localObject3 = arrayOfByte;
      localObject4 = arrayOfByte;
      localObject5 = arrayOfByte;
      localObject6 = arrayOfByte;
      localObject7 = ((Cipher)localObject7).getIV();
      if (localObject7 != null)
      {
        localObject1 = arrayOfByte;
        localObject2 = arrayOfByte;
        localObject3 = arrayOfByte;
        localObject4 = arrayOfByte;
        localObject5 = arrayOfByte;
        localObject6 = arrayOfByte;
        if (localObject7.length == 12) {}
      }
      else
      {
        localObject1 = arrayOfByte;
        localObject2 = arrayOfByte;
        localObject3 = arrayOfByte;
        localObject4 = arrayOfByte;
        localObject5 = arrayOfByte;
        localObject6 = arrayOfByte;
        b.f(TAG, "IV is invalid.");
        return arrayOfByte;
      }
    }
    catch (NoSuchPaddingException paramString)
    {
      Object localObject7;
      b.f(TAG, "NoSuchPaddingException : " + paramString.getMessage());
      return localObject2;
      localObject1 = arrayOfByte;
      localObject2 = arrayOfByte;
      localObject3 = arrayOfByte;
      localObject4 = arrayOfByte;
      localObject5 = arrayOfByte;
      localObject6 = arrayOfByte;
      paramString = Arrays.copyOf((byte[])localObject7, localObject7.length + paramArrayOfByte.length);
      localObject1 = paramString;
      localObject2 = paramString;
      localObject3 = paramString;
      localObject4 = paramString;
      localObject5 = paramString;
      localObject6 = paramString;
      System.arraycopy(paramArrayOfByte, 0, paramString, localObject7.length, paramArrayOfByte.length);
      return paramString;
    }
    catch (BadPaddingException paramString)
    {
      b.f(TAG, "BadPaddingException : " + paramString.getMessage());
      return localObject3;
    }
    catch (IllegalBlockSizeException paramString)
    {
      b.f(TAG, "IllegalBlockSizeException : " + paramString.getMessage());
      return localObject4;
    }
    catch (InvalidKeyException paramString)
    {
      b.f(TAG, "InvalidKeyException : " + paramString.getMessage());
      return localObject5;
    }
    catch (Exception paramString)
    {
      b.f(TAG, "Exception: " + paramString.getMessage());
    }
    return localObject6;
  }
  
  private static boolean isBuildVersionHigherThan22()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS
 * JD-Core Version:    0.7.0.1
 */