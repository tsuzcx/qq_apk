package com.tencent.biz.qqcircle.immersive.feed;

import android.widget.TextView;
import com.tencent.biz.qqcircle.utils.TimeUtils;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.superplayer.api.ISuperPlayer;

class QFSFeedChildVideoPresenter$4
  implements Runnable
{
  QFSFeedChildVideoPresenter$4(QFSFeedChildVideoPresenter paramQFSFeedChildVideoPresenter, ISuperPlayer paramISuperPlayer) {}
  
  public void run()
  {
    if (QFSFeedChildVideoPresenter.i(this.this$0) != null)
    {
      RFWTypefaceUtil.a(QFSFeedChildVideoPresenter.i(this.this$0), false);
      QFSFeedChildVideoPresenter.i(this.this$0).setText(TimeUtils.a((int)this.a.getDurationMs()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter.4
 * JD-Core Version:    0.7.0.1
 */