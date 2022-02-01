package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import android.widget.SeekBar;
import com.tencent.image.URLImageView;

class QFSFullScreenVideoPresenter$2
  implements Runnable
{
  QFSFullScreenVideoPresenter$2(QFSFullScreenVideoPresenter paramQFSFullScreenVideoPresenter, boolean paramBoolean) {}
  
  public void run()
  {
    if (QFSFullScreenVideoPresenter.d(this.this$0) != null)
    {
      if (QFSFullScreenVideoPresenter.e(this.this$0) == null) {
        return;
      }
      if (this.a)
      {
        QFSFullScreenVideoPresenter.d(this.this$0).setVisibility(8);
        QFSFullScreenVideoPresenter.e(this.this$0).setVisibility(0);
        QFSFullScreenVideoPresenter.f(this.this$0).setVisibility(8);
        return;
      }
      QFSFullScreenVideoPresenter.d(this.this$0).setVisibility(0);
      QFSFullScreenVideoPresenter.e(this.this$0).setVisibility(8);
      QFSFullScreenVideoPresenter.f(this.this$0).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter.2
 * JD-Core Version:    0.7.0.1
 */