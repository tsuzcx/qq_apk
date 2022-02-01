package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import rev;

public class SocializeFeedsInfo$JumpInfo
  implements Parcelable
{
  public static final Parcelable.Creator<JumpInfo> CREATOR = new rev();
  private final long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private final String b;
  
  public SocializeFeedsInfo$JumpInfo(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public SocializeFeedsInfo$JumpInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public String b()
  {
    if (this.b != null) {
      return this.b;
    }
    return "";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "JumpInfo{id=" + this.jdField_a_of_type_Long + ", wording='" + this.jdField_a_of_type_JavaLangString + '\'' + ", jumpUrl='" + this.b + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo
 * JD-Core Version:    0.7.0.1
 */