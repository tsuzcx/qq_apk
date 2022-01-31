import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.musicwavesupport.MusicSoundFile;
import dov.com.tencent.mobileqq.shortvideo.musicwavesupport.MusicWaveformManager;

public class anzz
  implements Runnable
{
  public anzz(MusicWaveformManager paramMusicWaveformManager) {}
  
  public void run()
  {
    try
    {
      long l = SystemClock.elapsedRealtimeNanos();
      boolean bool = MusicWaveformManager.a(this.a).a(MusicWaveformManager.a(this.a), MusicWaveformManager.a(this.a), MusicWaveformManager.a(this.a));
      if (QLog.isColorLevel()) {
        QLog.d("MusicWaveformManager", 2, "createSoundFile time: " + (SystemClock.elapsedRealtimeNanos() - l) / 1000000L + "ms");
      }
      if (!bool)
      {
        MusicWaveformManager.a(this.a, false);
        if (QLog.isColorLevel()) {
          QLog.e("MusicWaveformManager", 2, "create musicSoundFile fail");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        MusicWaveformManager.a(this.a, false);
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("MusicWaveformManager", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anzz
 * JD-Core Version:    0.7.0.1
 */