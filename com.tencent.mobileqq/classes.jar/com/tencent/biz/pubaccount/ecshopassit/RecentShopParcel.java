package com.tencent.biz.pubaccount.ecshopassit;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RecentShopParcel
  implements Parcelable
{
  public static final Parcelable.Creator<RecentShopParcel> CREATOR = new RecentShopParcel.1();
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f;
  public int g;
  public int h;
  public String i;
  public long j;
  public long k;
  
  public RecentShopParcel() {}
  
  protected RecentShopParcel(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.i = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.j = paramParcel.readLong();
    this.k = paramParcel.readLong();
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
    paramParcel.writeString(this.i);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeLong(this.j);
    paramParcel.writeLong(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel
 * JD-Core Version:    0.7.0.1
 */