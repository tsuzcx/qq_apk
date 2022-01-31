import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class amsw
  implements MediaPlayer.OnPreparedListener
{
  amsw(amsu paramamsu) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "load bg music success. : " + amsu.b(this.a));
      }
      this.a.a.seekTo(0);
      amsu.b(this.a, true);
      if (amsu.b(this.a))
      {
        this.a.a.start();
        amsu.c(this.a, false);
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
 * Qualified Name:     amsw
 * JD-Core Version:    0.7.0.1
 */