package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import omo;
import uge;

public class VideoInfo$SoftAdDownloadBarInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoInfo.DownloadBarInfo> CREATOR = new omo();
  public int a;
  public UrlJumpInfo a;
  public String a;
  public uge a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "SoftAdDownloadBarInfo{title=" + this.jdField_a_of_type_JavaLangString + ", subTitle='" + this.jdField_b_of_type_JavaLangString + '\'' + ", smallIconUrl='" + this.c + '\'' + ", bigIconUrl='" + this.d + '\'' + ", changeBiggerPositionPercent='" + this.jdField_a_of_type_Int + '\'' + ", urlJumpInfo=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo, paramInt);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo
 * JD-Core Version:    0.7.0.1
 */