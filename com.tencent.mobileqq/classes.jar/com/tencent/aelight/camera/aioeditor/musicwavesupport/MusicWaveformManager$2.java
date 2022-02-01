package com.tencent.aelight.camera.aioeditor.musicwavesupport;

import android.os.SystemClock;
import com.tencent.mobileqq.filter.music.MusicSoundFile;
import com.tencent.qphone.base.util.QLog;

class MusicWaveformManager$2
  implements Runnable
{
  MusicWaveformManager$2(MusicWaveformManager paramMusicWaveformManager) {}
  
  public void run()
  {
    try
    {
      long l = SystemClock.elapsedRealtimeNanos();
      boolean bool = MusicWaveformManager.e(this.this$0).a(MusicWaveformManager.b(this.this$0), MusicWaveformManager.c(this.this$0), MusicWaveformManager.d(this.this$0));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("createSoundFile time: ");
        localStringBuilder.append((SystemClock.elapsedRealtimeNanos() - l) / 1000000L);
        localStringBuilder.append("ms");
        QLog.d("MusicWaveformManager", 2, localStringBuilder.toString());
      }
      if (!bool)
      {
        MusicWaveformManager.a(this.this$0, false);
        if (QLog.isColorLevel())
        {
          QLog.e("MusicWaveformManager", 2, "create musicSoundFile fail");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      MusicWaveformManager.a(this.this$0, false);
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("MusicWaveformManager", 2, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.musicwavesupport.MusicWaveformManager.2
 * JD-Core Version:    0.7.0.1
 */