package com.google.android.exoplayer2.extractor.ts;

import java.util.Arrays;

final class H262Reader$CsdBuffer
{
  private static final byte[] START_CODE = { 0, 0, 1 };
  public byte[] data;
  private boolean isFilling;
  public int length;
  public int sequenceExtensionPosition;
  
  public H262Reader$CsdBuffer(int paramInt)
  {
    this.data = new byte[paramInt];
  }
  
  public void onData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.isFilling) {
      return;
    }
    paramInt2 -= paramInt1;
    byte[] arrayOfByte = this.data;
    int i = arrayOfByte.length;
    int j = this.length;
    if (i < j + paramInt2) {
      this.data = Arrays.copyOf(arrayOfByte, (j + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.data, this.length, paramInt2);
    this.length += paramInt2;
  }
  
  public boolean onStartCode(int paramInt1, int paramInt2)
  {
    if (this.isFilling)
    {
      this.length -= paramInt2;
      if ((this.sequenceExtensionPosition == 0) && (paramInt1 == 181))
      {
        this.sequenceExtensionPosition = this.length;
      }
      else
      {
        this.isFilling = false;
        return true;
      }
    }
    else if (paramInt1 == 179)
    {
      this.isFilling = true;
    }
    byte[] arrayOfByte = START_CODE;
    onData(arrayOfByte, 0, arrayOfByte.length);
    return false;
  }
  
  public void reset()
  {
    this.isFilling = false;
    this.length = 0;
    this.sequenceExtensionPosition = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.H262Reader.CsdBuffer
 * JD-Core Version:    0.7.0.1
 */