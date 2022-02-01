import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arih
  extends aqwt<arig>
{
  @NonNull
  public arig a(int paramInt)
  {
    QLog.i("QFileApkCheckConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new arig();
  }
  
  @Nullable
  public arig a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("QFileApkCheckConfigProcessor", 1, "onParsed");
    if (paramArrayOfaqxa != null) {
      try
      {
        if (paramArrayOfaqxa.length > 0)
        {
          paramArrayOfaqxa = (arig)aqxo.a(paramArrayOfaqxa[0].a, arig.class);
          return paramArrayOfaqxa;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqxa) {}
    }
    return null;
  }
  
  public void a(arig paramarig)
  {
    if (paramarig == null) {
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
        localEditor.putBoolean("apkcheck_enable_switch", paramarig.a);
        localEditor.apply();
        localObject = (atix)((QQAppInterface)localObject).getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
        if (localObject == null) {
          break;
        }
        ((atix)localObject).a(paramarig.a);
        return;
      }
    }
  }
  
  public Class<arig> clazz()
  {
    return arig.class;
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
 * Qualified Name:     arih
 * JD-Core Version:    0.7.0.1
 */