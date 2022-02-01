package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ARRelationShip
  implements Parcelable
{
  public static final Parcelable.Creator<ARRelationShip> CREATOR = new ARRelationShip.1();
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public long h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n = "";
  public String o = "";
  
  public ARRelationShip() {}
  
  protected ARRelationShip(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readLong();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ARRelationShip
 * JD-Core Version:    0.7.0.1
 */