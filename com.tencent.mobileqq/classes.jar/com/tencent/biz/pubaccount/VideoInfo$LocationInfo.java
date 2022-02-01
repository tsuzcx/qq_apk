package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoInfo$LocationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocationInfo> CREATOR = new VideoInfo.LocationInfo.1();
  public String a;
  public boolean a;
  
  public VideoInfo$LocationInfo() {}
  
  protected VideoInfo$LocationInfo(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "LocationInfo{location=" + this.jdField_a_of_type_JavaLangString + ", isCreatedByUser=" + this.jdField_a_of_type_Boolean + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.LocationInfo
 * JD-Core Version:    0.7.0.1
 */