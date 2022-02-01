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

public class arja
  extends aqwt<ariz>
{
  @NonNull
  public ariz a(int paramInt)
  {
    return new ariz();
  }
  
  @Nullable
  public ariz a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onParsed");
    if (paramArrayOfaqxa != null) {
      try
      {
        if (paramArrayOfaqxa.length > 0)
        {
          paramArrayOfaqxa = (ariz)aqxo.a(paramArrayOfaqxa[0].a, ariz.class);
          return paramArrayOfaqxa;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqxa) {}
    }
    return null;
  }
  
  public void a(ariz paramariz)
  {
    if (paramariz == null) {
      QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onUpdate: newConf is null.");
    }
    label148:
    for (;;)
    {
      return;
      QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onUpdate: config[" + paramariz.a + "]");
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {}
      for (localObject = (QQAppInterface)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label148;
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        localEditor.putString("file_reader_key", paramariz.a);
        localEditor.apply();
        localObject = (atix)((QQAppInterface)localObject).getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
        if (localObject == null) {
          break;
        }
        ((atix)localObject).a(paramariz);
        return;
      }
    }
  }
  
  public Class<ariz> clazz()
  {
    return ariz.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 645;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arja
 * JD-Core Version:    0.7.0.1
 */