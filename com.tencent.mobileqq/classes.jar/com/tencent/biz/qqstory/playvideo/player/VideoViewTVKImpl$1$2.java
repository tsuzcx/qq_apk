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
    if ((this.a.f.c != null) && (!TextUtils.isEmpty(this.a.f.g)))
    {
      this.a.b.g = SystemClock.uptimeMillis();
      TVKPreloader.a();
      String[] arrayOfString = this.a.c.b(this.a.f.g.replace("https://", "http://"));
      SLog.d(this.a.f.a, "TVK_IMediaPlayer.openMediaPlayerByUrl, 1, vid=%s, urls=%s", new Object[] { this.a.d, Arrays.toString(arrayOfString) });
      this.a.f.c.openMediaPlayerByUrl(this.a.f.d, arrayOfString, 0L, 0L, this.a.e, null);
      this.a.f.j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.1.2
 * JD-Core Version:    0.7.0.1
 */