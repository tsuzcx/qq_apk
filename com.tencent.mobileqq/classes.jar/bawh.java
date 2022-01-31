import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

public class bawh
  implements DownloadParams.DecodeHandler
{
  private final int a = 10;
  private final int b = 20;
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    try
    {
      paramDownloadParams = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 20, paramBitmap.getHeight() / 20, true);
      bbju.a(paramDownloadParams, 10);
      return paramDownloadParams;
    }
    catch (OutOfMemoryError paramDownloadParams)
    {
      return paramBitmap;
    }
    catch (Exception paramDownloadParams) {}
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bawh
 * JD-Core Version:    0.7.0.1
 */