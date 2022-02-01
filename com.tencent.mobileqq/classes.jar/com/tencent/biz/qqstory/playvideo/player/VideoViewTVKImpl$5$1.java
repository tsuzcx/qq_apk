package com.tencent.biz.qqstory.playvideo.player;

import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

class VideoViewTVKImpl$5$1
  implements Runnable
{
  VideoViewTVKImpl$5$1(VideoViewTVKImpl.5 param5, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getStreamDumpInfo();
    if (!TextUtils.isEmpty(str))
    {
      Properties localProperties = new Properties();
      Object localObject;
      try
      {
        localProperties.load(new StringReader(str));
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        localObject = null;
      }
      if (localObject != null)
      {
        VideoViewTVKImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl$5.a).jdField_b_of_type_JavaLangString = localObject.getProperty("VideoCodec");
        VideoViewTVKImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl$5.a).jdField_b_of_type_Long = Long.valueOf(localObject.getProperty("VideoBitRate")).longValue();
        VideoViewTVKImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl$5.a).a = Integer.valueOf(localObject.getProperty("Width")).intValue();
        VideoViewTVKImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl$5.a).jdField_b_of_type_Int = Integer.valueOf(localObject.getProperty("Height")).intValue();
        VideoViewTVKImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl$5.a).jdField_c_of_type_JavaLangString = localObject.getProperty("AudioCodec");
        VideoViewTVKImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl$5.a).jdField_c_of_type_Long = Long.valueOf(localObject.getProperty("AudioBitRate")).longValue();
      }
    }
    SLog.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl$5.a.a, "Video Info : %s", VideoViewTVKImpl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl$5.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.5.1
 * JD-Core Version:    0.7.0.1
 */