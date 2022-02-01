package com.tencent.mobileqq.apollo.process.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

class CmGameAudioPlayer$1
  implements MediaPlayer.OnErrorListener
{
  CmGameAudioPlayer$1(CmGameAudioPlayer paramCmGameAudioPlayer) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.e("CmGameAudioPlayer", 1, "what " + paramInt1 + " ext " + paramInt2);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.audio.CmGameAudioPlayer.1
 * JD-Core Version:    0.7.0.1
 */