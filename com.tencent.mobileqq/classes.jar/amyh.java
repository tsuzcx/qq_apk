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

public class amyh
  extends ampb<amyg>
{
  public int a()
  {
    return 449;
  }
  
  @NonNull
  public amyg a(int paramInt)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new amyg();
  }
  
  @Nullable
  public amyg a(ampi[] paramArrayOfampi)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "onParsed");
    if (paramArrayOfampi != null) {
      try
      {
        if (paramArrayOfampi.length > 0)
        {
          paramArrayOfampi = (amyg)ampw.a(paramArrayOfampi[0].a, amyg.class);
          return paramArrayOfampi;
        }
      }
      catch (QStorageInstantiateException paramArrayOfampi) {}
    }
    return null;
  }
  
  public Class<amyg> a()
  {
    return amyg.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileIPv6ConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amyg paramamyg)
  {
    if (paramamyg == null) {
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
        ((SharedPreferences.Editor)localObject2).putBoolean("ipv6_all_switch", paramamyg.a);
        ((SharedPreferences.Editor)localObject2).apply();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("ipv6_all_switch", paramamyg.a);
        paramamyg = (aows)((QQAppInterface)localObject1).getManager(317);
        if (paramamyg == null) {
          break;
        }
        paramamyg.b((Bundle)localObject2);
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
 * Qualified Name:     amyh
 * JD-Core Version:    0.7.0.1
 */