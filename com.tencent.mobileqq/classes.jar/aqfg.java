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

public class aqfg
  extends aptq<aqff>
{
  @NonNull
  public aqff a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aqff();
  }
  
  @Nullable
  public aqff a(aptx[] paramArrayOfaptx)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onParsed");
    if (paramArrayOfaptx != null) {
      try
      {
        if (paramArrayOfaptx.length > 0)
        {
          paramArrayOfaptx = (aqff)apul.a(paramArrayOfaptx[0].jdField_a_of_type_JavaLangString, aqff.class);
          return paramArrayOfaptx;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaptx) {}
    }
    return null;
  }
  
  public void a(aqff paramaqff)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onUpdate");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject1).getCurrentUin(), 0).edit();
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_up", paramaqff.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_down", paramaqff.b);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2czip_down", paramaqff.c);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_thumb", paramaqff.d);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_up", paramaqff.e);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_down", paramaqff.f);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disczip_down", paramaqff.g);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_thumb", paramaqff.h);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_up", paramaqff.i);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_down", paramaqff.j);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troopzip_down", paramaqff.k);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_thumb", paramaqff.l);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew", paramaqff.m);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_svip", paramaqff.n);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramaqff.o);
        ((SharedPreferences.Editor)localObject2).putBoolean("enable_file_media_platform", paramaqff.p);
        ((SharedPreferences.Editor)localObject2).apply();
        QLog.i("QFileCommonConfigProcessor", 1, "save download config." + paramaqff.jdField_a_of_type_JavaLangString);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("troop_video_preivew", paramaqff.m);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_svip", paramaqff.n);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramaqff.o);
        ((Bundle)localObject2).putBoolean("enable_file_media_platform", paramaqff.p);
        paramaqff = (aser)((QQAppInterface)localObject1).getManager(317);
        if (paramaqff != null) {
          paramaqff.a((Bundle)localObject2);
        }
      }
      return;
    }
  }
  
  public Class<aqff> clazz()
  {
    return aqff.class;
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
 * Qualified Name:     aqfg
 * JD-Core Version:    0.7.0.1
 */