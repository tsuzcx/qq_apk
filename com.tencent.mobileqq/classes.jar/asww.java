import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class asww
{
  public static final String a = "qqmusic://qq.com/ui/myTab?p=%7B%22tab%22%3A%22home%22%7D&ADTAG=YIQITING&source=" + URLEncoder.encode("https://y.qq.com/m/index.html?ADTAG=YIQITING");
  
  public static void a(Context paramContext, String paramString)
  {
    long l = 0L;
    for (;;)
    {
      try
      {
        localObject = new URL(paramString);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject;
        int i;
        QLog.e("QQMusicConst", 1, "music player activity url io MalformedURLException ", localMalformedURLException);
        continue;
      }
      try
      {
        i = ((URL)localObject).openConnection().getContentLength();
        l = i;
      }
      catch (IOException localIOException)
      {
        QLog.e("QQMusicConst", 1, "music player activity url IOException ", localIOException);
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("big_brother_source_key", "biz_src_qqmusic");
    ((Bundle)localObject).putLong("_filesize_from_dlg", l);
    ((Bundle)localObject).putString("_filename_from_dlg", paramContext.getResources().getString(2131694787));
    ((Bundle)localObject).putString("FILE_MIME_TYPE", "application/vnd.android.package-archive");
    ((Bundle)localObject).putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_qqmusic");
    apcy.a().b(paramString, (Bundle)localObject);
  }
  
  public static boolean a(Context paramContext)
  {
    return a(paramContext, "com.tencent.qqmusic");
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getPackageInfo(paramString, 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asww
 * JD-Core Version:    0.7.0.1
 */