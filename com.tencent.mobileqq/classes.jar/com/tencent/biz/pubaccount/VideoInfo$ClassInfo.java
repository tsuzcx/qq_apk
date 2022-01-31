package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import npe;

public class VideoInfo$ClassInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ClassInfo> CREATOR = new npe();
  public long a;
  public String a;
  public long b;
  public String b;
  public long c;
  public String c;
  
  public VideoInfo$ClassInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public VideoInfo$ClassInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.ClassInfo
 * JD-Core Version:    0.7.0.1
 */