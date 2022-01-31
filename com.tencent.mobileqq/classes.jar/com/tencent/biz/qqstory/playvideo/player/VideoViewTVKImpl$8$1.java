package com.tencent.biz.qqstory.playvideo.player;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import trk;
import trs;

public class VideoViewTVKImpl$8$1
  implements Runnable
{
  public VideoViewTVKImpl$8$1(trs paramtrs, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Trs.a.a != null) {
      this.jdField_a_of_type_Trs.a.a.onSeekComplete(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.8.1
 * JD-Core Version:    0.7.0.1
 */