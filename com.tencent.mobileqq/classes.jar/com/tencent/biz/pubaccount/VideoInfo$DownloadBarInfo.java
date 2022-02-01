package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import obr;

public class VideoInfo$DownloadBarInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadBarInfo> CREATOR = new obr();
  public int a;
  public UrlJumpInfo a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public VideoInfo$DownloadBarInfo() {}
  
  public VideoInfo$DownloadBarInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DownloadBarInfo{appearTime=" + this.jdField_a_of_type_Int + ", logoUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", downloadBtnText='" + this.jdField_b_of_type_JavaLangString + '\'' + ", openBtnText='" + this.c + '\'' + ", buttonBgColor=" + this.jdField_b_of_type_Int + ", jumpInfo=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo + ", commonData='" + this.d + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo, paramInt);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.DownloadBarInfo
 * JD-Core Version:    0.7.0.1
 */