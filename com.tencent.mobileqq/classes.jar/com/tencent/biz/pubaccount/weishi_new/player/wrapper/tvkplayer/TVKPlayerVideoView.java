package com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer;

import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSVideoView;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;

public class TVKPlayerVideoView
  implements IWSVideoView
{
  private IVideoViewBase a;
  
  public TVKPlayerVideoView(IVideoViewBase paramIVideoViewBase)
  {
    this.a = paramIVideoViewBase;
  }
  
  public View a()
  {
    if ((this.a instanceof View)) {
      return (View)this.a;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.setFixedSize(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer.TVKPlayerVideoView
 * JD-Core Version:    0.7.0.1
 */