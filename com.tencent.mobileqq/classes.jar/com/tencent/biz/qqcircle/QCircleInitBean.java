package com.tencent.biz.qqcircle;

import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.io.Serializable;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import tqo;

public class QCircleInitBean
  implements Serializable
{
  public boolean isSingleFeed;
  public QCircleInitBean.QCircleActionBean mActionBean;
  private byte[] mBusiInfoDataByteArray;
  public int mDataPosInList;
  private ExtraTypeInfo mExtraTypeInfo;
  private byte[] mFeedByteArray;
  private byte[] mFeedListBusiReqByteArray;
  private byte[] mTagInfoByteArray;
  private byte[] mUserByteArray;
  public long mVideoCurrentPosition;
  
  private QCircleInitBean(tqo paramtqo)
  {
    if (tqo.a(paramtqo) != null) {
      this.mFeedByteArray = tqo.a(paramtqo).toByteArray();
    }
    if (tqo.a(paramtqo) != null) {
      this.mUserByteArray = tqo.a(paramtqo).toByteArray();
    }
    if (tqo.a(paramtqo) != null) {
      this.mTagInfoByteArray = tqo.a(paramtqo).toByteArray();
    }
    if (tqo.a(paramtqo) != null) {
      this.mFeedListBusiReqByteArray = tqo.a(paramtqo).toByteArray();
    }
    this.mBusiInfoDataByteArray = tqo.a(paramtqo);
    if (tqo.a(paramtqo) == null) {}
    for (ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();; localExtraTypeInfo = tqo.a(paramtqo))
    {
      this.mExtraTypeInfo = localExtraTypeInfo;
      this.mDataPosInList = tqo.a(paramtqo);
      this.mActionBean = tqo.a(paramtqo);
      return;
    }
  }
  
  public byte[] getBusiInfoData()
  {
    return this.mBusiInfoDataByteArray;
  }
  
  public int getDataPosInList()
  {
    return this.mDataPosInList;
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    return this.mExtraTypeInfo;
  }
  
  public FeedCloudMeta.StFeed getFeed()
  {
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    try
    {
      localStFeed.mergeFrom(this.mFeedByteArray);
      return localStFeed;
    }
    catch (Exception localException) {}
    return localStFeed;
  }
  
  public QQCircleFeedBase.StFeedListBusiReqData getFeedListBusiReq()
  {
    QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    if (this.mFeedListBusiReqByteArray != null) {}
    try
    {
      localStFeedListBusiReqData.mergeFrom(this.mFeedListBusiReqByteArray);
      return localStFeedListBusiReqData;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    return localStFeedListBusiReqData;
  }
  
  public FeedCloudMeta.StTagInfo getTagInfo()
  {
    FeedCloudMeta.StTagInfo localStTagInfo = new FeedCloudMeta.StTagInfo();
    try
    {
      localStTagInfo.mergeFrom(this.mTagInfoByteArray);
      return localStTagInfo;
    }
    catch (Exception localException) {}
    return localStTagInfo;
  }
  
  public FeedCloudMeta.StUser getUser()
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    try
    {
      localStUser.mergeFrom(this.mUserByteArray);
      return localStUser;
    }
    catch (Exception localException) {}
    return localStUser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleInitBean
 * JD-Core Version:    0.7.0.1
 */