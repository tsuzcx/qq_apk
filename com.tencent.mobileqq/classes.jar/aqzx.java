import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aqzx
  extends aqwt<aqzy>
{
  @NonNull
  public aqzy a(int paramInt)
  {
    return new aqzy();
  }
  
  @Nullable
  public aqzy a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      aqzy localaqzy = aqzy.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localaqzy;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(aqzy paramaqzy)
  {
    if (paramaqzy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "onUpdate " + paramaqzy.toString());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    alht.a(localQQAppInterface, paramaqzy.jdField_a_of_type_Boolean);
    bhii.a(localQQAppInterface.getApp(), "KEY_DELAY_LOAD_PROXY", paramaqzy.e);
    bhii.a(localQQAppInterface.getApp(), "KEY_ENABLE_MEMORY_LEAK", paramaqzy.f);
    bhii.a(localQQAppInterface.getApp(), "KEY_DISABLE_NAVIGATION_BAR", paramaqzy.g);
    localQQAppInterface.getApp().getSharedPreferences("acc_info" + localQQAppInterface.getAccount(), 0).edit().putLong("PREF_PLUGIN_DELAY_TIME", paramaqzy.jdField_a_of_type_Long).apply();
    try
    {
      File localFile = new File(localQQAppInterface.getApp().getFilesDir() + File.separator + "enableKernelServiceInVivo");
      if (paramaqzy.b) {
        if (!localFile.exists()) {
          localFile.createNewFile();
        }
      }
      for (;;)
      {
        localQQAppInterface.getApp().getSharedPreferences("dt_sdk_start", 0).edit().putBoolean("is_init_dt_sdk_at_start_b", paramaqzy.d).apply();
        try
        {
          BaseApplicationImpl.getApplication().getSharedPreferences("suspend_thread_pref_file", 0).edit().putInt("enable_syslog_key", paramaqzy.jdField_a_of_type_Int).apply();
          return;
        }
        catch (Throwable paramaqzy)
        {
          QLog.e("BootOptimizeConfProcessor", 1, "syslog print config failed", paramaqzy);
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
  
  public Class<aqzy> clazz()
  {
    return aqzy.class;
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
 * Qualified Name:     aqzx
 * JD-Core Version:    0.7.0.1
 */