package com.tencent.biz.qqcircle.fragments.content;

import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.flutter.QQCircleMethodImpl;
import com.tencent.biz.qqcircle.flutter.QQCircleMethodMine;
import com.tencent.biz.qqcircle.flutter.layer.QCircleFlutterPolyLikeLayer;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Map;

class QCircleFlutterContentDetailTransFragment$1
  implements Runnable
{
  QCircleFlutterContentDetailTransFragment$1(QCircleFlutterContentDetailTransFragment paramQCircleFlutterContentDetailTransFragment, QCircleFlutterPolyLikeLayer paramQCircleFlutterPolyLikeLayer) {}
  
  public void run()
  {
    FeedCloudMeta.StFeed localStFeed = QQCircleMethodImpl.getInstance().getCurrentFeed();
    if (localStFeed == null)
    {
      QLog.w("QCircleContentDetailFragment", 1, "[handleComment] invalid feed");
      return;
    }
    new QCircleCommentInfo().b = localStFeed;
    QCircleReportBean localQCircleReportBean = new QCircleReportBean();
    localQCircleReportBean.setPageId(57);
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = new QCircleExtraTypeInfo();
    localQCircleExtraTypeInfo.mFeed = localStFeed;
    try
    {
      if (QQCircleMethodMine.getCurrentReportParam() != null)
      {
        localQCircleExtraTypeInfo.mDataPosition = ((Integer)QQCircleMethodMine.getCurrentReportParam().get("current_index")).intValue();
        localQCircleExtraTypeInfo.sourceType = ((Integer)QQCircleMethodMine.getCurrentReportParam().get("source_type")).intValue();
        localQCircleReportBean.setFromPageId(((Integer)QQCircleMethodMine.getCurrentReportParam().get("from_page_id")).intValue());
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleContentDetailFragment", 1, "[handlePraise] error", localException);
    }
    localQCircleReportBean.setFromPageId(localQCircleExtraTypeInfo.sourceType);
    localQCircleExtraTypeInfo.mPlayScene = 2;
    if (localStFeed.title != null) {
      localQCircleExtraTypeInfo.title = localStFeed.title.get();
    }
    this.a.a(localQCircleExtraTypeInfo, localQCircleReportBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleFlutterContentDetailTransFragment.1
 * JD-Core Version:    0.7.0.1
 */