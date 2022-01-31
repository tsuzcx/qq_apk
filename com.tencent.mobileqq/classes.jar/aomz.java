import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aomz
  extends aokh<aona>
{
  public int a()
  {
    return 566;
  }
  
  @NonNull
  public aona a(int paramInt)
  {
    return new aona();
  }
  
  @Nullable
  public aona a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0) && (paramArrayOfaoko[0] != null))
    {
      aona localaona = aona.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaona;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<aona> a()
  {
    return aona.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aona paramaona)
  {
    if (paramaona == null) {
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onUpdate but newConf==null");
      }
    }
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("BootOptimizeConfProcessor", 2, "onUpdate " + paramaona.toString());
        }
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        ajkl.a((QQAppInterface)localObject, paramaona.jdField_a_of_type_Boolean);
        ((QQAppInterface)localObject).getApp().getSharedPreferences("acc_info" + ((QQAppInterface)localObject).getAccount(), 0).edit().putLong("PREF_PLUGIN_DELAY_TIME", paramaona.jdField_a_of_type_Long).apply();
        try
        {
          localObject = new File(((QQAppInterface)localObject).getApp().getFilesDir() + File.separator + "enableKernelServiceInVivo");
          if (paramaona.b)
          {
            if (((File)localObject).exists()) {
              continue;
            }
            ((File)localObject).createNewFile();
          }
        }
        catch (Throwable paramaona)
        {
          QLog.e("BootOptimizeConfProcessor", 1, "create file failed", paramaona);
          return;
        }
      }
    } while (!((File)localObject).exists());
    ((File)localObject).delete();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aomz
 * JD-Core Version:    0.7.0.1
 */