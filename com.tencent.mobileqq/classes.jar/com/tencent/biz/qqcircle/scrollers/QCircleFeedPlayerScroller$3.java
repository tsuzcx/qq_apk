package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.richframework.widget.BaseVideoViewListenerSets;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemBaseVideoPresenter;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.HashMap;

class QCircleFeedPlayerScroller$3
  extends BaseVideoViewListenerSets
{
  private boolean f = false;
  
  QCircleFeedPlayerScroller$3(QCircleFeedPlayerScroller paramQCircleFeedPlayerScroller, QCircleFeedItemBaseVideoPresenter paramQCircleFeedItemBaseVideoPresenter, QCircleFeedCleanPlayView paramQCircleFeedCleanPlayView, String paramString1, String paramString2) {}
  
  public void a()
  {
    QCircleFeedPlayerScroller.a(this.e, this.a, false);
    this.f = false;
    this.a.setVoiceIconAndProgressText(false);
    QCircleFeedPlayerScroller.a(this.e);
  }
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    if (!QCircleFeedPlayerScroller.b(this.e)) {
      return;
    }
    this.b.h();
    QCircleFeedPlayerScroller.a(this.e, this.c);
    QCircleFeedPlayerScroller.a(this.e);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == QCircleFeedPlayerScroller.c(this.e)) && (QCircleFeedPlayerScroller.d(this.e) == paramInt1)) {
      return;
    }
    paramString = (Long)QCircleFeedPlayerScroller.e(this.e).get(this.d);
    if ((paramString != null) && (paramString.longValue() > paramInt2))
    {
      long l = paramInt1;
      if ((l != paramString.longValue()) && (Math.abs(l - paramString.longValue()) > 100L)) {}
    }
    else
    {
      QCircleFeedPlayerScroller.e(this.e).put(this.d, Long.valueOf(paramInt2));
    }
    paramString = this.e;
    QCircleFeedPlayerScroller.a(paramString, this.a, QCircleFeedPlayerScroller.a(paramString, paramInt1, paramInt2));
    if ((paramInt2 > 3000) && (!this.f))
    {
      this.f = true;
      this.a.setVoiceIconAndProgressText(true);
    }
    else if ((paramInt2 <= 3000) && (this.f))
    {
      this.f = false;
      this.a.setVoiceIconAndProgressText(false);
    }
    QCircleFeedPlayerScroller.a(this.e, paramInt2);
    QCircleFeedPlayerScroller.b(this.e, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPlayerScroller.3
 * JD-Core Version:    0.7.0.1
 */