package com.tencent.mobileqq.apollo.game.process.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.apollo.render.IRenderRunner;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloGameMusicPlayer$1
  implements MediaPlayer.OnCompletionListener
{
  int jdField_a_of_type_Int = this.b;
  
  ApolloGameMusicPlayer$1(ApolloGameMusicPlayer paramApolloGameMusicPlayer, int paramInt, IRenderRunner paramIRenderRunner, long paramLong) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    try
    {
      this.jdField_a_of_type_Int -= 1;
      paramMediaPlayer.seekTo(0);
      if ((this.jdField_a_of_type_Int > 0) && (!this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioApolloGameMusicPlayer.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        paramMediaPlayer.start();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioApolloGameMusicPlayer.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        ApolloGameMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioApolloGameMusicPlayer, false);
      }
      synchronized (ApolloGameMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioApolloGameMusicPlayer))
      {
        if (ApolloGameMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioApolloGameMusicPlayer).contains(paramMediaPlayer)) {
          ApolloGameMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioApolloGameMusicPlayer).remove(paramMediaPlayer);
        }
        if (QLog.isColorLevel())
        {
          ??? = ApolloGameMusicPlayer.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[onCompletion], audio_sessionID: ");
          localStringBuilder.append(paramMediaPlayer.getAudioSessionId());
          QLog.d((String)???, 2, localStringBuilder.toString());
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloRenderIRenderRunner instanceof ApolloSurfaceView))
        {
          ??? = (ApolloSurfaceView)this.jdField_a_of_type_ComTencentMobileqqApolloRenderIRenderRunner;
          ((ApolloSurfaceView)???).runRenderTask(new ApolloGameMusicPlayer.1.1(this, (ApolloSurfaceView)???));
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
      QLog.e(ApolloGameMusicPlayer.jdField_a_of_type_JavaLangString, 1, "[onCompletion]", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.ApolloGameMusicPlayer.1
 * JD-Core Version:    0.7.0.1
 */