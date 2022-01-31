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

public class amxt
  extends ampa<amxs>
{
  public int a()
  {
    return 396;
  }
  
  @NonNull
  public amxs a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new amxs();
  }
  
  @Nullable
  public amxs a(amph[] paramArrayOfamph)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onParsed");
    if (paramArrayOfamph != null) {
      try
      {
        if (paramArrayOfamph.length > 0)
        {
          paramArrayOfamph = (amxs)ampv.a(paramArrayOfamph[0].jdField_a_of_type_JavaLangString, amxs.class);
          return paramArrayOfamph;
        }
      }
      catch (QStorageInstantiateException paramArrayOfamph) {}
    }
    return null;
  }
  
  public Class<amxs> a()
  {
    return amxs.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amxs paramamxs)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onUpdate");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject1).c(), 0).edit();
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_up", paramamxs.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_down", paramamxs.b);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2czip_down", paramamxs.c);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_thumb", paramamxs.d);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_up", paramamxs.e);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_down", paramamxs.f);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disczip_down", paramamxs.g);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_thumb", paramamxs.h);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_up", paramamxs.i);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_down", paramamxs.j);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troopzip_down", paramamxs.k);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_thumb", paramamxs.l);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew", paramamxs.m);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_svip", paramamxs.n);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramamxs.o);
        ((SharedPreferences.Editor)localObject2).apply();
        QLog.i("QFileCommonConfigProcessor", 1, "save download config." + paramamxs.jdField_a_of_type_JavaLangString);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("troop_video_preivew", paramamxs.m);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_svip", paramamxs.n);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramamxs.o);
        paramamxs = (aoww)((QQAppInterface)localObject1).getManager(317);
        if (paramamxs != null) {
          paramamxs.a((Bundle)localObject2);
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
 * Qualified Name:     amxt
 * JD-Core Version:    0.7.0.1
 */