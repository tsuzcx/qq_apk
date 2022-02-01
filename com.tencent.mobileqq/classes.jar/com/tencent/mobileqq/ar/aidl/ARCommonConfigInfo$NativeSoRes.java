package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ARCommonConfigInfo$NativeSoRes
  implements Parcelable
{
  public static final Parcelable.Creator<NativeSoRes> CREATOR = new ARCommonConfigInfo.NativeSoRes.1();
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public long e = 0L;
  
  public ARCommonConfigInfo$NativeSoRes() {}
  
  public ARCommonConfigInfo$NativeSoRes(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("NativeSoRes{");
    localStringBuffer.append("name = '");
    localStringBuffer.append(this.a);
    localStringBuffer.append('\'');
    localStringBuffer.append(", version = '");
    localStringBuffer.append(this.b);
    localStringBuffer.append('\'');
    localStringBuffer.append(", url = '");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append(", md5 = '");
    localStringBuffer.append(this.d);
    localStringBuffer.append('\'');
    localStringBuffer.append(", size = ");
    localStringBuffer.append(this.e);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes
 * JD-Core Version:    0.7.0.1
 */