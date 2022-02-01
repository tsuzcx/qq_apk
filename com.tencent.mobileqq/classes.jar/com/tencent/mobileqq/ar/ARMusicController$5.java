package com.tencent.mobileqq.ar;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class ARMusicController$5
  implements MediaPlayer.OnPreparedListener
{
  ARMusicController$5(ARMusicController paramARMusicController) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        paramMediaPlayer = new StringBuilder();
        paramMediaPlayer.append("load bg music success. : ");
        paramMediaPlayer.append(ARMusicController.c(this.a));
        QLog.d("ARMusicController", 2, paramMediaPlayer.toString());
      }
      this.a.a.seekTo(0);
      ARMusicController.b(this.a, true);
      if (ARMusicController.d(this.a))
      {
        this.a.a.start();
        ARMusicController.c(this.a, false);
        return;
      }
    }
    catch (Exception paramMediaPlayer)
    {
      paramMediaPlayer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARMusicController.5
 * JD-Core Version:    0.7.0.1
 */