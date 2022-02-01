package com.tencent.biz.qqcircle.fragments.content;

import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickHashTagTextListener;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;

class QCircleContentOperationView$2
  implements RFWAsyncRichTextView.OnClickHashTagTextListener
{
  QCircleContentOperationView$2(QCircleContentOperationView paramQCircleContentOperationView, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void onClick(String paramString)
  {
    QCirclePolymerizationBean localQCirclePolymerizationBean = new QCirclePolymerizationBean();
    FeedCloudMeta.StTagInfo localStTagInfo = new FeedCloudMeta.StTagInfo();
    localStTagInfo.tagName.set(paramString);
    localQCirclePolymerizationBean.setTagInfo(localStTagInfo);
    localQCirclePolymerizationBean.setFromReportBean(this.b.getReportBean().clone());
    localQCirclePolymerizationBean.setPolymerizationType(7);
    localQCirclePolymerizationBean.setExt1From(3);
    QCircleLauncher.a(this.b.getContext(), localQCirclePolymerizationBean);
    QCircleContentOperationView.a(this.b, 16, 2, this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView.2
 * JD-Core Version:    0.7.0.1
 */