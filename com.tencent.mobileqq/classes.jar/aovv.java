import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aovv
{
  public static int a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    for (;;)
    {
      try
      {
        paramString1 = a(paramString1, paramString2, paramString3) + File.separator + paramString4 + ".so";
        QLog.i("AREngine_ArNativeSoLoaderBase", 2, "loadArNativeSo. soFilename = " + paramString1);
        boolean bool = new File(paramString1).exists();
        if (bool)
        {
          try
          {
            if ((paramString1.endsWith("libARCloud.so")) || (paramString1.endsWith("libARCloud_64.so")) || (paramString1.endsWith("libARFeature.so"))) {
              SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "c++_shared");
            }
            System.load(paramString1);
            i = 0;
            QLog.i("AREngine_ArNativeSoLoaderBase", 2, "loadArNativeSo successfully. result = " + 0 + ", soFilename = " + paramString1);
          }
          catch (UnsatisfiedLinkError paramString2)
          {
            i = -4;
            QLog.e("AREngine_ArNativeSoLoaderBase", 2, "loadArNativeSo failed. result = " + -4 + ", soFilename = " + paramString1 + ", errMsg = " + paramString2.getMessage() + ", StackTrace = " + paramString2.getStackTrace().toString());
            continue;
          }
          return i;
        }
      }
      finally {}
      int i = -2;
      QLog.i("AREngine_ArNativeSoLoaderBase", 2, "loadArNativeSo failed. result = " + -2 + ", soFilename = " + paramString1);
    }
  }
  
  public static String a()
  {
    if (BaseApplicationImpl.sApplication.getFilesDir() == null)
    {
      QLog.i("AREngine_ArNativeSoLoaderBase", 2, "getARNativeSoRootDir. ARNativeSoRootDir is null.");
      return "";
    }
    return BaseApplicationImpl.getContext().getFilesDir() + "/pddata/prd";
  }
  
  public static String a(String paramString)
  {
    return a() + File.separator + paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1) + File.separator + paramString2 + File.separator + paramString3;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = paramString1 + paramString2 + paramString3;
    paramString2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).edit();
    paramString2.putString(paramString1, paramString4);
    paramString2.commit();
    QLog.i("AREngine_ArNativeSoLoaderBase", 2, "saveMd5. key = " + paramString1 + ", md5 = " + paramString4);
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = paramString1 + paramString2 + paramString3;
    paramString2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString(paramString1, "");
    QLog.i("AREngine_ArNativeSoLoaderBase", 2, "readMd5. key = " + paramString1 + ", md5 = " + paramString2);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovv
 * JD-Core Version:    0.7.0.1
 */