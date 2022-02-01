package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;

class QFSFeedChildBottomInfoPresenter$RichTextAtClickListener
  implements RFWAsyncRichTextView.OnClickAtTextListener
{
  private QFSFeedChildBottomInfoPresenter$RichTextAtClickListener(QFSFeedChildBottomInfoPresenter paramQFSFeedChildBottomInfoPresenter) {}
  
  public void onClick(String paramString)
  {
    if ((this.a.c != null) && (this.a.f != null))
    {
      QCircleInitBean localQCircleInitBean = new QCircleInitBean();
      localQCircleInitBean.setUin(paramString);
      localQCircleInitBean.setFeed((FeedCloudMeta.StFeed)this.a.c);
      if (this.a.i() != null) {
        localQCircleInitBean.setFromReportBean(this.a.i().clone());
      }
      QCircleLauncher.b(this.a.f.getContext(), localQCircleInitBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBottomInfoPresenter.RichTextAtClickListener
 * JD-Core Version:    0.7.0.1
 */