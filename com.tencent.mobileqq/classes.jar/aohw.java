import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.OnTrimVDPlayCompelteListener;

public class aohw
  implements MediaPlayer.OnCompletionListener
{
  public aohw(FixedSizeVideoView paramFixedSizeVideoView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.a.a != null)
    {
      if (FixedSizeVideoView.a(this.a) != null) {
        FixedSizeVideoView.a(this.a).removeMessages(0);
      }
      this.a.a.a(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aohw
 * JD-Core Version:    0.7.0.1
 */