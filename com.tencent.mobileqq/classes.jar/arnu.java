import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.ApolloLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class arnu
  extends arnz
{
  public static final String[] a = { "libjsc.so" };
  
  public arnu(QQAppInterface paramQQAppInterface)
  {
    super("android.qq.apollo.js.839g1", paramQQAppInterface);
  }
  
  public static void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (arno)((QQAppInterface)localObject).getManager(77);
      if (localObject != null)
      {
        localObject = (arnu)((arno)localObject).a("android.qq.apollo.js.839g1");
        if (localObject != null)
        {
          ((arnu)localObject).a(true);
          QLog.i("ApolloSoLoader_libHandler", 1, "restartDownload savaLib");
        }
      }
    }
  }
  
  public int a()
  {
    return 10038;
  }
  
  public Class<? extends XmlData> a()
  {
    return ApolloLibData.class;
  }
  
  public String a()
  {
    return "ApolloSoLoader_libHandler";
  }
  
  public void a(String paramString)
  {
    QLog.i("ApolloSoLoader_libHandler", 1, "[doOnDownloadSuccess] sava:" + paramString);
    Object localObject = a();
    if (localObject != null) {
      QLog.i("ApolloSoLoader_libHandler", 1, "version:" + ((XmlData)localObject).Version);
    }
    int i;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      i = 1;
      if (i != 0) {
        anaw.a(10, null, new int[] { 1 });
      }
      if (new File(paramString).exists())
      {
        if (bkgc.a(paramString, 1)) {
          break label189;
        }
        if (localObject != null)
        {
          ((XmlData)localObject).loadState = 0;
          ((XmlData)localObject).Version = 0;
          arnn.a((XmlData)localObject, new String[] { "loadState", "Version" });
        }
        QLog.e("ApolloSoLoader_libHandler", 1, "[doOnDownloadSuccess],unzip apollo lib failed!");
        if (i != 0)
        {
          anaw.a(10, 200, 1001, new Object[] { "unzip sava lib failed" });
          andw.a = true;
        }
      }
    }
    for (;;)
    {
      super.a(paramString);
      return;
      i = 0;
      break;
      label189:
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("res_name", "android.qq.apollo.js.839g1").commit();
      }
      if (i != 0) {
        anaw.a(10, 200, 0, new Object[] { "libsava so download success" });
      }
      andw.a("after_ApolloSo_downloaded");
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arnu
 * JD-Core Version:    0.7.0.1
 */