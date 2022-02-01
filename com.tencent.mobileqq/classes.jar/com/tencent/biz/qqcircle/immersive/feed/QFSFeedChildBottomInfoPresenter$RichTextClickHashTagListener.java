package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickHashTagTextListener;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;

class QFSFeedChildBottomInfoPresenter$RichTextClickHashTagListener
  implements RFWAsyncRichTextView.OnClickHashTagTextListener
{
  private QFSFeedChildBottomInfoPresenter$RichTextClickHashTagListener(QFSFeedChildBottomInfoPresenter paramQFSFeedChildBottomInfoPresenter) {}
  
  public void onClick(String paramString)
  {
    if (this.a.f != null)
    {
      Object localObject = new QCirclePolymerizationBean();
      FeedCloudMeta.StTagInfo localStTagInfo = new FeedCloudMeta.StTagInfo();
      localStTagInfo.tagName.set(paramString);
      ((QCirclePolymerizationBean)localObject).setTagInfo(localStTagInfo);
      ((QCirclePolymerizationBean)localObject).setFromReportBean(this.a.i().clone());
      ((QCirclePolymerizationBean)localObject).setPolymerizationType(7);
      ((QCirclePolymerizationBean)localObject).setExt1From(3);
      QCircleLauncher.a(this.a.f.getContext(), (QCirclePolymerizationBean)localObject);
      if ((this.a.c != null) && (!TextUtils.isEmpty(paramString)))
      {
        localObject = this.a;
        QFSFeedChildBottomInfoPresenter.a((QFSFeedChildBottomInfoPresenter)localObject, 16, 2, (FeedCloudMeta.StFeed)((QFSFeedChildBottomInfoPresenter)localObject).c, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBottomInfoPresenter.RichTextClickHashTagListener
 * JD-Core Version:    0.7.0.1
 */