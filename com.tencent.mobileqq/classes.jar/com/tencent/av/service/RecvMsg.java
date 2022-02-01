package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;

public class RecvMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<RecvMsg> CREATOR = new RecvMsg.1();
  static String jdField_a_of_type_JavaLangString = "RecvMsg";
  int jdField_a_of_type_Int;
  public long a;
  public boolean a;
  public int b;
  String b;
  public int c;
  String c;
  public int d;
  String d;
  public int e;
  String e;
  public int f;
  String f;
  String g;
  
  public RecvMsg()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.g = "";
  }
  
  public RecvMsg(Parcel paramParcel)
  {
    this.jdField_a_of_type_Boolean = false;
    a(paramParcel);
  }
  
  public String a()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void a(Parcel paramParcel)
  {
    try
    {
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_JavaLangString = paramParcel.readString();
      this.jdField_d_of_type_JavaLangString = paramParcel.readString();
      this.jdField_e_of_type_JavaLangString = paramParcel.readString();
      this.jdField_f_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_c_of_type_Int = paramParcel.readInt();
      this.jdField_d_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.g = paramParcel.readString();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      return;
    }
    catch (RuntimeException paramParcel)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "readFromParcel RuntimeException", paramParcel);
      }
    }
  }
  
  public String b()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", mVipBubbleId:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mAccountUin:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", mFriendUin:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(", mSenderUin:");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append(", mSenderName:");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append(", mMsg:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", msgType:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeInt(this.jdField_c_of_type_Int);
      paramParcel.writeInt(this.jdField_d_of_type_Int);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeString(this.g);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "writeToParcel RuntimeException", paramParcel);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.RecvMsg
 * JD-Core Version:    0.7.0.1
 */