package com.tencent.biz.qqstory.playvideo.player;

import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import xuk;
import xup;
import yuk;

public class VideoViewTVKImpl$5$1
  implements Runnable
{
  public VideoViewTVKImpl$5$1(xup paramxup, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getStreamDumpInfo();
    Properties localProperties;
    if (!TextUtils.isEmpty(str)) {
      localProperties = new Properties();
    }
    try
    {
      localProperties.load(new StringReader(str));
      if (localProperties != null)
      {
        xuk.a(this.jdField_a_of_type_Xup.a).jdField_b_of_type_JavaLangString = localProperties.getProperty("VideoCodec");
        xuk.a(this.jdField_a_of_type_Xup.a).jdField_b_of_type_Long = Long.valueOf(localProperties.getProperty("VideoBitRate")).longValue();
        xuk.a(this.jdField_a_of_type_Xup.a).a = Integer.valueOf(localProperties.getProperty("Width")).intValue();
        xuk.a(this.jdField_a_of_type_Xup.a).jdField_b_of_type_Int = Integer.valueOf(localProperties.getProperty("Height")).intValue();
        xuk.a(this.jdField_a_of_type_Xup.a).jdField_c_of_type_JavaLangString = localProperties.getProperty("AudioCodec");
        xuk.a(this.jdField_a_of_type_Xup.a).jdField_c_of_type_Long = Long.valueOf(localProperties.getProperty("AudioBitRate")).longValue();
      }
      yuk.a(this.jdField_a_of_type_Xup.a.a, "Video Info : %s", xuk.a(this.jdField_a_of_type_Xup.a));
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
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.5.1
 * JD-Core Version:    0.7.0.1
 */