import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

final class bgfh
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      paramDownloadParams = null;
    }
    do
    {
      do
      {
        return paramDownloadParams;
        localObject = paramDownloadParams.tag;
        paramDownloadParams = paramBitmap;
      } while (!(localObject instanceof int[]));
      paramDownloadParams = paramBitmap;
    } while (((int[])localObject).length != 2);
    paramDownloadParams = (int[])localObject;
    float f2 = bgln.a();
    float f1 = f2;
    if (f2 < 0.01F) {
      f1 = 1.0F;
    }
    paramDownloadParams[0] = ((int)(paramDownloadParams[0] / f1));
    paramDownloadParams[1] = ((int)(paramDownloadParams[1] / f1));
    paramDownloadParams = bgmo.a(paramBitmap, paramDownloadParams[0], paramDownloadParams[1]);
    paramBitmap = new Canvas(paramDownloadParams);
    Object localObject = new Paint();
    ((Paint)localObject).setAntiAlias(true);
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    ((Paint)localObject).setColor(Color.argb(20, 0, 0, 0));
    ((Paint)localObject).setStrokeWidth(0.5F);
    f1 = paramDownloadParams.getWidth() * 0.5F;
    paramBitmap.drawCircle(f1, f1, f1 - 0.5F, (Paint)localObject);
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfh
 * JD-Core Version:    0.7.0.1
 */