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

public class aoty
  extends aokh<aotx>
{
  public int a()
  {
    return 449;
  }
  
  @NonNull
  public aotx a(int paramInt)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aotx();
  }
  
  @Nullable
  public aotx a(aoko[] paramArrayOfaoko)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "onParsed");
    if (paramArrayOfaoko != null) {
      try
      {
        if (paramArrayOfaoko.length > 0)
        {
          paramArrayOfaoko = (aotx)aolc.a(paramArrayOfaoko[0].a, aotx.class);
          return paramArrayOfaoko;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaoko) {}
    }
    return null;
  }
  
  public Class<aotx> a()
  {
    return aotx.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aotx paramaotx)
  {
    if (paramaotx == null) {
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
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_all_switch", paramaotx.a);
        ((SharedPreferences.Editor)localObject2).apply();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("ipv6_all_switch", paramaotx.a);
        paramaotx = (aqud)((QQAppInterface)localObject1).getManager(317);
        if (paramaotx == null) {
          break;
        }
        paramaotx.b((Bundle)localObject2);
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
 * Qualified Name:     aoty
 * JD-Core Version:    0.7.0.1
 */