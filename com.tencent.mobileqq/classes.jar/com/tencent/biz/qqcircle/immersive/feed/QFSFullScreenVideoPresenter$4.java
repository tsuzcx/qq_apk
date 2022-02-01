package com.tencent.biz.qqcircle.immersive.feed;

import android.widget.TextView;
import com.tencent.biz.qqcircle.utils.TimeUtils;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.superplayer.api.ISuperPlayer;

class QFSFullScreenVideoPresenter$4
  implements Runnable
{
  QFSFullScreenVideoPresenter$4(QFSFullScreenVideoPresenter paramQFSFullScreenVideoPresenter, ISuperPlayer paramISuperPlayer) {}
  
  public void run()
  {
    if ((QFSFullScreenVideoPresenter.h(this.this$0) != null) && (QFSFullScreenVideoPresenter.i(this.this$0) != null) && (QFSFullScreenVideoPresenter.g(this.this$0) != null))
    {
      RFWTypefaceUtil.a(QFSFullScreenVideoPresenter.h(this.this$0), false);
      String str = TimeUtils.a((int)this.a.getDurationMs());
      QFSFullScreenVideoPresenter.h(this.this$0).setText(str);
      QFSFullScreenVideoPresenter.i(this.this$0).setText(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter.4
 * JD-Core Version:    0.7.0.1
 */