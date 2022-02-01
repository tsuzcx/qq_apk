package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class SocializeFeedsInfo$BiuCommentInfo
  implements Parcelable, Serializable, Cloneable
{
  public static final Parcelable.Creator<BiuCommentInfo> CREATOR = new SocializeFeedsInfo.BiuCommentInfo.1();
  public static final int OP_TYPE_AT = 1;
  public static final int OP_TYPE_BIU = 0;
  public static final int OP_TYPE_TOPIC = 2;
  public static final int OP_TYPE_URL = 3;
  public SocializeFeedsInfo.JumpInfo jumpInfo;
  public String mBiuComment;
  public int mBiuTime;
  public Long mFeedId;
  public int mFeedsType = 1;
  public int mOpType = 0;
  public String mOrigBiuComment;
  public Long mUin;
  public SocializeFeedsInfo.UGCVoiceInfo ugcVoiceInfo;
  
  public SocializeFeedsInfo$BiuCommentInfo() {}
  
  protected SocializeFeedsInfo$BiuCommentInfo(Parcel paramParcel)
  {
    this.mBiuTime = paramParcel.readInt();
    this.mUin = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
    this.mFeedId = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
    this.mBiuComment = paramParcel.readString();
    this.mOrigBiuComment = paramParcel.readString();
    this.mFeedsType = paramParcel.readInt();
    this.jumpInfo = ((SocializeFeedsInfo.JumpInfo)paramParcel.readParcelable(SocializeFeedsInfo.JumpInfo.class.getClassLoader()));
    this.mOpType = paramParcel.readInt();
    this.ugcVoiceInfo = ((SocializeFeedsInfo.UGCVoiceInfo)paramParcel.readParcelable(SocializeFeedsInfo.UGCVoiceInfo.class.getClassLoader()));
  }
  
  public SocializeFeedsInfo$BiuCommentInfo(Long paramLong1, Long paramLong2, String paramString)
  {
    this.mUin = paramLong1;
    this.mFeedId = paramLong2;
    this.mBiuComment = paramString;
  }
  
  public SocializeFeedsInfo$BiuCommentInfo(String paramString1, Long paramLong, String paramString2)
  {
    try
    {
      this.mUin = Long.valueOf(paramString1);
      this.mFeedId = paramLong;
      this.mBiuComment = paramString2;
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        this.mUin = Long.valueOf(0L);
      }
    }
  }
  
  public SocializeFeedsInfo$BiuCommentInfo(String paramString1, Long paramLong, String paramString2, int paramInt)
  {
    this(paramString1, paramLong, paramString2);
    this.mOpType = paramInt;
  }
  
  public SocializeFeedsInfo$BiuCommentInfo(String paramString1, Long paramLong, String paramString2, int paramInt, SocializeFeedsInfo.JumpInfo paramJumpInfo)
  {
    this(paramString1, paramLong, paramString2, paramInt);
    this.jumpInfo = paramJumpInfo;
  }
  
  public SocializeFeedsInfo$BiuCommentInfo(String paramString1, Long paramLong, String paramString2, int paramInt, SocializeFeedsInfo.JumpInfo paramJumpInfo, SocializeFeedsInfo.UGCVoiceInfo paramUGCVoiceInfo)
  {
    this(paramString1, paramLong, paramString2, paramInt, paramJumpInfo);
    this.ugcVoiceInfo = paramUGCVoiceInfo;
  }
  
  public BiuCommentInfo clone()
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
    return "biuTime=" + this.mBiuTime + "uin=" + this.mUin + "feedId=" + this.mFeedId + "comment=" + this.mBiuComment + "feedsType=" + this.mFeedsType;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mBiuTime);
    paramParcel.writeValue(this.mUin);
    paramParcel.writeValue(this.mFeedId);
    paramParcel.writeString(this.mBiuComment);
    paramParcel.writeString(this.mOrigBiuComment);
    paramParcel.writeInt(this.mFeedsType);
    paramParcel.writeParcelable(this.jumpInfo, paramInt);
    paramParcel.writeInt(this.mOpType);
    paramParcel.writeParcelable(this.ugcVoiceInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo
 * JD-Core Version:    0.7.0.1
 */