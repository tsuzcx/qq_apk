package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

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
  
  public long open(DataSpec paramDataSpec)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.encryptionKey, "AES");
      IvParameterSpec localIvParameterSpec = new IvParameterSpec(this.encryptionIv);
      try
      {
        localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
        this.cipherInputStream = new CipherInputStream(new DataSourceInputStream(this.upstream, paramDataSpec), localCipher);
        return -1L;
      }
      catch (InvalidAlgorithmParameterException paramDataSpec) {}catch (InvalidKeyException paramDataSpec) {}
      throw new RuntimeException(paramDataSpec);
    }
    catch (NoSuchPaddingException paramDataSpec) {}catch (NoSuchAlgorithmException paramDataSpec) {}
    throw new RuntimeException(paramDataSpec);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (this.cipherInputStream != null) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    paramInt2 = this.cipherInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = -1;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.Aes128DataSource
 * JD-Core Version:    0.7.0.1
 */