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

public class arin
  extends aqwt<arim>
{
  @NonNull
  public arim a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new arim();
  }
  
  @Nullable
  public arim a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onParsed");
    if (paramArrayOfaqxa != null) {
      try
      {
        if (paramArrayOfaqxa.length > 0)
        {
          paramArrayOfaqxa = (arim)aqxo.a(paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString, arim.class);
          return paramArrayOfaqxa;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqxa) {}
    }
    return null;
  }
  
  public void a(arim paramarim)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onUpdate");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject1).getCurrentUin(), 0).edit();
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_up", paramarim.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_down", paramarim.b);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2czip_down", paramarim.c);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_thumb", paramarim.d);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_up", paramarim.e);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_down", paramarim.f);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disczip_down", paramarim.g);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_thumb", paramarim.h);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_up", paramarim.i);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_down", paramarim.j);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troopzip_down", paramarim.k);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_thumb", paramarim.l);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew", paramarim.m);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_svip", paramarim.n);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramarim.o);
        ((SharedPreferences.Editor)localObject2).putBoolean("enable_file_media_platform", paramarim.p);
        ((SharedPreferences.Editor)localObject2).apply();
        QLog.i("QFileCommonConfigProcessor", 1, "save download config." + paramarim.jdField_a_of_type_JavaLangString);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("troop_video_preivew", paramarim.m);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_svip", paramarim.n);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramarim.o);
        ((Bundle)localObject2).putBoolean("enable_file_media_platform", paramarim.p);
        paramarim = (atix)((QQAppInterface)localObject1).getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
        if (paramarim != null) {
          paramarim.a((Bundle)localObject2);
        }
      }
      return;
    }
  }
  
  public Class<arim> clazz()
  {
    return arim.class;
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
 * Qualified Name:     arin
 * JD-Core Version:    0.7.0.1
 */