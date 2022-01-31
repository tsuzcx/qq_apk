package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import npg;

public class VideoInfo$ChannelInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ChannelInfo> CREATOR = new npg();
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public VideoInfo$ChannelInfo() {}
  
  public VideoInfo$ChannelInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ChannelInfo{channelID=" + this.jdField_a_of_type_Int + ", channelType=" + this.jdField_b_of_type_Int + ", channelName='" + this.jdField_a_of_type_JavaLangString + '\'' + ", channelDisplayName='" + this.jdField_b_of_type_JavaLangString + '\'' + ", channelURL='" + this.jdField_c_of_type_JavaLangString + '\'' + ", isTopic=" + this.jdField_c_of_type_Int + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.ChannelInfo
 * JD-Core Version:    0.7.0.1
 */