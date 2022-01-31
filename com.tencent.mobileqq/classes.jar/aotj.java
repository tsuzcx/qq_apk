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

public class aotj
  extends aokh<aoti>
{
  public int a()
  {
    return 396;
  }
  
  @NonNull
  public aoti a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aoti();
  }
  
  @Nullable
  public aoti a(aoko[] paramArrayOfaoko)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onParsed");
    if (paramArrayOfaoko != null) {
      try
      {
        if (paramArrayOfaoko.length > 0)
        {
          paramArrayOfaoko = (aoti)aolc.a(paramArrayOfaoko[0].jdField_a_of_type_JavaLangString, aoti.class);
          return paramArrayOfaoko;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaoko) {}
    }
    return null;
  }
  
  public Class<aoti> a()
  {
    return aoti.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aoti paramaoti)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onUpdate");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject1).c(), 0).edit();
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_up", paramaoti.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_down", paramaoti.b);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2czip_down", paramaoti.c);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_thumb", paramaoti.d);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_up", paramaoti.e);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_down", paramaoti.f);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disczip_down", paramaoti.g);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_thumb", paramaoti.h);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_up", paramaoti.i);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_down", paramaoti.j);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troopzip_down", paramaoti.k);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_thumb", paramaoti.l);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew", paramaoti.m);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_svip", paramaoti.n);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramaoti.o);
        ((SharedPreferences.Editor)localObject2).apply();
        QLog.i("QFileCommonConfigProcessor", 1, "save download config." + paramaoti.jdField_a_of_type_JavaLangString);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("troop_video_preivew", paramaoti.m);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_svip", paramaoti.n);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramaoti.o);
        paramaoti = (aqud)((QQAppInterface)localObject1).getManager(317);
        if (paramaoti != null) {
          paramaoti.a((Bundle)localObject2);
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
 * Qualified Name:     aotj
 * JD-Core Version:    0.7.0.1
 */