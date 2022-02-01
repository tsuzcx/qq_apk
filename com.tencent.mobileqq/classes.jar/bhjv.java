import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

final class bhjv
  implements MediaPlayer.OnPreparedListener
{
  bhjv(bhjz parambhjz) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.start();
    paramMediaPlayer.setLooping(true);
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjv
 * JD-Core Version:    0.7.0.1
 */