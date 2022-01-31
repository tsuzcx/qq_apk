import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.ViolaLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class anqb
  extends anpi
{
  public static final String a;
  public static final String[] a;
  
  static
  {
    Object localObject;
    if (AppSetting.b)
    {
      localObject = "android.qq.readinjoy.viola64_820";
      jdField_a_of_type_JavaLangString = (String)localObject;
      if (!AppSetting.b) {
        break label45;
      }
      localObject = new String[2];
      localObject[0] = "libc++_shared.so";
      localObject[1] = "libviola_jsc.so";
    }
    for (;;)
    {
      jdField_a_of_type_ArrayOfJavaLangString = (String[])localObject;
      return;
      localObject = "android.qq.readinjoy.viola_795";
      break;
      label45:
      localObject = new String[2];
      localObject[0] = "libgnustl_shared.so";
      localObject[1] = "libjsc.so";
    }
  }
  
  public anqb(QQAppInterface paramQQAppInterface)
  {
    super(jdField_a_of_type_JavaLangString, paramQQAppInterface);
  }
  
  public static void a()
  {
    if (i()) {}
    do
    {
      return;
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (anox)((QQAppInterface)localObject).getManager(77);
        if (localObject != null)
        {
          localObject = (anqb)((anox)localObject).a(jdField_a_of_type_JavaLangString);
          if (localObject != null)
          {
            ((anqb)localObject).a(true);
            QLog.i("viola.ViolaLibHandler", 1, "restartDownloadLib");
          }
        }
      }
    } while (anqa.i());
    anqa.a();
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
    return 10071;
  }
  
  public Class<? extends XmlData> a()
  {
    return ViolaLibData.class;
  }
  
  public String a()
  {
    return "viola.ViolaLibHandler";
  }
  
  public void a(String paramString)
  {
    QLog.i("viola.ViolaLibHandler", 1, "[doOnDownloadSuccess]:" + paramString);
    XmlData localXmlData = a();
    if (localXmlData != null) {
      QLog.i("viola.ViolaLibHandler", 1, "version:" + localXmlData.Version);
    }
    if (new File(paramString).exists())
    {
      if (osz.a(paramString)) {
        break label124;
      }
      if (localXmlData != null)
      {
        localXmlData.loadState = 0;
        localXmlData.Version = 0;
        anow.a(localXmlData, new String[] { "loadState", "Version" });
      }
      QLog.e("viola.ViolaLibHandler", 1, "[doOnDownloadSuccess],unzip readinjoy_viola lib failed!");
    }
    label124:
    do
    {
      return;
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
      if (paramString != null) {
        paramString.edit().putString("res_name", jdField_a_of_type_JavaLangString).commit();
      }
    } while (!anqa.i());
    ost.a("jsc doOnDownloadSuccess");
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
 * Qualified Name:     anqb
 * JD-Core Version:    0.7.0.1
 */