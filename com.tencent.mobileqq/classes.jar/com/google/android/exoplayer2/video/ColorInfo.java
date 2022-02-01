package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class ColorInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ColorInfo> CREATOR = new ColorInfo.1();
  public final int colorRange;
  public final int colorSpace;
  public final int colorTransfer;
  private int hashCode;
  public final byte[] hdrStaticInfo;
  
  public ColorInfo(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.colorSpace = paramInt1;
    this.colorRange = paramInt2;
    this.colorTransfer = paramInt3;
    this.hdrStaticInfo = paramArrayOfByte;
  }
  
  ColorInfo(Parcel paramParcel)
  {
    this.colorSpace = paramParcel.readInt();
    this.colorRange = paramParcel.readInt();
    this.colorTransfer = paramParcel.readInt();
    int i;
    if (paramParcel.readInt() != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramParcel = paramParcel.createByteArray();
    } else {
      paramParcel = null;
    }
    this.hdrStaticInfo = paramParcel;
  }
  
  public int describeContents()
  {
    return 0;
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
      paramObject = (ColorInfo)paramObject;
      return (this.colorSpace == paramObject.colorSpace) && (this.colorRange == paramObject.colorRange) && (this.colorTransfer == paramObject.colorTransfer) && (Arrays.equals(this.hdrStaticInfo, paramObject.hdrStaticInfo));
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0) {
      this.hashCode = ((((527 + this.colorSpace) * 31 + this.colorRange) * 31 + this.colorTransfer) * 31 + Arrays.hashCode(this.hdrStaticInfo));
    }
    return this.hashCode;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ColorInfo(");
    localStringBuilder.append(this.colorSpace);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.colorRange);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.colorTransfer);
    localStringBuilder.append(", ");
    boolean bool;
    if (this.hdrStaticInfo != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.colorSpace);
    paramParcel.writeInt(this.colorRange);
    paramParcel.writeInt(this.colorTransfer);
    if (this.hdrStaticInfo != null) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    paramParcel.writeInt(paramInt);
    byte[] arrayOfByte = this.hdrStaticInfo;
    if (arrayOfByte != null) {
      paramParcel.writeByteArray(arrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.video.ColorInfo
 * JD-Core Version:    0.7.0.1
 */