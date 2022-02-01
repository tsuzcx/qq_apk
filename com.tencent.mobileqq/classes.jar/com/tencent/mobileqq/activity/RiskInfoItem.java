package com.tencent.mobileqq.activity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RiskInfoItem
  implements Parcelable
{
  public static final Parcelable.Creator<RiskInfoItem> CREATOR = new RiskInfoItem.1();
  String a;
  String b;
  String c;
  String d;
  int e;
  int f;
  String g;
  
  public RiskInfoItem() {}
  
  private RiskInfoItem(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readString();
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
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskInfoItem
 * JD-Core Version:    0.7.0.1
 */