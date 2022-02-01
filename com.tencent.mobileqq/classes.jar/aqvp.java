import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aqvp
  extends aqkz<aqvo>
{
  @NonNull
  public aqvo a(int paramInt)
  {
    QLog.i("QFileApkCheckConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aqvo();
  }
  
  @Nullable
  public aqvo a(aqlg[] paramArrayOfaqlg)
  {
    QLog.i("QFileApkCheckConfigProcessor", 1, "onParsed");
    if (paramArrayOfaqlg != null) {
      try
      {
        if (paramArrayOfaqlg.length > 0)
        {
          paramArrayOfaqlg = (aqvo)aqlu.a(paramArrayOfaqlg[0].a, aqvo.class);
          return paramArrayOfaqlg;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqlg) {}
    }
    return null;
  }
  
  public void a(aqvo paramaqvo)
  {
    if (paramaqvo == null) {
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
        localEditor.putBoolean("apkcheck_enable_switch", paramaqvo.a);
        localEditor.apply();
        localObject = (atam)((QQAppInterface)localObject).getManager(317);
        if (localObject == null) {
          break;
        }
        ((atam)localObject).a(paramaqvo.a);
        return;
      }
    }
  }
  
  public Class<aqvo> clazz()
  {
    return aqvo.class;
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
 * Qualified Name:     aqvp
 * JD-Core Version:    0.7.0.1
 */