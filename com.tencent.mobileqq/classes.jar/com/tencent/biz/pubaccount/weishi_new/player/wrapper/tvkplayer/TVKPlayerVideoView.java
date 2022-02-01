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
    IVideoViewBase localIVideoViewBase = this.a;
    if ((localIVideoViewBase instanceof View)) {
      return (View)localIVideoViewBase;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    IVideoViewBase localIVideoViewBase = this.a;
    if (localIVideoViewBase != null) {
      localIVideoViewBase.setFixedSize(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer.TVKPlayerVideoView
 * JD-Core Version:    0.7.0.1
 */