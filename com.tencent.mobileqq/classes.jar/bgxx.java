import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.qphone.base.util.QLog;

final class bgxx
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("URLDrawableDecodeHandler", 2, "PART_ROUND_CORNER_DECODER");
    }
    if (paramBitmap == null) {
      paramDownloadParams = null;
    }
    Object localObject;
    do
    {
      do
      {
        return paramDownloadParams;
        localObject = paramDownloadParams.tag;
        paramDownloadParams = paramBitmap;
      } while (!(localObject instanceof int[]));
      paramDownloadParams = paramBitmap;
    } while (((int[])localObject).length != 3);
    paramDownloadParams = (int[])localObject;
    return bheg.e(paramBitmap, paramDownloadParams[0], paramDownloadParams[1], paramDownloadParams[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgxx
 * JD-Core Version:    0.7.0.1
 */