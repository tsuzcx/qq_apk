import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class anyp
  implements MediaPlayer.OnPreparedListener
{
  anyp(anyn paramanyn) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "load bg music success. : " + anyn.b(this.a));
      }
      this.a.a.seekTo(0);
      anyn.b(this.a, true);
      if (anyn.b(this.a))
      {
        this.a.a.start();
        anyn.c(this.a, false);
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
 * Qualified Name:     anyp
 * JD-Core Version:    0.7.0.1
 */