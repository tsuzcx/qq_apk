package com.tencent.biz.qqcircle;

import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.io.Serializable;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase.StPolyLike;
import uxk;

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
  public QCircleReportBean mFromReportBean;
  private byte[] mPoiInfoByteArray;
  private byte[] mPolyLikeByteArray;
  private byte[] mTagInfoByteArray;
  private byte[] mUserByteArray;
  public long mVideoCurrentPosition;
  
  private QCircleInitBean(uxk paramuxk)
  {
    if (uxk.a(paramuxk) != null) {
      this.mFeedByteArray = uxk.a(paramuxk).toByteArray();
    }
    if (uxk.a(paramuxk) != null) {
      this.mUserByteArray = uxk.a(paramuxk).toByteArray();
    }
    if (uxk.a(paramuxk) != null) {
      this.mTagInfoByteArray = uxk.a(paramuxk).toByteArray();
    }
    if (uxk.a(paramuxk) != null) {
      this.mPoiInfoByteArray = uxk.a(paramuxk).toByteArray();
    }
    if (uxk.a(paramuxk) != null) {
      this.mFeedListBusiReqByteArray = uxk.a(paramuxk).toByteArray();
    }
    if (uxk.a(paramuxk) != null) {
      this.mPolyLikeByteArray = uxk.a(paramuxk).toByteArray();
    }
    this.mBusiInfoDataByteArray = uxk.a(paramuxk);
    if (uxk.a(paramuxk) == null) {}
    for (ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();; localExtraTypeInfo = uxk.a(paramuxk))
    {
      this.mExtraTypeInfo = localExtraTypeInfo;
      this.mDataPosInList = uxk.a(paramuxk);
      this.mActionBean = uxk.a(paramuxk);
      this.mFromReportBean = uxk.a(paramuxk);
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
  
  public FeedCloudMeta.StPoiInfoV2 getPoiInfo()
  {
    FeedCloudMeta.StPoiInfoV2 localStPoiInfoV2 = new FeedCloudMeta.StPoiInfoV2();
    try
    {
      localStPoiInfoV2.mergeFrom(this.mPoiInfoByteArray);
      return localStPoiInfoV2;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleInitBean", 1, localException, new Object[0]);
    }
    return localStPoiInfoV2;
  }
  
  public QQCircleFeedBase.StPolyLike getPolyLike()
  {
    QQCircleFeedBase.StPolyLike localStPolyLike = new QQCircleFeedBase.StPolyLike();
    try
    {
      localStPolyLike.mergeFrom(this.mPolyLikeByteArray);
      return localStPolyLike;
    }
    catch (Exception localException) {}
    return localStPolyLike;
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
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleInitBean
 * JD-Core Version:    0.7.0.1
 */