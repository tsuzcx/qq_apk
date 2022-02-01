package com.android.dex;

import com.android.dex.util.ByteArrayByteInput;
import com.android.dex.util.ByteInput;

public final class EncodedValue
  implements Comparable<EncodedValue>
{
  private final byte[] data;
  
  public EncodedValue(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  public ByteInput asByteInput()
  {
    return new ByteArrayByteInput(this.data);
  }
  
  public int compareTo(EncodedValue paramEncodedValue)
  {
    int j = Math.min(this.data.length, paramEncodedValue.data.length);
    int i = 0;
    while (i < j)
    {
      if (this.data[i] != paramEncodedValue.data[i]) {
        return (this.data[i] & 0xFF) - (paramEncodedValue.data[i] & 0xFF);
      }
      i += 1;
    }
    return this.data.length - paramEncodedValue.data.length;
  }
  
  public byte[] getBytes()
  {
    return this.data;
  }
  
  public String toString()
  {
    return Integer.toHexString(this.data[0] & 0xFF) + "...(" + this.data.length + ")";
  }
  
  public void writeTo(Dex.Section paramSection)
  {
    paramSection.write(this.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.EncodedValue
 * JD-Core Version:    0.7.0.1
 */