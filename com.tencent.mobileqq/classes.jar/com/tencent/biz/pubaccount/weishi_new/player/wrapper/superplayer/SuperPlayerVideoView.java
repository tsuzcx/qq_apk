package com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer;

import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSVideoView;
import com.tencent.superplayer.view.ISPlayerVideoView;

public class SuperPlayerVideoView
  implements IWSVideoView
{
  private ISPlayerVideoView a;
  
  public SuperPlayerVideoView(ISPlayerVideoView paramISPlayerVideoView)
  {
    this.a = paramISPlayerVideoView;
  }
  
  public View a()
  {
    ISPlayerVideoView localISPlayerVideoView = this.a;
    if ((localISPlayerVideoView instanceof View)) {
      return (View)localISPlayerVideoView;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ISPlayerVideoView localISPlayerVideoView = this.a;
    if (localISPlayerVideoView != null) {
      localISPlayerVideoView.setFixedSize(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer.SuperPlayerVideoView
 * JD-Core Version:    0.7.0.1
 */