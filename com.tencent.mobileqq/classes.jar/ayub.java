import android.app.Application;
import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ayub
  extends ProtocolDownloader.Adapter
{
  public ayub(Application paramApplication) {}
  
  public static URL a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2, true);
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.path = paramString;
    paramString = new File(paramString);
    if (paramString.exists()) {
      localLocalMediaInfo.modifiedDate = paramString.lastModified();
    }
    localLocalMediaInfo.thumbWidth = paramInt1;
    localLocalMediaInfo.thumbHeight = paramInt2;
    localLocalMediaInfo.isRegionThumbUseNewDecoder = paramBoolean;
    try
    {
      paramString = new URL("regionalthumb", null, LocalMediaInfo.getUrl(localLocalMediaInfo));
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = null;
    paramURLDrawableHandler = LocalMediaInfo.parseUrl(paramDownloadParams.url);
    if (paramURLDrawableHandler != null) {
      if (!paramURLDrawableHandler.isRegionThumbUseNewDecoder) {
        break label58;
      }
    }
    label58:
    for (paramFile = new agmn();; paramFile = new agpj())
    {
      paramFile = paramFile.a(paramDownloadParams.url);
      paramDownloadParams.outWidth = paramFile.getWidth();
      paramDownloadParams.outHeight = paramFile.getHeight();
      return paramFile;
    }
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    boolean bool2 = false;
    paramDownloadParams = LocalMediaInfo.parseUrl(paramDownloadParams.url);
    boolean bool1 = bool2;
    if (paramDownloadParams != null)
    {
      bool1 = bool2;
      if (new File(paramDownloadParams.path).exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = LocalMediaInfo.parseUrl(paramDownloadParams.url);
    if (paramDownloadParams != null)
    {
      paramDownloadParams = new File(paramDownloadParams.path);
      if (paramDownloadParams.exists()) {
        return paramDownloadParams;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayub
 * JD-Core Version:    0.7.0.1
 */