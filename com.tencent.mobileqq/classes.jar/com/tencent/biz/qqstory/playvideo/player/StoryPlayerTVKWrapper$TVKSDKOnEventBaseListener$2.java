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
        StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.a(this.this$0).jdField_b_of_type_Long = Long.valueOf(localObject.getProperty("VideoBitRate")).longValue();
        StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.a(this.this$0).jdField_b_of_type_JavaLangString = localObject.getProperty("VideoCodec");
        StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.a(this.this$0).c = localObject.getProperty("AudioCodec");
        StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.a(this.this$0).a = Integer.valueOf(localObject.getProperty("Width")).intValue();
        StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.a(this.this$0).jdField_b_of_type_Int = Integer.valueOf(localObject.getProperty("Height")).intValue();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.2
 * JD-Core Version:    0.7.0.1
 */