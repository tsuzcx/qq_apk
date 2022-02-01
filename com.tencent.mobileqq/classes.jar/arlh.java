import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arlh
  extends arac<arlg>
{
  @NonNull
  public arlg a(int paramInt)
  {
    return new arlg();
  }
  
  @Nullable
  public arlg a(araj[] paramArrayOfaraj)
  {
    QLog.i("QFileAppStorePromoteDialogConfigProcessor<QFile>", 1, "onParsed");
    if (paramArrayOfaraj != null) {
      try
      {
        if (paramArrayOfaraj.length > 0)
        {
          paramArrayOfaraj = (arlg)arax.a(paramArrayOfaraj[0].a, arlg.class);
          return paramArrayOfaraj;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaraj) {}
    }
    return null;
  }
  
  public void a(arlg paramarlg)
  {
    if (paramarlg == null) {
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
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("yyb_promote_dialog_key", paramarlg.a);
        localEditor.apply();
        localObject = (atsh)((QQAppInterface)localObject).getManager(317);
        if (localObject == null) {
          break;
        }
        ((atsh)localObject).a(paramarlg);
        return;
      }
    }
  }
  
  public Class<arlg> clazz()
  {
    return arlg.class;
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
 * Qualified Name:     arlh
 * JD-Core Version:    0.7.0.1
 */