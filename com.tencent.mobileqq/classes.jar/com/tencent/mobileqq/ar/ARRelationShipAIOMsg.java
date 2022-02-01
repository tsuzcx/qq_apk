package com.tencent.mobileqq.ar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import apec;

public class ARRelationShipAIOMsg
  implements Parcelable
{
  public static final Parcelable.Creator<ARRelationShipAIOMsg> CREATOR = new apec();
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public ARRelationShipAIOMsg() {}
  
  public ARRelationShipAIOMsg(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRelationShipAIOMsg
 * JD-Core Version:    0.7.0.1
 */