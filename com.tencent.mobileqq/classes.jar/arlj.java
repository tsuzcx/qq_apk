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

public class arlj
  extends arac<arli>
{
  @NonNull
  public arli a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new arli();
  }
  
  @Nullable
  public arli a(araj[] paramArrayOfaraj)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onParsed");
    if (paramArrayOfaraj != null) {
      try
      {
        if (paramArrayOfaraj.length > 0)
        {
          paramArrayOfaraj = (arli)arax.a(paramArrayOfaraj[0].jdField_a_of_type_JavaLangString, arli.class);
          return paramArrayOfaraj;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaraj) {}
    }
    return null;
  }
  
  public void a(arli paramarli)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onUpdate");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject1).c(), 0).edit();
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_up", paramarli.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_down", paramarli.b);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2czip_down", paramarli.c);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_thumb", paramarli.d);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_up", paramarli.e);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_down", paramarli.f);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disczip_down", paramarli.g);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_thumb", paramarli.h);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_up", paramarli.i);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_down", paramarli.j);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troopzip_down", paramarli.k);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_thumb", paramarli.l);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew", paramarli.m);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_svip", paramarli.n);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramarli.o);
        ((SharedPreferences.Editor)localObject2).putBoolean("enable_file_media_platform", paramarli.p);
        ((SharedPreferences.Editor)localObject2).apply();
        QLog.i("QFileCommonConfigProcessor", 1, "save download config." + paramarli.jdField_a_of_type_JavaLangString);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("troop_video_preivew", paramarli.m);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_svip", paramarli.n);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramarli.o);
        ((Bundle)localObject2).putBoolean("enable_file_media_platform", paramarli.p);
        paramarli = (atsh)((QQAppInterface)localObject1).getManager(317);
        if (paramarli != null) {
          paramarli.a((Bundle)localObject2);
        }
      }
      return;
    }
  }
  
  public Class<arli> clazz()
  {
    return arli.class;
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
    QLog.i("QFileCommonConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 396;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arlj
 * JD-Core Version:    0.7.0.1
 */