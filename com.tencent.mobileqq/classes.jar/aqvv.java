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

public class aqvv
  extends aqkz<aqvu>
{
  @NonNull
  public aqvu a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aqvu();
  }
  
  @Nullable
  public aqvu a(aqlg[] paramArrayOfaqlg)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onParsed");
    if (paramArrayOfaqlg != null) {
      try
      {
        if (paramArrayOfaqlg.length > 0)
        {
          paramArrayOfaqlg = (aqvu)aqlu.a(paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString, aqvu.class);
          return paramArrayOfaqlg;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqlg) {}
    }
    return null;
  }
  
  public void a(aqvu paramaqvu)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onUpdate");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject1).c(), 0).edit();
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_up", paramaqvu.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_down", paramaqvu.b);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2czip_down", paramaqvu.c);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_thumb", paramaqvu.d);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_up", paramaqvu.e);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_down", paramaqvu.f);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disczip_down", paramaqvu.g);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_thumb", paramaqvu.h);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_up", paramaqvu.i);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_down", paramaqvu.j);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troopzip_down", paramaqvu.k);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_thumb", paramaqvu.l);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew", paramaqvu.m);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_svip", paramaqvu.n);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramaqvu.o);
        ((SharedPreferences.Editor)localObject2).putBoolean("enable_file_media_platform", paramaqvu.p);
        ((SharedPreferences.Editor)localObject2).apply();
        QLog.i("QFileCommonConfigProcessor", 1, "save download config." + paramaqvu.jdField_a_of_type_JavaLangString);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("troop_video_preivew", paramaqvu.m);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_svip", paramaqvu.n);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramaqvu.o);
        ((Bundle)localObject2).putBoolean("enable_file_media_platform", paramaqvu.p);
        paramaqvu = (atam)((QQAppInterface)localObject1).getManager(317);
        if (paramaqvu != null) {
          paramaqvu.a((Bundle)localObject2);
        }
      }
      return;
    }
  }
  
  public Class<aqvu> clazz()
  {
    return aqvu.class;
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
 * Qualified Name:     aqvv
 * JD-Core Version:    0.7.0.1
 */