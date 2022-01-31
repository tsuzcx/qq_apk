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

public class aopp
  extends aofy<aopo>
{
  public int a()
  {
    return 449;
  }
  
  @NonNull
  public aopo a(int paramInt)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aopo();
  }
  
  @Nullable
  public aopo a(aogf[] paramArrayOfaogf)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "onParsed");
    if (paramArrayOfaogf != null) {
      try
      {
        if (paramArrayOfaogf.length > 0)
        {
          paramArrayOfaogf = (aopo)aogt.a(paramArrayOfaogf[0].a, aopo.class);
          return paramArrayOfaogf;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaogf) {}
    }
    return null;
  }
  
  public Class<aopo> a()
  {
    return aopo.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aopo paramaopo)
  {
    if (paramaopo == null) {
      QLog.i("QFileIPv6ConfigProcessor", 1, "onUpdate: newConf is null.");
    }
    label141:
    for (;;)
    {
      return;
      QLog.i("QFileIPv6ConfigProcessor", 1, "onUpdate");
      Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface)) {}
      for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label141;
        }
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject1).c(), 0).edit();
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_all_switch", paramaopo.a);
        ((SharedPreferences.Editor)localObject2).apply();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("ipv6_all_switch", paramaopo.a);
        paramaopo = (aqpu)((QQAppInterface)localObject1).getManager(317);
        if (paramaopo == null) {
          break;
        }
        paramaopo.b((Bundle)localObject2);
        return;
      }
    }
  }
  
  public int b()
  {
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
 * Qualified Name:     aopp
 * JD-Core Version:    0.7.0.1
 */