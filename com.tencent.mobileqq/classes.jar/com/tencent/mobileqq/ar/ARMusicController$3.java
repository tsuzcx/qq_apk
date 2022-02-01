package com.tencent.mobileqq.ar;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

class ARMusicController$3
  implements MediaPlayer.OnErrorListener
{
  ARMusicController$3(ARMusicController paramARMusicController) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("ARMusicController, onError, what=");
      paramMediaPlayer.append(paramInt1);
      paramMediaPlayer.append(", extra=");
      paramMediaPlayer.append(paramInt2);
      QLog.e("ARMusicController", 2, paramMediaPlayer.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARMusicController.3
 * JD-Core Version:    0.7.0.1
 */