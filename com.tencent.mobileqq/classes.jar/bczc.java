import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

final class bczc
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramDownloadParams == null)) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      do
      {
        return paramBitmap;
        paramDownloadParams = paramDownloadParams.tag;
      } while ((!(paramDownloadParams instanceof int[])) || (((int[])paramDownloadParams).length != 4));
      paramDownloadParams = (int[])paramDownloadParams;
      i = paramDownloadParams[0];
      j = paramDownloadParams[1];
      k = paramDownloadParams[2];
      m = paramDownloadParams[3];
    } while ((k <= 0) || (m <= 0) || ((k == paramBitmap.getWidth()) && (m == paramBitmap.getHeight())));
    try
    {
      paramDownloadParams = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(paramDownloadParams);
      Matrix localMatrix = new Matrix();
      bcyz.a(localMatrix, paramBitmap.getWidth(), paramBitmap.getHeight(), k, m, i, j);
      localCanvas.drawBitmap(paramBitmap, localMatrix, new Paint(6));
      return paramDownloadParams;
    }
    catch (OutOfMemoryError paramDownloadParams) {}
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczc
 * JD-Core Version:    0.7.0.1
 */