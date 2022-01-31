import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

public class bcvp
  implements DownloadParams.DecodeHandler
{
  private final int a = 10;
  private final int b = 20;
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    try
    {
      paramDownloadParams = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 20, paramBitmap.getHeight() / 20, true);
      bdjc.a(paramDownloadParams, 10);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcvp
 * JD-Core Version:    0.7.0.1
 */