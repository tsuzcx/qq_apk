package com.tencent.mobileqq.ar;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class ARMusicController$2
  implements MediaPlayer.OnPreparedListener
{
  ARMusicController$2(ARMusicController paramARMusicController) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "load bg music success. : " + ARMusicController.b(this.a));
      }
      this.a.a.seekTo(0);
      ARMusicController.b(this.a, true);
      if (ARMusicController.b(this.a))
      {
        this.a.a.start();
        ARMusicController.c(this.a, false);
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      paramMediaPlayer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARMusicController.2
 * JD-Core Version:    0.7.0.1
 */