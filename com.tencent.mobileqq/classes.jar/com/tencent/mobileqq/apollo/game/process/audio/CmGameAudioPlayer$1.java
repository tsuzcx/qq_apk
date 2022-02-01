package com.tencent.mobileqq.apollo.game.process.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

class CmGameAudioPlayer$1
  implements MediaPlayer.OnErrorListener
{
  CmGameAudioPlayer$1(CmGameAudioPlayer paramCmGameAudioPlayer) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append("what ");
    paramMediaPlayer.append(paramInt1);
    paramMediaPlayer.append(" ext ");
    paramMediaPlayer.append(paramInt2);
    QLog.e("[cmshow]CmGameAudioPlayer", 1, paramMediaPlayer.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmGameAudioPlayer.1
 * JD-Core Version:    0.7.0.1
 */