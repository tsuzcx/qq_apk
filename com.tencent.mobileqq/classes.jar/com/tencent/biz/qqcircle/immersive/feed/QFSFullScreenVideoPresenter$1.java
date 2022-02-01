package com.tencent.biz.qqcircle.immersive.feed;

import android.widget.ImageView;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.qqlive.module.videoreport.VideoReport;

class QFSFullScreenVideoPresenter$1
  implements Runnable
{
  QFSFullScreenVideoPresenter$1(QFSFullScreenVideoPresenter paramQFSFullScreenVideoPresenter, int paramInt) {}
  
  public void run()
  {
    if (QFSFullScreenVideoPresenter.a(this.this$0) != null)
    {
      if (QFSFullScreenVideoPresenter.b(this.this$0) == null) {
        return;
      }
      if (this.a == 0)
      {
        QFSFullScreenVideoPresenter.a(this.this$0).setImageResource(2130848889);
        QFSFullScreenVideoPresenter.c(this.this$0);
        QFSFullScreenVideoPresenter.b(this.this$0).h();
        return;
      }
      QFSFullScreenVideoPresenter.a(this.this$0).setImageResource(2130848890);
      VideoReport.unbindVideoPlayerInfo(QFSFullScreenVideoPresenter.b(this.this$0));
      QFSFullScreenVideoPresenter.b(this.this$0).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter.1
 * JD-Core Version:    0.7.0.1
 */