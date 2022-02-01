package com.tencent.mobileqq.activity;

import aedy;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RiskInfoItem
  implements Parcelable
{
  public static final Parcelable.Creator<RiskInfoItem> CREATOR = new aedy();
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public RiskInfoItem() {}
  
  private RiskInfoItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.e = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskInfoItem
 * JD-Core Version:    0.7.0.1
 */