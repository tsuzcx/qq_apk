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

public class aril
  extends aqwt<arik>
{
  @NonNull
  public arik a(int paramInt)
  {
    return new arik();
  }
  
  @Nullable
  public arik a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("QFileAppStorePromoteDialogConfigProcessor<QFile>", 1, "onParsed");
    if (paramArrayOfaqxa != null) {
      try
      {
        if (paramArrayOfaqxa.length > 0)
        {
          paramArrayOfaqxa = (arik)aqxo.a(paramArrayOfaqxa[0].a, arik.class);
          return paramArrayOfaqxa;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqxa) {}
    }
    return null;
  }
  
  public void a(arik paramarik)
  {
    if (paramarik == null) {
      QLog.i("QFileAppStorePromoteDialogConfigProcessor<QFile>", 1, "onUpdate: newConf is null.");
    }
    label123:
    for (;;)
    {
      return;
      QLog.i("QFileAppStorePromoteDialogConfigProcessor<QFile>", 1, "onUpdate");
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {}
      for (localObject = (QQAppInterface)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label123;
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        localEditor.putString("yyb_promote_dialog_key", paramarik.a);
        localEditor.apply();
        localObject = (atix)((QQAppInterface)localObject).getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
        if (localObject == null) {
          break;
        }
        ((atix)localObject).a(paramarik);
        return;
      }
    }
  }
  
  public Class<arik> clazz()
  {
    return arik.class;
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
    return 625;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aril
 * JD-Core Version:    0.7.0.1
 */