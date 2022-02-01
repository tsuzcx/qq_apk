import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class bdtq
  extends bdvl
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams.url = new URL(paramDownloadParams.url.getFile());
    paramDownloadParams.urlStr = paramDownloadParams.url.toString();
    return super.a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = new BitmapFactory.Options();
    paramURLDrawableHandler.inJustDecodeBounds = true;
    paramDownloadParams = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramURLDrawableHandler);
    float f = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    paramURLDrawableHandler.inSampleSize = (Math.min(paramURLDrawableHandler.outWidth, paramURLDrawableHandler.outHeight) / (int)(f * 70.0F + 0.5F));
    paramURLDrawableHandler.inJustDecodeBounds = false;
    try
    {
      paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramURLDrawableHandler);
      return bgmo.c(bgmo.b(paramFile), 70, 70);
    }
    catch (OutOfMemoryError paramFile)
    {
      for (;;)
      {
        paramFile = paramDownloadParams;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtq
 * JD-Core Version:    0.7.0.1
 */