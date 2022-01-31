package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import nsw;

public class VideoInfo$TopBarInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TopBarInfo> CREATOR = new nsw();
  public int a;
  public UrlJumpInfo a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public VideoInfo$TopBarInfo() {}
  
  public VideoInfo$TopBarInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "TopBarInfo{logoId=" + this.jdField_a_of_type_Int + ", iconUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", title='" + this.b + '\'' + ", backgroundUrl='" + this.c + '\'' + ", jumpInfo=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo + ", commonData='" + this.d + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo, paramInt);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.TopBarInfo
 * JD-Core Version:    0.7.0.1
 */