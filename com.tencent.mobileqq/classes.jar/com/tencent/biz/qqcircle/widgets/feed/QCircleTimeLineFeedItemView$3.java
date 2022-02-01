package com.tencent.biz.qqcircle.widgets.feed;

import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

class QCircleTimeLineFeedItemView$3
  implements RFWAsyncRichTextView.OnClickAtTextListener
{
  static {}
  
  QCircleTimeLineFeedItemView$3(QCircleTimeLineFeedItemView paramQCircleTimeLineFeedItemView) {}
  
  @QCircleFeedClick
  public void onClick(String paramString)
  {
    JoinPoint localJoinPoint = Factory.makeJP(ajc$tjp_0, this, this, paramString);
    onClick_aroundBody1$advice(this, paramString, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView.3
 * JD-Core Version:    0.7.0.1
 */