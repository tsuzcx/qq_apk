package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import npf;

public class VideoInfo$AdTagInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AdTagInfo> CREATOR = new npf();
  public int a;
  public VideoInfo.ClassInfo a;
  public String a;
  public ArrayList<VideoInfo.KdTagItem> a;
  public int b;
  public String b;
  
  public VideoInfo$AdTagInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public VideoInfo$AdTagInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(VideoInfo.KdTagItem.CREATOR);
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ClassInfo = ((VideoInfo.ClassInfo)paramParcel.readParcelable(VideoInfo.ClassInfo.class.getClassLoader()));
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ClassInfo, paramInt);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.AdTagInfo
 * JD-Core Version:    0.7.0.1
 */