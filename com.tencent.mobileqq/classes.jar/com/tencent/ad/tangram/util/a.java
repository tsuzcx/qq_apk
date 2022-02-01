package com.tencent.ad.tangram.util;

import com.tencent.ad.tangram.log.AdLog;
import javax.crypto.Cipher;

public final class a
{
  private static final String TAG = "AdCryptoUtil";
  private static Cipher decryptCipher = null;
  private static Cipher encryptCipher = null;
  
  public static byte[] decrypt(a.a parama, byte[] paramArrayOfByte)
  {
    if ((parama == null) || (!parama.isValid()))
    {
      AdLog.e("AdCryptoUtil", "decrypt params error");
      return null;
    }
    try
    {
      parama = getDecryptCipher(parama).doFinal(paramArrayOfByte);
      return parama;
    }
    catch (Throwable parama)
    {
      AdLog.e("AdCryptoUtil", "decrypt failed", parama);
    }
    return null;
  }
  
  public static byte[] encrypt(a.a parama, byte[] paramArrayOfByte)
  {
    if ((parama == null) || (!parama.isValid()))
    {
      AdLog.e("AdCryptoUtil", "encrypt params error");
      return null;
    }
    try
    {
      parama = getEncryptCipher(parama).doFinal(paramArrayOfByte);
      return parama;
    }
    catch (Throwable parama)
    {
      AdLog.e("AdCryptoUtil", "encrypt failed", parama);
    }
    return null;
  }
  
  /* Error */
  private static Cipher getDecryptCipher(a.a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 17	com/tencent/ad/tangram/util/a:decryptCipher	Ljavax/crypto/Cipher;
    //   6: ifnull +12 -> 18
    //   9: getstatic 17	com/tencent/ad/tangram/util/a:decryptCipher	Ljavax/crypto/Cipher;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: getfield 65	com/tencent/ad/tangram/util/a$a:cipherAlgorithm	Ljava/lang/String;
    //   22: invokestatic 69	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   25: astore_1
    //   26: aload_1
    //   27: iconst_2
    //   28: new 71	javax/crypto/spec/SecretKeySpec
    //   31: dup
    //   32: aload_0
    //   33: getfield 75	com/tencent/ad/tangram/util/a$a:key	[B
    //   36: aload_0
    //   37: getfield 78	com/tencent/ad/tangram/util/a$a:keyAlgorithm	Ljava/lang/String;
    //   40: invokespecial 81	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   43: invokevirtual 85	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   46: aload_1
    //   47: putstatic 17	com/tencent/ad/tangram/util/a:decryptCipher	Ljavax/crypto/Cipher;
    //   50: getstatic 17	com/tencent/ad/tangram/util/a:decryptCipher	Ljavax/crypto/Cipher;
    //   53: astore_0
    //   54: goto -41 -> 13
    //   57: astore_0
    //   58: ldc 8
    //   60: ldc 87
    //   62: aload_0
    //   63: invokestatic 54	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: goto -16 -> 50
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	parama	a.a
    //   25	22	1	localCipher	Cipher
    // Exception table:
    //   from	to	target	type
    //   18	50	57	java/lang/Throwable
    //   3	13	69	finally
    //   18	50	69	finally
    //   50	54	69	finally
    //   58	66	69	finally
  }
  
  /* Error */
  @android.annotation.SuppressLint({"TrulyRandom"})
  private static Cipher getEncryptCipher(a.a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 15	com/tencent/ad/tangram/util/a:encryptCipher	Ljavax/crypto/Cipher;
    //   6: ifnull +12 -> 18
    //   9: getstatic 15	com/tencent/ad/tangram/util/a:encryptCipher	Ljavax/crypto/Cipher;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: getfield 65	com/tencent/ad/tangram/util/a$a:cipherAlgorithm	Ljava/lang/String;
    //   22: invokestatic 69	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   25: astore_1
    //   26: aload_1
    //   27: iconst_1
    //   28: new 71	javax/crypto/spec/SecretKeySpec
    //   31: dup
    //   32: aload_0
    //   33: getfield 75	com/tencent/ad/tangram/util/a$a:key	[B
    //   36: aload_0
    //   37: getfield 78	com/tencent/ad/tangram/util/a$a:keyAlgorithm	Ljava/lang/String;
    //   40: invokespecial 81	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   43: invokevirtual 85	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   46: aload_1
    //   47: putstatic 15	com/tencent/ad/tangram/util/a:encryptCipher	Ljavax/crypto/Cipher;
    //   50: getstatic 15	com/tencent/ad/tangram/util/a:encryptCipher	Ljavax/crypto/Cipher;
    //   53: astore_0
    //   54: goto -41 -> 13
    //   57: astore_0
    //   58: ldc 8
    //   60: ldc 87
    //   62: aload_0
    //   63: invokestatic 54	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: goto -16 -> 50
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	parama	a.a
    //   25	22	1	localCipher	Cipher
    // Exception table:
    //   from	to	target	type
    //   18	50	57	java/lang/Throwable
    //   3	13	69	finally
    //   18	50	69	finally
    //   50	54	69	finally
    //   58	66	69	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.a
 * JD-Core Version:    0.7.0.1
 */