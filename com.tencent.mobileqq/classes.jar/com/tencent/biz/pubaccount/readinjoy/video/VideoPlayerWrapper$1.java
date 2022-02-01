package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStringUtils;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayer;
import java.util.Properties;

class VideoPlayerWrapper$1
  implements Runnable
{
  VideoPlayerWrapper$1(VideoPlayerWrapper paramVideoPlayerWrapper, IPlayer paramIPlayer) {}
  
  public void run()
  {
    Object localObject = this.a.a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = RIJStringUtils.a((String)localObject);
      if (localObject == null) {
        break label52;
      }
    }
    label52:
    for (localObject = ((Properties)localObject).getProperty("VideoBitRate");; localObject = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.this$0.a = Long.parseLong((String)localObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */