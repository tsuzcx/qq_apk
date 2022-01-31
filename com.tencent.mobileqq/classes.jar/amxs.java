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

public class amxs
  extends ampb<amxr>
{
  public int a()
  {
    return 396;
  }
  
  @NonNull
  public amxr a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new amxr();
  }
  
  @Nullable
  public amxr a(ampi[] paramArrayOfampi)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onParsed");
    if (paramArrayOfampi != null) {
      try
      {
        if (paramArrayOfampi.length > 0)
        {
          paramArrayOfampi = (amxr)ampw.a(paramArrayOfampi[0].jdField_a_of_type_JavaLangString, amxr.class);
          return paramArrayOfampi;
        }
      }
      catch (QStorageInstantiateException paramArrayOfampi) {}
    }
    return null;
  }
  
  public Class<amxr> a()
  {
    return amxr.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amxr paramamxr)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onUpdate");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject1).c(), 0).edit();
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_up", paramamxr.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_down", paramamxr.b);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2czip_down", paramamxr.c);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_thumb", paramamxr.d);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_up", paramamxr.e);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_down", paramamxr.f);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disczip_down", paramamxr.g);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_thumb", paramamxr.h);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_up", paramamxr.i);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_down", paramamxr.j);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troopzip_down", paramamxr.k);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_thumb", paramamxr.l);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew", paramamxr.m);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_svip", paramamxr.n);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramamxr.o);
        ((SharedPreferences.Editor)localObject2).apply();
        QLog.i("QFileCommonConfigProcessor", 1, "save download config." + paramamxr.jdField_a_of_type_JavaLangString);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("troop_video_preivew", paramamxr.m);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_svip", paramamxr.n);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramamxr.o);
        paramamxr = (aows)((QQAppInterface)localObject1).getManager(317);
        if (paramamxr != null) {
          paramamxr.a((Bundle)localObject2);
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
 * Qualified Name:     amxs
 * JD-Core Version:    0.7.0.1
 */