import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arlm
  extends arac<arlk>
{
  @NonNull
  public arlk a(int paramInt)
  {
    return new arlk();
  }
  
  @Nullable
  public arlk a(araj[] paramArrayOfaraj)
  {
    QLog.i("QFileDownloadConfigProcessor", 1, "onParsed");
    if (paramArrayOfaraj != null) {
      try
      {
        if (paramArrayOfaraj.length > 0)
        {
          paramArrayOfaraj = (arlk)arax.a(paramArrayOfaraj[0].jdField_a_of_type_JavaLangString, arlk.class);
          return paramArrayOfaraj;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaraj)
      {
        QLog.e("QFileDownloadConfigProcessor", 1, "onParsed : error " + paramArrayOfaraj.getMessage());
      }
    }
    return null;
  }
  
  public void a(arlk paramarlk)
  {
    if ((paramarlk != null) && (paramarlk.jdField_a_of_type_JavaUtilHashMap != null))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label156;
      }
    }
    label156:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(paramarlk.jdField_a_of_type_JavaLangString))
        {
          SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).c(), 0).edit();
          localEditor.putString("qfile_file_auto_download", paramarlk.jdField_a_of_type_JavaLangString);
          localEditor.apply();
          QLog.i("QFileDownloadConfigProcessor", 1, "save download config [" + paramarlk.jdField_a_of_type_JavaLangString + "]");
        }
        localObject = (atsh)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((atsh)localObject).a(paramarlk.jdField_a_of_type_JavaUtilHashMap);
        }
      }
      return;
    }
  }
  
  public Class<arlk> clazz()
  {
    return arlk.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
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
    QLog.i("QFileDownloadConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 85;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arlm
 * JD-Core Version:    0.7.0.1
 */