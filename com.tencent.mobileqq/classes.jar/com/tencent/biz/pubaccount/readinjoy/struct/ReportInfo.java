package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.persistence.Entity;

public class ReportInfo
  extends Entity
  implements Cloneable
{
  public int mAlgorithmId;
  public int mArticleLength = -1;
  public int mChannelId;
  public String mCollectUrl;
  public ReportInfo.FeedsReportData mFeedsReportData;
  public int mFolderStatus;
  public byte[] mGalleryReportInfo;
  public String mInnerId;
  public boolean mIsGallery;
  public int mOpSource;
  public int mOperation;
  public int mPlayTimeLength;
  public long mPuin;
  public int mReadArticleLength = -1;
  public int mReadTimeLength;
  public byte[] mServerContext;
  public int mSource;
  public long mSourceArticleId;
  public int mStrategyId;
  public long mUin;
  public ReportInfo.VideoExtraRepoerData mVideoExtraRepoerData;
  
  public ReportInfo clone()
  {
    try
    {
      ReportInfo localReportInfo = (ReportInfo)super.clone();
      return localReportInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo
 * JD-Core Version:    0.7.0.1
 */