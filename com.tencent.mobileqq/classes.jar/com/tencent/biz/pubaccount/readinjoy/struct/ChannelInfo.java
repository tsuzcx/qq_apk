package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.persistence.Entity;

public class ChannelInfo
  extends Entity
  implements Cloneable
{
  public static final int GIF_CHANNEL_TYPE = 4;
  public static final int LOCAL_CHANNEL_TYPE = 1;
  public static final int NORMAL_CHANNEL_TYPE = 0;
  public static final int PICTURE_CHANNEL_TYPE = 2;
  public static final String TABLE_NAME = ArticleInfo.class.getSimpleName();
  public static final int VIDEO_CHANNEL_TYPE = 3;
  public int mChannelID = -1;
  public String mChannelName = "";
  public int mChannelType;
  public int mFollowNum;
  public int mFontColor = -16777216;
  public int mFrameColor = -3355444;
  public String mHeaderPicUrl;
  public boolean mIsFirstReq;
  public boolean mIsFollowed;
  public boolean mIsSystemRecomm;
  public boolean mIsTopic;
  public String mJumpUrl;
  public boolean mShow;
  public int mSortOrder;
  
  public ChannelInfo clone()
  {
    try
    {
      ChannelInfo localChannelInfo = (ChannelInfo)super.clone();
      return localChannelInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChannelInfo:[");
    localStringBuilder.append("\n |-").append("mChannelID: ").append(this.mChannelID);
    localStringBuilder.append("\n |-").append("mChannelName: ").append(this.mChannelName);
    localStringBuilder.append("\n |-").append("mChannelType: ").append(this.mChannelType);
    localStringBuilder.append("\n |-").append("mHeaderPicUrl: ").append(this.mHeaderPicUrl);
    localStringBuilder.append("\n |-").append("mFollowNum: ").append(this.mFollowNum);
    localStringBuilder.append("\n |-").append("mIsFollowed:").append(this.mIsFollowed);
    localStringBuilder.append("\n |-").append("mIsSystemRecomm:").append(this.mIsSystemRecomm);
    localStringBuilder.append("\n |-").append("mIsTopic:").append(this.mIsTopic);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo
 * JD-Core Version:    0.7.0.1
 */