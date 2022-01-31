import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

public class bbxs
  implements DownloadParams.DecodeHandler
{
  private int a;
  private int b;
  
  public bbxs(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return null;
    }
    paramDownloadParams = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.ARGB_8888);
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setAntiAlias(true);
    Canvas localCanvas = new Canvas(paramDownloadParams);
    localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth() / 5, paramBitmap.getHeight()), new Rect(0, 0, paramBitmap.getWidth() / 5, paramDownloadParams.getHeight()), localPaint);
    localCanvas.drawBitmap(paramBitmap, new Rect(paramBitmap.getWidth() / 5, 0, paramBitmap.getWidth() - paramBitmap.getWidth() / 5, paramBitmap.getHeight()), new Rect(paramBitmap.getWidth() / 5, 0, paramDownloadParams.getWidth() - paramBitmap.getWidth() / 5, paramDownloadParams.getHeight()), localPaint);
    localCanvas.drawBitmap(paramBitmap, new Rect(paramBitmap.getWidth() - paramBitmap.getWidth() / 5, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(paramDownloadParams.getWidth() - paramBitmap.getWidth() / 5, 0, paramDownloadParams.getWidth(), paramDownloadParams.getHeight()), localPaint);
    return paramDownloadParams;
  }
  
  public String toString()
  {
    return "TitleDrawableDecoderHandler{reqW=" + this.a + ", reqH=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbxs
 * JD-Core Version:    0.7.0.1
 */