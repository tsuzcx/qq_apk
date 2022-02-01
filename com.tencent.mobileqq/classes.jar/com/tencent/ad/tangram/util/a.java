package com.tencent.ad.tangram.util;

import android.annotation.SuppressLint;
import com.tencent.ad.tangram.log.AdLog;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
  private static final String TAG = "AdCryptoUtil";
  private static Cipher decryptCipher;
  private static Cipher encryptCipher;
  
  public static byte[] decrypt(a.a parama, byte[] paramArrayOfByte)
  {
    if ((parama != null) && (parama.isValid())) {
      try
      {
        parama = getDecryptCipher(parama).doFinal(paramArrayOfByte);
        return parama;
      }
      catch (Throwable parama)
      {
        AdLog.e("AdCryptoUtil", "decrypt failed", parama);
        return null;
      }
    }
    AdLog.e("AdCryptoUtil", "decrypt params error");
    return null;
  }
  
  public static byte[] encrypt(a.a parama, byte[] paramArrayOfByte)
  {
    if ((parama != null) && (parama.isValid())) {
      try
      {
        parama = getEncryptCipher(parama).doFinal(paramArrayOfByte);
        return parama;
      }
      catch (Throwable parama)
      {
        AdLog.e("AdCryptoUtil", "encrypt failed", parama);
        return null;
      }
    }
    AdLog.e("AdCryptoUtil", "encrypt params error");
    return null;
  }
  
  private static Cipher getDecryptCipher(a.a parama)
  {
    try
    {
      if (decryptCipher != null)
      {
        parama = decryptCipher;
        return parama;
      }
      try
      {
        Cipher localCipher = Cipher.getInstance(parama.cipherAlgorithm);
        localCipher.init(2, new SecretKeySpec(parama.key, parama.keyAlgorithm));
        decryptCipher = localCipher;
      }
      catch (Throwable parama)
      {
        AdLog.e("AdCryptoUtil", "fail to init cipher", parama);
      }
      parama = decryptCipher;
      return parama;
    }
    finally {}
  }
  
  @SuppressLint({"TrulyRandom"})
  private static Cipher getEncryptCipher(a.a parama)
  {
    try
    {
      if (encryptCipher != null)
      {
        parama = encryptCipher;
        return parama;
      }
      try
      {
        Cipher localCipher = Cipher.getInstance(parama.cipherAlgorithm);
        localCipher.init(1, new SecretKeySpec(parama.key, parama.keyAlgorithm));
        encryptCipher = localCipher;
      }
      catch (Throwable parama)
      {
        AdLog.e("AdCryptoUtil", "fail to init cipher", parama);
      }
      parama = encryptCipher;
      return parama;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.a
 * JD-Core Version:    0.7.0.1
 */