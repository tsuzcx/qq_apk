package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import javax.crypto.CipherInputStream;

final class Aes128DataSource
  implements DataSource
{
  private CipherInputStream cipherInputStream;
  private final byte[] encryptionIv;
  private final byte[] encryptionKey;
  private final DataSource upstream;
  
  public Aes128DataSource(DataSource paramDataSource, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.upstream = paramDataSource;
    this.encryptionKey = paramArrayOfByte1;
    this.encryptionIv = paramArrayOfByte2;
  }
  
  public void close()
  {
    this.cipherInputStream = null;
    this.upstream.close();
  }
  
  public Uri getUri()
  {
    return this.upstream.getUri();
  }
  
  /* Error */
  public long open(com.google.android.exoplayer2.upstream.DataSpec paramDataSpec)
  {
    // Byte code:
    //   0: ldc 46
    //   2: invokestatic 52	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   5: astore_2
    //   6: new 54	javax/crypto/spec/SecretKeySpec
    //   9: dup
    //   10: aload_0
    //   11: getfield 22	com/google/android/exoplayer2/source/hls/Aes128DataSource:encryptionKey	[B
    //   14: ldc 56
    //   16: invokespecial 59	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   19: astore_3
    //   20: new 61	javax/crypto/spec/IvParameterSpec
    //   23: dup
    //   24: aload_0
    //   25: getfield 24	com/google/android/exoplayer2/source/hls/Aes128DataSource:encryptionIv	[B
    //   28: invokespecial 64	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   31: astore 4
    //   33: aload_2
    //   34: iconst_2
    //   35: aload_3
    //   36: aload 4
    //   38: invokevirtual 68	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   41: aload_0
    //   42: new 70	javax/crypto/CipherInputStream
    //   45: dup
    //   46: new 72	com/google/android/exoplayer2/upstream/DataSourceInputStream
    //   49: dup
    //   50: aload_0
    //   51: getfield 20	com/google/android/exoplayer2/source/hls/Aes128DataSource:upstream	Lcom/google/android/exoplayer2/upstream/DataSource;
    //   54: aload_1
    //   55: invokespecial 75	com/google/android/exoplayer2/upstream/DataSourceInputStream:<init>	(Lcom/google/android/exoplayer2/upstream/DataSource;Lcom/google/android/exoplayer2/upstream/DataSpec;)V
    //   58: aload_2
    //   59: invokespecial 78	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   62: putfield 28	com/google/android/exoplayer2/source/hls/Aes128DataSource:cipherInputStream	Ljavax/crypto/CipherInputStream;
    //   65: ldc2_w 79
    //   68: lreturn
    //   69: astore_1
    //   70: new 82	java/lang/RuntimeException
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 85	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   78: athrow
    //   79: astore_1
    //   80: new 82	java/lang/RuntimeException
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 85	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   88: athrow
    //   89: astore_1
    //   90: goto -10 -> 80
    //   93: astore_1
    //   94: goto -24 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	Aes128DataSource
    //   0	97	1	paramDataSpec	com.google.android.exoplayer2.upstream.DataSpec
    //   5	54	2	localCipher	javax.crypto.Cipher
    //   19	17	3	localSecretKeySpec	javax.crypto.spec.SecretKeySpec
    //   31	6	4	localIvParameterSpec	javax.crypto.spec.IvParameterSpec
    // Exception table:
    //   from	to	target	type
    //   0	6	69	java/security/NoSuchAlgorithmException
    //   33	41	79	java/security/InvalidKeyException
    //   33	41	89	java/security/InvalidAlgorithmParameterException
    //   0	6	93	javax/crypto/NoSuchPaddingException
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.cipherInputStream != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      paramInt2 = this.cipherInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = -1;
      }
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.Aes128DataSource
 * JD-Core Version:    0.7.0.1
 */