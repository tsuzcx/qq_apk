package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aplg;

public class ARCommonConfigInfo$NativeSoRes
  implements Parcelable
{
  public static final Parcelable.Creator<NativeSoRes> CREATOR = new aplg();
  public long a;
  public String a;
  public String b = "";
  public String c = "";
  public String d = "";
  
  public ARCommonConfigInfo$NativeSoRes()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public ARCommonConfigInfo$NativeSoRes(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("NativeSoRes{");
    localStringBuffer.append("name = '").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", version = '").append(this.b).append('\'');
    localStringBuffer.append(", url = '").append(this.c).append('\'');
    localStringBuffer.append(", md5 = '").append(this.d).append('\'');
    localStringBuffer.append(", size = ").append(this.jdField_a_of_type_Long);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes
 * JD-Core Version:    0.7.0.1
 */