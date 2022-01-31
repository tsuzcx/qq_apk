import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class amln
{
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return null;
      try
      {
        paramString1 = bdcs.a(new File(new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config"), paramString1 + paramString2));
        if ((paramString1 == null) || (paramString1.length <= 0)) {
          continue;
        }
        if (Build.VERSION.SDK_INT <= 8)
        {
          paramString1 = new String(paramString1);
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramString1.printStackTrace();
          }
          paramString1 = null;
          continue;
          try
          {
            paramString1 = new String(paramString1, "UTF-8");
          }
          catch (Exception paramString1)
          {
            if (QLog.isDevelopLevel()) {
              paramString1.printStackTrace();
            }
            paramString1 = null;
          }
        }
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      if (QLog.isColorLevel()) {
        QLog.i("UpgradeConfigManager", 2, "save Config to file failed，content is empty----" + paramString1);
      }
    }
    do
    {
      return;
      File localFile = new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config");
      bdcs.a(localFile.getAbsolutePath() + "/", paramString1 + paramString2, paramString3);
    } while (!QLog.isColorLevel());
    QLog.i("UpgradeConfigManager", 2, "save Config to file finish.");
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeConfigManager", 2, String.format("deleteUpgradeConfig fileName=%s uin=%s", new Object[] { paramString1, paramString2 }));
    }
    File localFile;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      localFile = new File(new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config"), paramString1 + paramString2);
      if (!localFile.exists()) {}
    }
    for (;;)
    {
      try
      {
        bool = localFile.delete();
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeConfigManager", 2, String.format("deleteUpgradeConfig fileName=%s uin=%s result=%s", new Object[] { paramString1, paramString2, Boolean.valueOf(bool) }));
        }
        return bool;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeConfigManager", 2, String.format("deleteUpgradeConfig fail! fileName=%s uin=%s", new Object[] { paramString1, paramString2 }), localException);
        }
        bool = false;
        continue;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amln
 * JD-Core Version:    0.7.0.1
 */