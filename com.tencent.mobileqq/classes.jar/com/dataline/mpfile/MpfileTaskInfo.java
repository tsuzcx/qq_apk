package com.dataline.mpfile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import fa;

public class MpfileTaskInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MpfileTaskInfo> CREATOR = new fa();
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public long a;
  public String a;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public int f;
  public long f;
  public String f;
  public int g;
  public long g;
  public String g;
  public String h;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
    jdField_e_of_type_Int = 4;
  }
  
  public MpfileTaskInfo()
  {
    this.jdField_e_of_type_Long = System.currentTimeMillis();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(this.h);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
    paramParcel.writeLong(this.jdField_f_of_type_Long);
    paramParcel.writeLong(this.jdField_g_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.mpfile.MpfileTaskInfo
 * JD-Core Version:    0.7.0.1
 */