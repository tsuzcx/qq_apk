package com.tencent.mobileqq.ar.aidl;

import akpk;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ARScanStarFaceActInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ARScanStarFaceActInfo> CREATOR = new akpk();
  public long a;
  public String a;
  public long b;
  public String b;
  public long c;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public ARScanStarFaceActInfo() {}
  
  public ARScanStarFaceActInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Long = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ARScanStarFaceActInfo{actTitle='" + this.jdField_c_of_type_JavaLangString + '\'' + "actDescription='" + this.d + '\'' + ", starName='" + this.jdField_a_of_type_JavaLangString + '\'' + ", starUin='" + this.jdField_b_of_type_JavaLangString + '\'' + ", starWebUrl='" + this.e + '\'' + ", adImgUrl='" + this.f + '\'' + ", beginTime=" + this.jdField_a_of_type_Long + ", endTime=" + this.jdField_b_of_type_Long + ", actID=" + this.jdField_c_of_type_Long + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ARScanStarFaceActInfo
 * JD-Core Version:    0.7.0.1
 */