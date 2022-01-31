import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.image.DownloadParams;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URL;

public class axut
  extends axoa
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      localBitmap.setDensity(160);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      RectF localRectF = new RectF(new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()));
      float f = paramInt;
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-16777216);
      localCanvas.drawRoundRect(localRectF, f, f, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), localRect, localPaint);
      return localBitmap;
    }
    catch (Exception localException) {}
    return paramBitmap;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(paramDownloadParams.url.getFile());
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = paramFile.getAbsolutePath();
    if (!bace.b(paramFile))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoThumbDownloader", 2, "decodeFile file not exits. just return");
      }
      return null;
    }
    paramURLDrawableHandler = new BitmapFactory.Options();
    paramURLDrawableHandler.inDensity = 160;
    paramURLDrawableHandler.inTargetDensity = 160;
    paramURLDrawableHandler.inScreenDensity = 160;
    paramURLDrawableHandler.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramFile, paramURLDrawableHandler);
    paramURLDrawableHandler.inJustDecodeBounds = false;
    paramURLDrawableHandler.inSampleSize = a(paramURLDrawableHandler, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight);
    try
    {
      paramFile = BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(paramFile)), null, paramURLDrawableHandler);
      paramDownloadParams = paramDownloadParams.tag;
      if (((paramDownloadParams instanceof int[])) && (((int[])paramDownloadParams).length == 3))
      {
        paramFile = a(paramFile, ((int[])(int[])paramDownloadParams)[2]);
        return paramFile;
      }
    }
    catch (OutOfMemoryError paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoThumbDownloader", 2, "decodeFile : OutOfMemoryError ", paramFile);
      }
      return null;
    }
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axut
 * JD-Core Version:    0.7.0.1
 */