package com.tencent.biz.qqcircle.fragments.content;

import com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickLayout;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.widgets.multitouchimg.OnScaleChangedListener;
import com.tencent.biz.qqcircle.widgets.multitouchimg.QCircleMultiTouchImageView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleContentImage$2
  implements OnScaleChangedListener
{
  QCircleContentImage$2(QCircleContentImage paramQCircleContentImage, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((QCircleContentImage.d(this.b) != null) && (QCircleContentImage.e(this.b) != null)) {
      QCircleContentImage.d(this.b).a(QCircleContentImage.e(this.b).getScale());
    }
    QCircleContentImage.a(this.b, paramFloat1, paramFloat2, paramFloat3);
    if (!QCircleContentImage.f(this.b))
    {
      QCircleContentImage.a(this.b, true);
      Object localObject = this.a;
      if (localObject != null)
      {
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d((FeedCloudMeta.StFeed)localObject)).setActionType(67).setSubActionType(2).setPosition(QCircleContentImage.b(this.b)).setPlayScene(QCircleContentImage.i(this.b)).setPageId(QCircleContentImage.h(this.b)).setfpageid(QCircleContentImage.g(this.b)));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onScaleChange report success. pos: ");
        ((StringBuilder)localObject).append(QCircleContentImage.b(this.b));
        QLog.d("Stick-PIC-QCircleContentImage", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentImage.2
 * JD-Core Version:    0.7.0.1
 */