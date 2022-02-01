package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.comment.QCircleCommentInputPopupWindow.OnCommentPopupHeightChangeListener;
import com.tencent.biz.qqcircle.events.QCircleRelocationScrollEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleCommentHelper$2
  implements QCircleCommentInputPopupWindow.OnCommentPopupHeightChangeListener
{
  QCircleCommentHelper$2(QCircleCommentHelper paramQCircleCommentHelper, QCircleFeedCommentInfo paramQCircleFeedCommentInfo, int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    String str = this.a.a.id.get();
    QLog.d("QCircleCommentHelper", 1, new Object[] { "onCommentPopupHeightChange() keyboardHeight: ", Integer.valueOf(paramInt1), " | inputPanelHeight: ", Integer.valueOf(paramInt2) });
    SimpleEventBus.getInstance().dispatchEvent(new QCircleRelocationScrollEvent(str, paramInt1, paramInt2, this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleCommentHelper.2
 * JD-Core Version:    0.7.0.1
 */