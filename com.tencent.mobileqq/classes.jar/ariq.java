import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ariq
  extends aqwt<ario>
{
  @NonNull
  public ario a(int paramInt)
  {
    return new ario();
  }
  
  @Nullable
  public ario a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("QFileDownloadConfigProcessor", 1, "onParsed");
    if (paramArrayOfaqxa != null) {
      try
      {
        if (paramArrayOfaqxa.length > 0)
        {
          paramArrayOfaqxa = (ario)aqxo.a(paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString, ario.class);
          return paramArrayOfaqxa;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqxa)
      {
        QLog.e("QFileDownloadConfigProcessor", 1, "onParsed : error " + paramArrayOfaqxa.getMessage());
      }
    }
    return null;
  }
  
  public void a(ario paramario)
  {
    if ((paramario != null) && (paramario.jdField_a_of_type_JavaUtilHashMap != null))
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
        if (!TextUtils.isEmpty(paramario.jdField_a_of_type_JavaLangString))
        {
          SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
          localEditor.putString("qfile_file_auto_download", paramario.jdField_a_of_type_JavaLangString);
          localEditor.apply();
          QLog.i("QFileDownloadConfigProcessor", 1, "save download config [" + paramario.jdField_a_of_type_JavaLangString + "]");
        }
        localObject = (atix)((QQAppInterface)localObject).getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
        if (localObject != null) {
          ((atix)localObject).a(paramario.jdField_a_of_type_JavaUtilHashMap);
        }
      }
      return;
    }
  }
  
  public Class<ario> clazz()
  {
    return ario.class;
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
 * Qualified Name:     ariq
 * JD-Core Version:    0.7.0.1
 */