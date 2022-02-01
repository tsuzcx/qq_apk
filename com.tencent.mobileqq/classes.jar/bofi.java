import android.graphics.Bitmap;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbListener;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;

public class bofi
  implements VideoThumbListener
{
  public bofi(VideoTrackContainerView paramVideoTrackContainerView) {}
  
  public void onThumbGenerated(Object paramObject, CMTime paramCMTime, Bitmap paramBitmap)
  {
    if ((paramObject instanceof String)) {
      this.a.a((String)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bofi
 * JD-Core Version:    0.7.0.1
 */