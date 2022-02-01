import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.util.Pair;
import java.io.File;

public class apsn
{
  public static volatile ISPlayerPreDownloader a;
  
  public static Pair<Long, String> a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AROnlineVideoUtil", 2, "parseFileSize, str=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      paramString = paramString.split("\\|");
      if ((paramString == null) || (paramString.length != 2)) {
        continue;
      }
      try
      {
        l = Long.parseLong(paramString[0]);
        if (l == -1L) {
          continue;
        }
        return new Pair(Long.valueOf(l), paramString[1]);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            localException.printStackTrace();
          }
          long l = -1L;
        }
      }
    }
  }
  
  private static String a()
  {
    if (bhjr.a()) {
      return bigv.a(antf.ba + "iar" + File.separator);
    }
    return BaseApplicationImpl.getApplication().getFilesDir() + File.separator + "iar" + File.separator;
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = bjtz.d(paramString);
      paramString = a() + paramString;
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("AROnlineVideoUtil", 2, "getStorageDir, Exception");
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a()
  {
    if (a != null)
    {
      a.destory();
      a = null;
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    if (bhnv.b(BaseApplication.getContext()) == 1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AROnlineVideoUtil", 2, "preload, isWifi=" + bool);
      }
      if (bool) {}
      return;
      bool = false;
    }
  }
  
  public static void a(Context paramContext, ArVideoResourceInfo paramArVideoResourceInfo)
  {
    boolean bool = true;
    if ((paramArVideoResourceInfo == null) || (TextUtils.isEmpty(paramArVideoResourceInfo.jdField_d_of_type_JavaLangString)) || (paramArVideoResourceInfo.jdField_d_of_type_Int != 4)) {
      return;
    }
    if (bhnv.b(BaseApplication.getContext()) == 1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AROnlineVideoUtil", 2, "preload for multi, isWifi=" + bool);
      }
      if (!bool) {
        break;
      }
      if (a == null) {
        a = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getApplication(), 108);
      }
      if (TextUtils.isEmpty(paramArVideoResourceInfo.jdField_d_of_type_JavaLangString)) {
        break;
      }
      paramContext = paramArVideoResourceInfo.jdField_d_of_type_JavaLangString;
      String str = a(paramContext);
      bool = a(str);
      if (QLog.isColorLevel()) {
        QLog.d("AROnlineVideoUtil", 2, "preload for multi, url=" + paramContext + ", videoPath=" + str + ", isCached=" + bool);
      }
      paramContext = SuperPlayerFactory.createVideoInfoForUrl(paramContext, 101, bjtz.d(paramContext));
      if (paramArVideoResourceInfo.a <= 4L) {
        break;
      }
      a.startPreDownload(paramContext, paramArVideoResourceInfo.a / 4L);
      return;
      bool = false;
    }
  }
  
  private static boolean a(String paramString)
  {
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.length() > 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsn
 * JD-Core Version:    0.7.0.1
 */