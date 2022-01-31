import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

final class bdyk
  implements MediaPlayer.OnPreparedListener
{
  bdyk(bdyo parambdyo) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.start();
    paramMediaPlayer.setLooping(true);
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyk
 * JD-Core Version:    0.7.0.1
 */