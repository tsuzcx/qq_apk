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
    String str = this.a.getStreamDumpInfo();
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
        VideoViewTVKImpl.a(this.b.a).e = localObject.getProperty("VideoCodec");
        VideoViewTVKImpl.a(this.b.a).h = Long.valueOf(localObject.getProperty("VideoBitRate")).longValue();
        VideoViewTVKImpl.a(this.b.a).f = Integer.valueOf(localObject.getProperty("Width")).intValue();
        VideoViewTVKImpl.a(this.b.a).g = Integer.valueOf(localObject.getProperty("Height")).intValue();
        VideoViewTVKImpl.a(this.b.a).i = localObject.getProperty("AudioCodec");
        VideoViewTVKImpl.a(this.b.a).j = Long.valueOf(localObject.getProperty("AudioBitRate")).longValue();
      }
    }
    SLog.a(this.b.a.a, "Video Info : %s", VideoViewTVKImpl.a(this.b.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.5.1
 * JD-Core Version:    0.7.0.1
 */