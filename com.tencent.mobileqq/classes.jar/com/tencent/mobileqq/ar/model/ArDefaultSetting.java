package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArDefaultSetting
  implements Parcelable
{
  public static final Parcelable.Creator<ArDefaultSetting> CREATOR = new ArDefaultSetting.1();
  public int a;
  public String a;
  public int b;
  public int c;
  
  public ArDefaultSetting() {}
  
  public ArDefaultSetting(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ArDefaultSetting{key='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", modelLevel=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", traceLevel=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArDefaultSetting
 * JD-Core Version:    0.7.0.1
 */