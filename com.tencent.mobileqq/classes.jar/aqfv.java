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

public class aqfv
  extends aptq<aqfu>
{
  @NonNull
  public aqfu a(int paramInt)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aqfu();
  }
  
  @Nullable
  public aqfu a(aptx[] paramArrayOfaptx)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "onParsed");
    if (paramArrayOfaptx != null) {
      try
      {
        if (paramArrayOfaptx.length > 0)
        {
          paramArrayOfaptx = (aqfu)apul.a(paramArrayOfaptx[0].a, aqfu.class);
          return paramArrayOfaptx;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaptx) {}
    }
    return null;
  }
  
  public void a(aqfu paramaqfu)
  {
    if (paramaqfu == null) {
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
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_all_switch", paramaqfu.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_c2c_switch", paramaqfu.b);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_group_switch", paramaqfu.c);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_disc_switch", paramaqfu.d);
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_dataline_switch", paramaqfu.e);
        ((SharedPreferences.Editor)localObject2).putInt("ipv6_strategy", paramaqfu.jdField_a_of_type_Int);
        ((SharedPreferences.Editor)localObject2).apply();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("ipv6_all_switch", paramaqfu.jdField_a_of_type_Boolean);
        ((Bundle)localObject2).putBoolean("ipv6_c2c_switch", paramaqfu.b);
        ((Bundle)localObject2).putBoolean("ipv6_group_switch", paramaqfu.c);
        ((Bundle)localObject2).putBoolean("ipv6_disc_switch", paramaqfu.d);
        ((Bundle)localObject2).putBoolean("ipv6_dataline_switch", paramaqfu.e);
        ((Bundle)localObject2).putInt("ipv6_strategy", paramaqfu.jdField_a_of_type_Int);
        paramaqfu = (aser)((QQAppInterface)localObject1).getManager(317);
        if (paramaqfu == null) {
          break;
        }
        paramaqfu.b((Bundle)localObject2);
        return;
      }
    }
  }
  
  public Class<aqfu> clazz()
  {
    return aqfu.class;
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
 * Qualified Name:     aqfv
 * JD-Core Version:    0.7.0.1
 */