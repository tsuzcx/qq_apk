package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import cooperation.qqcircle.report.QCircleReportBean;

public class QCircleStickShareEvent
  extends SimpleBaseEvent
{
  public String mFeedId;
  public boolean mIsContentPage;
  public int mPicPos;
  public QCircleReportBean mReportBean;
  
  public QCircleStickShareEvent(String paramString, int paramInt, boolean paramBoolean, QCircleReportBean paramQCircleReportBean)
  {
    this.mFeedId = paramString;
    this.mPicPos = paramInt;
    this.mIsContentPage = paramBoolean;
    this.mReportBean = paramQCircleReportBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleStickShareEvent
 * JD-Core Version:    0.7.0.1
 */