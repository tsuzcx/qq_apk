package com.tencent.biz.qqcircle.immersive.refresh;

class QFSPullRefreshLayout$5
  implements Runnable
{
  QFSPullRefreshLayout$5(QFSPullRefreshLayout paramQFSPullRefreshLayout) {}
  
  public void run()
  {
    if (QFSPullRefreshLayout.i(this.this$0) == null) {
      return;
    }
    if (QFSPullRefreshLayout.h(this.this$0) == 3)
    {
      QFSPullRefreshLayout.g(this.this$0).a(this.this$0);
      QFSPullRefreshLayout.a(this.this$0, 1);
    }
    QFSPullRefreshLayout localQFSPullRefreshLayout = this.this$0;
    QFSPullRefreshLayout.a(localQFSPullRefreshLayout, 0.0F, QFSPullRefreshLayout.f(localQFSPullRefreshLayout), new QFSPullRefreshLayout.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.5
 * JD-Core Version:    0.7.0.1
 */