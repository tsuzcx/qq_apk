package com.tencent.biz.qqstory.playvideo.player;

import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import xtu;

public class StoryPlayerTVKWrapper$TVKSDKOnEventBaseListener$2
  implements Runnable
{
  public StoryPlayerTVKWrapper$TVKSDKOnEventBaseListener$2(xtu paramxtu, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    String str = this.a.getStreamDumpInfo();
    Properties localProperties;
    if (!TextUtils.isEmpty(str)) {
      localProperties = new Properties();
    }
    try
    {
      localProperties.load(new StringReader(str));
      if (localProperties != null)
      {
        xtu.a(this.this$0).jdField_b_of_type_Long = Long.valueOf(localProperties.getProperty("VideoBitRate")).longValue();
        xtu.a(this.this$0).jdField_b_of_type_JavaLangString = localProperties.getProperty("VideoCodec");
        xtu.a(this.this$0).c = localProperties.getProperty("AudioCodec");
        xtu.a(this.this$0).a = Integer.valueOf(localProperties.getProperty("Width")).intValue();
        xtu.a(this.this$0).jdField_b_of_type_Int = Integer.valueOf(localProperties.getProperty("Height")).intValue();
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.2
 * JD-Core Version:    0.7.0.1
 */