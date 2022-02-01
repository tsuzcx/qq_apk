package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build.VERSION;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.prng.SP800SecureRandomBuilder;

public class EncryptUtil
{
  private static final String P = "RSA";
  private static boolean Q = false;
  private static boolean R = true;
  private static final String TAG = "EncryptUtil";
  
  private static boolean a()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  private static SecureRandom b()
  {
    try
    {
      Object localObject1 = SecureRandom.getInstanceStrong();
      localObject2 = new AESEngine();
      byte[] arrayOfByte = new byte[32];
      ((SecureRandom)localObject1).nextBytes(arrayOfByte);
      localObject1 = new SP800SecureRandomBuilder((SecureRandom)localObject1, true).setEntropyBitsRequired(384).buildCTR((BlockCipher)localObject2, 256, arrayOfByte, false);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      if (R)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("exception : ");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        ((StringBuilder)localObject2).append(" , you should implementation bcprov-jdk15on library");
        b.f("EncryptUtil", ((StringBuilder)localObject2).toString());
        R = false;
        break label110;
        b.f("EncryptUtil", "NoSuchAlgorithmException");
      }
      return new SecureRandom();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      label103:
      label110:
      break label103;
    }
  }
  
  private static byte[] b(int paramInt)
  {
    b.c("EncryptUtil", "generateSecureRandomNew ");
    SecureRandom localSecureRandom = b();
    if (localSecureRandom == null) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[paramInt];
    localSecureRandom.nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  public static SecureRandom genSecureRandom()
  {
    if ((Q) && (a())) {
      return b();
    }
    return new SecureRandom();
  }
  
  public static byte[] generateSecureRandom(int paramInt)
  {
    if ((Q) && (a())) {
      return b(paramInt);
    }
    try
    {
      SecureRandom localSecureRandom = new SecureRandom();
      localObject = new byte[paramInt];
      localSecureRandom.nextBytes((byte[])localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("generate secure random error");
      ((StringBuilder)localObject).append(localException.getMessage());
      b.f("EncryptUtil", ((StringBuilder)localObject).toString());
    }
    return new byte[0];
  }
  
  public static String generateSecureRandomStr(int paramInt)
  {
    return HexUtil.byteArray2HexStr(generateSecureRandom(paramInt));
  }
  
  /* Error */
  public static java.security.PrivateKey getPrivateKey(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: invokestatic 133	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   5: astore_0
    //   6: new 135	java/security/spec/PKCS8EncodedKeySpec
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 137	java/security/spec/PKCS8EncodedKeySpec:<init>	([B)V
    //   14: astore_0
    //   15: ldc 8
    //   17: invokestatic 143	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   20: aload_0
    //   21: invokevirtual 147	java/security/KeyFactory:generatePrivate	(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   24: astore_0
    //   25: aload_0
    //   26: areturn
    //   27: astore_0
    //   28: new 65	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   35: astore_1
    //   36: aload_1
    //   37: ldc 149
    //   39: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_1
    //   44: aload_0
    //   45: invokevirtual 150	java/security/GeneralSecurityException:getMessage	()Ljava/lang/String;
    //   48: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: ldc 16
    //   54: aload_1
    //   55: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 87	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aconst_null
    //   62: areturn
    //   63: astore_0
    //   64: new 65	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: ldc 152
    //   75: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_1
    //   80: aload_0
    //   81: invokevirtual 111	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   84: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc 16
    //   90: aload_1
    //   91: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 87	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aconst_null
    //   98: areturn
    //   99: ldc 16
    //   101: ldc 154
    //   103: invokestatic 87	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: goto -10 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramString	String
    //   35	56	1	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	25	27	java/security/GeneralSecurityException
    //   0	6	63	java/lang/Exception
    //   0	6	108	java/lang/IllegalArgumentException
  }
  
  /* Error */
  public static java.security.interfaces.RSAPublicKey getPublicKey(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: invokestatic 133	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   5: astore_0
    //   6: ldc 8
    //   8: invokestatic 143	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   11: new 158	java/security/spec/X509EncodedKeySpec
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 159	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   19: invokevirtual 163	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   22: checkcast 165	java/security/interfaces/RSAPublicKey
    //   25: astore_0
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: new 65	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   36: astore_1
    //   37: aload_1
    //   38: ldc 149
    //   40: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_1
    //   45: aload_0
    //   46: invokevirtual 150	java/security/GeneralSecurityException:getMessage	()Ljava/lang/String;
    //   49: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 16
    //   55: aload_1
    //   56: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 87	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aconst_null
    //   63: areturn
    //   64: astore_0
    //   65: new 65	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   72: astore_1
    //   73: aload_1
    //   74: ldc 152
    //   76: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_1
    //   81: aload_0
    //   82: invokevirtual 111	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   85: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: ldc 16
    //   91: aload_1
    //   92: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 87	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aconst_null
    //   99: areturn
    //   100: ldc 16
    //   102: ldc 154
    //   104: invokestatic 87	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aconst_null
    //   108: areturn
    //   109: astore_0
    //   110: goto -10 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	paramString	String
    //   36	56	1	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	26	28	java/security/GeneralSecurityException
    //   0	6	64	java/lang/Exception
    //   0	6	109	java/lang/IllegalArgumentException
  }
  
  public static boolean isBouncycastleFlag()
  {
    return Q;
  }
  
  public static void setBouncycastleFlag(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBouncycastleFlag: ");
    localStringBuilder.append(paramBoolean);
    b.d("EncryptUtil", localStringBuilder.toString());
    Q = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.utils.EncryptUtil
 * JD-Core Version:    0.7.0.1
 */