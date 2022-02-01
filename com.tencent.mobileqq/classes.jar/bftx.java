import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class bftx
  implements MediaPlayer.OnCompletionListener
{
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    bftt.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bftx
 * JD-Core Version:    0.7.0.1
 */