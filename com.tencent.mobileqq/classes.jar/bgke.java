import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class bgke
{
  private static bgke jdField_a_of_type_Bgke;
  bgkd jdField_a_of_type_Bgkd;
  bgkf jdField_a_of_type_Bgkf = new bgkf();
  bgkh jdField_a_of_type_Bgkh;
  
  static SharedPreferences a()
  {
    return BaseApplication.getContext().getSharedPreferences("config_qq.android.gme_sdk", 4);
  }
  
  static bgke a()
  {
    if (jdField_a_of_type_Bgke == null) {
      jdField_a_of_type_Bgke = new bgke();
    }
    return jdField_a_of_type_Bgke;
  }
  
  public static String a()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      str = ((File)localObject).getParent() + "/txlib/gme_sdk/";
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  public static String a(bgkd parambgkd)
  {
    return a() + "gme_sdk_" + parambgkd.a + "_" + parambgkd.b + ".zip";
  }
  
  public static void a()
  {
    ArrayList localArrayList = bbdx.a(a());
    if (localArrayList != null)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        QLog.e("TMG_Downloader", 1, String.format("ListSoDirs file i=" + i + ", name=" + (String)localArrayList.get(i), new Object[0]));
        i += 1;
      }
    }
  }
  
  static void a(String paramString)
  {
    SharedPreferences.Editor localEditor = a().edit();
    localEditor.putString("gme_sdk_download_md5", paramString);
    localEditor.commit();
  }
  
  static String b()
  {
    return a().getString("gme_sdk_download_md5", null);
  }
  
  public static boolean b(bgkd parambgkd)
  {
    String str1 = parambgkd.b;
    parambgkd = a(parambgkd);
    String str2 = b();
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TMG_Downloader", 4, String.format("isSoReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
      }
    }
    do
    {
      return false;
      if (bbdx.a(parambgkd)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("TMG_Downloader", 4, String.format("isSoReady, file no exist,  fileName[%s]", new Object[] { parambgkd }));
    return false;
    a();
    return true;
  }
  
  boolean a(bgkd parambgkd)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      if (((QQAppInterface)localAppRuntime).getManager(21) == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TMG_Downloader", 4, "innerDownload, getNetEngine 为空");
        }
        return false;
      }
    }
    else if (QLog.isDevelopLevel()) {
      QLog.d("TMG_Downloader", 4, "appRuntime 不是 QQAppInterface");
    }
    this.jdField_a_of_type_Bgkd = parambgkd;
    return this.jdField_a_of_type_Bgkf.a(parambgkd, this.jdField_a_of_type_Bgkh);
  }
  
  boolean a(bgkd parambgkd, bgkh parambgkh)
  {
    this.jdField_a_of_type_Bgkh = parambgkh;
    return a(parambgkd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgke
 * JD-Core Version:    0.7.0.1
 */