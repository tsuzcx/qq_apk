import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;

public class bdso
  extends bdsh
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams == null) || (paramDownloadParams.url == null)) {
      paramOutputStream = null;
    }
    String str;
    Object localObject2;
    do
    {
      return paramOutputStream;
      paramOutputStream = paramDownloadParams.url.getHost();
      str = paramDownloadParams.url.getFile();
      if (!"DEFAULT_HEAD".equals(paramOutputStream)) {
        break;
      }
      localObject2 = anhk.ba + "avatarPendantDefaultHead" + str;
      localObject1 = new File((String)localObject2);
      paramOutputStream = (OutputStream)localObject1;
    } while (((File)localObject1).exists());
    Object localObject1 = "https://i.gtimg.cn/qqshow/admindata/comdata/mobileDefaultHead/" + str;
    paramOutputStream = (OutputStream)localObject2;
    for (;;)
    {
      for (;;)
      {
        if (localObject1 != null)
        {
          paramDownloadParams.url = new URL((String)localObject1);
          if (QLog.isDevelopLevel()) {
            QLog.d("AvatarPendantDownloader", 4, "downloadImage pendant: " + (String)localObject1 + " -> " + paramOutputStream);
          }
          paramURLDrawableHandler.publishProgress(0);
          localObject2 = new FileOutputStream(paramOutputStream);
          try
          {
            new bdvl().a((OutputStream)localObject2, paramDownloadParams, paramURLDrawableHandler);
            ((FileOutputStream)localObject2).close();
            paramDownloadParams = new File(paramOutputStream);
            paramOutputStream = paramDownloadParams;
            if (paramDownloadParams.exists()) {
              break;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("AvatarPendantDownloader", 2, "downloadImage pendant fail.-> " + (String)localObject1);
            }
            return null;
            if ((!"AIO_STATIC".equals(paramOutputStream)) || (TextUtils.isEmpty(str))) {
              break label410;
            }
            paramOutputStream = new File(anhk.bT + str);
            if (!paramOutputStream.exists()) {
              paramOutputStream.mkdir();
            }
            long l = Long.valueOf(str.split("/")[1]).longValue();
            localObject1 = bgks.b(l, 5);
            localObject2 = new File((String)localObject1);
            paramOutputStream = (OutputStream)localObject2;
            if (((File)localObject2).exists()) {
              break;
            }
            localObject2 = bgks.c(l, 5);
            paramOutputStream = (OutputStream)localObject1;
            localObject1 = localObject2;
          }
          catch (Exception paramDownloadParams)
          {
            for (;;)
            {
              ((FileOutputStream)localObject2).close();
              new File(paramOutputStream).delete();
            }
          }
        }
      }
      return null;
      label410:
      paramOutputStream = null;
      localObject1 = null;
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdso
 * JD-Core Version:    0.7.0.1
 */