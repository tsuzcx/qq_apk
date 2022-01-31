import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

final class bczw
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    if ((paramDownloadParams != null) && (paramDownloadParams.reqWidth >= 0) && (paramDownloadParams.reqHeight >= 0)) {
      return bczv.a(paramBitmap, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight);
    }
    return bczv.a(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczw
 * JD-Core Version:    0.7.0.1
 */