import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aqfa
  extends aptq<aqez>
{
  @NonNull
  public aqez a(int paramInt)
  {
    QLog.i("QFileApkCheckConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aqez();
  }
  
  @Nullable
  public aqez a(aptx[] paramArrayOfaptx)
  {
    QLog.i("QFileApkCheckConfigProcessor", 1, "onParsed");
    if (paramArrayOfaptx != null) {
      try
      {
        if (paramArrayOfaptx.length > 0)
        {
          paramArrayOfaptx = (aqez)apul.a(paramArrayOfaptx[0].a, aqez.class);
          return paramArrayOfaptx;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaptx) {}
    }
    return null;
  }
  
  public void a(aqez paramaqez)
  {
    if (paramaqez == null) {
      QLog.i("QFileApkCheckConfigProcessor", 1, "apkcheckConfig onUpdate: newConf is null.");
    }
    label126:
    for (;;)
    {
      return;
      QLog.i("QFileApkCheckConfigProcessor", 1, "apkcheckConfig onUpdate");
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {}
      for (localObject = (QQAppInterface)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label126;
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        localEditor.putBoolean("apkcheck_enable_switch", paramaqez.a);
        localEditor.apply();
        localObject = (aser)((QQAppInterface)localObject).getManager(317);
        if (localObject == null) {
          break;
        }
        ((aser)localObject).a(paramaqez.a);
        return;
      }
    }
  }
  
  public Class<aqez> clazz()
  {
    return aqez.class;
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
    QLog.i("QFileApkCheckConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 663;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqfa
 * JD-Core Version:    0.7.0.1
 */