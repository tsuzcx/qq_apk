package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArModelResource
  implements Parcelable
{
  public static final Parcelable.Creator<ArModelResource> CREATOR = new ArModelResource.1();
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public ArModelResource() {}
  
  protected ArModelResource(Parcel paramParcel)
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
    localStringBuffer.append("modelResourceSize='");
    localStringBuffer.append(this.jdField_a_of_type_Long);
    localStringBuffer.append('\'');
    localStringBuffer.append(", modelResourceMD5=");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", modelResourceUrl=");
    localStringBuffer.append(this.b);
    localStringBuffer.append('\'');
    localStringBuffer.append(", modelResourceBgMusic=");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append(", modelConfigFile=");
    localStringBuffer.append(this.d);
    localStringBuffer.append('\'');
    localStringBuffer.append(", modelRepeatTimes=");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append('\'');
    localStringBuffer.append(", videoLayout=");
    localStringBuffer.append(this.e);
    localStringBuffer.append('\'');
    localStringBuffer.append(", zipFileName=");
    localStringBuffer.append(this.f);
    localStringBuffer.append('\'');
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArModelResource
 * JD-Core Version:    0.7.0.1
 */