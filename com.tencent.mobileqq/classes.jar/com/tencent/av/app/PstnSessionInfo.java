package com.tencent.av.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import jgx;

public class PstnSessionInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new jgx();
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e = "";
  
  public PstnSessionInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 7;
  }
  
  public PstnSessionInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 7;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "mPeerUin=" + this.jdField_a_of_type_JavaLangString + ", mUinType=" + this.jdField_a_of_type_Int + ", mPeerPhoneNum=" + this.jdField_b_of_type_JavaLangString + ", mSelfPhoneNum=" + this.jdField_c_of_type_JavaLangString + ", mNickName=" + this.d + ", mStatus=" + this.jdField_b_of_type_Int;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.app.PstnSessionInfo
 * JD-Core Version:    0.7.0.1
 */