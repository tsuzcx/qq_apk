package com.tencent.biz.qqcircle.immersive.feed;

import com.tencent.biz.qqcircle.immersive.manager.QFSFeedShareButtonManager;

class QFSFeedChildInteractPresenter$3
  implements Runnable
{
  QFSFeedChildInteractPresenter$3(QFSFeedChildInteractPresenter paramQFSFeedChildInteractPresenter) {}
  
  public void run()
  {
    if (QFSFeedChildInteractPresenter.b(this.this$0) == null)
    {
      QFSFeedChildInteractPresenter localQFSFeedChildInteractPresenter = this.this$0;
      QFSFeedChildInteractPresenter.a(localQFSFeedChildInteractPresenter, new QFSFeedShareButtonManager(QFSFeedChildInteractPresenter.c(localQFSFeedChildInteractPresenter), QFSFeedChildInteractPresenter.d(this.this$0)));
    }
    QFSFeedChildInteractPresenter.b(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildInteractPresenter.3
 * JD-Core Version:    0.7.0.1
 */