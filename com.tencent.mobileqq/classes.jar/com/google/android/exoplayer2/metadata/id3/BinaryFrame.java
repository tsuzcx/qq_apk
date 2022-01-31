package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class BinaryFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<BinaryFrame> CREATOR = new BinaryFrame.1();
  public final byte[] data;
  
  BinaryFrame(Parcel paramParcel)
  {
    super(paramParcel.readString());
    this.data = paramParcel.createByteArray();
  }
  
  public BinaryFrame(String paramString, byte[] paramArrayOfByte)
  {
    super(paramString);
    this.data = paramArrayOfByte;
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
      paramObject = (BinaryFrame)paramObject;
    } while ((this.id.equals(paramObject.id)) && (Arrays.equals(this.data, paramObject.data)));
    return false;
  }
  
  public int hashCode()
  {
    return (this.id.hashCode() + 527) * 31 + Arrays.hashCode(this.data);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeByteArray(this.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.BinaryFrame
 * JD-Core Version:    0.7.0.1
 */