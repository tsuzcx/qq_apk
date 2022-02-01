import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.VideoView;

final class bibk
  implements MediaPlayer.OnCompletionListener
{
  bibk(VideoView paramVideoView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bibk
 * JD-Core Version:    0.7.0.1
 */