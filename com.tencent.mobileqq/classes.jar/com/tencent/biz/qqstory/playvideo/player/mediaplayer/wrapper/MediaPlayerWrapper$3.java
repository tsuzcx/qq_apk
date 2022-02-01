package com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;

class MediaPlayerWrapper$3
  implements MediaPlayer.OnBufferingUpdateListener
{
  MediaPlayerWrapper$3(MediaPlayerWrapper paramMediaPlayerWrapper, IMediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener) {}
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    this.a.a(this.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.MediaPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */