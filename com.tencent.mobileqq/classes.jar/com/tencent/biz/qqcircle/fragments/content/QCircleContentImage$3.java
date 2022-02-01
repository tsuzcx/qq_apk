package com.tencent.biz.qqcircle.fragments.content;

import android.graphics.Point;
import android.view.View;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickLayout;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.widgets.multitouchimg.OnViewTapListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleContentImage$3
  implements OnViewTapListener
{
  QCircleContentImage$3(QCircleContentImage paramQCircleContentImage, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleContentImmersiveEvent(1));
    paramView = this.a;
    if (paramView != null)
    {
      QCircleLpReportDc05507.DataBuilder localDataBuilder = new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramView)).setActionType(90).setSubActionType(2).setPosition(QCircleContentImage.b(this.b)).setPlayScene(QCircleContentImage.i(this.b));
      paramView = "1";
      localDataBuilder = localDataBuilder.setExt1("1");
      if (QCircleContentImmersiveEvent.isImmersive()) {
        paramView = "2";
      }
      QCircleLpReportDc05507.report(localDataBuilder.setExt4(paramView).setPageId(QCircleContentImage.k(this.b)).setfpageid(QCircleContentImage.j(this.b)));
    }
    if (QCircleContentImage.d(this.b) != null) {
      QCircleContentImage.d(this.b).a(new Point((int)paramFloat1, (int)paramFloat2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentImage.3
 * JD-Core Version:    0.7.0.1
 */