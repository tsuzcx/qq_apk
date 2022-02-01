import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class bhcr
  implements MediaPlayer.OnCompletionListener
{
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    bhcl.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhcr
 * JD-Core Version:    0.7.0.1
 */