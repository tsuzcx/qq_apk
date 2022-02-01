package com.tencent.mobileqq.apollo.game.process.audio;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.qphone.base.util.QLog;

class ApolloGameMusicPlayer$2
  implements AudioManager.OnAudioFocusChangeListener
{
  ApolloGameMusicPlayer$2(ApolloGameMusicPlayer paramApolloGameMusicPlayer) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ApolloGameMusicPlayer.a, 2, new Object[] { "[onAudioFocusChange],focusChange:", Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.ApolloGameMusicPlayer.2
 * JD-Core Version:    0.7.0.1
 */