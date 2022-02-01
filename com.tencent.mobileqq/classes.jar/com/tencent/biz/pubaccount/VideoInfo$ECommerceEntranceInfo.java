package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import java.util.Arrays;
import obs;

public class VideoInfo$ECommerceEntranceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ECommerceEntranceInfo> CREATOR = new obs();
  public int a;
  public UrlJumpInfo a;
  public String a;
  public int[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  
  public VideoInfo$ECommerceEntranceInfo()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
  }
  
  public VideoInfo$ECommerceEntranceInfo(Parcel paramParcel)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_ArrayOfInt = paramParcel.createIntArray();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("commerceEntranceInfo{title='").append(this.jdField_a_of_type_JavaLangString).append('\'').append(", subTitle='").append(this.jdField_b_of_type_JavaLangString).append('\'').append(", thumbnailUrl='").append(this.jdField_c_of_type_JavaLangString).append('\'').append(", linkIconUrl='").append(this.jdField_d_of_type_JavaLangString).append('\'').append(", jumpType=").append(this.jdField_a_of_type_Int).append(", jumpUrl='").append(this.jdField_e_of_type_JavaLangString).append('\'').append(", showPosition=").append(Arrays.toString(this.jdField_a_of_type_ArrayOfInt)).append(", showPercent=").append(this.jdField_c_of_type_Int).append(", playTime=").append(this.jdField_b_of_type_Int).append(", commonData=").append(this.jdField_f_of_type_JavaLangString).append(", displayCountsVersion=").append(this.jdField_d_of_type_Int).append(", sessionDisplayCounts=").append(this.jdField_e_of_type_Int).append(", oneDayMaxDisplayCounts=").append(this.jdField_f_of_type_Int).append(", videoSource=").append(this.jdField_g_of_type_Int).append(", style=").append(this.jdField_h_of_type_Int).append(", appInfo=");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null) {}
    for (String str = "null";; str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.toString()) {
      return str + ", downloadBtnText=" + this.jdField_g_of_type_JavaLangString + ", openBtnText=" + this.jdField_h_of_type_JavaLangString + '}';
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeIntArray(this.jdField_a_of_type_ArrayOfInt);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo, paramInt);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo
 * JD-Core Version:    0.7.0.1
 */