import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

final class bbyv
  implements MediaPlayer.OnPreparedListener
{
  bbyv(bbyz parambbyz) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.start();
    paramMediaPlayer.setLooping(true);
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbyv
 * JD-Core Version:    0.7.0.1
 */