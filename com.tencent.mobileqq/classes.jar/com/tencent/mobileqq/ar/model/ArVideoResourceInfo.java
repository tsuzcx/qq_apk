package com.tencent.mobileqq.ar.model;

import aakx;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArVideoResourceInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new aakx();
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  
  public ArVideoResourceInfo() {}
  
  public ArVideoResourceInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readString();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int == 2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArVideoResourceInfo
 * JD-Core Version:    0.7.0.1
 */