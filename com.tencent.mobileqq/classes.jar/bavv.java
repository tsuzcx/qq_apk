import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

final class bavv
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    paramDownloadParams = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    RectF localRectF = new RectF(0.0F, 0.0F, i, j);
    Canvas localCanvas = new Canvas(paramDownloadParams);
    BitmapShader localBitmapShader = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localPaint.setShader(localBitmapShader);
    localCanvas.drawRoundRect(localRectF, 12.0F, 12.0F, localPaint);
    localPaint.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, j / 2, Color.parseColor("#80000000"), Color.parseColor("#00000000"), Shader.TileMode.CLAMP));
    localCanvas.drawRoundRect(localRectF, 12.0F, 12.0F, localPaint);
    paramBitmap.recycle();
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bavv
 * JD-Core Version:    0.7.0.1
 */