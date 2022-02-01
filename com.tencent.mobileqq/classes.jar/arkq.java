import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arkq
  extends arac<arkp>
{
  @NonNull
  public arkp a(int paramInt)
  {
    QLog.i("QDatalineHttpsConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new arkp();
  }
  
  @Nullable
  public arkp a(araj[] paramArrayOfaraj)
  {
    QLog.i("QDatalineHttpsConfigProcessor", 1, "onParsed");
    if (paramArrayOfaraj != null) {
      try
      {
        if (paramArrayOfaraj.length > 0)
        {
          paramArrayOfaraj = (arkp)arax.a(paramArrayOfaraj[0].jdField_a_of_type_JavaLangString, arkp.class);
          return paramArrayOfaraj;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaraj) {}
    }
    return null;
  }
  
  public void a(arkp paramarkp)
  {
    QLog.i("QDatalineHttpsConfigProcessor", 1, "onUpdate");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences("dataline_config_" + ((QQAppInterface)localObject).c(), 0).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("use_new_httpclient", paramarkp.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject).putBoolean("use_https_connect", paramarkp.b);
        ((SharedPreferences.Editor)localObject).apply();
        QLog.i("QDatalineHttpsConfigProcessor", 1, "save download config." + paramarkp.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  public Class<arkp> clazz()
  {
    return arkp.class;
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
    QLog.i("QDatalineHttpsConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 637;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arkq
 * JD-Core Version:    0.7.0.1
 */