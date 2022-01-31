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

public class aopa
  extends aofy<aooz>
{
  public int a()
  {
    return 396;
  }
  
  @NonNull
  public aooz a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aooz();
  }
  
  @Nullable
  public aooz a(aogf[] paramArrayOfaogf)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onParsed");
    if (paramArrayOfaogf != null) {
      try
      {
        if (paramArrayOfaogf.length > 0)
        {
          paramArrayOfaogf = (aooz)aogt.a(paramArrayOfaogf[0].jdField_a_of_type_JavaLangString, aooz.class);
          return paramArrayOfaogf;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaogf) {}
    }
    return null;
  }
  
  public Class<aooz> a()
  {
    return aooz.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aooz paramaooz)
  {
    QLog.i("QFileCommonConfigProcessor", 1, "onUpdate");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject1).c(), 0).edit();
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_up", paramaooz.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_down", paramaooz.b);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2czip_down", paramaooz.c);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_c2c_thumb", paramaooz.d);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_up", paramaooz.e);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_down", paramaooz.f);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disczip_down", paramaooz.g);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_disc_thumb", paramaooz.h);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_up", paramaooz.i);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_down", paramaooz.j);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troopzip_down", paramaooz.k);
        ((SharedPreferences.Editor)localObject2).putBoolean("https_troop_thumb", paramaooz.l);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew", paramaooz.m);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_svip", paramaooz.n);
        ((SharedPreferences.Editor)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramaooz.o);
        ((SharedPreferences.Editor)localObject2).apply();
        QLog.i("QFileCommonConfigProcessor", 1, "save download config." + paramaooz.jdField_a_of_type_JavaLangString);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("troop_video_preivew", paramaooz.m);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_svip", paramaooz.n);
        ((Bundle)localObject2).putBoolean("troop_video_preivew_for_yearsvip", paramaooz.o);
        paramaooz = (aqpu)((QQAppInterface)localObject1).getManager(317);
        if (paramaooz != null) {
          paramaooz.a((Bundle)localObject2);
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
 * Qualified Name:     aopa
 * JD-Core Version:    0.7.0.1
 */