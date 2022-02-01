package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import reo;

public class SocializeFeedsInfo$BiuCommentInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<BiuCommentInfo> CREATOR = new reo();
  public int a;
  public SocializeFeedsInfo.JumpInfo a;
  public SocializeFeedsInfo.UGCVoiceInfo a;
  public Long a;
  public String a;
  public int b;
  public Long b;
  public String b;
  public int c = 0;
  
  public SocializeFeedsInfo$BiuCommentInfo()
  {
    this.jdField_b_of_type_Int = 1;
  }
  
  public SocializeFeedsInfo$BiuCommentInfo(Parcel paramParcel)
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangLong = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
    this.jdField_b_of_type_JavaLangLong = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = ((SocializeFeedsInfo.JumpInfo)paramParcel.readParcelable(SocializeFeedsInfo.JumpInfo.class.getClassLoader()));
    this.c = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo = ((SocializeFeedsInfo.UGCVoiceInfo)paramParcel.readParcelable(SocializeFeedsInfo.UGCVoiceInfo.class.getClassLoader()));
  }
  
  public SocializeFeedsInfo$BiuCommentInfo(Long paramLong1, Long paramLong2, String paramString)
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangLong = paramLong1;
    this.jdField_b_of_type_JavaLangLong = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public SocializeFeedsInfo$BiuCommentInfo(String paramString1, Long paramLong, String paramString2)
  {
    this.jdField_b_of_type_Int = 1;
    try
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramString1);
      this.jdField_b_of_type_JavaLangLong = paramLong;
      this.jdField_a_of_type_JavaLangString = paramString2;
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
      }
    }
  }
  
  public SocializeFeedsInfo$BiuCommentInfo(String paramString1, Long paramLong, String paramString2, int paramInt)
  {
    this(paramString1, paramLong, paramString2);
    this.c = paramInt;
  }
  
  public SocializeFeedsInfo$BiuCommentInfo(String paramString1, Long paramLong, String paramString2, int paramInt, SocializeFeedsInfo.JumpInfo paramJumpInfo)
  {
    this(paramString1, paramLong, paramString2, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = paramJumpInfo;
  }
  
  public BiuCommentInfo a()
  {
    try
    {
      BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)super.clone();
      return localBiuCommentInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "biuTime=" + this.jdField_a_of_type_Int + "uin=" + this.jdField_a_of_type_JavaLangLong + "feedId=" + this.jdField_b_of_type_JavaLangLong + "comment=" + this.jdField_a_of_type_JavaLangString + "feedsType=" + this.jdField_b_of_type_Int;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeValue(this.jdField_a_of_type_JavaLangLong);
    paramParcel.writeValue(this.jdField_b_of_type_JavaLangLong);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo, paramInt);
    paramParcel.writeInt(this.c);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo
 * JD-Core Version:    0.7.0.1
 */