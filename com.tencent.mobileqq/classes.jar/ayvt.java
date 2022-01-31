import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class ayvt
  extends ayrp
{
  private float a = 2.0F;
  
  public ayvt(BaseApplicationImpl paramBaseApplicationImpl)
  {
    try
    {
      this.a = paramBaseApplicationImpl.getResources().getDisplayMetrics().density;
      return;
    }
    catch (Exception paramBaseApplicationImpl) {}
  }
  
  public static Bitmap a(Bitmap paramBitmap, double paramDouble1, double paramDouble2)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      localObject = new Matrix();
      ((Matrix)localObject).postScale((float)paramDouble1 / f1, (float)paramDouble2 / f2);
      localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, (int)f1, (int)f2, (Matrix)localObject, true);
      localObject = localBitmap;
    } while (localBitmap == paramBitmap);
    paramBitmap.recycle();
    return localBitmap;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    URL localURL = paramDownloadParams.url;
    paramDownloadParams.url = new URL("http", localURL.getAuthority(), localURL.getFile());
    return super.a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = null;
    try
    {
      paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), null);
      paramDownloadParams = a(paramFile, this.a * 50.0F, this.a * 50.0F);
      int i = paramDownloadParams.getWidth();
      int j = paramDownloadParams.getHeight();
      paramFile = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      paramFile.setDensity(160);
      paramURLDrawableHandler = new Canvas(paramFile);
      Paint localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      Rect localRect = new Rect(0, 0, i, j);
      RectF localRectF = new RectF(localRect);
      float f = 10.0F * this.a;
      paramURLDrawableHandler.drawRoundRect(localRectF, f, f, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      paramURLDrawableHandler.drawBitmap(paramDownloadParams, localRect, localRect, localPaint);
    }
    catch (OutOfMemoryError paramFile)
    {
      for (;;)
      {
        try
        {
          if (!paramDownloadParams.isRecycled()) {
            paramDownloadParams.recycle();
          }
          return paramFile;
        }
        catch (Throwable paramDownloadParams)
        {
          paramDownloadParams.printStackTrace();
        }
        paramFile = paramFile;
        paramFile.printStackTrace();
        paramFile = paramDownloadParams;
      }
    }
    catch (Exception paramFile)
    {
      for (;;)
      {
        paramFile.printStackTrace();
        paramFile = paramDownloadParams;
      }
    }
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayvt
 * JD-Core Version:    0.7.0.1
 */