package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import lxe;

public class LBSInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LBSInfo> CREATOR = new lxe();
  static String jdField_a_of_type_JavaLangString = "LBSInfo";
  double jdField_a_of_type_Double = 0.0D;
  String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  double jdField_b_of_type_Double = 0.0D;
  String jdField_b_of_type_JavaLangString = "";
  double jdField_c_of_type_Double = 0.0D;
  String jdField_c_of_type_JavaLangString = "";
  String d = "";
  String e = "";
  String f = "";
  String g = "";
  String h = "";
  String i = "";
  
  public LBSInfo() {}
  
  public LBSInfo(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public LBSInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, double paramDouble1, double paramDouble2, double paramDouble3, String[] paramArrayOfString)
  {
    this.jdField_b_of_type_JavaLangString = paramString6;
    this.jdField_c_of_type_JavaLangString = paramString5;
    this.d = paramString8;
    this.e = paramString7;
    this.f = paramString2;
    this.g = paramString4;
    this.h = paramString1;
    this.i = paramString3;
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
    this.jdField_c_of_type_Double = paramDouble3;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public void a(Parcel paramParcel)
  {
    try
    {
      this.h = paramParcel.readString();
      this.f = paramParcel.readString();
      this.i = paramParcel.readString();
      this.g = paramParcel.readString();
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      this.e = paramParcel.readString();
      this.d = paramParcel.readString();
      this.jdField_a_of_type_Double = paramParcel.readDouble();
      this.jdField_b_of_type_Double = paramParcel.readDouble();
      this.jdField_c_of_type_Double = paramParcel.readDouble();
      this.jdField_a_of_type_ArrayOfJavaLangString = paramParcel.createStringArray();
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "readFromParcel RuntimeException", paramParcel);
    }
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof LBSInfo))) {
        return false;
      }
      paramObject = (LBSInfo)paramObject;
    } while ((this.h.equals(paramObject.h)) && (this.f.equals(paramObject.f)) && (this.i.equals(paramObject.i)) && (this.g.equals(paramObject.g)) && (this.jdField_c_of_type_JavaLangString.equals(paramObject.jdField_c_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equals(paramObject.jdField_b_of_type_JavaLangString)) && (this.e.equals(paramObject.e)) && (this.d.equals(paramObject.d)) && (this.jdField_a_of_type_Double == paramObject.jdField_a_of_type_Double) && (this.jdField_b_of_type_Double == paramObject.jdField_b_of_type_Double) && (this.jdField_c_of_type_Double == paramObject.jdField_c_of_type_Double));
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.i);
      paramParcel.writeString(this.g);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.d);
      paramParcel.writeDouble(this.jdField_a_of_type_Double);
      paramParcel.writeDouble(this.jdField_b_of_type_Double);
      paramParcel.writeDouble(this.jdField_c_of_type_Double);
      paramParcel.writeArray(this.jdField_a_of_type_ArrayOfJavaLangString);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "writeToParcel RuntimeException", paramParcel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.service.LBSInfo
 * JD-Core Version:    0.7.0.1
 */