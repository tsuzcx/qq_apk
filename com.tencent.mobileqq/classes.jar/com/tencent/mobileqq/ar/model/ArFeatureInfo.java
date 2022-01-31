package com.tencent.mobileqq.ar.model;

import alkq;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArFeatureInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ArFeatureInfo> CREATOR = new alkq();
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public ArFeatureInfo() {}
  
  public ArFeatureInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArFeatureInfo{");
    localStringBuffer.append("featureMd5='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", featureSize=").append(this.jdField_a_of_type_Long).append('\'');
    localStringBuffer.append(", featureUrl=").append(this.b).append('\'');
    localStringBuffer.append(", featurefileName=").append(this.c).append('\'');
    localStringBuffer.append(", modelRootDir=").append(this.d).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArFeatureInfo
 * JD-Core Version:    0.7.0.1
 */