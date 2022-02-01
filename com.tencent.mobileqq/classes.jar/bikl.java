import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.VideoView;

final class bikl
  implements MediaPlayer.OnCompletionListener
{
  bikl(VideoView paramVideoView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bikl
 * JD-Core Version:    0.7.0.1
 */