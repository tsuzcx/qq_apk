package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.SpannableString;
import com.tencent.qphone.base.util.QLog;
import jpv;

public class RecvMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR = new jpv();
  static String jdField_a_of_type_JavaLangString = "RecvMsg";
  int jdField_a_of_type_Int;
  public long a;
  SpannableString jdField_a_of_type_AndroidTextSpannableString;
  public Object a;
  public boolean a;
  public int b;
  String b;
  public boolean b;
  public int c;
  String c;
  public int d;
  String d;
  public int e;
  String e;
  public int f;
  String f;
  public String g;
  public String h;
  String i;
  
  public RecvMsg()
  {
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
    this.i = "";
  }
  
  public RecvMsg(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public SpannableString a()
  {
    return this.jdField_a_of_type_AndroidTextSpannableString;
  }
  
  public String a()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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
      this.i = paramParcel.readString();
      this.jdField_e_of_type_Int = paramParcel.readInt();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "readFromParcel RuntimeException", paramParcel);
    }
  }
  
  public void a(SpannableString paramSpannableString)
  {
    this.jdField_a_of_type_AndroidTextSpannableString = paramSpannableString;
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public String b()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public String c()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void c(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void f(String paramString)
  {
    this.i = paramString;
  }
  
  public String toString()
  {
    return jdField_a_of_type_JavaLangString + ", mVipBubbleId:" + this.jdField_a_of_type_Int + ", mAccountUin:" + this.jdField_c_of_type_JavaLangString + ", mFriendUin:" + this.jdField_d_of_type_JavaLangString + ", mSenderUin:" + this.jdField_e_of_type_JavaLangString + ", mSenderName:" + this.jdField_f_of_type_JavaLangString + ", mMsg:" + this.jdField_b_of_type_JavaLangString + ", msgType:" + this.jdField_e_of_type_Int;
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
      paramParcel.writeString(this.i);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "writeToParcel RuntimeException", paramParcel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.service.RecvMsg
 * JD-Core Version:    0.7.0.1
 */