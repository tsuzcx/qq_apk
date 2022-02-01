package com.google.android.exoplayer2.decoder;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import com.google.android.exoplayer2.util.Util;

public final class CryptoInfo
{
  public int clearBlocks;
  public int encryptedBlocks;
  private final MediaCodec.CryptoInfo frameworkCryptoInfo;
  public byte[] iv;
  public byte[] key;
  public int mode;
  public int[] numBytesOfClearData;
  public int[] numBytesOfEncryptedData;
  public int numSubSamples;
  private final CryptoInfo.PatternHolderV24 patternHolder;
  
  public CryptoInfo()
  {
    Object localObject;
    if (Util.SDK_INT >= 16) {
      localObject = newFrameworkCryptoInfoV16();
    } else {
      localObject = null;
    }
    this.frameworkCryptoInfo = ((MediaCodec.CryptoInfo)localObject);
    if (Util.SDK_INT >= 24) {
      localObject = new CryptoInfo.PatternHolderV24(this.frameworkCryptoInfo, null);
    } else {
      localObject = null;
    }
    this.patternHolder = ((CryptoInfo.PatternHolderV24)localObject);
  }
  
  @TargetApi(16)
  private MediaCodec.CryptoInfo newFrameworkCryptoInfoV16()
  {
    return new MediaCodec.CryptoInfo();
  }
  
  @TargetApi(16)
  private void updateFrameworkCryptoInfoV16()
  {
    MediaCodec.CryptoInfo localCryptoInfo = this.frameworkCryptoInfo;
    localCryptoInfo.numSubSamples = this.numSubSamples;
    localCryptoInfo.numBytesOfClearData = this.numBytesOfClearData;
    localCryptoInfo.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
    localCryptoInfo.key = this.key;
    localCryptoInfo.iv = this.iv;
    localCryptoInfo.mode = this.mode;
    if (Util.SDK_INT >= 24) {
      CryptoInfo.PatternHolderV24.access$100(this.patternHolder, this.encryptedBlocks, this.clearBlocks);
    }
  }
  
  @TargetApi(16)
  public MediaCodec.CryptoInfo getFrameworkCryptoInfoV16()
  {
    return this.frameworkCryptoInfo;
  }
  
  public void set(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.numSubSamples = paramInt1;
    this.numBytesOfClearData = paramArrayOfInt1;
    this.numBytesOfEncryptedData = paramArrayOfInt2;
    this.key = paramArrayOfByte1;
    this.iv = paramArrayOfByte2;
    this.mode = paramInt2;
    this.encryptedBlocks = paramInt3;
    this.clearBlocks = paramInt4;
    if (Util.SDK_INT >= 16) {
      updateFrameworkCryptoInfoV16();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.decoder.CryptoInfo
 * JD-Core Version:    0.7.0.1
 */