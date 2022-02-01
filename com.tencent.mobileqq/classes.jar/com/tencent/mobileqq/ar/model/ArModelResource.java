package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArModelResource
  implements Parcelable
{
  public static final Parcelable.Creator<ArModelResource> CREATOR = new ArModelResource.1();
  public long a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f;
  public String g;
  public String h;
  
  public ArModelResource() {}
  
  protected ArModelResource(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArModelResource{");
    localStringBuffer.append("modelResourceSize='");
    localStringBuffer.append(this.a);
    localStringBuffer.append('\'');
    localStringBuffer.append(", modelResourceMD5=");
    localStringBuffer.append(this.b);
    localStringBuffer.append('\'');
    localStringBuffer.append(", modelResourceUrl=");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append(", modelResourceBgMusic=");
    localStringBuffer.append(this.d);
    localStringBuffer.append('\'');
    localStringBuffer.append(", modelConfigFile=");
    localStringBuffer.append(this.e);
    localStringBuffer.append('\'');
    localStringBuffer.append(", modelRepeatTimes=");
    localStringBuffer.append(this.f);
    localStringBuffer.append('\'');
    localStringBuffer.append(", videoLayout=");
    localStringBuffer.append(this.g);
    localStringBuffer.append('\'');
    localStringBuffer.append(", zipFileName=");
    localStringBuffer.append(this.h);
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArModelResource
 * JD-Core Version:    0.7.0.1
 */