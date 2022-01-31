import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.ApolloJscLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class anph
  extends anpn
{
  public static final String a;
  
  static
  {
    if (AppSetting.b) {}
    for (String str = "android.qq.apollo.jsc820_64";; str = "android.qq.apollo.jsc820")
    {
      a = str;
      return;
    }
  }
  
  public anph(QQAppInterface paramQQAppInterface)
  {
    super(a, paramQQAppInterface);
  }
  
  public static void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (anpc)((QQAppInterface)localObject).getManager(77);
      if (localObject != null)
      {
        localObject = (anph)((anpc)localObject).a(a);
        if (localObject != null)
        {
          ((anph)localObject).a(true);
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
        ajlo.a(10, null, new int[] { 1 });
      }
      if (new File(paramString).exists())
      {
        if (bfnq.a(paramString, 0)) {
          break label189;
        }
        if (localXmlData != null)
        {
          localXmlData.loadState = 0;
          localXmlData.Version = 0;
          anpb.a(localXmlData, new String[] { "loadState", "Version" });
        }
        QLog.e("ApolloSoLoader_JscHandler", 1, "[doOnDownloadSuccess],unzip apollo jsclib failed!");
        if (i != 0)
        {
          ajlo.a(10, 201, 1001, new Object[] { "unzip jsc lib failed" });
          ajom.a = true;
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
        ajlo.a(10, 201, 0, new Object[] { "libjsc so download success" });
      }
      ajom.a("after_JSC_downloaded");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anph
 * JD-Core Version:    0.7.0.1
 */