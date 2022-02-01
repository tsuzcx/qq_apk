import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class aorq
  implements MediaPlayer.OnPreparedListener
{
  aorq(aorl paramaorl) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "load bg music success. : " + aorl.b(this.a));
      }
      this.a.a.seekTo(0);
      aorl.b(this.a, true);
      if (aorl.b(this.a))
      {
        this.a.a.start();
        aorl.c(this.a, false);
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
 * Qualified Name:     aorq
 * JD-Core Version:    0.7.0.1
 */