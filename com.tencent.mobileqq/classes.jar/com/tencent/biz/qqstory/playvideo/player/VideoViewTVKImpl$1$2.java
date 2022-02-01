package com.tencent.biz.qqstory.playvideo.player;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Arrays;
import wjt;
import xlo;
import xuk;
import xul;
import yuk;

public class VideoViewTVKImpl$1$2
  implements Runnable
{
  public VideoViewTVKImpl$1$2(xul paramxul) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_Xuk.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_Xuk.d)))
    {
      this.a.jdField_a_of_type_Xjh.a = SystemClock.uptimeMillis();
      xlo.a();
      String[] arrayOfString = this.a.jdField_a_of_type_Wjt.a(this.a.jdField_a_of_type_Xuk.d.replace("https://", "http://"));
      yuk.d(this.a.jdField_a_of_type_Xuk.jdField_a_of_type_JavaLangString, "TVK_IMediaPlayer.openMediaPlayerByUrl, 1, vid=%s, urls=%s", new Object[] { this.a.jdField_a_of_type_JavaLangString, Arrays.toString(arrayOfString) });
      this.a.jdField_a_of_type_Xuk.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.a.jdField_a_of_type_Xuk.jdField_a_of_type_AndroidContentContext, arrayOfString, 0L, 0L, this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo, null);
      this.a.jdField_a_of_type_Xuk.b = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.1.2
 * JD-Core Version:    0.7.0.1
 */