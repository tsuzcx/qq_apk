import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView;

public class bcuw
  implements MediaPlayer.OnSeekCompleteListener
{
  public bcuw(VideoTextureView paramVideoTextureView) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (VideoTextureView.a() != null) {
      VideoTextureView.a().onVideoStart(VideoTextureView.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcuw
 * JD-Core Version:    0.7.0.1
 */