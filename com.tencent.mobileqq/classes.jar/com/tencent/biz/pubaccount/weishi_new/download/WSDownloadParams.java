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
    return "WSDownloadParams{mScene=" + this.mScene + ", mLinkStrategyType=" + this.mLinkStrategyType + ", mEventId=" + this.mEventId + ", mTestId='" + this.mTestId + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams
 * JD-Core Version:    0.7.0.1
 */