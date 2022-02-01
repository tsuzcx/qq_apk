package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

class QCircleFeedCommentWidget$3
  implements RFWAsyncRichTextView.OnClickAtTextListener
{
  static {}
  
  QCircleFeedCommentWidget$3(QCircleFeedCommentWidget paramQCircleFeedCommentWidget) {}
  
  @QCircleFeedClick
  public void onClick(String paramString)
  {
    JoinPoint localJoinPoint = Factory.makeJP(b, this, this, paramString);
    a(this, paramString, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget.3
 * JD-Core Version:    0.7.0.1
 */