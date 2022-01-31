import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.qphone.base.util.QLog;

final class bcvf
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    try
    {
      int i = paramBitmap.getHeight();
      int j = paramBitmap.getWidth();
      int k = paramDownloadParams.reqWidth;
      int m = paramDownloadParams.reqHeight;
      float f = k * 1.0F / j;
      paramDownloadParams = new Matrix();
      paramDownloadParams.setScale(f, f);
      if (i * f > m) {}
      for (paramDownloadParams = Bitmap.createBitmap(paramBitmap, 0, 0, j, (int)(m / f), paramDownloadParams, true); QLog.isColorLevel(); paramDownloadParams = Bitmap.createBitmap(paramBitmap, 0, 0, j, i, paramDownloadParams, true))
      {
        QLog.d(bcuq.a(), 2, String.format("ALIGN_TOP_DECODER srcHeight = %s, srcWidth = %s, reqWidth = %s, reqHeight = %s, scale = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f) }));
        break;
      }
      return paramDownloadParams;
    }
    catch (Exception paramDownloadParams)
    {
      paramDownloadParams.printStackTrace();
      return paramBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcvf
 * JD-Core Version:    0.7.0.1
 */