package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickHashTagTextListener;
import feedcloud.FeedCloudMeta.StFeed;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

class QCircleFeedItemDesPresenter$2
  implements RFWAsyncRichTextView.OnClickHashTagTextListener
{
  static {}
  
  QCircleFeedItemDesPresenter$2(QCircleFeedItemDesPresenter paramQCircleFeedItemDesPresenter, FeedCloudMeta.StFeed paramStFeed) {}
  
  @QCircleFeedClick
  public void onClick(String paramString)
  {
    JoinPoint localJoinPoint = Factory.makeJP(c, this, this, paramString);
    a(this, paramString, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemDesPresenter.2
 * JD-Core Version:    0.7.0.1
 */