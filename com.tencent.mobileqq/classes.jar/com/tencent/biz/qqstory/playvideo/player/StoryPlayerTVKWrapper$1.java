package com.tencent.biz.qqstory.playvideo.player;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import vwm;
import wxe;

public class StoryPlayerTVKWrapper$1
  implements Runnable
{
  public StoryPlayerTVKWrapper$1(vwm paramvwm, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    wxe.d("StoryPlayerTVKWrapper", ">> stop + release");
    this.a.stop();
    this.a.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper.1
 * JD-Core Version:    0.7.0.1
 */