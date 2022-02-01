import android.content.res.Resources;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import org.apache.http.Header;

public class bewg
  extends beqz
{
  protected static File a;
  
  protected File a(int paramInt)
  {
    Object localObject = null;
    NullPointerException localNullPointerException1 = null;
    if ((paramInt >= begd.a.length) || (a == null)) {}
    try
    {
      a = BaseApplicationImpl.getApplication().getDir("systemface", 0);
      String str = BaseApplicationImpl.getContext().getResources().getResourceEntryName(begd.a[paramInt]);
      localObject = new File(a + File.separator + str);
      if (!((File)localObject).exists())
      {
        localObject = localNullPointerException1;
        if (QLog.isColorLevel())
        {
          if (localNullPointerException1 != null)
          {
            bool = true;
            QLog.d("AbsDownloader", 2, new Object[] { "getGifFileFromOldDir:", Integer.valueOf(paramInt), " ,name:", str, " ,exist:", Boolean.valueOf(bool) });
            localObject = localNullPointerException1;
          }
        }
        else {
          return localObject;
        }
      }
    }
    catch (NullPointerException localNullPointerException2)
    {
      for (;;)
      {
        QLog.e("AbsDownloader", 1, "npe while getGifFileFromOldDir!");
        continue;
        boolean bool = false;
        continue;
        localNullPointerException1 = localNullPointerException2;
      }
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = paramDownloadParams.url.getHost();
    String str = paramDownloadParams.url.getFile();
    paramURLDrawableHandler = new File(b(paramOutputStream, str));
    if (paramURLDrawableHandler.exists())
    {
      paramOutputStream = paramURLDrawableHandler;
      if (QLog.isColorLevel())
      {
        QLog.d("AbsDownloader", 2, new Object[] { "found file:", str });
        paramOutputStream = paramURLDrawableHandler;
      }
    }
    int i;
    do
    {
      do
      {
        return paramOutputStream;
        paramDownloadParams = paramDownloadParams.getHeader("emoId");
        if (paramDownloadParams == null) {
          break label224;
        }
        paramDownloadParams = paramDownloadParams.getValue();
        QLog.d("AbsDownloader", 1, String.format("file[%s] not found, loading[%s], host[%s]", new Object[] { str, paramDownloadParams, paramOutputStream }));
        i = Integer.parseInt(paramDownloadParams);
        if (!"host_qqsys_gif".equals(paramOutputStream)) {
          break label226;
        }
        if (!a(i)) {
          break;
        }
        paramDownloadParams = new File(b("host_qqsys_static", str.replace(".gif", ".png")));
        if (!paramDownloadParams.exists()) {
          break label217;
        }
        paramOutputStream = paramDownloadParams;
      } while (!QLog.isColorLevel());
      QLog.d("AbsDownloader", 2, new Object[] { "static file exist:", Integer.valueOf(i) });
      return paramDownloadParams;
      paramDownloadParams = a(i);
      paramOutputStream = paramDownloadParams;
    } while (paramDownloadParams != null);
    label217:
    a(1, i);
    for (;;)
    {
      label224:
      return null;
      label226:
      if ("host_qqsys_static".equals(paramOutputStream)) {
        a(1, i);
      } else if ("host_emoji".equals(paramOutputStream)) {
        a(2, i);
      }
    }
  }
  
  protected Object a(File paramFile)
  {
    return NativeGifFactory.getNativeGifObject(paramFile, false);
  }
  
  protected Object a(String paramString)
  {
    return BitmapFactory.decodeFile(paramString);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    asky.a().a(paramInt1).b(paramInt2);
  }
  
  protected boolean a(int paramInt)
  {
    return asle.a(paramInt);
  }
  
  protected String b(String paramString1, String paramString2)
  {
    int i = 2;
    if ("host_qqsys_gif".equals(paramString1)) {
      i = 1;
    }
    for (;;)
    {
      return asky.a(i, paramString2);
      if ("host_emoji".equals(paramString1)) {
        i = 3;
      }
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramFile == null) {
      return null;
    }
    if (GifDrawable.isGifFile(paramFile)) {
      return a(paramFile);
    }
    return a(paramFile.getAbsolutePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewg
 * JD-Core Version:    0.7.0.1
 */