import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aqvc
  extends aqkz<aqvb>
{
  @NonNull
  public aqvb a(int paramInt)
  {
    QLog.i("QDatalineHttpsConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + paramInt + "]");
    return new aqvb();
  }
  
  @Nullable
  public aqvb a(aqlg[] paramArrayOfaqlg)
  {
    QLog.i("QDatalineHttpsConfigProcessor", 1, "onParsed");
    if (paramArrayOfaqlg != null) {
      try
      {
        if (paramArrayOfaqlg.length > 0)
        {
          paramArrayOfaqlg = (aqvb)aqlu.a(paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString, aqvb.class);
          return paramArrayOfaqlg;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqlg) {}
    }
    return null;
  }
  
  public void a(aqvb paramaqvb)
  {
    QLog.i("QDatalineHttpsConfigProcessor", 1, "onUpdate");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences("dataline_config_" + ((QQAppInterface)localObject).c(), 0).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("use_new_httpclient", paramaqvb.jdField_a_of_type_Boolean);
        ((SharedPreferences.Editor)localObject).putBoolean("use_https_connect", paramaqvb.b);
        ((SharedPreferences.Editor)localObject).apply();
        QLog.i("QDatalineHttpsConfigProcessor", 1, "save download config." + paramaqvb.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  public Class<aqvb> clazz()
  {
    return aqvb.class;
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
 * Qualified Name:     aqvc
 * JD-Core Version:    0.7.0.1
 */