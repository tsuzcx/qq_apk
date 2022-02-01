import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arly
  extends arac<arlx>
{
  @NonNull
  public arlx a(int paramInt)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new arlx();
  }
  
  @Nullable
  public arlx a(araj[] paramArrayOfaraj)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "onParsed");
    if (paramArrayOfaraj != null) {
      try
      {
        if (paramArrayOfaraj.length > 0)
        {
          paramArrayOfaraj = (arlx)arax.a(paramArrayOfaraj[0].a, arlx.class);
          return paramArrayOfaraj;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaraj) {}
    }
    return null;
  }
  
  public void a(arlx paramarlx)
  {
    if (paramarlx == null) {
      QLog.i("QFileIPv6ConfigProcessor", 1, "FileIPv6Config onUpdate: newConf is null.");
    }
    label256:
    for (;;)
    {
      return;
      QLog.i("QFileIPv6ConfigProcessor", 1, "FileIPv6Config onUpdate");
      Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface)) {}
      for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label256;
        }
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject1).c(), 0).edit();
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_all_switch", paramarlx.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_c2c_switch", paramarlx.b);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_group_switch", paramarlx.c);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_disc_switch", paramarlx.d);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_dataline_switch", paramarlx.e);
        ((SharedPreferences.Editor)localObject2).putInt("ipv6_strategy", paramarlx.jdField_a_of_type_Int);
        ((SharedPreferences.Editor)localObject2).apply();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("ipv6_all_switch", paramarlx.jdField_a_of_type_Boolean);
        ((Bundle)localObject2).putBoolean("ipv6_c2c_switch", paramarlx.b);
        ((Bundle)localObject2).putBoolean("ipv6_group_switch", paramarlx.c);
        ((Bundle)localObject2).putBoolean("ipv6_disc_switch", paramarlx.d);
        ((Bundle)localObject2).putBoolean("ipv6_dataline_switch", paramarlx.e);
        ((Bundle)localObject2).putInt("ipv6_strategy", paramarlx.jdField_a_of_type_Int);
        paramarlx = (atsh)((QQAppInterface)localObject1).getManager(317);
        if (paramarlx == null) {
          break;
        }
        paramarlx.b((Bundle)localObject2);
        return;
      }
    }
  }
  
  public Class<arlx> clazz()
  {
    return arlx.class;
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
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 449;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arly
 * JD-Core Version:    0.7.0.1
 */