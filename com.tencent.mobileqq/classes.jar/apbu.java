import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class apbu
  implements MediaPlayer.OnPreparedListener
{
  apbu(apbp paramapbp) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "load bg music success. : " + apbp.b(this.a));
      }
      this.a.a.seekTo(0);
      apbp.b(this.a, true);
      if (apbp.b(this.a))
      {
        this.a.a.start();
        apbp.c(this.a, false);
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      paramMediaPlayer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbu
 * JD-Core Version:    0.7.0.1
 */