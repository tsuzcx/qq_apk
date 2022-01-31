import android.app.Application;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;
import java.net.URL;

public class axoh
  extends ProtocolDownloader.Adapter
{
  public static int a = 200;
  
  public axoh(Application paramApplication) {}
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    if (!LocalMediaInfo.class.isInstance(paramDownloadParams.tag)) {
      throw new RuntimeException("Decode info is invalide");
    }
    paramURLDrawableHandler = (LocalMediaInfo)paramDownloadParams.tag;
    for (;;)
    {
      try
      {
        paramFile = paramDownloadParams.url.getRef();
        if ("VIDEO".equals(paramFile))
        {
          paramFile = new agev(localBaseApplicationImpl, paramURLDrawableHandler);
          paramFile = afzf.a(localBaseApplicationImpl).a(paramDownloadParams.url, paramFile, paramDownloadParams);
          if ((paramFile == null) || (paramURLDrawableHandler == null)) {
            break;
          }
          paramURLDrawableHandler.thumbSize = paramFile.getByteCount();
          return paramFile;
        }
        if ("FLOW_THUMB".equals(paramFile))
        {
          paramFile = new afzu(localBaseApplicationImpl, paramURLDrawableHandler);
          continue;
        }
        if (!"APP_VIDEO".equals(paramFile)) {
          break label153;
        }
      }
      catch (NumberFormatException paramFile)
      {
        throw new RuntimeException("Decode type is invalid");
      }
      paramFile = new afzh(localBaseApplicationImpl, paramURLDrawableHandler);
      continue;
      label153:
      paramFile = new agei(localBaseApplicationImpl, paramURLDrawableHandler);
    }
    return paramFile;
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    return true;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(ajed.aT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axoh
 * JD-Core Version:    0.7.0.1
 */