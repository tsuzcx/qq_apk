package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

class VideoExtractFrameTask$1
  implements TVK_IMediaPlayer.OnCompletionListener
{
  VideoExtractFrameTask$1(VideoExtractFrameTask paramVideoExtractFrameTask) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoExtractFrameTask.a(), 2, "播放器状态回调 onCompletion");
    }
    if (VideoExtractFrameTask.a(this.a) != null) {
      VideoExtractFrameTask.a(this.a).a(1, null, VideoExtractFrameTask.a(this.a), System.currentTimeMillis() - VideoExtractFrameTask.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoExtractFrameTask.1
 * JD-Core Version:    0.7.0.1
 */