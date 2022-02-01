package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.os.Build.VERSION;

public class MediaPlayer$VideoRenderTimingMode
{
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return paramInt == 3;
      }
      return false;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.VideoRenderTimingMode
 * JD-Core Version:    0.7.0.1
 */