import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.ArNativeSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class anpk
  extends anpn
{
  public static final String a;
  
  static
  {
    if (AppSetting.b) {}
    for (String str = "qq.android.ar.native.so64_v8.0.0";; str = "qq.android.ar.native.so_v8.0.0")
    {
      jdField_a_of_type_JavaLangString = str;
      return;
    }
  }
  
  public anpk(QQAppInterface paramQQAppInterface)
  {
    super(jdField_a_of_type_JavaLangString, paramQQAppInterface);
  }
  
  public int a()
  {
    return 10024;
  }
  
  public Class<? extends XmlData> a()
  {
    return ArNativeSoData.class;
  }
  
  public String a()
  {
    return "ArConfig_NativeSoDownloadHandler";
  }
  
  public void a(XmlData paramXmlData)
  {
    int i = 0;
    try
    {
      Object localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("ArNativeSoDownloadHandler", 4);
      if (((SharedPreferences)localObject1).getBoolean(jdField_a_of_type_JavaLangString, true))
      {
        ((SharedPreferences)localObject1).edit().putBoolean(jdField_a_of_type_JavaLangString, false).commit();
        localObject1 = new File(alby.a() + File.separator).listFiles();
        int j = localObject1.length;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_NativeSoDownloadHandler", 2, "File name=" + localObject2.getAbsolutePath());
          }
          if ((localObject2.isFile()) && (localObject2.getName().startsWith("libArMapEngine")) && (!localObject2.getName().contains(alby.jdField_a_of_type_JavaLangString)))
          {
            localObject2.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ArConfig_NativeSoDownloadHandler", 2, "delete f=" + localObject2.getName());
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_NativeSoDownloadHandler", 2, "exception =" + localException.getMessage());
        localException.printStackTrace();
      }
      super.a(paramXmlData);
    }
  }
  
  public void a(String paramString)
  {
    int i = alby.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_NativeSoDownloadHandler", 2, "download success: " + paramString + ",result=" + i);
    }
    if (i == 0) {
      BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit().putInt("ar_native_so_version", b()).commit();
    }
    for (;;)
    {
      try
      {
        str = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getString("ar_native_" + alby.jdField_a_of_type_JavaLangString, "");
        if (!TextUtils.isEmpty(str))
        {
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          i = a().Version;
          if (!TextUtils.isEmpty(str)) {
            continue;
          }
          localObject = "0";
          axqy.b(localQQAppInterface, "dc01440", "", "", "0X8007A3D", "0X8007A3D", 0, 0, "", String.valueOf(i), (String)localObject, jdField_a_of_type_JavaLangString);
          localObject = new HashMap();
          ((HashMap)localObject).put("config_version", String.valueOf(a().Version));
          ((HashMap)localObject).put("md5", str);
          ((HashMap)localObject).put("res_name", jdField_a_of_type_JavaLangString);
          axrn.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "armap_so_update_rate", true, 0L, 0L, (HashMap)localObject, "", false);
        }
      }
      catch (Exception localException)
      {
        String str;
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localException.printStackTrace();
        continue;
      }
      super.a(paramString);
      return;
      a().loadState = 0;
      a().Version = 0;
      anpb.a(a(), new String[0]);
      continue;
      localObject = str;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(false, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_NativeSoDownloadHandler", 2, "restartDownload " + paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      super.a(paramBoolean2);
    }
    do
    {
      return;
      if ((a() == null) || (a().loadState != 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ArConfig_NativeSoDownloadHandler", 2, "restartDownloadForce is in downloading");
    return;
    super.a(paramBoolean2);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return "prd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anpk
 * JD-Core Version:    0.7.0.1
 */