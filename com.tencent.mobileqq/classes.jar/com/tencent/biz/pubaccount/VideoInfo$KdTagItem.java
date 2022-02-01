package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import odg;

public class VideoInfo$KdTagItem
  implements Parcelable
{
  public static final Parcelable.Creator<KdTagItem> CREATOR = new odg();
  public long a;
  public String a;
  
  public VideoInfo$KdTagItem()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public VideoInfo$KdTagItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.KdTagItem
 * JD-Core Version:    0.7.0.1
 */