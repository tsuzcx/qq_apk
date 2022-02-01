package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ARScanStarFaceActInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ARScanStarFaceActInfo> CREATOR = new ARScanStarFaceActInfo.1();
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public long g;
  public long h;
  public long i;
  
  public ARScanStarFaceActInfo() {}
  
  protected ARScanStarFaceActInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readLong();
    this.h = paramParcel.readLong();
    this.i = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARScanStarFaceActInfo{actTitle='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append("actDescription='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", starName='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", starUin='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", starWebUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", adImgUrl='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", beginTime=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", actID=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeLong(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeLong(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ARScanStarFaceActInfo
 * JD-Core Version:    0.7.0.1
 */