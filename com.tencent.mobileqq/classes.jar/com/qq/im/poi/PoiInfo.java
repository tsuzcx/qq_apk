package com.qq.im.poi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PoiInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PoiInfo> CREATOR = new PoiInfo.1();
  public long a;
  public int b;
  public int c;
  public String d;
  public String e;
  
  public PoiInfo() {}
  
  private PoiInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", latitude:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", longitude:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", name:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", address");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.im.poi.PoiInfo
 * JD-Core Version:    0.7.0.1
 */