package com.tencent.mobileqq.ar.model;

import anbh;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArModelResource
  implements Parcelable
{
  public static final Parcelable.Creator<ArModelResource> CREATOR = new anbh();
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public ArModelResource() {}
  
  public ArModelResource(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArModelResource{");
    localStringBuffer.append("modelResourceSize='").append(this.jdField_a_of_type_Long).append('\'');
    localStringBuffer.append(", modelResourceMD5=").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", modelResourceUrl=").append(this.b).append('\'');
    localStringBuffer.append(", modelResourceBgMusic=").append(this.c).append('\'');
    localStringBuffer.append(", modelConfigFile=").append(this.d).append('\'');
    localStringBuffer.append(", modelRepeatTimes=").append(this.jdField_a_of_type_Int).append('\'');
    localStringBuffer.append(", videoLayout=").append(this.e).append('\'');
    localStringBuffer.append(", zipFileName=").append(this.f).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArModelResource
 * JD-Core Version:    0.7.0.1
 */