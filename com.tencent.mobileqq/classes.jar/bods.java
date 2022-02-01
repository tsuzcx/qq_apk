import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class bods
{
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public static boolean a;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public static byte a(String paramString)
  {
    byte b = 0;
    if (paramString == null) {
      b = -1;
    }
    do
    {
      for (;;)
      {
        return b;
        paramString = a() + "/lib" + paramString + ".so";
        if (QLog.isColorLevel()) {
          QLog.i("TK_Config_NativeSoLoader", 2, "start TKNativeSo: " + paramString);
        }
        File localFile = new File(paramString);
        if ((!jdField_a_of_type_Boolean) && (localFile.exists())) {
          try
          {
            System.load(paramString);
            if (QLog.isColorLevel())
            {
              QLog.i("TK_Config_NativeSoLoader", 2, "load " + paramString + " success!");
              return 0;
            }
          }
          catch (UnsatisfiedLinkError paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.i("TK_Config_NativeSoLoader", 2, "load from tk dir failed: " + paramString.getMessage());
            }
            return -3;
          }
        }
      }
      b = -2;
    } while (!QLog.isColorLevel());
    QLog.i("TK_Config_NativeSoLoader", 2, "no tk so in ar dir");
    return -2;
  }
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TK_Config_NativeSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/tk";
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String str1 = a() + "/lib" + paramString + ".so";
    ??? = new File(str1);
    if (QLog.isColorLevel()) {
      QLog.d("TK_Config_NativeSoLoader", 2, "isSoFileExist: exist= " + ((File)???).exists() + " isUncompressZip=" + jdField_a_of_type_Boolean);
    }
    if ((!jdField_a_of_type_Boolean) && (((File)???).exists())) {
      for (;;)
      {
        synchronized (jdField_a_of_type_ArrayOfByte)
        {
          String str2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getString("tk_native_" + paramString, null);
          if (str2 != null) {
            if (str2.equalsIgnoreCase(ayja.a(str1)))
            {
              break label221;
              return bool1;
            }
            else
            {
              bool1 = bool2;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("TK_Config_NativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " check md5 false!");
              bool1 = bool2;
            }
          }
        }
        label221:
        boolean bool1 = true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bods
 * JD-Core Version:    0.7.0.1
 */