import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class ayoe
  extends ayrn
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    URL localURL = paramDownloadParams.url;
    String str = paramDownloadParams.urlStr;
    paramDownloadParams.url = new URL(paramDownloadParams.url.getFile());
    paramDownloadParams.urlStr = paramDownloadParams.url.toString();
    if (QLog.isDevelopLevel()) {
      QLog.i("AIOFlowerImgDownloader", 4, paramDownloadParams.urlStr);
    }
    paramOutputStream = super.a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
    paramDownloadParams.url = localURL;
    paramDownloadParams.urlStr = str;
    return paramOutputStream;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Canvas localCanvas = null;
    paramURLDrawableHandler = null;
    paramDownloadParams = new BitmapFactory.Options();
    paramDownloadParams.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramDownloadParams);
    float f = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    paramDownloadParams.inSampleSize = ((int)Math.min(paramDownloadParams.outWidth / (115.0F * f + 0.5F), paramDownloadParams.outHeight / (f * 105.0F + 0.5F)));
    paramDownloadParams.inJustDecodeBounds = false;
    label234:
    do
    {
      int i;
      int j;
      try
      {
        paramDownloadParams = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramDownloadParams);
        if (paramDownloadParams == null) {
          return paramURLDrawableHandler;
        }
      }
      catch (OutOfMemoryError paramFile)
      {
        for (;;)
        {
          paramDownloadParams = null;
        }
        i = paramDownloadParams.getWidth();
        j = paramDownloadParams.getHeight();
        paramFile = localCanvas;
      }
      try
      {
        paramURLDrawableHandler = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        paramFile = paramURLDrawableHandler;
        paramURLDrawableHandler.setDensity(160);
        paramFile = paramURLDrawableHandler;
        localCanvas = new Canvas(paramURLDrawableHandler);
        paramFile = paramURLDrawableHandler;
        Paint localPaint = new Paint(1);
        paramFile = paramURLDrawableHandler;
        localPaint.setColor(-16777216);
        paramFile = paramURLDrawableHandler;
        BaseApplicationImpl.getApplication();
        paramFile = paramURLDrawableHandler;
        Rect localRect = new Rect(0, 0, i, j - (int)(5.0F * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density));
        paramFile = paramURLDrawableHandler;
        localCanvas.drawBitmap(paramDownloadParams, localRect, new RectF(localRect), localPaint);
        paramFile = paramURLDrawableHandler;
      }
      catch (OutOfMemoryError paramURLDrawableHandler)
      {
        break label234;
      }
      paramURLDrawableHandler = paramFile;
    } while (paramDownloadParams.isRecycled());
    paramDownloadParams.recycle();
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayoe
 * JD-Core Version:    0.7.0.1
 */