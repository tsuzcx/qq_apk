import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class amoh
  implements MediaPlayer.OnPreparedListener
{
  amoh(amof paramamof) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "load bg music success. : " + amof.b(this.a));
      }
      this.a.a.seekTo(0);
      amof.b(this.a, true);
      if (amof.b(this.a))
      {
        this.a.a.start();
        amof.c(this.a, false);
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
 * Qualified Name:     amoh
 * JD-Core Version:    0.7.0.1
 */