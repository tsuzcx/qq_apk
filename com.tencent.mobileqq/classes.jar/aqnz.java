import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aqnz
  extends aqkz<aqoa>
{
  @NonNull
  public aqoa a(int paramInt)
  {
    return new aqoa();
  }
  
  @Nullable
  public aqoa a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null))
    {
      aqoa localaqoa = aqoa.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaqoa;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(aqoa paramaqoa)
  {
    if (paramaqoa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "onUpdate " + paramaqoa.toString());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    alcu.a(localQQAppInterface, paramaqoa.jdField_a_of_type_Boolean);
    localQQAppInterface.getApp().getSharedPreferences("acc_info" + localQQAppInterface.getAccount(), 0).edit().putLong("PREF_PLUGIN_DELAY_TIME", paramaqoa.jdField_a_of_type_Long).apply();
    try
    {
      File localFile = new File(localQQAppInterface.getApp().getFilesDir() + File.separator + "enableKernelServiceInVivo");
      if (paramaqoa.b) {
        if (!localFile.exists()) {
          localFile.createNewFile();
        }
      }
      for (;;)
      {
        localQQAppInterface.getApp().getSharedPreferences("dt_sdk_start", 0).edit().putBoolean("is_init_dt_sdk_at_start", paramaqoa.d).apply();
        try
        {
          BaseApplicationImpl.getApplication().getSharedPreferences("suspend_thread_pref_file", 0).edit().putBoolean("enable_sys_log", paramaqoa.e).apply();
          return;
        }
        catch (Throwable paramaqoa)
        {
          QLog.e("BootOptimizeConfProcessor", 1, "syslog print config failed", paramaqoa);
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
  
  public Class<aqoa> clazz()
  {
    return aqoa.class;
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
 * Qualified Name:     aqnz
 * JD-Core Version:    0.7.0.1
 */