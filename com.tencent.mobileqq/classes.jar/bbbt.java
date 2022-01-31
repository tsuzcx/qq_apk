import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class bbbt
  implements MediaPlayer.OnCompletionListener
{
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    bbbr.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbt
 * JD-Core Version:    0.7.0.1
 */