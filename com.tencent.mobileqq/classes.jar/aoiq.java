import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aoiq
  extends aofy<aoir>
{
  public int a()
  {
    return 566;
  }
  
  @NonNull
  public aoir a(int paramInt)
  {
    return new aoir();
  }
  
  @Nullable
  public aoir a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null))
    {
      aoir localaoir = aoir.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimizeConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaoir;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<aoir> a()
  {
    return aoir.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimizeConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aoir paramaoir)
  {
    if (paramaoir == null) {
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
          QLog.d("BootOptimizeConfProcessor", 2, "onUpdate " + paramaoir.toString());
        }
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        ajfw.a((QQAppInterface)localObject, paramaoir.jdField_a_of_type_Boolean);
        ((QQAppInterface)localObject).getApp().getSharedPreferences("acc_info" + ((QQAppInterface)localObject).getAccount(), 0).edit().putLong("PREF_PLUGIN_DELAY_TIME", paramaoir.jdField_a_of_type_Long).apply();
        try
        {
          localObject = new File(((QQAppInterface)localObject).getApp().getFilesDir() + File.separator + "enableKernelServiceInVivo");
          if (paramaoir.b)
          {
            if (((File)localObject).exists()) {
              continue;
            }
            ((File)localObject).createNewFile();
          }
        }
        catch (Throwable paramaoir)
        {
          QLog.e("BootOptimizeConfProcessor", 1, "create file failed", paramaoir);
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
 * Qualified Name:     aoiq
 * JD-Core Version:    0.7.0.1
 */