package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArVideoResourceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ArVideoResourceInfo> CREATOR = new ArVideoResourceInfo.1();
  public int a;
  public long b;
  public String c;
  public String d;
  public String e;
  public int f;
  public int g;
  public int h;
  public String i;
  public String j;
  
  public ArVideoResourceInfo() {}
  
  protected ArVideoResourceInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
  }
  
  public boolean a()
  {
    return this.a == 0;
  }
  
  public boolean b()
  {
    return this.a == 1;
  }
  
  public boolean c()
  {
    return this.a == 2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArVideoResourceInfo
 * JD-Core Version:    0.7.0.1
 */