package com.tencent.biz.qqcircle.immersive.refresh;

import android.widget.TextView;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.OnRefreshLoadViewStatusListener;
import com.tencent.qphone.base.util.QLog;

class QFSLayerRefreshHeaderView$1
  implements Runnable
{
  QFSLayerRefreshHeaderView$1(QFSLayerRefreshHeaderView paramQFSLayerRefreshHeaderView) {}
  
  public void run()
  {
    QFSLayerRefreshHeaderView.b(this.this$0).setText(QFSLayerRefreshHeaderView.a(this.this$0));
    QFSLayerRefreshHeaderView.b(this.this$0).setVisibility(8);
    QFSLayerRefreshHeaderView.c(this.this$0).b();
    QFSLayerRefreshHeaderView.c(this.this$0).setVisibility(8);
    this.this$0.invalidate();
    if (QFSLayerRefreshHeaderView.d(this.this$0) != null) {
      QFSLayerRefreshHeaderView.d(this.this$0).b(false);
    }
    QLog.d("FSLayerRefreshHeaderView", 1, "onComplete");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.refresh.QFSLayerRefreshHeaderView.1
 * JD-Core Version:    0.7.0.1
 */