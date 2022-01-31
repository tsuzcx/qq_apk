import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;

public class bjaz
  implements MediaPlayer.OnCompletionListener
{
  public bjaz(FixedSizeVideoView paramFixedSizeVideoView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.a.a != null)
    {
      this.a.removeCallbacks(FixedSizeVideoView.a(this.a));
      this.a.a.a(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjaz
 * JD-Core Version:    0.7.0.1
 */