package com.tencent.biz.qqcircle.immersive.feed;

import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.richframework.widget.BaseVideoView.InitListener;
import com.tencent.qphone.base.util.QLog;

class QFSFeedChildVideoPresenter$3
  implements BaseVideoView.InitListener
{
  QFSFeedChildVideoPresenter$3(QFSFeedChildVideoPresenter paramQFSFeedChildVideoPresenter, String paramString) {}
  
  public void a()
  {
    QFSFeedChildVideoPresenter.f(this.b).setBaseVideoViewListenerSets(new QFSFeedChildVideoPresenter.3.1(this));
    QFSFeedChildVideoPresenter.f(this.b).setProgressBar(QFSFeedChildVideoPresenter.c(this.b));
    QFSFeedChildVideoPresenter.f(this.b).setLoadingView(QFSFeedChildVideoPresenter.g(this.b));
    QFSFeedChildVideoPresenter.f(this.b).setLoopBack(true);
    QFSFeedChildVideoPresenter.f(this.b).setOutPutMute(QFSFeedChildVideoPresenter.h(this.b));
    QLog.d("QFSFeedChildVideoPresenter", 1, "onInitSuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter.3
 * JD-Core Version:    0.7.0.1
 */