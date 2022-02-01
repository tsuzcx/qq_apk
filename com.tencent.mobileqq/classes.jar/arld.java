import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arld
  extends arac<arlc>
{
  @NonNull
  public arlc a(int paramInt)
  {
    QLog.i("QFileApkCheckConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new arlc();
  }
  
  @Nullable
  public arlc a(araj[] paramArrayOfaraj)
  {
    QLog.i("QFileApkCheckConfigProcessor", 1, "onParsed");
    if (paramArrayOfaraj != null) {
      try
      {
        if (paramArrayOfaraj.length > 0)
        {
          paramArrayOfaraj = (arlc)arax.a(paramArrayOfaraj[0].a, arlc.class);
          return paramArrayOfaraj;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaraj) {}
    }
    return null;
  }
  
  public void a(arlc paramarlc)
  {
    if (paramarlc == null) {
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
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putBoolean("apkcheck_enable_switch", paramarlc.a);
        localEditor.apply();
        localObject = (atsh)((QQAppInterface)localObject).getManager(317);
        if (localObject == null) {
          break;
        }
        ((atsh)localObject).a(paramarlc.a);
        return;
      }
    }
  }
  
  public Class<arlc> clazz()
  {
    return arlc.class;
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
 * Qualified Name:     arld
 * JD-Core Version:    0.7.0.1
 */