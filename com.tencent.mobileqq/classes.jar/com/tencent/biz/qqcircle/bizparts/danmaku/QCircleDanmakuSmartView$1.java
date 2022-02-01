package com.tencent.biz.qqcircle.bizparts.danmaku;

import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

class QCircleDanmakuSmartView$1
  implements Runnable
{
  QCircleDanmakuSmartView$1(QCircleDanmakuSmartView paramQCircleDanmakuSmartView) {}
  
  public void run()
  {
    if (QCircleDanmakuSmartView.a(this.this$0) != null)
    {
      QCircleDanmakuSmartView.a(this.this$0).setVisibility(0);
      QCircleDanmakuSmartView.a(this.this$0).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.QCircleDanmakuSmartView.1
 * JD-Core Version:    0.7.0.1
 */