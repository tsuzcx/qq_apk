package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import lxz;

public class RecvGVideoLevelInfo$Medal
  implements Parcelable
{
  public static final Parcelable.Creator<Medal> CREATOR = new lxz();
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public RecvGVideoLevelInfo$Medal(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  public RecvGVideoLevelInfo$Medal(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    try
    {
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(RecvGVideoLevelInfo.jdField_a_of_type_JavaLangString, 2, "readFromParcel RuntimeException", paramParcel);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(RecvGVideoLevelInfo.jdField_a_of_type_JavaLangString, 2, "writeToParcel RuntimeException", paramParcel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.service.RecvGVideoLevelInfo.Medal
 * JD-Core Version:    0.7.0.1
 */