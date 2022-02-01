package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.common.app.AppInterface;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;

public abstract class QCircleBaseLightInteractWidget
  extends QCircleBaseWidgetView
{
  public int a;
  public ReportExtraTypeInfo a;
  protected AppInterface a;
  public FeedCloudMeta.StFeed a;
  protected FeedCloudMeta.StLightInteractInfo a;
  protected int b;
  
  public QCircleBaseLightInteractWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(AppInterface paramAppInterface, FeedCloudMeta.StFeed paramStFeed, ReportExtraTypeInfo paramReportExtraTypeInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = paramReportExtraTypeInfo;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBaseLightInteractWidget
 * JD-Core Version:    0.7.0.1
 */