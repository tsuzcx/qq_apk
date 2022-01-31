import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.together.ui.WatchPanelView;

public class axnx
  implements DownloadParams.DecodeHandler
{
  public axnx(WatchPanelView paramWatchPanelView) {}
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    return bacm.b(paramBitmap, 6.0F, this.a.a, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnx
 * JD-Core Version:    0.7.0.1
 */