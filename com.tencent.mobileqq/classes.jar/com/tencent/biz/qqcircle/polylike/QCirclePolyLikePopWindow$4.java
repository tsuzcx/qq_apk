package com.tencent.biz.qqcircle.polylike;

import com.tencent.biz.qqcircle.flutter.event.QCircleFlutterPolyLikeCloseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBUInt32Field;
import qqcircle.QQCircleFeedBase.StPolyLike;

class QCirclePolyLikePopWindow$4
  implements QCirclePolyLikeFrameLayout.OnClickHookListener
{
  QCirclePolyLikePopWindow$4(QCirclePolyLikePopWindow paramQCirclePolyLikePopWindow, QQCircleFeedBase.StPolyLike paramStPolyLike, QCirclePolyBaseLikeView paramQCirclePolyBaseLikeView) {}
  
  public void a()
  {
    if (QCirclePolyLikePopWindow.c(this.c) != null) {
      QCirclePolyLikePopWindow.c(this.c).a();
    }
  }
  
  public void a(QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    if (QCirclePolyLikePopWindow.c(this.c) != null) {
      QCirclePolyLikePopWindow.c(this.c).a(this.a);
    }
    paramStPolyLike = this.b;
    if ((!(paramStPolyLike instanceof QCirclePolyLikePayView)) || (((QCirclePolyLikePayView)paramStPolyLike).e.price.get() <= QCirclePolyLikeInfoManger.a().c()))
    {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFlutterPolyLikeCloseEvent(1));
      this.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikePopWindow.4
 * JD-Core Version:    0.7.0.1
 */