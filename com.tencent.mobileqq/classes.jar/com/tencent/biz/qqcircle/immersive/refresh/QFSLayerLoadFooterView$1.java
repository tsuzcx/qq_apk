package com.tencent.biz.qqcircle.immersive.refresh;

class QFSLayerLoadFooterView$1
  implements Runnable
{
  QFSLayerLoadFooterView$1(QFSLayerLoadFooterView paramQFSLayerLoadFooterView, QFSPullRefreshLayout paramQFSPullRefreshLayout) {}
  
  public void run()
  {
    if (QFSLayerLoadFooterView.a(this.this$0, this.a)) {
      return;
    }
    QFSLayerLoadFooterView.a(this.this$0).b();
    QFSLayerLoadFooterView.a(this.this$0).setVisibility(8);
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.refresh.QFSLayerLoadFooterView.1
 * JD-Core Version:    0.7.0.1
 */