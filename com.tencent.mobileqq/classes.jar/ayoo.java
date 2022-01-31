import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class ayoo
  extends ayoi
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(paramDownloadParams.url.getFile());
  }
  
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
          paramFile = new agqr(localBaseApplicationImpl, paramURLDrawableHandler);
          paramFile = aglb.a(localBaseApplicationImpl).a(paramDownloadParams.url, paramFile, paramDownloadParams);
          if ((paramFile == null) || (paramURLDrawableHandler == null)) {
            break;
          }
          paramURLDrawableHandler.thumbSize = paramFile.getByteCount();
          return paramFile;
        }
        if ("FLOW_THUMB".equals(paramFile))
        {
          paramFile = new aglq(localBaseApplicationImpl, paramURLDrawableHandler);
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
      paramFile = new agld(localBaseApplicationImpl, paramURLDrawableHandler);
      continue;
      label153:
      paramFile = new agqe(localBaseApplicationImpl, paramURLDrawableHandler);
    }
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayoo
 * JD-Core Version:    0.7.0.1
 */