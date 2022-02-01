import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arlf
  extends arac<arle>
{
  @NonNull
  public arle a(int paramInt)
  {
    return new arle();
  }
  
  @Nullable
  public arle a(araj[] paramArrayOfaraj)
  {
    QLog.i("QFileAppStorePromoteConfigProcessor<QFile>", 1, "onParsed");
    if (paramArrayOfaraj != null) {
      try
      {
        if (paramArrayOfaraj.length > 0)
        {
          paramArrayOfaraj = (arle)arax.a(paramArrayOfaraj[0].a, arle.class);
          return paramArrayOfaraj;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaraj) {}
    }
    return null;
  }
  
  public void a(arle paramarle)
  {
    if (paramarle == null) {
      QLog.i("QFileAppStorePromoteConfigProcessor<QFile>", 1, "onUpdate: newConf is null.");
    }
    label123:
    for (;;)
    {
      return;
      QLog.i("QFileAppStorePromoteConfigProcessor<QFile>", 1, "onUpdate");
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {}
      for (localObject = (QQAppInterface)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label123;
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("yyb_promote_action_key", paramarle.c);
        localEditor.apply();
        localObject = (atsh)((QQAppInterface)localObject).getManager(317);
        if (localObject == null) {
          break;
        }
        ((atsh)localObject).a(paramarle);
        return;
      }
    }
  }
  
  public Class<arle> clazz()
  {
    return arle.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 626;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arlf
 * JD-Core Version:    0.7.0.1
 */