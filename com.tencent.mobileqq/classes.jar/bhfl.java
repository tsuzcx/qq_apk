import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.qphone.base.util.QLog;

final class bhfl
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER");
    }
    if (paramBitmap == null) {
      return null;
    }
    paramDownloadParams = paramDownloadParams.tag;
    if (((paramDownloadParams instanceof int[])) && (((int[])paramDownloadParams).length == 2))
    {
      paramDownloadParams = (int[])paramDownloadParams;
      return bhmq.a(paramBitmap, 0.0F, paramDownloadParams[0], paramDownloadParams[1]);
    }
    return bhmq.c(paramBitmap, 50, 50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhfl
 * JD-Core Version:    0.7.0.1
 */