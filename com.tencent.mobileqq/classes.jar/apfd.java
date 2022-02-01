import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class apfd
  implements MediaPlayer.OnPreparedListener
{
  apfd(apfb paramapfb) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "load bg music success. : " + apfb.b(this.a));
      }
      this.a.a.seekTo(0);
      apfb.b(this.a, true);
      if (apfb.b(this.a))
      {
        this.a.a.start();
        apfb.c(this.a, false);
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
 * Qualified Name:     apfd
 * JD-Core Version:    0.7.0.1
 */