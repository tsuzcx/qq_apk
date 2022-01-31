package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import neo;

public class VideoInfo$LikeActionDownloadBar
  implements Parcelable
{
  public static final Parcelable.Creator<LikeActionDownloadBar> CREATOR = new neo();
  public UrlJumpInfo a;
  public String a;
  public String b;
  public String c;
  
  public VideoInfo$LikeActionDownloadBar() {}
  
  public VideoInfo$LikeActionDownloadBar(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "LikeActionDownloadBar{logoUrl=" + this.jdField_a_of_type_JavaLangString + ", downloadBarText='" + this.b + '\'' + ", jumpInfo=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo + ", commonData='" + this.c + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo, paramInt);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar
 * JD-Core Version:    0.7.0.1
 */