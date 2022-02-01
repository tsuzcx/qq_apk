package com.tencent.mobileqq.apollo.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloMusicPlayer$1
  implements MediaPlayer.OnCompletionListener
{
  int jdField_a_of_type_Int = this.b;
  
  ApolloMusicPlayer$1(ApolloMusicPlayer paramApolloMusicPlayer, int paramInt) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    try
    {
      this.jdField_a_of_type_Int -= 1;
      paramMediaPlayer.seekTo(0);
      if ((this.jdField_a_of_type_Int > 0) && (!this.jdField_a_of_type_ComTencentMobileqqApolloAudioApolloMusicPlayer.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        paramMediaPlayer.start();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloAudioApolloMusicPlayer.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        this.jdField_a_of_type_ComTencentMobileqqApolloAudioApolloMusicPlayer.a(false);
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloAudioApolloMusicPlayer.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloAudioApolloMusicPlayer.jdField_a_of_type_JavaUtilList.contains(paramMediaPlayer)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloAudioApolloMusicPlayer.jdField_a_of_type_JavaUtilList.remove(paramMediaPlayer);
        }
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("[onCompletion] audio_sessionID: ");
          ((StringBuilder)???).append(paramMediaPlayer.getAudioSessionId());
          QLog.d("[cmshow]ApolloMusicPlayer", 2, ((StringBuilder)???).toString());
        }
        paramMediaPlayer.reset();
        paramMediaPlayer.release();
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      QLog.e("[cmshow]ApolloMusicPlayer", 1, "[onCompletion]", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.audio.ApolloMusicPlayer.1
 * JD-Core Version:    0.7.0.1
 */