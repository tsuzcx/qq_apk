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

public class amho
  extends alzl<amhn>
{
  public int a()
  {
    return 396;
  }
  
  @NonNull
  public amhn a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new amhn();
  }
  
  @Nullable
  public amhn a(alzs[] paramArrayOfalzs)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onParsed");
    if (paramArrayOfalzs != null) {
      try
      {
        if (paramArrayOfalzs.length > 0)
        {
          paramArrayOfalzs = (amhn)amaf.a(paramArrayOfalzs[0].jdField_a_of_type_JavaLangString, amhn.class);
          return paramArrayOfalzs;
        }
      }
      catch (QStorageInstantiateException paramArrayOfalzs) {}
    }
    return null;
  }
  
  public Class<amhn> a()
  {
    return amhn.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amhn paramamhn)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onUpdate");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject1).c(), 0).edit();
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_up", paramamhn.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_down", paramamhn.b);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2czip_down", paramamhn.c);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_thumb", paramamhn.d);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_up", paramamhn.e);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_down", paramamhn.f);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disczip_down", paramamhn.g);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_thumb", paramamhn.h);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_up", paramamhn.i);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_down", paramamhn.j);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troopzip_down", paramamhn.k);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_thumb", paramamhn.l);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew", paramamhn.m);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_svip", paramamhn.n);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramamhn.o);
        ((SharedPreferences.Editor)localObject2).apply();
        QLog.i("QFileCommonConfigProcessor", 1, "save download config." + paramamhn.jdField_a_of_type_JavaLangString);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("troop_video_preivew", paramamhn.m);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_svip", paramamhn.n);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramamhn.o);
        paramamhn = (aofy)((QQAppInterface)localObject1).getManager(317);
        if (paramamhn != null) {
          paramamhn.a((Bundle)localObject2);
        }
      }
      return;
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
 * Qualified Name:     amho
 * JD-Core Version:    0.7.0.1
 */