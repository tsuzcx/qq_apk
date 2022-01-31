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

public class amid
  extends alzl<amic>
{
  public int a()
  {
    return 449;
  }
  
  @NonNull
  public amic a(int paramInt)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new amic();
  }
  
  @Nullable
  public amic a(alzs[] paramArrayOfalzs)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "onParsed");
    if (paramArrayOfalzs != null) {
      try
      {
        if (paramArrayOfalzs.length > 0)
        {
          paramArrayOfalzs = (amic)amaf.a(paramArrayOfalzs[0].a, amic.class);
          return paramArrayOfalzs;
        }
      }
      catch (QStorageInstantiateException paramArrayOfalzs) {}
    }
    return null;
  }
  
  public Class<amic> a()
  {
    return amic.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amic paramamic)
  {
    if (paramamic == null) {
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
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_all_switch", paramamic.a);
        ((SharedPreferences.Editor)localObject2).apply();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("ipv6_all_switch", paramamic.a);
        paramamic = (aofy)((QQAppInterface)localObject1).getManager(317);
        if (paramamic == null) {
          break;
        }
        paramamic.b((Bundle)localObject2);
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
 * Qualified Name:     amid
 * JD-Core Version:    0.7.0.1
 */