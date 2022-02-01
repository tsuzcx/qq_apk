package com.tencent.mobileqq.apollo.game.process.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderRunner;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloGameMusicPlayer$1
  implements MediaPlayer.OnCompletionListener
{
  int a = this.b;
  
  ApolloGameMusicPlayer$1(ApolloGameMusicPlayer paramApolloGameMusicPlayer, int paramInt, IRenderRunner paramIRenderRunner, long paramLong) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer == null) {
      return;
    }
    try
    {
      this.a -= 1;
      paramMediaPlayer.seekTo(0);
      if ((this.a > 0) && (!this.e.b.get()))
      {
        paramMediaPlayer.start();
        return;
      }
      if (this.e.b.get()) {
        ApolloGameMusicPlayer.a(this.e, false);
      }
      synchronized (ApolloGameMusicPlayer.a(this.e))
      {
        if (ApolloGameMusicPlayer.b(this.e).contains(paramMediaPlayer)) {
          ApolloGameMusicPlayer.b(this.e).remove(paramMediaPlayer);
        }
        if (QLog.isColorLevel())
        {
          ??? = ApolloGameMusicPlayer.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[onCompletion], audio_sessionID: ");
          localStringBuilder.append(paramMediaPlayer.getAudioSessionId());
          QLog.d((String)???, 2, localStringBuilder.toString());
        }
        if ((this.c instanceof ApolloSurfaceView))
        {
          ??? = (ApolloSurfaceView)this.c;
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
      paramMediaPlayer.release();
      QLog.e(ApolloGameMusicPlayer.a, 1, "[onCompletion]", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.ApolloGameMusicPlayer.1
 * JD-Core Version:    0.7.0.1
 */