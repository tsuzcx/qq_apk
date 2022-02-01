package com.tencent.biz.qqcircle.immersive.feed;

import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.richframework.widget.BaseVideoView.InitListener;
import com.tencent.qphone.base.util.QLog;

class QFSFullScreenVideoPresenter$5
  implements BaseVideoView.InitListener
{
  QFSFullScreenVideoPresenter$5(QFSFullScreenVideoPresenter paramQFSFullScreenVideoPresenter) {}
  
  public void a()
  {
    if (QFSFullScreenVideoPresenter.b(this.a) == null) {
      return;
    }
    QFSFullScreenVideoPresenter.b(this.a).setBaseVideoViewListenerSets(new QFSFullScreenVideoPresenter.5.1(this));
    QFSFullScreenVideoPresenter.b(this.a).setProgressBar(QFSFullScreenVideoPresenter.e(this.a));
    QFSFullScreenVideoPresenter.b(this.a).setLoadingView(QFSFullScreenVideoPresenter.f(this.a), 1);
    QFSFullScreenVideoPresenter.b(this.a).setVideoCover(QFSFullScreenVideoPresenter.d(this.a));
    QFSFullScreenVideoPresenter.b(this.a).setLoopBack(true);
    QFSFullScreenVideoPresenter.b(this.a).setOutPutMute(false);
    QLog.d("QFSFullScreenVideoPresenter", 1, "onInitSuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter.5
 * JD-Core Version:    0.7.0.1
 */