package com.tencent.biz.pubaccount.readinjoy.struct;

import auko;
import java.util.Arrays;
import qbz;
import qca;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;

public class ReportInfo
  extends auko
  implements Cloneable
{
  public String firstVideoRowkey;
  public int mAlgorithmId;
  public int mArticleLength = -1;
  public int mChannelId;
  public String mCollectUrl;
  public int mColumnID = -1;
  public qbz mFeedsReportData;
  public int mFolderStatus;
  public String mGWCommonData;
  public byte[] mGalleryReportInfo;
  public String mHotWord;
  public String mInnerId;
  public boolean mIsGallery;
  public int mOpSource;
  public int mOperation;
  public int mPlayTimeLength;
  public long mPuin;
  public int mReadArticleLength = -1;
  public int mReadTimeLength;
  public String mSearchTagName;
  public byte[] mServerContext;
  public int mSource;
  public long mSourceArticleId;
  public int mStrategyId;
  public long mUin;
  public qca mVideoExtraRepoerData;
  public int noDifferenceJump;
  public String replyID;
  public long replyUin = -1L;
  public oidb_cmd0x64e.SRTClickInfo srtClickInfo;
  public String videoReportInfo;
  
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
  
  public String toString()
  {
    return "ReportInfo{mUin=" + this.mUin + ", mSource=" + this.mSource + ", mSourceArticleId=" + this.mSourceArticleId + ", mChannelId=" + this.mChannelId + ", mAlgorithmId=" + this.mAlgorithmId + ", mStrategyId=" + this.mStrategyId + ", mOperation=" + this.mOperation + ", mOpSource=" + this.mOpSource + ", mInnerId='" + this.mInnerId + '\'' + ", mFolderStatus=" + this.mFolderStatus + ", mServerContext=" + Arrays.toString(this.mServerContext) + ", mSearchTagName='" + this.mSearchTagName + '\'' + ", replyUin='" + this.replyUin + '\'' + ", replyID='" + this.replyID + '\'' + ", videoReportInfo=" + this.videoReportInfo + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo
 * JD-Core Version:    0.7.0.1
 */