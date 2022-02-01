package com.tencent.biz.qqcircle.events;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import cooperation.qqcircle.report.QCircleReportBean;

public class QCircleFeedViewExportEvent
  extends SimpleBaseEvent
{
  private Bundle mAttach = null;
  private String mFeedId = "";
  private int mPageId = -1;
  private QCircleReportBean mReportBean;
  
  public QCircleFeedViewExportEvent(String paramString, Bundle paramBundle, QCircleReportBean paramQCircleReportBean)
  {
    if (this.mAttach == null) {
      this.mAttach = new Bundle();
    }
    if (paramBundle != null) {
      this.mAttach.putAll(paramBundle);
    }
    this.mFeedId = paramString;
    this.mReportBean = paramQCircleReportBean;
  }
  
  public Bundle getAttach()
  {
    return this.mAttach;
  }
  
  public String getFeedId()
  {
    return this.mFeedId;
  }
  
  public QCircleReportBean getReportBean()
  {
    return this.mReportBean;
  }
  
  public Bundle obtainBundle()
  {
    if (this.mAttach == null) {
      this.mAttach = new Bundle();
    }
    return this.mAttach;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedViewExportEvent
 * JD-Core Version:    0.7.0.1
 */