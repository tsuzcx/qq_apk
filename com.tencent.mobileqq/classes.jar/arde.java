import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class arde
  extends arac<ardf>
{
  @NonNull
  public ardf a(int paramInt)
  {
    return new ardf();
  }
  
  @Nullable
  public ardf a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      ardf localardf = ardf.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localardf;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(ardf paramardf)
  {
    if (paramardf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "onUpdate " + paramardf.toString());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    alok.a(localQQAppInterface, paramardf.jdField_a_of_type_Boolean);
    bhtb.a(localQQAppInterface.getApp(), "KEY_DELAY_LOAD_PROXY", paramardf.f);
    bhtb.a(localQQAppInterface.getApp(), "KEY_ENABLE_MEMORY_LEAK", paramardf.g);
    localQQAppInterface.getApp().getSharedPreferences("acc_info" + localQQAppInterface.getAccount(), 0).edit().putLong("PREF_PLUGIN_DELAY_TIME", paramardf.jdField_a_of_type_Long).apply();
    try
    {
      File localFile = new File(localQQAppInterface.getApp().getFilesDir() + File.separator + "enableKernelServiceInVivo");
      if (paramardf.b) {
        if (!localFile.exists()) {
          localFile.createNewFile();
        }
      }
      for (;;)
      {
        localQQAppInterface.getApp().getSharedPreferences("dt_sdk_start", 0).edit().putBoolean("is_init_dt_sdk_at_start", paramardf.d).apply();
        try
        {
          BaseApplicationImpl.getApplication().getSharedPreferences("suspend_thread_pref_file", 0).edit().putBoolean("enable_sys_log", paramardf.e).apply();
          return;
        }
        catch (Throwable paramardf)
        {
          QLog.e("BootOptimizeConfProcessor", 1, "syslog print config failed", paramardf);
          return;
        }
        if (localFile.exists()) {
          localFile.delete();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("BootOptimizeConfProcessor", 1, "create file failed", localThrowable);
      }
    }
  }
  
  public Class<ardf> clazz()
  {
    return ardf.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 566;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arde
 * JD-Core Version:    0.7.0.1
 */