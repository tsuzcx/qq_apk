import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.ViolaBizLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class anqa
  extends anpi
{
  public static final String a;
  public static final String[] a;
  
  static
  {
    if (AppSetting.b) {}
    for (String str = "android.qq.readinjoy.viola_biz64_810";; str = "android.qq.readinjoy.viola_biz_810")
    {
      jdField_a_of_type_JavaLangString = str;
      jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libviola.so" };
      return;
    }
  }
  
  public anqa(QQAppInterface paramQQAppInterface)
  {
    super(jdField_a_of_type_JavaLangString, paramQQAppInterface);
  }
  
  public static void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (anox)((QQAppInterface)localObject).getManager(77);
      if (localObject != null)
      {
        localObject = (anqa)((anox)localObject).a(jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          ((anqa)localObject).a(true);
          QLog.i("viola.ViolaBizLibHandler", 1, "restartDownloadLib");
        }
      }
    }
  }
  
  public static boolean i()
  {
    String str = osz.a();
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      File localFile = new File(str, jdField_a_of_type_ArrayOfJavaLangString[i]);
      if ((localFile == null) || (!localFile.exists()) || (!localFile.isFile())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int a()
  {
    return 10079;
  }
  
  public Class<? extends XmlData> a()
  {
    return ViolaBizLibData.class;
  }
  
  public String a()
  {
    return "viola.ViolaBizLibHandler";
  }
  
  public void a(String paramString)
  {
    QLog.i("viola.ViolaBizLibHandler", 1, "[doOnDownloadSuccess]:" + paramString);
    XmlData localXmlData = a();
    if (localXmlData != null) {
      QLog.i("viola.ViolaBizLibHandler", 1, "version:" + localXmlData.Version);
    }
    if (new File(paramString).exists())
    {
      if (osz.a(paramString)) {
        break label148;
      }
      if (localXmlData != null)
      {
        localXmlData.loadState = 0;
        localXmlData.Version = 0;
        anow.a(localXmlData, new String[] { "loadState", "Version" });
      }
      QLog.e("viola.ViolaBizLibHandler", 1, "[doOnDownloadSuccess],unzip " + jdField_a_of_type_JavaLangString + " lib failed!");
    }
    label148:
    do
    {
      return;
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
      if (paramString != null) {
        paramString.edit().putString("res_name", jdField_a_of_type_JavaLangString).commit();
      }
    } while (!anqb.i());
    ost.a("biz doOnDownloadSuccess");
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
 * Qualified Name:     anqa
 * JD-Core Version:    0.7.0.1
 */