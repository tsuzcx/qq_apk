import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aqen
  extends aptq<aqem>
{
  @NonNull
  public aqem a(int paramInt)
  {
    QLog.i("QDatalineHttpsConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aqem();
  }
  
  @Nullable
  public aqem a(aptx[] paramArrayOfaptx)
  {
    QLog.i("QDatalineHttpsConfigProcessor", 1, "onParsed");
    if (paramArrayOfaptx != null) {
      try
      {
        if (paramArrayOfaptx.length > 0)
        {
          paramArrayOfaptx = (aqem)apul.a(paramArrayOfaptx[0].jdField_a_of_type_JavaLangString, aqem.class);
          return paramArrayOfaptx;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaptx) {}
    }
    return null;
  }
  
  public void a(aqem paramaqem)
  {
    QLog.i("QDatalineHttpsConfigProcessor", 1, "onUpdate");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences("dataline_config_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("use_new_httpclient", paramaqem.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject).putBoolean("use_https_connect", paramaqem.b);
        ((SharedPreferences.Editor)localObject).apply();
        QLog.i("QDatalineHttpsConfigProcessor", 1, "save download config." + paramaqem.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  public Class<aqem> clazz()
  {
    return aqem.class;
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
 * Qualified Name:     aqen
 * JD-Core Version:    0.7.0.1
 */