package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Properties;
import obz;
import qhw;

public class VideoPlayerWrapper$1
  implements Runnable
{
  public VideoPlayerWrapper$1(qhw paramqhw, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    Object localObject = this.a.getStreamDumpInfo();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = obz.a((String)localObject);
      if (localObject != null)
      {
        this.this$0.a = Long.valueOf(((Properties)localObject).getProperty("VideoBitRate")).longValue();
        if (qhw.a(this.this$0) == null) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */