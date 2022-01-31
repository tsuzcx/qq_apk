import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView;

public class bbrf
  implements MediaPlayer.OnCompletionListener
{
  public bbrf(VideoTextureView paramVideoTextureView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (VideoTextureView.a() != null) {
      VideoTextureView.a().onVideoComplete(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbrf
 * JD-Core Version:    0.7.0.1
 */