package com.tencent.biz.qqcircle.bizparts.danmaku;

import com.tencent.biz.qqcircle.bizparts.danmaku.entity.R2LPhotoDanmaku.IR2LDanmakuInterface;
import feedcloud.FeedCloudMeta.StFeed;
import java.lang.ref.WeakReference;

class QCircleDanmakuSmartView$IR2LDanmakuHandler
  implements R2LPhotoDanmaku.IR2LDanmakuInterface
{
  private WeakReference<QCircleDanmakuSmartView> a;
  private FeedCloudMeta.StFeed b;
  
  public QCircleDanmakuSmartView$IR2LDanmakuHandler(QCircleDanmakuSmartView paramQCircleDanmakuSmartView, FeedCloudMeta.StFeed paramStFeed)
  {
    this.a = new WeakReference(paramQCircleDanmakuSmartView);
    this.b = paramStFeed;
  }
  
  public void a()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference != null)
    {
      if (localWeakReference.get() == null) {
        return;
      }
      QCircleDanmakuSmartView.a((QCircleDanmakuSmartView)this.a.get(), this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.QCircleDanmakuSmartView.IR2LDanmakuHandler
 * JD-Core Version:    0.7.0.1
 */