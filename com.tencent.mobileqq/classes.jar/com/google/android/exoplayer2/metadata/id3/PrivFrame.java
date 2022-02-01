package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class PrivFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<PrivFrame> CREATOR = new PrivFrame.1();
  public static final String ID = "PRIV";
  public final String owner;
  public final byte[] privateData;
  
  PrivFrame(Parcel paramParcel)
  {
    super("PRIV");
    this.owner = paramParcel.readString();
    this.privateData = paramParcel.createByteArray();
  }
  
  public PrivFrame(String paramString, byte[] paramArrayOfByte)
  {
    super("PRIV");
    this.owner = paramString;
    this.privateData = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (PrivFrame)paramObject;
      return (Util.areEqual(this.owner, paramObject.owner)) && (Arrays.equals(this.privateData, paramObject.privateData));
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.owner;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return (527 + i) * 31 + Arrays.hashCode(this.privateData);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.owner);
    paramParcel.writeByteArray(this.privateData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.PrivFrame
 * JD-Core Version:    0.7.0.1
 */