import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class bftz
  implements MediaPlayer.OnCompletionListener
{
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    bftt.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bftz
 * JD-Core Version:    0.7.0.1
 */