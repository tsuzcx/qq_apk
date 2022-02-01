package com.tencent.biz.qqstory.playvideo.player;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Arrays;

class VideoViewTVKImpl$1$2
  implements Runnable
{
  VideoViewTVKImpl$1$2(VideoViewTVKImpl.1 param1) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.d)))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilPlayModeUtils$DebugInfo.f = SystemClock.uptimeMillis();
      TVKPreloader.a();
      String[] arrayOfString = this.a.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadUrlManager.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.d.replace("https://", "http://"));
      SLog.d(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.jdField_a_of_type_JavaLangString, "TVK_IMediaPlayer.openMediaPlayerByUrl, 1, vid=%s, urls=%s", new Object[] { this.a.jdField_a_of_type_JavaLangString, Arrays.toString(arrayOfString) });
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.jdField_a_of_type_AndroidContentContext, arrayOfString, 0L, 0L, this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo, null);
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.b = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.1.2
 * JD-Core Version:    0.7.0.1
 */