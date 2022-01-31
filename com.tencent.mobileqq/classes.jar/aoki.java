import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;

public class aoki
{
  public static Bitmap a(int paramInt1, int paramInt2, float paramFloat)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1 * 2, paramInt1 * 2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(1);
    localPaint.setAlpha((int)(255.0F * paramFloat));
    localPaint.setColor(paramInt2);
    localPaint.setStyle(Paint.Style.FILL);
    localCanvas.drawCircle(paramInt1, paramInt1, paramInt1, localPaint);
    localCanvas.save();
    localCanvas.restore();
    return localBitmap;
  }
  
  public static Bitmap a(Resources paramResources, Bitmap paramBitmap, int paramInt, float paramFloat, boolean paramBoolean)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    for (;;)
    {
      Canvas localCanvas;
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        localCanvas = new Canvas(localBitmap);
        localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
        if (!paramBoolean)
        {
          paramBitmap = new RectF(0.0F, 0.0F, i, j);
          Paint localPaint = new Paint(1);
          localPaint.setColor(paramInt);
          localPaint.setAlpha((int)(paramFloat * 255.0F));
          paramInt = actn.a(2.0F, paramResources);
          localCanvas.drawRoundRect(paramBitmap, paramInt, paramInt, localPaint);
          localCanvas.save();
          localCanvas.restore();
          return localBitmap;
        }
      }
      catch (OutOfMemoryError paramResources)
      {
        QLog.e("BackgroundUtil", 1, "get OOM when create ret, return target");
        return paramBitmap;
      }
      i /= 2;
      paramResources = new Paint(1);
      paramResources.setAlpha((int)(paramFloat * 255.0F));
      paramResources.setColor(paramInt);
      paramResources.setStyle(Paint.Style.FILL);
      localCanvas.drawCircle(i, i, i, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoki
 * JD-Core Version:    0.7.0.1
 */