import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView;

public class bifk
  implements MediaPlayer.OnPreparedListener
{
  public bifk(VideoTextureView paramVideoTextureView) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (VideoTextureView.a(this.a) != null)
    {
      VideoTextureView.a(this.a).start();
      VideoTextureView.a(this.a, VideoTextureView.a(this.a).getDuration());
    }
    if (VideoTextureView.a() != null)
    {
      VideoTextureView.a().onVideoStart(VideoTextureView.a(this.a));
      VideoTextureView.a().onVideoProgressUpdate(0);
      VideoTextureView.a().onVideoSize(VideoTextureView.a(this.a).getVideoWidth(), VideoTextureView.a(this.a).getVideoHeight());
    }
    if (VideoTextureView.a(this.a) != null) {
      VideoTextureView.a(this.a).post(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bifk
 * JD-Core Version:    0.7.0.1
 */