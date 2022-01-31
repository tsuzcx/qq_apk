package com.google.android.exoplayer2.extractor;

import java.util.Arrays;

public final class TrackOutput$CryptoData
{
  public final int clearBlocks;
  public final int cryptoMode;
  public final int encryptedBlocks;
  public final byte[] encryptionKey;
  
  public TrackOutput$CryptoData(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.cryptoMode = paramInt1;
    this.encryptionKey = paramArrayOfByte;
    this.encryptedBlocks = paramInt2;
    this.clearBlocks = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (CryptoData)paramObject;
    } while ((this.cryptoMode == paramObject.cryptoMode) && (this.encryptedBlocks == paramObject.encryptedBlocks) && (this.clearBlocks == paramObject.clearBlocks) && (Arrays.equals(this.encryptionKey, paramObject.encryptionKey)));
    return false;
  }
  
  public int hashCode()
  {
    return ((this.cryptoMode * 31 + Arrays.hashCode(this.encryptionKey)) * 31 + this.encryptedBlocks) * 31 + this.clearBlocks;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.TrackOutput.CryptoData
 * JD-Core Version:    0.7.0.1
 */