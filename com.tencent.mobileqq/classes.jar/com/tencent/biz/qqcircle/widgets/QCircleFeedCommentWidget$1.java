package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.events.QCircleFeedCommentEllipseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnTriggerEllipseListener;

class QCircleFeedCommentWidget$1
  implements RFWAsyncRichTextView.OnTriggerEllipseListener
{
  QCircleFeedCommentWidget$1(QCircleFeedCommentWidget paramQCircleFeedCommentWidget) {}
  
  public void a()
  {
    if (QCircleFeedCommentWidget.a(this.a) != null) {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedCommentEllipseEvent(QCircleFeedCommentWidget.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget.1
 * JD-Core Version:    0.7.0.1
 */