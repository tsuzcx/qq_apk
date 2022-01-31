package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import gs;

public class SendInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SendInfo> CREATOR = new gs();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  private SendInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  private boolean a(SendInfo paramSendInfo)
  {
    return (this.jdField_a_of_type_JavaLangString.equals(paramSendInfo.jdField_a_of_type_JavaLangString)) && (this.b.equals(paramSendInfo.b)) && (this.jdField_a_of_type_Long == paramSendInfo.jdField_a_of_type_Long) && (this.jdField_a_of_type_Int == paramSendInfo.jdField_a_of_type_Int);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof SendInfo))) {
      return false;
    }
    return a((SendInfo)paramObject);
  }
  
  public int hashCode()
  {
    return (this.jdField_a_of_type_JavaLangString + this.b + this.jdField_a_of_type_Long).hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.util.file.SendInfo
 * JD-Core Version:    0.7.0.1
 */