package com.tencent.luggage.wxa.ab;

import android.net.Uri;
import com.tencent.luggage.wxa.am.g;
import com.tencent.luggage.wxa.am.i;
import com.tencent.luggage.wxa.am.j;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class a
  implements g
{
  private final g a;
  private final byte[] b;
  private final byte[] c;
  private CipherInputStream d;
  
  public a(g paramg, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.a = paramg;
    this.b = paramArrayOfByte1;
    this.c = paramArrayOfByte2;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (this.d != null) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.b(bool);
    paramInt2 = this.d.read(paramArrayOfByte, paramInt1, paramInt2);
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = -1;
    }
    return paramInt1;
  }
  
  public long a(j paramj)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.b, "AES");
      IvParameterSpec localIvParameterSpec = new IvParameterSpec(this.c);
      try
      {
        localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
        this.d = new CipherInputStream(new i(this.a, paramj), localCipher);
        return -1L;
      }
      catch (InvalidAlgorithmParameterException paramj) {}catch (InvalidKeyException paramj) {}
      throw new RuntimeException(paramj);
    }
    catch (NoSuchPaddingException paramj) {}catch (NoSuchAlgorithmException paramj) {}
    throw new RuntimeException(paramj);
  }
  
  public void a()
  {
    this.d = null;
    this.a.a();
  }
  
  public Uri b()
  {
    return this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ab.a
 * JD-Core Version:    0.7.0.1
 */