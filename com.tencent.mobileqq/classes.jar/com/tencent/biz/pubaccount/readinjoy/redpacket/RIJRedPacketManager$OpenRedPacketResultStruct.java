package com.tencent.biz.pubaccount.readinjoy.redpacket;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import qri;

public class RIJRedPacketManager$OpenRedPacketResultStruct
  implements Parcelable
{
  public static final Parcelable.Creator<OpenRedPacketResultStruct> CREATOR = new qri();
  public long a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public RIJRedPacketManager$OpenRedPacketResultStruct(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.b = paramParcel.readString();
      this.c = paramParcel.readString();
      this.d = paramParcel.readString();
      this.e = paramParcel.readString();
      this.f = paramParcel.readString();
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.b);
      paramParcel.writeString(this.c);
      paramParcel.writeString(this.d);
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.f);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.OpenRedPacketResultStruct
 * JD-Core Version:    0.7.0.1
 */