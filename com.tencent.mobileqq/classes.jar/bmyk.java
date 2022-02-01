import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class bmyk
  extends beqz
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams == null) {
      return null;
    }
    String str = paramDownloadParams.url.getHost();
    paramOutputStream = new File(str);
    if (paramOutputStream.exists()) {}
    for (;;)
    {
      return paramOutputStream;
      paramURLDrawableHandler = paramDownloadParams.url.getFile();
      if (TextUtils.isEmpty(paramURLDrawableHandler))
      {
        QLog.e("qzonecontentboxdownloader", 2, "downloadImage url err, url=" + paramURLDrawableHandler + ", path=" + str);
        return null;
      }
      paramDownloadParams = paramURLDrawableHandler;
      if (paramURLDrawableHandler.startsWith(File.separator)) {
        paramDownloadParams = paramURLDrawableHandler.substring(1);
      }
      if (!paramDownloadParams.startsWith("http"))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("qzonecontentboxdownloader", 2, "downloadImage url has no http err, url=" + paramDownloadParams + ", path=" + str);
        return null;
      }
      int i = bihw.a(new bihu(paramDownloadParams, paramOutputStream), BaseApplicationImpl.sApplication.getRuntime());
      if (i == 0)
      {
        if (!paramOutputStream.exists())
        {
          QLog.e("qzonecontentboxdownloader", 1, "downloadImage file not exists, url=" + paramDownloadParams + ", path=" + str + ", ret:" + i);
          paramOutputStream = null;
        }
      }
      else
      {
        QLog.e("qzonecontentboxdownloader", 1, "downloadImage Error url=" + paramDownloadParams + ", path=" + str + ", ret:" + i);
        paramOutputStream = null;
      }
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject = null;
    paramURLDrawableHandler = null;
    if ((paramFile != null) && (paramFile.exists()) && (paramDownloadParams != null) && (paramDownloadParams.useApngImage) && (ApngDrawable.isApngFile(paramFile)))
    {
      if ((paramDownloadParams.mExtraInfo instanceof Bundle)) {
        paramURLDrawableHandler = (Bundle)paramDownloadParams.mExtraInfo;
      }
      paramDownloadParams = new ApngImage(paramFile, true, paramURLDrawableHandler);
      if (paramDownloadParams.firstFrame == null) {
        ChatBackgroundManager.a(paramFile.getAbsolutePath());
      }
      paramFile = paramDownloadParams;
    }
    do
    {
      return paramFile;
      paramFile = localObject;
    } while (paramDownloadParams == null);
    paramDownloadParams.useApngImage = false;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyk
 * JD-Core Version:    0.7.0.1
 */