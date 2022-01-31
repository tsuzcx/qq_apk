package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import gq;

public class ImageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ImageInfo> CREATOR = new gq();
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  private ImageInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.c = paramParcel.readString();
  }
  
  private boolean a(ImageInfo paramImageInfo)
  {
    return (this.jdField_b_of_type_JavaLangString.equals(paramImageInfo.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == paramImageInfo.jdField_a_of_type_Long) && (this.jdField_b_of_type_Long == paramImageInfo.jdField_b_of_type_Long) && (this.jdField_a_of_type_JavaLangString.equals(paramImageInfo.jdField_a_of_type_JavaLangString));
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
    if ((paramObject == null) || (!(paramObject instanceof ImageInfo))) {
      return false;
    }
    return a((ImageInfo)paramObject);
  }
  
  public int hashCode()
  {
    return (this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long + this.jdField_b_of_type_Long).hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.util.file.ImageInfo
 * JD-Core Version:    0.7.0.1
 */