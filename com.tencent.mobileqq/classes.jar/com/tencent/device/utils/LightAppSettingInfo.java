package com.tencent.device.utils;

import absm;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashMap;

public class LightAppSettingInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<LightAppSettingInfo> CREATOR = new absm();
  public int a;
  public long a;
  public String a;
  public ArrayList<Integer> a;
  public HashMap<Integer, String> a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      return Long.valueOf(this.jdField_a_of_type_Long).hashCode();
    }
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeMap(this.jdField_a_of_type_JavaUtilHashMap);
    paramParcel.writeString(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.utils.LightAppSettingInfo
 * JD-Core Version:    0.7.0.1
 */