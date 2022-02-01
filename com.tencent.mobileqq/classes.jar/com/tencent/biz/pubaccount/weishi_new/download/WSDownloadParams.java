package com.tencent.biz.pubaccount.weishi_new.download;

import UserGrowth.stReportItem;

public class WSDownloadParams
{
  public int mEventId;
  public int mLinkStrategyType;
  public int mScene;
  public String mScheme;
  public stReportItem mStReportItem;
  public String mTestId;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSDownloadParams{mScene=");
    localStringBuilder.append(this.mScene);
    localStringBuilder.append(", mLinkStrategyType=");
    localStringBuilder.append(this.mLinkStrategyType);
    localStringBuilder.append(", mEventId=");
    localStringBuilder.append(this.mEventId);
    localStringBuilder.append(", mTestId='");
    localStringBuilder.append(this.mTestId);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams
 * JD-Core Version:    0.7.0.1
 */