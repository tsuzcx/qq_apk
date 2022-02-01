import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arjc
  extends aqwt<arjb>
{
  @NonNull
  public arjb a(int paramInt)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new arjb();
  }
  
  @Nullable
  public arjb a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "onParsed");
    if (paramArrayOfaqxa != null) {
      try
      {
        if (paramArrayOfaqxa.length > 0)
        {
          paramArrayOfaqxa = (arjb)aqxo.a(paramArrayOfaqxa[0].a, arjb.class);
          return paramArrayOfaqxa;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqxa) {}
    }
    return null;
  }
  
  public void a(arjb paramarjb)
  {
    if (paramarjb == null) {
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
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject1).getCurrentUin(), 0).edit();
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_all_switch", paramarjb.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_c2c_switch", paramarjb.b);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_group_switch", paramarjb.c);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_disc_switch", paramarjb.d);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_dataline_switch", paramarjb.e);
        ((SharedPreferences.Editor)localObject2).putInt("ipv6_strategy", paramarjb.jdField_a_of_type_Int);
        ((SharedPreferences.Editor)localObject2).apply();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("ipv6_all_switch", paramarjb.jdField_a_of_type_Boolean);
        ((Bundle)localObject2).putBoolean("ipv6_c2c_switch", paramarjb.b);
        ((Bundle)localObject2).putBoolean("ipv6_group_switch", paramarjb.c);
        ((Bundle)localObject2).putBoolean("ipv6_disc_switch", paramarjb.d);
        ((Bundle)localObject2).putBoolean("ipv6_dataline_switch", paramarjb.e);
        ((Bundle)localObject2).putInt("ipv6_strategy", paramarjb.jdField_a_of_type_Int);
        paramarjb = (atix)((QQAppInterface)localObject1).getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
        if (paramarjb == null) {
          break;
        }
        paramarjb.b((Bundle)localObject2);
        return;
      }
    }
  }
  
  public Class<arjb> clazz()
  {
    return arjb.class;
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
 * Qualified Name:     arjc
 * JD-Core Version:    0.7.0.1
 */