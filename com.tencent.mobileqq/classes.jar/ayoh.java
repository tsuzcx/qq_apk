import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ayoh
  extends aypv
{
  public ayoh(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("AIOPhotoImageDownloader", paramBaseApplicationImpl);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    try
    {
      paramURLDrawableHandler.publishProgress(9900);
      paramURLDrawableHandler = paramDownloadParams.urlStr;
      boolean bool = "aiothumb".equals(paramDownloadParams.url.getProtocol());
      if (QLog.isColorLevel()) {
        a("AIOPhotoImageDownloader", "DecodeFile", "DecodeFile START,cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramURLDrawableHandler);
      }
      if ((GifDrawable.isGifFile(paramFile)) && (!bool))
      {
        if (!QLog.isColorLevel()) {
          break label332;
        }
        a("AIOPhotoImageDownloader", "DecodeFile", "DecodeFile END,GIF image,cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramURLDrawableHandler);
        return null;
      }
      paramDownloadParams = new BitmapFactory.Options();
      paramDownloadParams.inPreferredConfig = aywm.a;
      paramDownloadParams.inDensity = 160;
      paramDownloadParams.inTargetDensity = 160;
      paramDownloadParams.inScreenDensity = 160;
      if (bool) {
        try
        {
          paramDownloadParams.inJustDecodeBounds = false;
          paramDownloadParams = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramDownloadParams);
          if (paramDownloadParams != null) {
            return new ayxa(paramFile.getAbsolutePath()).a(paramDownloadParams);
          }
          paramFile.delete();
          throw new IOException("step:decode error, not valid pic");
        }
        catch (OutOfMemoryError paramFile)
        {
          throw paramFile;
        }
      }
      if (!QLog.isColorLevel()) {
        break label332;
      }
    }
    catch (Exception paramURLDrawableHandler)
    {
      paramDownloadParams = a(paramURLDrawableHandler);
      if (paramDownloadParams != null)
      {
        paramFile = paramDownloadParams;
        if (paramDownloadParams.length() != 0) {}
      }
      else
      {
        paramFile = paramURLDrawableHandler.toString();
      }
      if (QLog.isColorLevel())
      {
        QLog.e("AIOPhotoImageDownloader", 2, paramFile);
        a("AIOPhotoImageDownloader", "DecodeFile", "DecodeFile FAIL,exceptionmsg:" + paramFile);
      }
      throw paramURLDrawableHandler;
    }
    a("AIOPhotoImageDownloader", "DecodeFile", "DecodeFile END,is not Thumb,cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramURLDrawableHandler);
    label332:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayoh
 * JD-Core Version:    0.7.0.1
 */