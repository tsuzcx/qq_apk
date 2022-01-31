import android.app.Activity;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnControllerClickListener;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer;
import java.lang.ref.WeakReference;

public class beos
  implements VideoPlayerProxy.OnControllerClickListener
{
  public beos(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onAttationClick(VideoPlayerProxy paramVideoPlayerProxy) {}
  
  public void onBackClick(VideoPlayerProxy paramVideoPlayerProxy)
  {
    betc.a("MiniAppVideoPlayer", "video player onBackClick");
    if ((Activity)this.a.a.get() == null) {}
    while (!this.a.c) {
      return;
    }
    this.a.g();
  }
  
  public void onBackOnFullScreenClick(VideoPlayerProxy paramVideoPlayerProxy)
  {
    betc.a("MiniAppVideoPlayer", "video player onBackOnFullScreenClick");
    if ((Activity)this.a.a.get() == null) {}
    while (!this.a.c) {
      return;
    }
    this.a.g();
  }
  
  public void onCacheClick(VideoPlayerProxy paramVideoPlayerProxy) {}
  
  public void onFeedbackClick(VideoPlayerProxy paramVideoPlayerProxy) {}
  
  public void onFullScreenClick(VideoPlayerProxy paramVideoPlayerProxy)
  {
    if (this.a.c)
    {
      this.a.g();
      return;
    }
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beos
 * JD-Core Version:    0.7.0.1
 */