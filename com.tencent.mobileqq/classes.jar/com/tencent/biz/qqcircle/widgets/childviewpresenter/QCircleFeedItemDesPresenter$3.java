package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleFeedItemDesPresenter$3
  implements RFWAsyncRichTextView.OnClickAtTextListener
{
  QCircleFeedItemDesPresenter$3(QCircleFeedItemDesPresenter paramQCircleFeedItemDesPresenter, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void onClick(String paramString)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUin(paramString);
    localQCircleInitBean.setFeed(this.a);
    localQCircleInitBean.setFromReportBean(this.b.getReportBean().clone());
    QCircleLauncher.b(this.b.mContainer.getContext(), localQCircleInitBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemDesPresenter.3
 * JD-Core Version:    0.7.0.1
 */