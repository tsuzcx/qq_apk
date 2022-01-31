package com.tencent.biz.qqstory.playvideo.player;

import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import trk;
import trp;
import urk;

public class VideoViewTVKImpl$5$1
  implements Runnable
{
  public VideoViewTVKImpl$5$1(trp paramtrp, TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
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
        trk.a(this.jdField_a_of_type_Trp.a).jdField_b_of_type_JavaLangString = localProperties.getProperty("VideoCodec");
        trk.a(this.jdField_a_of_type_Trp.a).jdField_b_of_type_Long = Long.valueOf(localProperties.getProperty("VideoBitRate")).longValue();
        trk.a(this.jdField_a_of_type_Trp.a).a = Integer.valueOf(localProperties.getProperty("Width")).intValue();
        trk.a(this.jdField_a_of_type_Trp.a).jdField_b_of_type_Int = Integer.valueOf(localProperties.getProperty("Height")).intValue();
        trk.a(this.jdField_a_of_type_Trp.a).jdField_c_of_type_JavaLangString = localProperties.getProperty("AudioCodec");
        trk.a(this.jdField_a_of_type_Trp.a).jdField_c_of_type_Long = Long.valueOf(localProperties.getProperty("AudioBitRate")).longValue();
      }
      urk.a(this.jdField_a_of_type_Trp.a.a, "Video Info : %s", trk.a(this.jdField_a_of_type_Trp.a));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.5.1
 * JD-Core Version:    0.7.0.1
 */