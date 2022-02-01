package com.tencent.biz.qqstory.playvideo.player;

import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

class StoryPlayerTVKWrapper$TVKSDKOnEventBaseListener$2
  implements Runnable
{
  StoryPlayerTVKWrapper$TVKSDKOnEventBaseListener$2(StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener paramTVKSDKOnEventBaseListener, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
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
        StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.a(this.this$0).h = Long.valueOf(localObject.getProperty("VideoBitRate")).longValue();
        StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.a(this.this$0).e = localObject.getProperty("VideoCodec");
        StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.a(this.this$0).i = localObject.getProperty("AudioCodec");
        StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.a(this.this$0).f = Integer.valueOf(localObject.getProperty("Width")).intValue();
        StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.a(this.this$0).g = Integer.valueOf(localObject.getProperty("Height")).intValue();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.2
 * JD-Core Version:    0.7.0.1
 */