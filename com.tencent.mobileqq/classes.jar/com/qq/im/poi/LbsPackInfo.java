package com.qq.im.poi;

import amp;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LbsPackInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new amp();
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public LbsPackInfo() {}
  
  public LbsPackInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString).append("|").append(this.jdField_a_of_type_Long).append("|").append(this.jdField_a_of_type_Int).append("|").append(this.jdField_a_of_type_JavaLangString).append("|").append(this.jdField_b_of_type_Int).append("|").append(this.jdField_b_of_type_Long).append("|").append(this.jdField_c_of_type_Int).append("|").append(this.jdField_d_of_type_Int).append("|").append(this.jdField_c_of_type_JavaLangString).append("|").append(this.jdField_c_of_type_Long).append("|").append(this.e).append("|").append(this.f);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackInfo
 * JD-Core Version:    0.7.0.1
 */