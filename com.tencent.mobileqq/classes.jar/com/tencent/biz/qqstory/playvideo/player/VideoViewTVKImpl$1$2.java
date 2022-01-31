package com.tencent.biz.qqstory.playvideo.player;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Arrays;
import stl;
import tvh;
import ued;
import uee;
import ved;

public class VideoViewTVKImpl$1$2
  implements Runnable
{
  public VideoViewTVKImpl$1$2(uee paramuee) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_Ued.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_Ued.d)))
    {
      this.a.jdField_a_of_type_Tsz.a = SystemClock.uptimeMillis();
      tvh.a();
      String[] arrayOfString = this.a.jdField_a_of_type_Stl.a(this.a.jdField_a_of_type_Ued.d.replace("https://", "http://"));
      ved.d(this.a.jdField_a_of_type_Ued.jdField_a_of_type_JavaLangString, "TVK_IMediaPlayer.openMediaPlayerByUrl, 1, vid=%s, urls=%s", new Object[] { this.a.jdField_a_of_type_JavaLangString, Arrays.toString(arrayOfString) });
      this.a.jdField_a_of_type_Ued.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.a.jdField_a_of_type_Ued.jdField_a_of_type_AndroidContentContext, arrayOfString, 0L, 0L, this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo, null);
      this.a.jdField_a_of_type_Ued.b = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.1.2
 * JD-Core Version:    0.7.0.1
 */