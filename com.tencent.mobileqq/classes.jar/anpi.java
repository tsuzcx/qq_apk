import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.ApolloLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class anpi
  extends anpn
{
  public static final String a;
  public static final String[] a;
  
  static
  {
    if (AppSetting.b) {}
    for (String str = "android.qq.apollo.js.828g2_64";; str = "android.qq.apollo.js.828g2")
    {
      jdField_a_of_type_JavaLangString = str;
      jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libjsc.so" };
      return;
    }
  }
  
  public anpi(QQAppInterface paramQQAppInterface)
  {
    super(jdField_a_of_type_JavaLangString, paramQQAppInterface);
  }
  
  public static void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (anpc)((QQAppInterface)localObject).getManager(77);
      if (localObject != null)
      {
        localObject = (anpi)((anpc)localObject).a(jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          ((anpi)localObject).a(true);
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
        ajlo.a(10, null, new int[] { 1 });
      }
      if (new File(paramString).exists())
      {
        if (bfnq.a(paramString, 1)) {
          break label189;
        }
        if (localObject != null)
        {
          ((XmlData)localObject).loadState = 0;
          ((XmlData)localObject).Version = 0;
          anpb.a((XmlData)localObject, new String[] { "loadState", "Version" });
        }
        QLog.e("ApolloSoLoader_libHandler", 1, "[doOnDownloadSuccess],unzip apollo lib failed!");
        if (i != 0)
        {
          ajlo.a(10, 200, 1001, new Object[] { "unzip sava lib failed" });
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
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("res_name", jdField_a_of_type_JavaLangString).commit();
      }
      if (i != 0) {
        ajlo.a(10, 200, 0, new Object[] { "libsava so download success" });
      }
      ajom.a("after_ApolloSo_downloaded");
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
 * Qualified Name:     anpi
 * JD-Core Version:    0.7.0.1
 */