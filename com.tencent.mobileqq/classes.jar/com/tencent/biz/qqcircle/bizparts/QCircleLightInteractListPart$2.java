package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.IStatusListener;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class QCircleLightInteractListPart$2
  implements QCircleSlidBottomView.IStatusListener
{
  QCircleLightInteractListPart$2(QCircleLightInteractListPart paramQCircleLightInteractListPart) {}
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void b()
  {
    QCircleLightInteractListPart.b(this.a).getRecyclerView().scrollToPosition(0);
    QCircleLightInteractListPart.b(this.a).getBlockMerger().l();
    QCircleLightInteractListPart.c(this.a).clearData();
    this.a.a(true, false, true);
    if ((QCircleLightInteractListPart.d(this.a) != null) && (QCircleLightInteractListPart.d(this.a).mFeed != null))
    {
      QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b(QCircleLightInteractListPart.d(this.a).mFeed);
      int i;
      if (QCircleLightInteractListPart.e(this.a) == 1) {
        i = 87;
      } else {
        i = 75;
      }
      localDataBuilder = localDataBuilder.setActionType(i);
      if (QCircleLightInteractListPart.e(this.a) == 1) {
        i = 6;
      } else {
        i = 2;
      }
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(localDataBuilder.setSubActionType(i).setToUin(QCircleLightInteractListPart.d(this.a).mFeed.poster.id.get()).setIndex(QCircleLightInteractListPart.d(this.a).mDataPosition).setPageId(this.a.f())));
    }
    QLog.d("QCircleLightInteractListPart", 4, "dismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart.2
 * JD-Core Version:    0.7.0.1
 */