package com.tencent.biz.qqcircle.launchbean;

import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.io.Serializable;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase.StPolyLike;
import qqcircle.QQCircleFeedBase.StSimulateData;

public class QCircleInitBean
  implements Serializable
{
  private boolean enableSplash = true;
  private boolean isSingleFeed;
  private QCircleInitBean.QCircleActionBean mActionBean;
  private byte[] mBusiInfoDataByteArray;
  private int mDataPosInList;
  private ExtraTypeInfo mExtraTypeInfo;
  private byte[] mFeedByteArray;
  private byte[] mFeedListBusiReqByteArray;
  private QCircleReportBean mFromReportBean;
  private String mLaunchFrom;
  private String mLaunchId;
  private int mLaunchTo;
  private byte[] mPoiInfoByteArray;
  private byte[] mPolyLikeByteArray;
  private byte[] mSimulateDataByteArray;
  private byte[] mTagInfoByteArray;
  private byte[] mUserByteArray;
  private long mVideoCurrentPosition;
  
  public QCircleInitBean.QCircleActionBean getActionBean()
  {
    return this.mActionBean;
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
    if (this.mExtraTypeInfo == null) {
      this.mExtraTypeInfo = new ExtraTypeInfo();
    }
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
  
  public QCircleReportBean getFromReportBean()
  {
    return this.mFromReportBean;
  }
  
  public String getLaunchFrom()
  {
    return this.mLaunchFrom;
  }
  
  public String getLaunchId()
  {
    return this.mLaunchId;
  }
  
  public int getLaunchTo()
  {
    return this.mLaunchTo;
  }
  
  public FeedCloudMeta.StPoiInfoV2 getPoiInfo()
  {
    FeedCloudMeta.StPoiInfoV2 localStPoiInfoV2 = new FeedCloudMeta.StPoiInfoV2();
    try
    {
      if (this.mPoiInfoByteArray != null) {
        localStPoiInfoV2.mergeFrom(this.mPoiInfoByteArray);
      }
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
  
  public QQCircleFeedBase.StSimulateData getSimulateData()
  {
    QQCircleFeedBase.StSimulateData localStSimulateData = new QQCircleFeedBase.StSimulateData();
    try
    {
      localStSimulateData.mergeFrom(this.mSimulateDataByteArray);
      return localStSimulateData;
    }
    catch (Exception localException) {}
    return localStSimulateData;
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
  
  public String getUin()
  {
    FeedCloudMeta.StUser localStUser = getUser();
    if (localStUser != null) {
      return localStUser.id.get();
    }
    return null;
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
  
  public long getVideoCurrentPosition()
  {
    return this.mVideoCurrentPosition;
  }
  
  public boolean isEnableSplash()
  {
    return this.enableSplash;
  }
  
  public boolean isSingleFeed()
  {
    return this.isSingleFeed;
  }
  
  public void setActionBean(QCircleInitBean.QCircleActionBean paramQCircleActionBean)
  {
    this.mActionBean = paramQCircleActionBean;
  }
  
  public void setBusiInfoData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      this.mBusiInfoDataByteArray = paramArrayOfByte;
    }
  }
  
  public void setDataPosInList(int paramInt)
  {
    this.mDataPosInList = paramInt;
  }
  
  public void setEnableSplash(boolean paramBoolean)
  {
    this.enableSplash = paramBoolean;
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      this.mFeedByteArray = paramStFeed.toByteArray();
    }
  }
  
  public void setFeedListBusiReqData(QQCircleFeedBase.StFeedListBusiReqData paramStFeedListBusiReqData)
  {
    if (paramStFeedListBusiReqData != null) {
      this.mFeedListBusiReqByteArray = paramStFeedListBusiReqData.toByteArray();
    }
  }
  
  public void setFromReportBean(QCircleReportBean paramQCircleReportBean)
  {
    if (paramQCircleReportBean != null) {
      this.mFromReportBean = paramQCircleReportBean.clone();
    }
  }
  
  public void setLaunchFrom(String paramString)
  {
    this.mLaunchFrom = paramString;
  }
  
  public void setLaunchId(String paramString)
  {
    this.mLaunchId = paramString;
  }
  
  public void setLaunchTo(int paramInt)
  {
    this.mLaunchTo = paramInt;
  }
  
  public void setPoiInfo(FeedCloudMeta.StPoiInfoV2 paramStPoiInfoV2)
  {
    if (paramStPoiInfoV2 != null) {
      this.mPoiInfoByteArray = paramStPoiInfoV2.toByteArray();
    }
  }
  
  public void setPolyLike(QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    if (paramStPolyLike != null) {
      this.mPolyLikeByteArray = paramStPolyLike.toByteArray();
    }
  }
  
  public void setSimulateData(QQCircleFeedBase.StSimulateData paramStSimulateData)
  {
    if (paramStSimulateData != null) {
      this.mSimulateDataByteArray = paramStSimulateData.toByteArray();
    }
  }
  
  public void setSingleFeed(boolean paramBoolean)
  {
    this.isSingleFeed = paramBoolean;
  }
  
  public void setSourceType(int paramInt)
  {
    if (this.mExtraTypeInfo == null) {
      this.mExtraTypeInfo = new ExtraTypeInfo();
    }
    this.mExtraTypeInfo.sourceType = paramInt;
  }
  
  public void setTagInfo(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    if (paramStTagInfo != null) {
      this.mTagInfoByteArray = paramStTagInfo.toByteArray();
    }
  }
  
  public void setUin(String paramString)
  {
    if (paramString != null)
    {
      FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
      localStUser.id.set(paramString);
      this.mUserByteArray = localStUser.toByteArray();
    }
  }
  
  public void setUser(FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser != null) {
      this.mUserByteArray = paramStUser.toByteArray();
    }
  }
  
  public void setVideoCurrentPosition(long paramLong)
  {
    this.mVideoCurrentPosition = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launchbean.QCircleInitBean
 * JD-Core Version:    0.7.0.1
 */