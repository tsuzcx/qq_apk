import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnCaptureImageListener;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.17;

public class bgoq
  implements VideoPlayerProxy.OnCaptureImageListener
{
  public bgoq(MiniAppVideoPlayer.17 param17) {}
  
  public void onCaptureImageFailed(VideoPlayerProxy paramVideoPlayerProxy) {}
  
  public void onCaptureImageSucceed(VideoPlayerProxy paramVideoPlayerProxy, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      MiniAppVideoPlayer.a(this.a.this$0, Bitmap.createBitmap(paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgoq
 * JD-Core Version:    0.7.0.1
 */