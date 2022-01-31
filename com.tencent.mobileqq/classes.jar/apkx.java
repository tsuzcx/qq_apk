import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.ApolloJscLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class apkx
  extends apld
{
  public apkx(QQAppInterface paramQQAppInterface)
  {
    super("android.qq.apollo.jsc820", paramQQAppInterface);
  }
  
  public static void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (apks)((QQAppInterface)localObject).getManager(77);
      if (localObject != null)
      {
        localObject = (apkx)((apks)localObject).a("android.qq.apollo.jsc820");
        if (localObject != null)
        {
          ((apkx)localObject).a(true);
          QLog.i("ApolloSoLoader_JscHandler", 1, "restartDownload jscLib");
        }
      }
    }
  }
  
  public int a()
  {
    return 10072;
  }
  
  public Class<? extends XmlData> a()
  {
    return ApolloJscLibData.class;
  }
  
  public String a()
  {
    return "ApolloSoLoader_JscHandler";
  }
  
  public void a(String paramString)
  {
    QLog.i("ApolloSoLoader_JscHandler", 1, "[doOnDownloadSuccess] jsc:" + paramString);
    XmlData localXmlData = a();
    if (localXmlData != null) {
      QLog.i("ApolloSoLoader_JscHandler", 1, "version:" + localXmlData.Version);
    }
    int i;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      i = 1;
      if (i != 0) {
        alhp.a(10, null, new int[] { 1 });
      }
      if (new File(paramString).exists())
      {
        if (bhss.a(paramString, 0)) {
          break label189;
        }
        if (localXmlData != null)
        {
          localXmlData.loadState = 0;
          localXmlData.Version = 0;
          apkr.a(localXmlData, new String[] { "loadState", "Version" });
        }
        QLog.e("ApolloSoLoader_JscHandler", 1, "[doOnDownloadSuccess],unzip apollo jsclib failed!");
        if (i != 0)
        {
          alhp.a(10, 201, 1001, new Object[] { "unzip jsc lib failed" });
          alko.a = true;
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
      if (i != 0) {
        alhp.a(10, 201, 0, new Object[] { "libjsc so download success" });
      }
      alko.a("after_JSC_downloaded");
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
 * Qualified Name:     apkx
 * JD-Core Version:    0.7.0.1
 */