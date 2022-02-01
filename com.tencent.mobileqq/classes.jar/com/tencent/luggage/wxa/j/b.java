package com.tencent.luggage.wxa.j;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import com.tencent.luggage.wxa.ao.x;

public final class b
{
  public byte[] a;
  public byte[] b;
  public int c;
  public int[] d;
  public int[] e;
  public int f;
  public int g;
  public int h;
  private final MediaCodec.CryptoInfo i;
  private final b.a j;
  
  public b()
  {
    Object localObject;
    if (x.a >= 16) {
      localObject = b();
    } else {
      localObject = null;
    }
    this.i = ((MediaCodec.CryptoInfo)localObject);
    if (x.a >= 24) {
      localObject = new b.a(this.i, null);
    } else {
      localObject = null;
    }
    this.j = ((b.a)localObject);
  }
  
  @TargetApi(16)
  private MediaCodec.CryptoInfo b()
  {
    return new MediaCodec.CryptoInfo();
  }
  
  @TargetApi(16)
  private void c()
  {
    MediaCodec.CryptoInfo localCryptoInfo = this.i;
    localCryptoInfo.numSubSamples = this.f;
    localCryptoInfo.numBytesOfClearData = this.d;
    localCryptoInfo.numBytesOfEncryptedData = this.e;
    localCryptoInfo.key = this.b;
    localCryptoInfo.iv = this.a;
    localCryptoInfo.mode = this.c;
    if (x.a >= 24) {
      b.a.a(this.j, this.g, this.h);
    }
  }
  
  @TargetApi(16)
  public MediaCodec.CryptoInfo a()
  {
    return this.i;
  }
  
  public void a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = paramInt1;
    this.d = paramArrayOfInt1;
    this.e = paramArrayOfInt2;
    this.b = paramArrayOfByte1;
    this.a = paramArrayOfByte2;
    this.c = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
    if (x.a >= 16) {
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.j.b
 * JD-Core Version:    0.7.0.1
 */