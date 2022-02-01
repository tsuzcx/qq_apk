package com.tencent.biz.qcircleshadow.lib.bean;

public class QCircleVasRewardAdParams
{
  public int mAdvPos;
  public String mBizSrcId;
  public String mGdtBizId;
  public String mRewardItem;
  public String mRewardText;
  public int mRewardType;
  public long mUin;
  
  public QCircleVasRewardAdParams(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    this.mAdvPos = paramInt1;
    this.mRewardType = paramInt2;
    this.mRewardItem = paramString1;
    this.mRewardText = paramString2;
    this.mUin = paramLong;
    this.mGdtBizId = paramString3;
    this.mBizSrcId = paramString4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.bean.QCircleVasRewardAdParams
 * JD-Core Version:    0.7.0.1
 */