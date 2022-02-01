package com.tencent.biz.qqcircle.fragments.content;

import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import cooperation.qqcircle.report.QCircleLpReportDc05502.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public class QCircleContentFeedReportScroller
{
  private static String a = "QCircleContentFeedReportScroller";
  private final QCircleReportBean b;
  private int c;
  private QCircleContentFeedReportScroller.FeedReportBean d;
  
  public QCircleContentFeedReportScroller(QCircleReportBean paramQCircleReportBean)
  {
    this.b = paramQCircleReportBean;
    this.c = this.b.getFromPageId();
  }
  
  private void a(QCircleContentFeedReportScroller.FeedReportBean paramFeedReportBean)
  {
    if (paramFeedReportBean != null)
    {
      FeedCloudMeta.StFeed localStFeed = QCircleContentFeedReportScroller.FeedReportBean.a(paramFeedReportBean);
      paramFeedReportBean.a(System.currentTimeMillis());
      QCircleLpReportDc05502.report(new QCircleLpReportDc05502.DataBuilder(QCirclePluginReportUtil.c(localStFeed).setToUin(localStFeed.poster.id.get()).setBeginTime(paramFeedReportBean.b()).setEndTime(paramFeedReportBean.c()).setStayTime(paramFeedReportBean.d()).setIndex(paramFeedReportBean.e()).setExt1("2").setPageId(this.c)));
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportStayEvent id:");
      localStringBuilder.append(localStFeed.id.get());
      localStringBuilder.append(",pos:");
      localStringBuilder.append(paramFeedReportBean.e());
      localStringBuilder.append(",stayTime:");
      localStringBuilder.append(paramFeedReportBean.d());
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    if (this.d != null)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cleanUpLeftReportBean id:");
      localStringBuilder.append(QCircleContentFeedReportScroller.FeedReportBean.a(this.d).id.get());
      localStringBuilder.append(",pos:");
      localStringBuilder.append(QCircleContentFeedReportScroller.FeedReportBean.b(this.d));
      QLog.d(str, 2, localStringBuilder.toString());
      this.d.a(System.currentTimeMillis());
      a(this.d);
      this.d = null;
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateCurrentFeed id:");
    localStringBuilder.append(paramStFeed.id.get());
    localStringBuilder.append(",pos:");
    localStringBuilder.append(paramInt);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    localObject = this.d;
    if (localObject != null)
    {
      ((QCircleContentFeedReportScroller.FeedReportBean)localObject).a(System.currentTimeMillis());
      a(this.d);
    }
    localObject = new QCircleContentFeedReportScroller.FeedReportBean();
    ((QCircleContentFeedReportScroller.FeedReportBean)localObject).a();
    ((QCircleContentFeedReportScroller.FeedReportBean)localObject).a(paramInt);
    ((QCircleContentFeedReportScroller.FeedReportBean)localObject).a(paramStFeed);
    this.d = ((QCircleContentFeedReportScroller.FeedReportBean)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentFeedReportScroller
 * JD-Core Version:    0.7.0.1
 */