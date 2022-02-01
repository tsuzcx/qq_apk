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
    if (paramParcel.readInt() != 0)
    {
      i = 1;
      if (i == 0) {
        break label57;
      }
    }
    label57:
    for (paramParcel = paramParcel.createByteArray();; paramParcel = null)
    {
      this.hdrStaticInfo = paramParcel;
      return;
      i = 0;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
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
      paramObject = (ColorInfo)paramObject;
    } while ((this.colorSpace == paramObject.colorSpace) && (this.colorRange == paramObject.colorRange) && (this.colorTransfer == paramObject.colorTransfer) && (Arrays.equals(this.hdrStaticInfo, paramObject.hdrStaticInfo)));
    return false;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0) {
      this.hashCode = ((((this.colorSpace + 527) * 31 + this.colorRange) * 31 + this.colorTransfer) * 31 + Arrays.hashCode(this.hdrStaticInfo));
    }
    return this.hashCode;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ColorInfo(").append(this.colorSpace).append(", ").append(this.colorRange).append(", ").append(this.colorTransfer).append(", ");
    if (this.hdrStaticInfo != null) {}
    for (boolean bool = true;; bool = false) {
      return bool + ")";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.colorSpace);
    paramParcel.writeInt(this.colorRange);
    paramParcel.writeInt(this.colorTransfer);
    if (this.hdrStaticInfo != null) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (this.hdrStaticInfo != null) {
        paramParcel.writeByteArray(this.hdrStaticInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.video.ColorInfo
 * JD-Core Version:    0.7.0.1
 */