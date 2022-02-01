package com.tencent.biz.qqstory.playvideo.player;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class StoryPlayerTVKWrapper$1
  implements Runnable
{
  StoryPlayerTVKWrapper$1(StoryPlayerTVKWrapper paramStoryPlayerTVKWrapper, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    SLog.d("StoryPlayerTVKWrapper", ">> stop + release");
    this.a.stop();
    this.a.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper.1
 * JD-Core Version:    0.7.0.1
 */